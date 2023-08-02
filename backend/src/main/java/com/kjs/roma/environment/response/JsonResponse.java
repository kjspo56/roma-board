package com.kjs.roma.environment.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class JsonResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Getter(onMethod_ = @JsonIgnore)
    protected final String MSG_BEAN_NAME = "messageSourceAccessor";

    protected String resultCode;
    protected String resultMsg;
    protected Object data;
    protected Timestamp currentTimestamp;

    public static JsonResponse create(Object obj) {
        return new JsonBasicResponse(obj);
    }

    public static JsonResponse create(Object obj, String msg) {
        return new JsonBasicResponse(obj, msg);
    }

    public static JsonResponse create(Object obj, Pageable pageable, long total) {
        return new JsonBasicResponse(new PageImpl<>((List<?>) obj, pageable, total));
    }

    public static JsonResponse create(String errorCode) {
        return new JsonCodeResponse(errorCode);
    }

    public static JsonResponse create(String resultCode, String msg) {
        return new JsonCodeResponse(resultCode, msg);
    }

    public static JsonResponse create(ResponseCode rc) {
        return new JsonCodeResponse(rc);
    }

    public static JsonResponse create(ResponseCode rc, String msg) {
        return new JsonCodeResponse(rc, msg);
    }
}
