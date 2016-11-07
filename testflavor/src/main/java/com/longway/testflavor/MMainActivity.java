package com.longway.testflavor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 */

public class MMainActivity extends AppCompatActivity {
    private static final String TAG = MMainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmain);
        setTitle("Module Flavor1");
        //FModule.build().getPresenterService().dump("com.longway.testflavor.MainActivity");
        FModule.build().getUIService().update("ui update......");
    }
}
