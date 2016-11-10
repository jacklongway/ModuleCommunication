package com.longway.module;

/**
 * Created by longway on 16/11/10. Email:longway1991117@sina.com {@link ModuleTable}
 */

public abstract class AbstractModuleTable {
    public abstract void registerModuleTable(IModuleTable moduleTable);

    public abstract void unregisterModuleTable(IModuleTable moduleTable);

    abstract void clearModuleTable();

    abstract void reloadModuleTable();

    public abstract String getModuleServiceName(String serviceAliasName);

    public abstract boolean containModuleServiceName(String serviceAliasName);
}
