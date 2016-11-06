package com.longway.testflavor2;

import android.util.Log;

import com.longway.bz_common.module.flavor1.IPService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by longway on 16/8/15. Email:longway1991117@sina.com
 */

public class B implements IPService {
    private static final String TAG = B.class.getSimpleName();
    private ScheduledExecutorService mExecutor = Executors.newScheduledThreadPool(1);

    public static void print(String msg) {
        Log.e("B", msg);
    }


    @Override
    public void dump(final String msg) {
        mExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, msg != null ? msg : "null");
            }
        }, 0, 500, TimeUnit.MILLISECONDS);

    }
}
