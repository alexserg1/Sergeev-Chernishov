public class Main {

    public static void main(String[] args) {
        try {
            String str1 = "Hello, ";
            String str2 = "world!";
            String result = concatenateStrings(str1, str2);
            System.out.println("Результат конкатенации: " + result);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String concatenateStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new NullPointerException("Одна из строк равна null");
        }
        return str1 + str2;
    }
}