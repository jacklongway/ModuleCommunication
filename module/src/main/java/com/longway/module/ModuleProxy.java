package com.longway.module;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com module proxy 1.get module name 2.get
 * module real service 3.build default module service 4.and so on
 */

public abstract class ModuleProxy<U, S> implements Module<U, S> {

    /**
     * get ui service
     */
    @Override
    public final U getUIService() {
        Module<U, S> module = getProxy();
        if (module == null) {
            return null;
        }
        return module.getUIService();
    }

    /**
     * get controller service
     */
    @Override
    public final S getPresenterService() {
        Module<U, S> module = getProxy();
        if (module == null) {
            return null;
        }
        return module.getPresenterService();
    }

    private Module<U, S> getProxy() {
        Module module = ModuleManager.getInstance().loadModule(getModuleServiceName());
        return module != null ? module : getDefaultModuleService();
    }

    /**
     * get service name
     */
    public abstract String getModuleServiceName();

    /**
     * get default module service when load service error
     * @return
     */
    public abstract Module<U, S> getDefaultModuleService();
}
