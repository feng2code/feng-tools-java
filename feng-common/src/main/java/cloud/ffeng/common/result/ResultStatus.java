package cloud.ffeng.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultStatus {
    SUCCESS("SUCCESS", 200),
    BAD_REQUEST("BAD_REQUEST", 400),
    UNAUTHORIZED("UNAUTHORIZED", 401),
    FORBIDDEN("FORBIDDEN", 403),
    NOT_FOUND("NOT_FOUND", 404),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", 500),
    BAD_GATEWAY("BAD_GATEWAY", 502),
    SERVICE_UNAVAILABLE("SERVICE_UNAVAILABLE", 503),
    GATEWAY_TIMEOUT("GATEWAY_TIMEOUT", 504),
    BIZ_ERROR("BIZ_ERROR", 800),
    ;
    private final String code;
    private final Integer status;

}
