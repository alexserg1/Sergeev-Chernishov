import java.time.LocalDate;

public class DateComparator {
    public String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            return date1 + " раньше, чем " + date2;
        } else if (date1.isAfter(date2)) {
            return date1 + " позже, чем " + date2;
        } else {
            return date1 + " равна " + date2;
        }
    }
}
