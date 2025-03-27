// Задача 1
class DatabaseConnection {
  static DatabaseConnection? _instance;

  DatabaseConnection._() {
    print('Создано подключение к базе данных');
  }

  static DatabaseConnection get instance {
    _instance ??= DatabaseConnection._();
    return _instance!;
  }
}

// Задача 2
class Logger {
  static Logger? _instance;
  final List<String> _logs = [];

  Logger._() {}

  static Logger get instance {
    _instance ??= Logger._();
    return _instance!;
  }

  void addLog(String message) {
    _logs.add(message);
  }

  void printLogs() {
    for (var log in _logs) {
      print(log);
    }
  }
}

// Задача 3
enum OrderStatus { NEW, IN_PROGRESS, DELIVERED, CANCELLED }

class Order {
  String _id;
  OrderStatus _status;

  Order(this._id) : _status = OrderStatus.NEW;

  void changeStatus(OrderStatus newStatus) {
    if (_status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
      print('Нельзя отменить доставленный заказ');
      return;
    }

    _status = newStatus;
  }

  void printStatus() {
    print('Статус заказа $_id: $_status');
  }
}

// Задача 4
enum Season { WINTER, SPRING, SUMMER, AUTUMN }

String getSeasonName(Season season) {
  switch (season) {
    case Season.WINTER:
      return 'Зима';
    case Season.SPRING:
      return 'Весна';
    case Season.SUMMER:
      return 'Лето';
    case Season.AUTUMN:
      return 'Осень';
  }
}

void main() {
  // Задача 1
  DatabaseConnection db1 = DatabaseConnection.instance;
  DatabaseConnection db2 = DatabaseConnection.instance;

  print(db1 == db2); // true

  // Задача 2
  Logger logger1 = Logger.instance;
  Logger logger2 = Logger.instance;

  logger1.addLog('1');
  logger2.addLog('2');

  logger1.printLogs();

  // Задача 3
  Order order = Order('123');
  order.printStatus();

  order.changeStatus(OrderStatus.IN_PROGRESS);
  order.printStatus();

  order.changeStatus(OrderStatus.DELIVERED);
  order.printStatus();

  order.changeStatus(OrderStatus.CANCELLED);

  // Задача 4
  print(getSeasonName(Season.AUTUMN));
}
