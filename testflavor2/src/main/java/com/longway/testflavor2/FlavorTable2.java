package com.longway.testflavor2;

import com.longway.bz_common.module.flavor1.flavor2.Flavor2TableConstants;
import com.longway.module.IModuleTable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by longway on 16/11/10. Email:longway1991117@sina.com
 */

public class FlavorTable2 implements IModuleTable {
    private Map<String, String> mFlavorTable;

    public FlavorTable2() {
        mFlavorTable = new ConcurrentHashMap<>();
        mFlavorTable.put(Flavor2TableConstants.FLAVOR2, FlavorModule.class.getName());
    }

    @Override
    public String getModuleServiceName(String moduleServiceAliasName) {
        return mFlavorTable.get(moduleServiceAliasName);
    }

    @Override
    public String removeModuleServiceName(String moduleServiceAliasName) {
        return null;
    }

    @Override
    public boolean containModuleServiceName(String moduleServiceAliasName) {
        return mFlavorTable.containsKey(moduleServiceAliasName);
    }

    @Override
    public void addModuleServiceName(String moduleServiceAliasName, String moduleServiceName) {
    }

    @Override
    public void reloadModuleService() {

    }

    @Override
    public void clearModuleServiceTable() {

    }
}
