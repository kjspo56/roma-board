package com.kjs.roma.environment.response;


import com.kjs.roma.environment.utils.BeanUtils;
import org.springframework.context.support.MessageSourceAccessor;

import java.sql.Timestamp;

public class JsonCodeResponse extends JsonResponse {

    private MessageSourceAccessor accessor;

    public JsonCodeResponse(String errorCode) {
        accessor = BeanUtils.getBean(MSG_BEAN_NAME, MessageSourceAccessor.class);
        resultCode = errorCode;
        resultMsg = accessor.getMessage(resultCode, "");
        data = "";
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }

    public JsonCodeResponse(String errorCode, String msg) {
        resultCode = errorCode;
        resultMsg = msg;
        data = "";
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }

    public JsonCodeResponse(ResponseCode rc) {
        accessor = BeanUtils.getBean(MSG_BEAN_NAME, MessageSourceAccessor.class);
        resultCode = rc.code();
        resultMsg = accessor.getMessage(resultCode, rc.name());
        data = "";
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }

    public JsonCodeResponse(ResponseCode rc, String msg) {
        accessor = BeanUtils.getBean(MSG_BEAN_NAME, MessageSourceAccessor.class);
        resultCode = rc.code();
        resultMsg = accessor.getMessage(resultCode, rc.name());
        data = msg;
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }
}
