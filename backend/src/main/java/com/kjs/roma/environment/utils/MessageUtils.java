package com.kjs.roma.environment.utils;

import org.springframework.context.support.MessageSourceAccessor;
import static com.google.common.base.Preconditions.checkState;

public class MessageUtils {
    private static MessageSourceAccessor accessor;
    public static String getMessage(String key){
        checkState(null != accessor, "MessageSourceAccessor is not initialized.");
        return accessor.getMessage(key);
    }

    public static String getMessage(String key, Object... params){
        checkState(null != accessor, "MessageSourceAccessor is not initialized.");
        return accessor.getMessage(key, params);
    }

    public static void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor){
        MessageUtils.accessor = messageSourceAccessor;
    }
}
