package cloud.ffeng.common.result;

import cloud.ffeng.common.support.TraceContext;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

import static cloud.ffeng.common.result.ResultStatus.*;

@Data
public class Result<T> implements Serializable {
    private Integer status;
    private String code;
    private String message;
    private String traceId;
    private T data;

    public static <T> Result<T> success(T data) {
        return of(SUCCESS.getStatus(), SUCCESS.getCode(), null, data);
    }

    public static <T> Result<T> success(T data, String message) {
        return of(SUCCESS.getStatus(), SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> paramError(String message) {
        return of(BAD_REQUEST.getStatus(), BAD_REQUEST.getCode(), message, null);
    }

    public static <T> Result<T> systemError(String message) {
        return of(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getCode(), message, null);
    }

    public static <T> Result<T> systemError(String code, String message) {
        return of(INTERNAL_SERVER_ERROR.getStatus(), code, message, null);
    }

    public static <T> Result<T> of(ResultStatus resultStatus, String message, T data) {
        return of(resultStatus.getStatus(), resultStatus.getCode(), message, data);
    }

    public static <T> Result<T> of(ResultStatus resultStatus, T data) {
        return of(resultStatus.getStatus(), resultStatus.getCode(), null, data);
    }

    public static <T> Result<T> of(Integer status, String code, String message, T data) {
        Result<T> result = new Result<>();
        result.setMessage(message);
        result.setStatus(status);
        result.setCode(code);
        result.setTraceId(TraceContext.getTraceId());
        result.setData(data);
        return result;
    }

}
