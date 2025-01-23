interface Animal {
    void makeSound();
}

class Animal1 {
    void move() {}
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Bird extends Animal1 {
    @Override
    public void move() {
        System.out.println("Птица летает.");
    }
}

public class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "название: " + title + ", автор: " + author + ", Выпуск: " + year;
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Мяу");
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}

public class Counter {
    private static int count = 0;

    public Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class Cow implements Animal {
    public void makeSound() {
        System.out.println("Му");
    }
}

public class CreditCard implements PaymentSystem {
    private String cardNumber;

    public CreditCard(String cardNumber){
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " с помощью кредитной карты " + cardNumber);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возвращен " + amount + " на кредитную карту " + cardNumber);
    }
}

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Device {
    String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public void turnOn() {
        System.out.println(brand + " включен.");
    }

    public void turnOff() {
        System.out.println(brand + " выключен.");
    }
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Гав");
    }
}

class Dog1 extends Animal1{
    @Override
    void move(){ System.out.println("Собака бегает"); }
}

public class Enemy {
    String name;
    int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }
}

public class Fish extends Animal1 {
    @Override
    public void move() {
        System.out.println("рыба плывет.");
    }
}

import java.util.Scanner;

public class Game {
    private char[][] board;
    private Player1 player1;
    private Player1 player2;
    private char currentPlayer;

    public Game(Player1 player1, Player1 player2) {
        this.board = new char[3][3];
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int moves = 0;
        printBoard();
        while(!gameWon && moves < 9) {
            int[] move;
            if (currentPlayer == 'X') {
                System.out.println(player1.getName() + ", введите свой ход (строка и столбец, например, 0 0).");
                move = getPlayerMove(scanner);
                while(board[move[0]][move[1]] != '-'){
                    System.out.println("Неверный ход, пожалуйста, повторите попытку");
                    move = getPlayerMove(scanner);
                }
            } else {
                System.out.println(player2.getName() + ", введите свой ход (строка и столбец, например, 0 0).");
                move = getPlayerMove(scanner);
                while(board[move[0]][move[1]] != '-'){
                    System.out.println("Неверный ход, пожалуйста, повторите попытку");
                    move = getPlayerMove(scanner);
                }
            }
            board[move[0]][move[1]] = currentPlayer;
            printBoard();
            moves++;
            gameWon = checkWin();
            if(gameWon){
                System.out.println(currentPlayer + " Выиграл!");
            }else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        if (moves == 9 && !gameWon){
            System.out.println("Это ничья");
        }
    }

    private int[] getPlayerMove(Scanner scanner) {
        int[] move = new int[2];
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        move[0] = Integer.parseInt(parts[0]);
        move[1] = Integer.parseInt(parts[1]);
        return move;
    }


    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    public void opensSettings(){
        System.out.println("Ноутбук " + brand + " открыл приложение настроек.");
    }
}

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> searchByYear(int year) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void displayAllBooks() {
        for(Book book: books){
            System.out.println(book.toString());
        }
    }
}

public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix add(Matrix other) {
        int rows = this.matrix.length;
        int cols = this.matrix[0].length;
        if (rows != other.matrix.length || cols != other.matrix[0].length) {
            throw new IllegalArgumentException("Выступы должны иметь одинаковые размеры.");
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        int rows1 = this.matrix.length;
        int cols1 = this.matrix[0].length;
        int rows2 = other.matrix.length;
        int cols2 = other.matrix[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Для умножения количество столбцов в первой матрице должно равняться количеству строк во второй матрице.");
        }

        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    public void printMatrix() {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Product1> products;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product1 product) {
        this.products.add(product);
    }

    public double getTotalCost() {
        double total = 0;
        for(Product1 product: products){
            total += product.getPrice();
        }
        return total;
    }

    public List<Product1> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }
    @Override
    public String toString() {
        return "Заказ клиента " + customer.getName() + " включает в себя продукты: " + products + " cумма: " + getTotalCost();
    }

}

public class PayPal implements PaymentSystem {
    private String email;

    public PayPal(String email){
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("оплачено " + amount + " через PayPal по электронной почте " + email);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возвращен " + amount + " через PayPal по электронной почте " + email);
    }
}

public interface PaymentSystem {
    void pay(double amount);
    void refund(double amount);
}

class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Пол: " + gender);
    }

    public void increaseAge() {
        age++;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}

class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Пол: " + gender);
    }

    public void increaseAge() {
        age++;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}

public class Player {
    String name;
    int health;
    Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " атакует " + enemy.name + " с " + weapon.name);
        enemy.health -= weapon.damage;
        System.out.println(enemy.name + " состояние здоровья(HP): " + enemy.health);
    }
}

public class Player1 {
    private String name;
    private char symbol;

    public Player1(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

}

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Product {
    private String name;
    private double price;
    private int quantity;


    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public String toString(){
        return "продукт: " + name + ", цена: " + price + ", количество: " + quantity;
    }
}

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea() {
        return length * width;
    }
}

public abstract class Shape {
    public abstract double getArea();
}

public class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println("Телефон " + brand + " сделал фотографию.");
    }
}

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store(){
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(String name){
        products.removeIf(product -> product.getName().equalsIgnoreCase(name));
    }

    public List<Product> findProduct(String name){
        List<Product> foundProducts = new ArrayList<>();
        for(Product product: products){
            if(product.getName().equalsIgnoreCase(name)){
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public void displayAllProducts(){
        for(Product product: products){
            System.out.println(product.toString());
        }
    }
}

public class Student implements Comparable<Student>{
    private String name;
    private String group;
    private double grade;

    public Student(String name, String group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getGrade() {
        return grade;
    }


    public String toString(){
        return "Имя: " + name + ", Группа: " + group + ", Класс: " + grade;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}

abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    void move() {
        System.out.println("Машина едет");
    }
}

class Bike extends Transport {
    void move() {
        System.out.println("Велосипед едет");
    }
}

import java.util.UUID;

class UniqueID{
    private static int idCounter = 0;

    public static String generateID(){
        idCounter++;
        return UUID.randomUUID().toString() + "-" + idCounter;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    private List<Student> students;

    public University() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortByStudentName(){
        Collections.sort(students);
    }

    public List<Student> filterStudentsByGrade(double minGrade) {
        List<Student> filteredStudents = new ArrayList<>();
        for(Student student: students){
            if(student.getGrade() >= minGrade){
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public void displayAllStudents(){
        for (Student student: students){
            System.out.println(student.toString());
        }
    }
}

public class Weapon {
    String name;
    int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
}

class Worker extends Person {
    private double salary;

    public Worker(String name, int age, String gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Worker {
    private int numberOfSubordinates;

    public Manager(String name, int age, String gender, double salary, int numberOfSubordinates) {
        super(name, age, gender, salary);
        this.numberOfSubordinates = numberOfSubordinates;
    }
}



