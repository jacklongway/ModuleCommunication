package com.longway.bz_common.module.flavor1;

import com.longway.module.M;
import com.longway.module.ModuleTable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 */

public class FTable extends ModuleTable {
    public static final String MODULE = "f1";
    public static final String SERVICE_DUMP = "dump";

    private static FTable sFTable;

    private FTable() {
        super();
    }

    @Override
    public HashMap<String, ArrayList<M>> moduleTable() {
        HashMap<String, ArrayList<M>> map = new HashMap<>();
        ArrayList<M> ms = new ArrayList<>();
        M m = new M();
        m.mModuleName = MODULE;
        m.mServiceName = SERVICE_DUMP;
        m.mServiceClass = "com.longway.testflavor2.FlavorModule";
        ms.add(m);
        map.put(MODULE, ms);
        return map;
    }

    public static FTable getFTable() {
        if (sFTable == null) {
            synchronized (FTable.class) {
                sFTable = new FTable();
            }
        }
        return sFTable;
    }
}
