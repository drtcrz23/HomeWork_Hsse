package Multi;
class Judge {
  private static final Object lock = new Object();

  static void determineWinner() {
    synchronized(lock) {
      System.out.println("The winner is "); //не получилось написать это
    }
  }
}
