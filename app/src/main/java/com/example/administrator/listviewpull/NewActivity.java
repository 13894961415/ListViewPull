package com.example.administrator.listviewpull;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by B05 on 2018/9/5.
 */

  public class NewActivity extends AppCompatActivity {
    //返回主界面
    private TextView order_det_back;
    @Override
      protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.order_detalis_layout);
//点击按钮返回
        order_det_back = (TextView)findViewById(R.id.order_det_back);
        order_det_back.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(NewActivity.this,MainActivity.class);
            startActivity(intent);
          }
        });

    }
}
