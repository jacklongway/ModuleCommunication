package com.longway.testflavor2;

import android.app.Application;

import com.longway.module.ModuleTable;

/**
 * Created by longway on 16/11/10. Email:longway1991117@sina.com
 */

public class App extends Application {
    private FlavorTable2 mFlavorTable2;

    @Override
    public void onCreate() {
        super.onCreate();
        mFlavorTable2 = new FlavorTable2();
        ModuleTable.getInstance().registerModuleTable(mFlavorTable2);
    }
}
