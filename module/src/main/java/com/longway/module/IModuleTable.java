package com.longway.module;

/**
 * Created by longway on 16/11/10. Email:longway1991117@sina.com
 * module table interface
 * {@link ModuleTable}
 */

public interface IModuleTable {
    String getModuleServiceName(String moduleServiceAliasName);

    String removeModuleServiceName(String moduleServiceAliasName);

    boolean containModuleServiceName(String moduleServiceAliasName);

    void addModuleServiceName(String moduleServiceAliasName, String moduleServiceName);

    void reloadModuleService();

    void clearModuleServiceTable();
}
