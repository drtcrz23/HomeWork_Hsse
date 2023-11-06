package Multi;

import static Multi.Judge.determineWinner;

public class Main {
  public static void main(String[] args) {
    int N = 10;
    Thread[] players = new Thread[3];
    players[0] = new Thread(new Player("Player 1", N));
    players[1] = new Thread(new Player("Player 2", N));
    players[2] = new Thread(new Player("Player 3", N));

    for (Thread player : players) {
      player.start();
    }

    for (Thread player : players) {
      try {
        player.join();
      } catch (InterruptedException e) {

      }
    }

    determineWinner();
  }
}
