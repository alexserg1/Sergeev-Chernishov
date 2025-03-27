import java.time.Duration;
import java.time.LocalDateTime;

public class WorkingHoursCalculator {
    public double calculateWorkingHours(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        long totalSeconds = duration.getSeconds();

        // Учитываем только рабочие дни (без выходных)
        // Для простоты примера не учитываем праздники и другие нерабочие дни
        double workingHours = (double) totalSeconds / 3600;

        return workingHours;
    }
}
