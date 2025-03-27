import java.time.Year;

public class LeapYearChecker {
    public boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }
}
