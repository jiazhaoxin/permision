package com.mmall.exception;

/**
 * Created by admin on 2020/5/28.
 */
public class PermissionExceptin extends RuntimeException {
    public PermissionExceptin() {
        super();
    }

    public PermissionExceptin(String message) {
        super(message);
    }

    public PermissionExceptin(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionExceptin(Throwable cause) {
        super(cause);
    }

    protected PermissionExceptin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
