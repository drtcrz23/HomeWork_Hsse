package Reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaesarCipher {

  public static String readFile(String path) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded);
  }

  static void write(String message) throws IOException {
    File myFile = new File("otputfile.txt");
    FileOutputStream outputStream = new FileOutputStream(myFile);
    byte[] buffer = message.getBytes();
    outputStream.write(buffer);
    outputStream.close();
  }

  public static void main(String[] args) throws IOException {

    String file = "inputFile.txt";
    String message;
    message = readFile(file);
    System.out.println(message);

    int key = 3;
    int alphabetSize = 26;
    char symbol;
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < message.length(); i++) {
      symbol = (message.charAt(i));
      if (Character.isLetter(symbol)) {
        if ((Character.isLowerCase(symbol) && symbol <= 'z')
                || (Character.isUpperCase(symbol) && symbol <= 'Z')) {
          symbol = (char) (symbol + key);
        } else {
          symbol = (char) (symbol - (alphabetSize - key));
        }
      }
      stringBuilder.append(symbol);
    }
    //чтобы сделать для русского алфавита достаточно поменять 'z' на я, и поменять alphabetSize

    write(stringBuilder.toString());
    System.out.println(stringBuilder);
  }
}
