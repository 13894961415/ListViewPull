package com.example.administrator.listviewpull;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2019/11/6.
 */

public class ModelAdapter extends BaseAdapter {
    private Context context;
    private List<GoodsListModel> modelList;

    public ModelAdapter(Context context,List<GoodsListModel>modelList){
        super();
        this.context = context;
        this.modelList = modelList;

    }

    @Override
    public int getCount( ) {return this.modelList.size();}



    @Override
    public Object getItem(int position) {return this.modelList.get(position);
    }

    @Override
    public long getItemId(int position) {return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GoodsListModel model = modelList.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item,null);
            viewHolder.mImageView=(ImageView)convertView.findViewById(R.id.img2);
            viewHolder.mTextView1=(TextView)convertView.findViewById(R.id.t1);
            viewHolder.mTextView2=(TextView)convertView.findViewById(R.id.t3);
            viewHolder.mTextView3=(TextView)convertView.findViewById(R.id.t4);
            viewHolder.mTextView4=(TextView)convertView.findViewById(R.id.t5);
            viewHolder.mTextView5=(TextView)convertView.findViewById(R.id.t6);
            viewHolder.mTextView6=(TextView)convertView.findViewById(R.id.t7);
            viewHolder.mTextView7=(TextView)convertView.findViewById(R.id.t2);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ImageLoader.getInstance().displayImage("http://bb.wxtool.cn"+model.getGoodinfo().get(0).getPhoto(), viewHolder.mImageView);
        viewHolder.mTextView1.setText(""+model.getOrder_id());
        viewHolder.mTextView2.setText(""+model.getGoodinfo().get(0).getTitle());
        viewHolder.mTextView3.setText(""+model.getGoodinfo().get(0).getNprice());
        viewHolder.mTextView4.setText(""+model.getGoodinfo().get(0).getNum());
        viewHolder.mTextView5.setText("共"+model.getGoodinfo().get(0).getNum()+"件商品");
        viewHolder.mTextView6.setText("合计：  ￥"+model.getGoodinfo().get(0).getNprice()+"元（含运费0.00）");
        return convertView;
    }


    class ViewHolder{
        ImageView mImageView;
        TextView mTextView1,mTextView2,mTextView3,mTextView4,mTextView5,mTextView6,mTextView7;
    }
}

