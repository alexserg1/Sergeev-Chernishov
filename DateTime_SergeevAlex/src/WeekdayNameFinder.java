import java.time.LocalDate;

public class WeekdayNameFinder {
    public static String getWeekdayName(LocalDate date) {
        switch (date.getDayOfWeek()) {
            case MONDAY: return "Понедельник";
            case TUESDAY: return "Вторник";
            case WEDNESDAY: return "Среда";
            case THURSDAY: return "Четверг";
            case FRIDAY: return "Пятница";
            case SATURDAY: return "Суббота";
            case SUNDAY: return "Воскресенье";
            default: throw new IllegalArgumentException("неизвестный день недели");
        }
    }
}