package com.longway.module;

import android.content.Context;
import android.text.TextUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 * Module manager
 * 1.build module service instance
 * 2.cache service instance
 * 3.and so on
 */

public class ModuleManager {
    private static ModuleManager sInstance;
    private HashMap<String, Module> mModuleCache;

    private ModuleManager() {
        mModuleCache = new HashMap<>();
    }

    /**
     * init operator for example perLoad service class or other
     * @param context global
     */
    public void init(Context context) {

    }

    public static ModuleManager getInstance() {
        if (sInstance == null) {
            synchronized (ModuleManager.class) {
                if (sInstance == null) {
                    sInstance = new ModuleManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * load module
     * @param moduleName
     * @return
     */
    public Module loadModule(String moduleName) {
        if (TextUtils.isEmpty(moduleName)) {
            return null;
        }
        synchronized (mModuleCache) {
            if (mModuleCache.containsKey(moduleName)) {
                return mModuleCache.get(moduleName);
            }
            try {
                Class<?> clz = Class.forName(moduleName);
                Constructor constructor = clz.getConstructor();
                if (constructor == null) {
                    throw new IllegalModuleTypeException(moduleName + " must be has (void) constructor.");
                }
                Object o = clz.newInstance();
                if (!(o instanceof Module)) {
                    throw new IllegalModuleTypeException(moduleName + " must be implement Module interface.");
                }
                Module module = (Module) o;
                mModuleCache.put(moduleName, module);
                return module;
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
