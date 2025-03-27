import java.time.LocalDate;
import java.time.YearMonth;

public class WeekendCounter {
    public int countWeekends(int month, int year) {
        int weekends = 0;
        YearMonth yearMonth = YearMonth.of(year, month);

        for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
            LocalDate date = LocalDate.of(year, month, i);
            if (date.getDayOfWeek().getValue() >= 6) {
                weekends++;
            }
        }

        return weekends;
    }
}
