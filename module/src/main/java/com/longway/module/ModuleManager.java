package com.longway.module;

import android.content.Context;
import android.text.TextUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com Module manager 1.build module
 * service instance 2.cache service instance 3.and so on
 */

public class ModuleManager {
    private static volatile ModuleManager sInstance;
    private static final Object LOCK = new Object();
    private HashMap<String, Module> mModuleCache;

    private ModuleManager() {
        mModuleCache = new HashMap<>();
    }

    /**
     * init operator for example perLoad service class or other
     *
     * @param context global
     */
    public void init(Context context) {

    }

    /**
     * remove cached module
     * @param moduleName
     */
    public void clearModule(String moduleName) {
        synchronized (mModuleCache) {
            mModuleCache.remove(moduleName);
        }
    }

    /**
     * clear cache
     */
    public void clearAll() {
        synchronized (mModuleCache) {
            mModuleCache.clear();
        }
    }

    public static ModuleManager getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new ModuleManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * load module
     */
    public Module loadModule(String moduleName) {
        if (TextUtils.isEmpty(moduleName)) {
            return null;
        }
        synchronized (mModuleCache) {
            if (mModuleCache.containsKey(moduleName)) {
                return mModuleCache.get(moduleName);
            }
        }
        try {
            Class<?> clz = Class.forName(moduleName);
            if (!Module.class.isAssignableFrom(clz)) {
                throw new IllegalModuleTypeException(moduleName + " must be isAssignableFrom Module.");
            }
            Constructor constructor = clz.getConstructor();
            if (constructor == null) {
                throw new IllegalModuleTypeException(moduleName + " must be has (void) constructor.");
            }
            Module module = (Module) clz.newInstance();
            synchronized (mModuleCache) {
                mModuleCache.put(moduleName, module);
            }
            return module;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new IllegalModuleTypeException(moduleName + " not create instance.");
        }
    }
}
