package com.longway.testflavor2;

import com.longway.bz_common.module.flavor1.IPService;
import com.longway.bz_common.module.flavor1.IUIFlavor;
import com.longway.module.Module;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 */

public class FlavorModule implements Module<IUIFlavor,IPService> {


    @Override
    public IUIFlavor getUIService() {
        return Flavor.getInstance();
    }

    @Override
    public IPService getPresenterService() {
        return new B();
    }
}
