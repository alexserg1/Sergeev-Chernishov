import java.time.Duration;
import java.time.LocalDateTime;

public class TimeToEventCalculator {
    public String timeToEvent(LocalDateTime eventDateTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, eventDateTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        return String.format("%d часов %d минут %d секунд", hours, minutes, seconds);
    }
}
