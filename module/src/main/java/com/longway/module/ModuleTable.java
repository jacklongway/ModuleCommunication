package com.longway.module;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com Module table wrapper 1.provider
 * table base feature 2.cache table
 */

public class ModuleTable extends AbstractModuleTable {
    private static final String TAG = ModuleTable.class.getSimpleName();
    private static final Object SYNC_LOCK = new Object();
    private ArrayList<IModuleTable> mModuleTable;


    private static final class Inner {
        private static final ModuleTable INSTANCE = new ModuleTable();
    }

    private ModuleTable() {
        mModuleTable = new ArrayList<>();
    }

    public static ModuleTable getInstance() {
        return Inner.INSTANCE;
    }

    /**
     * by module and service alias get module service class
     */
    @Override
    public String getModuleServiceName(String serviceAliasName) {
        synchronized (SYNC_LOCK) {
            for (IModuleTable moduleTable : mModuleTable) {
                if (moduleTable != null) {
                    String serviceName = moduleTable.getModuleServiceName(serviceAliasName);
                    if (!TextUtils.isEmpty(serviceName)) {
                        return serviceName;
                    }
                }
            }
        }
        return null;
    }

    /**
     * check serviceAliasName
     */
    @Override
    public boolean containModuleServiceName(String serviceAliasName) {
        synchronized (SYNC_LOCK) {
            for (IModuleTable moduleTable : mModuleTable) {
                if (moduleTable != null) {
                    boolean contain = moduleTable.containModuleServiceName(serviceAliasName);
                    if (contain) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * register module table
     */
    @Override
    public void registerModuleTable(IModuleTable moduleTable) {
        if (moduleTable == null) {
            throw new IllegalModuleTableException("moduleTable must be not null");
        }
        synchronized (SYNC_LOCK) {
            if (!mModuleTable.contains(moduleTable)) {
                mModuleTable.add(moduleTable);
            }
        }
    }

    /**
     * unregister module table
     */
    @Override
    public void unregisterModuleTable(IModuleTable moduleTable) {
        if (moduleTable == null) {
            throw new IllegalModuleTableException("moduleTable must be not null");
        }
        synchronized (SYNC_LOCK) {
            if (mModuleTable.contains(moduleTable)) {
                mModuleTable.remove(moduleTable);
            }
        }
    }

    /**
     * private {@hide}
     */
    @Override
    void clearModuleTable() {
        synchronized (SYNC_LOCK) {
            for (IModuleTable moduleTable : mModuleTable) {
                if (moduleTable != null) {
                    moduleTable.clearModuleServiceTable();
                }
            }
        }
    }

    /**
     * private {@hide}
     */
    @Override
    void reloadModuleTable() {
        synchronized (SYNC_LOCK) {
            for (IModuleTable moduleTable : mModuleTable) {
                if (moduleTable != null) {
                    moduleTable.reloadModuleService();
                }
            }
        }
    }

    /**
     * debug dump
     */
    public void dump() {
        synchronized (SYNC_LOCK) {
            StringBuilder sb = new StringBuilder();
            sb.append("module size:" + mModuleTable.size()).append("\n");
            for (IModuleTable moduleTable : mModuleTable) {
                sb.append(moduleTable.toString()).append("\n");
            }
            Log.e(TAG, sb.toString());
        }
    }
}
