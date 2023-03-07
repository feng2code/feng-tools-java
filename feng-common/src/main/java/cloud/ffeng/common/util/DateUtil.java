package cloud.ffeng.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class DateUtil {
    public static DateTimeFormatter DT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter D_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String format(LocalDateTime localDateTime) {
        if (Objects.isNull(localDateTime)) {
            return null;
        }
        return DT_FORMATTER.format(localDateTime);
    }

    public static String format(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            return null;
        }
        return D_FORMATTER.format(localDate);
    }

    public static LocalDateTime parseDateTime(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return LocalDateTime.parse(str, DT_FORMATTER);
    }

    public static LocalDate parseDate(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return LocalDate.parse(str, D_FORMATTER);
    }

}
