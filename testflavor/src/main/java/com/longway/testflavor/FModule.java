package com.longway.testflavor;

import com.longway.bz_common.module.flavor1.FTable;
import com.longway.bz_common.module.flavor1.IPService;
import com.longway.bz_common.module.flavor1.IUIFlavor;
import com.longway.module.Module;
import com.longway.module.ModuleProxy;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 */

public class FModule extends ModuleProxy<IUIFlavor, IPService> {
    @Override
    public String getModuleServiceName() {
        return FTable.getFTable().getModuleServiceName(FTable.MODULE,FTable.SERVICE_DUMP);
    }

    public static FModule build() {
        return new FModule();
    }

    @Override
    public Module<IUIFlavor, IPService> getDefaultModuleService() {
        return null;
    }
}
