import java.time.Duration;
import java.time.Instant;

public class ExecutionTimeCalculator {
    public void measureExecutionTime(Runnable task) {
        Instant start = Instant.now();
        task.run();
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println("Время выполнения: " + duration.toMillis() + " мс");
    }
}
