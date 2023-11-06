package Multi;
//
//import java.util.Random;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Player {
//  public Random random = new Random();
//  public String name;
//  private static AtomicInteger counter = new AtomicInteger(0);
//  private Object points;
//
//  public Player(String name) {
//    this.name = name;
//  }
//}
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Player implements Runnable {
  private static final Random random = new Random();
  private static final Object lock = new Object();
  private static final Set<Integer> generatedNumbers = new HashSet<>();

  private final String name;
  private final int N;

  public Player(String name, int N) {
    this.name = name;
    this.N = N;
  }

  private int generateNumber() {
    synchronized(lock) {
      int number;
      do {
        number = random.nextInt(N) + 1;
      } while (generatedNumbers.contains(number));
      generatedNumbers.add(number);
      return number;
    }
  }

  @Override
  public void run() {
    int score = 0;
    while (generatedNumbers.size() < N) {
      int number = generateNumber();
      score++;
      System.out.println(name + " generated number " + number);
    }
    System.out.println(name + " finished with a score of " + score);
  }
}