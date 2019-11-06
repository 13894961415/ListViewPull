package com.example.administrator.listviewpull;

import android.app.Application;


/**
 * Created by MS_Android01 on 2018/8/28.
 */

public class LImageApplication extends Application {
    //图片加载，缓存和管理组件
    private static ImageLoaderKit imageLoaderKit;

    @Override
    public void onCreate() {
        super.onCreate();
        imageLoaderKit = new ImageLoaderKit(this,null);
    }
}
