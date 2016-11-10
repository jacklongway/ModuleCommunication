package com.longway.testflavor;

import android.app.Application;

import com.longway.module.ModuleTable;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 */

public class App extends Application {
    private FlavorTable1 mFlavorTable1;

    @Override
    public void onCreate() {
        super.onCreate();
        mFlavorTable1 = new FlavorTable1();
        ModuleTable.getInstance().registerModuleTable(mFlavorTable1);
    }
}
