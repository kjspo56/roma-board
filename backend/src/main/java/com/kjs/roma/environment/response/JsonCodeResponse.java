package com.kjs.roma.environment.response;


import java.sql.Timestamp;

public class JsonCodeResponse extends JsonResponse {

    public JsonCodeResponse(String errorCode) {
        resultCode = errorCode;
        //resultMsg = MessageUtils.getMessage(getResultCode());
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
        resultCode = rc.code();
        //resultMsg = MessageUtils.getMessage(getResultCode(), rc.name());
        data = "";
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }

    public JsonCodeResponse(ResponseCode rc, String msg) {
        resultCode = rc.code();
        //resultMsg = MessageUtils.getMessage(getResultCode(), rc.name());
        data = msg;
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }
}
