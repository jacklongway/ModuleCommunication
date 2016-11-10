package com.longway.testflavor2;

import com.longway.bz_common.module.flavor1.FlavorTableConstants;
import com.longway.bz_common.module.flavor1.flavor2.IPService2;
import com.longway.bz_common.module.flavor1.flavor2.IUiFlavor2;
import com.longway.module.Module;
import com.longway.module.ModuleProxy;
import com.longway.module.ModuleTable;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 */

public class FModule extends ModuleProxy<IUiFlavor2, IPService2> {
    @Override
    public String getModuleServiceName() {
        return ModuleTable.getInstance().getModuleServiceName(FlavorTableConstants.FLAVOR);
    }

    public static FModule build() {
        return new FModule();
    }

    @Override
    public Module<IUiFlavor2, IPService2> getDefaultModuleService() {
        return null;
    }
}
