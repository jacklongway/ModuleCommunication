package com.longway.module;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 * Module table wrapper
 * 1.provider table base feature
 * 2.cache table
 */

public abstract class ModuleTable {
    private HashMap<String, ArrayList<M>> mModuleTable;

    public ModuleTable() {
        mModuleTable = moduleTable();
    }

    /**
     * build module table in order to provider service
     * @return
     */
    public abstract HashMap<String, ArrayList<M>> moduleTable();

    /**
     * by module and service alias get module service class
     * @param module
     * @param serviceName
     * @return
     */
    public String getModuleServiceName(String module, String serviceName) {
        if (mModuleTable == null) {
            throw new IllegalModuleTableException("moduleTable() must be return not null module table map");
        }
        if (TextUtils.isEmpty(module) || TextUtils.isEmpty(serviceName)) {
            return null;
        }
        if (mModuleTable.containsKey(module)) {
            ArrayList<M> ms = mModuleTable.get(module);
            if (ms == null) {
                return null;
            }
            for (M m : ms) {
                if (m != null) {
                    if (TextUtils.equals(m.mModuleName, module) && TextUtils.equals(m.mServiceName, serviceName)) {
                        return m.mServiceClass;
                    }
                }
            }
        }
        return null;
    }
}
