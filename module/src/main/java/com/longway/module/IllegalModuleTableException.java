package com.longway.module;

/**
 * Created by longway on 16/11/6. Email:longway1991117@sina.com
 * build module table fail exception
 */

public class IllegalModuleTableException extends RuntimeException{
    public IllegalModuleTableException(String msg){
        super(msg);
    }
}
