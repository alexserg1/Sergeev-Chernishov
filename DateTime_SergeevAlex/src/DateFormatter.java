import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public String addDaysToDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        LocalDate newDate = date.plusDays(10);

        return newDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
