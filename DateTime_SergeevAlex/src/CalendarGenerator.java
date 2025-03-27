import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarGenerator {
    public void printCalendar(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);

        for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
            LocalDate date = LocalDate.of(year, month, i);
            String dayOfWeek = date.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.getDefault());

            if (date.getDayOfWeek().getValue() >= 6) {
                System.out.println(dayOfWeek + " (" + date + ") - Выходной");
            } else {
                System.out.println(dayOfWeek + " (" + date + ") - Рабочий день");
            }
        }
    }
}
