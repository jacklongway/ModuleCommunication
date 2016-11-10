package com.longway.productflavor;

import android.app.Application;

import com.longway.module.ModuleTable;


/**
 * Created by longway on 16/11/10. Email:longway1991117@sina.com
 */

public class MainApp extends Application {
    private com.longway.testflavor.App mFlavor1;
    private com.longway.testflavor2.App mFlavor2;

    @Override
    public void onCreate() {
        super.onCreate();
        // a simple app delegate
        mFlavor1 = new com.longway.testflavor.App();
        mFlavor2 = new com.longway.testflavor2.App();
        mFlavor1.onCreate();
        mFlavor2.onCreate();
        ModuleTable.getInstance().dump();
    }
}
