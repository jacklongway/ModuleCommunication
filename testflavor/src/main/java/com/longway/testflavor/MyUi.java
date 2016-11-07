package com.longway.testflavor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.longway.bz_common.module.flavor1.flavor2.IUiFlavor2;

/**
 * Created by longway on 16/11/7. Email:longway1991117@sina.com
 */

public class MyUi implements IUiFlavor2 {
    private static volatile MyUi mMyUi;

    private MyUi() {

    }

    public static MyUi getMyUi() {
        if (mMyUi == null) {
            synchronized (MyUi.class) {
                if (mMyUi == null) {
                    mMyUi = new MyUi();
                }
            }
        }
        return mMyUi;
    }


    @Override
    public void startActivityFlavor(Context context) {
        Intent intent = new Intent(context, MMainActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
