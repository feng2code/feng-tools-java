package cloud.ffeng.common.exception;


import cloud.ffeng.common.result.Result;
import cloud.ffeng.common.result.ResultStatus;
import cloud.ffeng.common.support.TraceContext;
import lombok.Getter;

import java.util.Objects;

import static cloud.ffeng.common.result.ResultStatus.*;

@Getter
public class BizException extends RuntimeException {
    private final Integer status;
    private final String code;
    private final String traceId;

    public BizException(Integer status, String code, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.code = code;
        this.traceId = TraceContext.getTraceId();
    }

    public boolean isParamError() {
        return Objects.equals(BAD_REQUEST.getStatus(), this.status);
    }

    public boolean isSystemError() {
        return Objects.equals(INTERNAL_SERVER_ERROR.getStatus(), this.status);
    }

    public boolean isForbiddenError() {
        return Objects.equals(FORBIDDEN.getStatus(), this.status);
    }

    public boolean isUnauthorizedError() {
        return Objects.equals(UNAUTHORIZED.getStatus(), this.status);
    }


    public static BizException paramError(String message, Throwable cause) {
        return new BizException(BAD_REQUEST.getStatus(), BAD_REQUEST.getCode(), message, cause);
    }

    public static BizException paramError(String message) {
        return new BizException(BAD_REQUEST.getStatus(), BAD_REQUEST.getCode(), message, null);
    }

    public static BizException systemError(String message, Throwable cause) {
        return new BizException(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getCode(), message, cause);
    }

    public static BizException systemError(String message) {
        return new BizException(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getCode(), message, null);
    }

    public static BizException bizError(String message, Throwable cause) {
        return new BizException(BIZ_ERROR.getStatus(), BIZ_ERROR.getCode(), message, cause);
    }

    public static BizException bizError(String message) {
        return new BizException(BIZ_ERROR.getStatus(), BIZ_ERROR.getCode(), message, null);
    }

    public static BizException of(ResultStatus status, String message, Throwable cause) {
        return new BizException(status.getStatus(), status.getCode(), message, cause);
    }

    public static BizException of(ResultStatus status, String message) {
        return new BizException(status.getStatus(), status.getCode(), message, null);
    }

    public static BizException of(ResultStatus status, String code, String message) {
        return new BizException(status.getStatus(), status.getCode(), message, null);
    }

    public static BizException of(ResultStatus status, String code, String message, Throwable cause) {
        return new BizException(status.getStatus(), code, message, cause);
    }

    public Result<?> toResult() {
        Result<?> result = new Result<>();
        result.setStatus(this.getStatus());
        result.setCode(this.getCode());
        result.setMessage(this.getMessage());
        result.setTraceId(this.getTraceId());
        result.setData(null);
        return result;
    }

    public String logString() {
        String causeInfo = Objects.nonNull(this.getCause()) ? "[ " + this.getCause().getClass().getSimpleName() + " - " + this.getCause().getMessage() + " ]" : "none";
        return String.format("status: %d, code: %s, message: %s. cause: %s", this.status, this.code, this.getMessage(), causeInfo);
    }
}
