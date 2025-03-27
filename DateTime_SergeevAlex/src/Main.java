import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // 1. Основы LocalDate и LocalTime
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Текущая дата и время: " + currentDateTime.format(formatter));

        // 2. Сравнение дат
        DateComparator comparator = new DateComparator();
        LocalDate date1 = LocalDate.of(2025, 1, 11);
        LocalDate date2 = LocalDate.of(2025, 1, 12);
        System.out.println(comparator.compareDates(date1, date2));

        // 3. Сколько дней до Нового года?
        DaysToNewYear daysToNewYear = new DaysToNewYear();
        System.out.println("Дней до Нового года: " + daysToNewYear.daysToNewYear());

        // 4. Проверка високосного года
        LeapYearChecker leapYearChecker = new LeapYearChecker();
        System.out.println("2025 - високосный год: " + leapYearChecker.isLeapYear(2025));

        // 5. Подсчет выходных за месяц
        WeekendCounter weekendCounter = new WeekendCounter();
        System.out.println("Выходных в январе: " + weekendCounter.countWeekends(1, 2025));

        // 6. Расчет времени выполнения метода
        ExecutionTimeCalculator executionTimeCalculator = new ExecutionTimeCalculator();
        Runnable task = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                // Простой цикл для демонстрации
            }
        };
        executionTimeCalculator.measureExecutionTime(task);

        // 7. Форматирование и парсинг даты
        DateFormatter dateFormatter = new DateFormatter();
        System.out.println("Дата через 10 дней: " + dateFormatter.addDaysToDate("13-08-2025"));

        // 8. Конвертация между часовыми поясами
        TimeZoneConverter timeZoneConverter = new TimeZoneConverter();
        System.out.println("Дата и время в Москве: " + timeZoneConverter.convertTimeZone("2025-01-30", "12:00:00"));

        // 9. Вычисление возраста по дате рождения
        AgeCalculator ageCalculator = new AgeCalculator();
        LocalDate birthDate = LocalDate.of(2006, 8, 13);
        System.out.println("Возраст: " + ageCalculator.calculateAge(birthDate));

        // 10. Создание календаря на месяц
        CalendarGenerator calendarGenerator = new CalendarGenerator();
        calendarGenerator.printCalendar(1, 2025);

        // 11. Генерация случайной даты в диапазоне
        RandomDateGenerator randomDateGenerator = new RandomDateGenerator();
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 31);
        System.out.println("Случайная дата: " + randomDateGenerator.generateRandomDate(startDate, endDate));

        // 12. Расчет времени до заданной даты
        TimeToEventCalculator timeToEventCalculator = new TimeToEventCalculator();
        LocalDateTime eventDateTime = LocalDateTime.of(2025, 8, 13, 0, 0);
        System.out.println("Время до события: " + timeToEventCalculator.timeToEvent(eventDateTime));

        // 13. Вычисление количества рабочих часов
        WorkingHoursCalculator workingHoursCalculator = new WorkingHoursCalculator();
        LocalDateTime start = LocalDateTime.of(2025, 1, 1, 8, 0);
        LocalDateTime end = LocalDateTime.of(2025, 1, 1, 17, 0);
        System.out.println("Количество рабочих часов: " + workingHoursCalculator.calculateWorkingHours(start, end));

        // 14. Конвертация даты в строку с учетом локали
        Locale locale = new Locale("ru");
        System.out.println("Форматированная дата: " + LocaleAwareFormatter.formatWithLocale(currentDateTime.toLocalDate(), locale));

        // 15. Определение дня недели по дате
        System.out.println("День недели для текущей даты: " + WeekdayNameFinder.getWeekdayName(currentDateTime.toLocalDate()));
    }
}

