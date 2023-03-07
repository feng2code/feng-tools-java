package cloud.ffeng.common.util;

import java.util.UUID;

public final class UuidUtil {

    public static String generateUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
