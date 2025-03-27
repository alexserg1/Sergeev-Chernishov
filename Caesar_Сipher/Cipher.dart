import 'dart:io';

class CaesarCipher {
  final String alphabet;

  CaesarCipher(this.alphabet);

  String encrypt(String text, int shift) {
    return _shiftText(text, shift);
  }

  String decrypt(String text, int shift) {
    return _shiftText(text, -shift);
  }

  String _shiftText(String text, int shift) {
    StringBuffer shiftedText = StringBuffer();
    for (int i = 0; i < text.length; i++) {
      int index = alphabet.indexOf(text[i]);
      if (index != -1) {
        int newIndex = (index + shift) % alphabet.length;
        if (newIndex < 0) newIndex += alphabet.length;
        shiftedText.write(alphabet[newIndex]);
      } else {
        shiftedText.write(text[i]);
      }
    }
    return shiftedText.toString();
  }

  List<String> bruteForceDecrypt(String text) {
    List<String> results = [];
    for (int shift = 1; shift < alphabet.length; shift++) {
      results.add(decrypt(text, shift));
    }
    return results;
  }

  String frequencyAnalysisDecrypt(String text) {
    // Предположим, что наиболее частая буква в английском языке - 'E'
    int mostFrequentLetterIndex = alphabet.indexOf('E');
    if (text.isEmpty || !alphabet.contains(text[0].toUpperCase())) return '';

    int firstLetterIndex = alphabet.indexOf(text[0].toUpperCase());
    if(firstLetterIndex == -1){
      print("Первая буква текста не найдена в алфавите.");
      return '';

    }

    int shift = (firstLetterIndex - mostFrequentLetterIndex + alphabet.length) % alphabet.length;

    return decrypt(text.toLowerCase(), shift);
  }
}

void main() async {

  const String alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
  final cipher = CaesarCipher(alphabet);

  print('Введите путь к файлу с зашифрованным текстом:');
  String encryptedFilePath;

  while(true){
    try{
      encryptedFilePath= stdin.readLineSync()!;
      if (!File(encryptedFilePath).existsSync()) {
        throw Exception('Файл не существует.');
      }
      break;
    }catch(e){
      print(e);
      print("Попробуйте еще раз:");
    }
  }

  String encryptedContent;
  try{
    encryptedContent= await File(encryptedFilePath).readAsString();
  }catch(e){
    print("Ошибка при чтении файла: $e");
    return;
  }

  print('Выберите метод расшифровки:');
  print('1. Стандартный метод (введите ключ)');
  print('2. Метод с перебором всех возможных сдвигов (brute force)');
  print('3. Метод с частотным анализом');

  String choice= stdin.readLineSync()!;

  switch(choice){
    case '1':
      print('Введите ключ (сдвиг):');
      try{
        int?shift=int.tryParse(stdin.readLineSync()!);
        if(shift==null||shift<0||shift>=alphabet.length){
          throw Exception("Неправильно введен ключ.");
        }
        String decryptedText=cipher.decrypt(encryptedContent.toLowerCase(),shift);
        print(decryptedText);
      }catch(e){
        print("Ошибка при вводе ключа:$e");
      }
      break;

    case '2':
      List<String> bruteForceResults=cipher.bruteForceDecrypt(encryptedContent.toLowerCase());
      for(int i=0;i<bruteForceResults.length;i++){
        print(bruteForceResults[i]);
      }
      break;

    case '3':
      String frequencyDecryptedText=cipher.frequencyAnalysisDecrypt(encryptedContent.toLowerCase());
      if(frequencyDecryptedText.isNotEmpty)
      {
        print(frequencyDecryptedText);
      }else{
        print("Не удалось применить частотный анализ.");
      }
      break;

    default:
      print("Неверный выбор");
      break;
  }
}

