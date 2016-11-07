package com.longway.module;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by longway on 16/11/7. Email:longway1991117@sina.com
 */

public class ReflectUtils {
    private ReflectUtils() {
        throw new AssertionError(" ReflectUtils not instance.");
    }

    public static <T> Class<T> getTypeByIndex(Class<T> clz, int index) {
        if (clz == null) {
            return null;
        }
        Type type = clz.getGenericSuperclass();
        if (type == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] types = parameterizedType.getActualTypeArguments();
            if (types != null && types.length > 0) {
                if (index >= 0 && index < types.length) {
                    return (Class<T>) types[index];
                }
            }
        }
        return null;
    }
}
