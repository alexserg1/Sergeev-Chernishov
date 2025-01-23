fun main() {
    // Запрашиваем у пользователя размер массива
    println("Введите размер массива:")
    val size = readLine()?.toIntOrNull() ?: return println("Некорректный ввод размера массива.")

    // Инициализируем массив
    val numbers = IntArray(size)

    // Запрашиваем у пользователя элементы массива
    println("Введите $size элементов массива (целые числа):")
    for (i in 0 until size) {
        numbers[i] = readLine()?.toIntOrNull() ?: return println("Некорректный ввод элемента массива.")
    }

    // Переменные для подсчета положительных и отрицательных чисел
    var positiveCount = 0
    var negativeCount = 0

    // Подсчитываем положительные и отрицательные числа
    for (number in numbers) {
        when {
            number > 0 -> positiveCount++
            number < 0 -> negativeCount++
        }
    }

    // Выводим результаты
    println("Количество положительных чисел: $positiveCount")
    println("Количество отрицательных чисел: $negativeCount")
}