import java.io.*
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.*
import kotlin.system.measureTimeMillis


// Задача 1: Работа с потоками ввода-вывода
fun copyFileWithIO(inputFile: String, outputFile: String) {
    try {
        BufferedReader(FileReader(inputFile)).use { reader ->
            BufferedWriter(FileWriter(outputFile)).use { writer ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    writer.write(line!!.uppercase(Locale.getDefault()))
                    writer.newLine()
                }
            }
        }
        println("Копирование завершено. Проверьте файл $outputFile.")
    } catch (e: FileNotFoundException) {
        println("Файл не найден: ${e.message}")
    } catch (e: IOException) {
        println("Ошибка ввода-вывода: ${e.message}")
    }
}

// Задача 2: Реализация паттерна Декоратор
interface TextProcessor {
    fun process(text: String): String
}

class SimpleTextProcessor : TextProcessor {
    override fun process(text: String): String = text
}

abstract class TextDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String): String = processor.process(text)
}

class UpperCaseDecorator(processor: TextProcessor) : TextDecorator(processor) {
    override fun process(text: String): String = super.process(text).uppercase(Locale.getDefault())
}

class TrimDecorator(processor: TextProcessor) : TextDecorator(processor) {
    override fun process(text: String): String = super.process(text).trim()
}

class ReplaceDecorator(processor: TextProcessor) : TextDecorator(processor) {
    override fun process(text: String): String = super.process(text).replace(" ", "_")
}

// Задача 3: Сравнение производительности IO и NIO
fun readFileWithIO(filePath: String): String {
    return BufferedReader(FileReader(filePath)).use { it.readText() }
}

fun readFileWithNIO(filePath: String): String {
    return Files.readString(Paths.get(filePath))
}

// Задача 4: Программа с использованием Java NIO
fun copyFileWithNIO(sourcePath: String, destPath: String) {
    try {
        FileInputStream(sourcePath).use { fis ->
            FileOutputStream(destPath).use { fos ->
                val srcChannel = fis.channel
                val destChannel = fos.channel
                srcChannel.transferTo(0, srcChannel.size(), destChannel)
            }
        }
        println("Задание 4: Копирование завершено. Проверьте файл $destPath.")
    } catch (e: IOException) {
        println("Ошибка при копировании файла: ${e.message}")
    }
}
// Задача 5: Асинхронное чтение файла с использованием NIO.2
fun asyncReadFile(filePath: String) {
    val fileChannel = AsynchronousFileChannel.open(Paths.get(filePath), StandardOpenOption.READ)

    val buffer = ByteBuffer.allocate(1024)

    fileChannel.read(buffer, 0, null, object : java.nio.channels.CompletionHandler<Int, Void?> {
        override fun completed(result: Int, attachment: Void?) {
            buffer.flip()
            val content = Charsets.UTF_8.decode(buffer).toString()
            println("Задание 5: Асинхронное чтение файла:\n$content")
        }

        override fun failed(exc: Throwable, attachment: Void?) {
            println("Ошибка при асинхронном чтении файла: ${exc.message}")
        }
    })
}

fun main() {
    // Задание 1
    copyFileWithIO("input.txt", "output.txt")

    val processor = ReplaceDecorator(
        UpperCaseDecorator(
            TrimDecorator(SimpleTextProcessor())
        )
    )
    val result = processor.process(" Hello world ")
    println("Результат обработки текста - $result")

    val filePath = "file.txt"
    val ioTime = measureTimeMillis {
        readFileWithIO(filePath)
    }

    val nioTime = measureTimeMillis {
        readFileWithNIO(filePath)
    }

    println("\nВремя выполнения IO: $ioTime ms\nВремя выполнения NIO: $nioTime ms")

    // Задание 4 - Копирование файла с использованием NIO
    copyFileWithNIO("input.txt", "copied_output.txt")

    // Задание 5 - Асинхронное чтение файла
    asyncReadFile("input.txt")
}