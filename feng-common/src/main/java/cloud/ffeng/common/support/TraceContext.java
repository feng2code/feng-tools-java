package cloud.ffeng.common.support;

public class TraceContext {
    public static final String TRANCE_ID = "traceId";
    private static final ThreadLocal<String> TRACE_THREAD_LOCAL = new ThreadLocal<>();

    public static void initTraceId(String traceId) {
        TRACE_THREAD_LOCAL.set(traceId);
    }

    public static String getTraceId() {
        return TRACE_THREAD_LOCAL.get();
    }

    public static void remove() {
        TRACE_THREAD_LOCAL.remove();
    }

}
