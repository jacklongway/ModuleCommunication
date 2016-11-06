package com.longway.testflavor;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 */

public class MMainActivity extends Activity {
    private static final String TAG = MMainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmain);
        FModule.build().getPresenterService().dump("com.longway.testflavor.MainActivity");
    }
}
