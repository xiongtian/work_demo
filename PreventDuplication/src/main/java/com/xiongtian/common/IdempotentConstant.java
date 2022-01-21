package com.xiongtian.common;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/7 17:05
 */
public final class IdempotentConstant {
    public final static String TOKEN = "PREVENT_DUPLICATION";
    public final static String PREVENT_DUPLICATION_PREFIX = "PREVENT_DUPLICATION_PREFIX";

    private IdempotentConstant() {
    }
}
