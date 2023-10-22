package com.kjs.roma.environment.response;


import java.sql.Timestamp;

public class JsonBasicResponse extends JsonResponse {


    public JsonBasicResponse(Object obj) {
        resultCode = ResponseCode.SUCCESS.code();
        //resultMsg = MessageUtils.getMessage(getResultCode());
        data = obj;
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }

    public JsonBasicResponse(Object obj, String msg) {
        resultCode = ResponseCode.SUCCESS.code();
        resultMsg = msg;
        data = obj;
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }
}
