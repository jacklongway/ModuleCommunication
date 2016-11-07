package com.longway.testflavor;

import com.longway.bz_common.module.flavor1.flavor2.IPService2;
import com.longway.bz_common.module.flavor1.flavor2.IUiFlavor2;
import com.longway.module.Module;

/**
 * Created by longway on 16/11/7. Email:longway1991117@sina.com
 */

public class FlavorModule2 implements Module<IUiFlavor2, IPService2> {
    @Override
    public IUiFlavor2 getUIService() {
        return MyUi.getMyUi();
    }

    @Override
    public IPService2 getPresenterService() {
        return null;
    }
}
