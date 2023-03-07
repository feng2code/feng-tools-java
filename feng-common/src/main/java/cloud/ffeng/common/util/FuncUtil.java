package cloud.ffeng.common.util;

import java.util.function.Supplier;

public final class FuncUtil {

    public static <T> T ifTrueThen(boolean flag, Supplier<T> supplier) {
        if (flag) {
            return supplier.get();
        }
        return null;
    }

    public static void ifTrueThen(boolean flag, Runnable runnable) {
        if (flag) {
            runnable.run();
        }
    }

}
