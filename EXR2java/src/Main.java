import java.time.format.DateTimeParseException;

class Utility {

    // 1. Функция для нахождения максимума
    public static int max(int a, int b) {
        if (a == b) {
            throw new IllegalArgumentException("Числа равны");
        }
        return Math.max(a, b);
    }

    // 2. Калькулятор деления
    public static double divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Недопустимо деление на ноль");
        }
        return (double) numerator / denominator;
    }

    // 3. Конвертер строк в числа
    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Не удалось конвертировать строку в число");
        }
    }

    // 4. Проверка возраста
    public static void checkAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть в диапазоне от 0 до 150");
        }
    }

    // 5. Нахождение корня
    public static double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Не возможно найти корень из отрицательного числа");
        }
        return Math.sqrt(number);
    }

    // 6. Факториал
    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // 7. Проверка массива на нули
    public static void checkForZeros(int[] array) {
        for (int num : array) {
            if (num == 0) {
                throw new IllegalArgumentException("Массив содержит нули");
            }
        }
    }

    // 8. Калькулятор возведения в степень
    public static double power(double base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Степень не может быть отрицательной");
        }
        return Math.pow(base, exponent);
    }

    // 9. Обрезка строки
    public static String trimString(String str, int length) {
        if (length > str.length()) {
            throw new IllegalArgumentException("Длина обрезки превышает длину строки");
        }
        return str.substring(0, length);
    }

    // 10. Поиск элемента в массиве
    public static int findInArray(int[] array, int element) {
        for (int i : array) {
            if (i == element) {
                return i;
            }
        }
        throw new IllegalArgumentException("Элемент не найден в массиве");
    }

    // 11. Конвертация в двоичную систему
    public static String toBinary(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        return Integer.toBinaryString(number);
    }

    // 12. Проверка делимости
    public static boolean isDivisible(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Недопустимо деление на ноль");
        }
        return a % b == 0;
    }

    // 13. Чтение элемента списка
    public static <T> T getElementAtIndex(java.util.List<T> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        return list.get(index);
    }

    // 14. Парольная проверка
    public static void checkPasswordStrength(String password) {
        if (password.length() < 8) {
            throw new WeakPasswordException("Пароль слишком слабый");
        }
    }

    // 15. Проверка даты
    public static void checkDate(String date) {
        try {
            java.time.LocalDate.parse(date, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Неверный формат даты", date, 0);
        }
    }
    // 16. Конкатенация строк
    public static String concatenateStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new NullPointerException("Одна из строк равна null");
        }
        return str1 + str2;
    }

    // 17. Остаток от деления
    public static int remainder(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Недопустимо деление на ноль");
        }
        return a % b;
    }

    // 18. Квадратный корень
    public static double sqrt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Не возможно найти квадратный корень из отрицательного числа");
        }
        return Math.sqrt(number);
    }

    // 19. Конвертер температуры
    public static double celsiusToFahrenheit(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Температура ниже абсолютного нуля");
        }
        return celsius * 9/5 + 32;
    }

    // 20. Проверка строки на пустоту
    public static void checkString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Строка пустая или равна null");
        }
    }

    // Исключение для слабого пароля
    public static class WeakPasswordException extends RuntimeException {
        public WeakPasswordException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        // Примеры использования функций
        try {
            System.out.println(max(5, 10));
            System.out.println(divide(10, 2));
            System.out.println(parseInt("123"));
            checkAge(25);
            System.out.println(squareRoot(16));
            System.out.println(factorial(5));
            checkForZeros(new int[]{1, 2, 3});
            System.out.println(power(2, 3));
            System.out.println(trimString("Hello World", 5));
            System.out.println(findInArray(new int[]{1, 2, 3}, 2));
            System.out.println(toBinary(10));
            System.out.println(isDivisible(10, 2));
            System.out.println(getElementAtIndex(java.util.Arrays.asList(1, 2, 3), 1));
            checkPasswordStrength("strongpass");
            checkDate("25.12.2023");
            System.out.println(concatenateStrings("Hello", " World"));
            System.out.println(remainder(10, 3));
            System.out.println(sqrt(9));
            System.out.println(celsiusToFahrenheit(25));
            checkString("Hello");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}