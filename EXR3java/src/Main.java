public class Main {

    public static void main(String[] args) {
        // Пример использования
        int[][] data1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] data2 = {
                {7, 8, 9},
                {10, 11, 12}
        };

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        System.out.println("Матрица 1:");
        matrix1.print();

        System.out.println("Матрица 2:");
        matrix2.print();

        // Сложение матриц
        Matrix sum = matrix1.add(matrix2);
        System.out.println("Сумма матриц:");
        sum.print();

        // Умножение матриц
        int[][] data3 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        Matrix matrix3 = new Matrix(data3);
        System.out.println("Матрица 3:");
        matrix3.print();

        Matrix product = matrix1.multiply(matrix3);
        System.out.println("Произведение матриц:");
        product.print();
    }
}

class Matrix {
    private final int[][] data;

    // Конструктор для инициализации матрицы
    public Matrix(int[][] data) {
        this.data = data;
    }

    // Метод для сложения матриц
    public Matrix add(Matrix other) {
        if (this.data.length != other.data.length || this.data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размеры для сложения.");
        }

        int rows = this.data.length;
        int cols = this.data[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return new Matrix(result);
    }

    // Метод для умножения матриц
    public Matrix multiply(Matrix other) {
        if (this.data[0].length != other.data.length) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно совпадать с количеством строк второй матрицы.");
        }

        int rows = this.data.length;
        int cols = other.data[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < this.data[0].length; k++) {
                    result[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }

        return new Matrix(result);
    }

    // Метод для вывода матрицы
    public void print() {
        for (int[] row : data) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}