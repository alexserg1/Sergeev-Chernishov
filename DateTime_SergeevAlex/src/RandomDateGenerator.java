import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RandomDateGenerator {
    public LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        Random random = new Random();
        long randomDays = random.nextInt((int) days + 1);

        return startDate.plusDays(randomDays);
    }
}
