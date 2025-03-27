import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {
    public String convertTimeZone(String dateStr, String timeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime utcDateTime = ZonedDateTime.of(LocalDate.parse(dateStr), LocalTime.parse(timeStr), ZoneId.of("UTC"));
        ZonedDateTime moscowDateTime = utcDateTime.withZoneSameInstant(ZoneId.of("Europe/Moscow"));

        return moscowDateTime.format(formatter);
    }
}
