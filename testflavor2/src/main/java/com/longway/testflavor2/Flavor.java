package com.longway.testflavor2;

import android.app.Activity;

import com.longway.bz_common.module.flavor1.IUIFlavor;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by longway on 16/11/7. Email:longway1991117@sina.com
 */

public class Flavor implements IUIFlavor {
    private static volatile Flavor sInstance;
    private HashMap<String, WeakReference<Activity>> mUi;

    public void addUiInterface(String logicName, Activity activity) {
        mUi.put(logicName, new WeakReference<>(activity));
    }

    public void removeUiInterface(String logicName) {
        mUi.remove(logicName);
    }

    private Flavor() {
        mUi = new HashMap<>();
    }

    public static Flavor getInstance() {
        if (sInstance == null) {
            synchronized (Flavor.class) {
                if (sInstance == null) {
                    sInstance = new Flavor();
                }
            }
        }
        return sInstance;
    }

    @Override
    public void update(String msg) {
        WeakReference<Activity> weakReference = mUi.get(Constants.UPDATE);
        Activity activity = weakReference.get();
        if (activity != null && !activity.isFinishing()) {
            FlavorActivity flavorActivity = (FlavorActivity) activity;
            flavorActivity.update(msg);
        }
    }
}
