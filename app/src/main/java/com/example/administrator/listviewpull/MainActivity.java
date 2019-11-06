package com.example.administrator.listviewpull;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.administrator.listviewpull.refresh_load.BaseRefreshListener;
import com.example.administrator.listviewpull.refresh_load.PullToRefreshLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements BaseRefreshListener {
    private PullToRefreshLayout refreshLayout;
    private int currentPage=1;
    private List<GoodsListModel> listModels =new ArrayList<>() ;

    private ModelAdapter adapter;
    private ListView goodslistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void  initView(){
        refreshLayout = (PullToRefreshLayout)findViewById(R.id.mypullid);
        //设置监听，继承 BaseRefreshListener，导入两个方法 refresh()，loadMore()
        refreshLayout.setRefreshListener(this);
        goodslistview = (ListView)findViewById(R.id.pulllidtviewid);
        Get_Goods_List(currentPage);
//        goodslistview = (ListView)findViewById(R.id.lv);
//        Get_Goods_List();
    }
    private void initData(){
        adapter = new ModelAdapter(MainActivity.this,listModels);
        goodslistview.setAdapter(adapter);
        goodslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override//点击
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Get_Goods_List(int currentPage){//接口
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("User_Id","10")
                .add("Tab","0")
                .add("Page","1")
                .add("Token","48B022CF4B571B5C1F5261851683A382")
                .build();
        Request request = new Request.Builder()
                .url("http://bb.mansonnet.com/Api/Get_OrderList?User_Id=10&Tab=0&Page=1&Token=48B022CF4B571B5C1F5261851683A382")
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtil.showToast(MainActivity.this,"GET 失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(str);
                    JSONArray jsonArray = jsonObject.getJSONArray("Result");
                    listModels = JSON.parseArray(""+jsonArray,GoodsListModel.class);
                    sendHandlerMessage(1,"");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //刷新UI使用handler
    private void sendHandlerMessage(int what, Object obj) {
        Message msg = new Message();
        msg.what = what;
        msg.obj = obj;
        handler.sendMessage(msg);
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @SuppressLint({"HandlerLeak", "ShowToast"})
        public void handleMessage(Message msg) {
            Log.e("come in", "");
            switch (msg.what) {
                case 1:
                    initData();
                    break;

                default:

            }
        }
    };

    @Override
    public void refresh() {
        currentPage = 1;
        Get_Goods_List(currentPage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.finishRefresh();
            }
        }, 2000);//时间值，根据接口返回速度定
    }

    @Override
    public void loadMore() {
        currentPage++;
        Get_Goods_List(currentPage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.finishLoadMore();
            }
        }, 2000);//时间值，根据接口返回速度定
    }
}
