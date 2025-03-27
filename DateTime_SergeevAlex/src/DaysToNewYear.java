import java.time.LocalDate;

public class DaysToNewYear {
    public long daysToNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);

        return java.time.temporal.ChronoUnit.DAYS.between(today, newYear);
    }
}
