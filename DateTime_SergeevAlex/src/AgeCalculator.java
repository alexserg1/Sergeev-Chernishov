import java.time.LocalDate;

public class AgeCalculator {
    public int calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDate.getYear();

        if ((today.getMonthValue() < birthDate.getMonthValue()) ||
                (today.getMonthValue() == birthDate.getMonthValue() && today.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }

        return age;
    }
}
