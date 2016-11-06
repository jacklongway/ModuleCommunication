package com.longway.module;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 * build service module fail exception
 * for example service class must be implement Module and void constructor and so on
 */

public class IllegalModuleTypeException extends RuntimeException {
    public IllegalModuleTypeException(String msg) {
        super(msg);
    }
}
