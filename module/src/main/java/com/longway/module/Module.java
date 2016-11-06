package com.longway.module;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 * Module service communication define
 * 1.very perfect to mvp,mvvm,mvc and so on
 */

public interface Module<U,S> {
    /**
     * get ui interface
     * @return
     */
    U getUIService();

    /**
     * get controller service or other
     * @return
     */
    S getPresenterService();
}
