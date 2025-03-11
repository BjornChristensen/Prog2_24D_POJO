// Dining Philosophers
// Bjørn Christensen, 14/1-2025
package threads.fishermensProblem;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  static final int N=5;             // No of fishermen and oars
  static Oar[] oars =new Oar[N];

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Main started");

    // Make some oars
    for (int i=0; i<N; i++) oars[i]=new Oar(i);

    // Make some fishermen and start them
    Fisher[] fishers =new Fisher[N];
    for (int i=0; i<N; i++) {
      fishers[i] = new Fisher(i);
      fishers[i].start();
    }

    // Wait for all fishermen to finish
    for (int i=0; i<N; i++) fishers[i].join();
    System.out.println("Main finished");
  }
}

class Fisher extends Thread {
  static final int M = 3;         // No of fish to eat
  int id;                         // Id of this fisher
  int left, right;                // Index of left and right oar
  Random gen = new Random();      // Random number generator

  Fisher(int id) {
    this.id = id;
    left = id;
    right = (id + 1) % Main.N;    // Wrap if index > N
  }

  public void run() {
    System.out.println("F" + id + " started");
    try {
      Oar first, second;            // Two oars
      int m = 0;                    // No of fish eaten so far
      while (M > m) {
        if (gen.nextBoolean()) {
          first = Main.oars[left];    // grab left first
          second = Main.oars[right];  // then right
        } else {                      // or
          first = Main.oars[right];   // right first
          second = Main.oars[left];   // the left
        }
        first.lock();                 // grab the first oar

        // Deadlock prone code:
//      second.lock();                        // and the second
//      m++;                                  // Eat a fish
//      System.out.println("F"+id+" eats fish "+m);
//      Thread.sleep(gen.nextInt(1000));
//      first.unlock();
//      second.unlock();

        // To avoid deadlock use tryLock() and release after 1000 ms
        if (second.tryLock(1000, TimeUnit.MILLISECONDS)) {
          m++;                              // Eat a meatball
          System.out.println("F" + id + " eats fish " + m);
          Thread.sleep(gen.nextInt(1000));
          second.unlock();
        } else {
          System.out.println("F" + id + " failed to grab oar " + second);
        }
        first.unlock(); // Always release the first oar

      } // while
    } catch (InterruptedException ex) {}
    System.out.println("F" + id + " finished");
  }
}

class Oar extends ReentrantLock {
  int id;
  Oar(int id) { this.id=id; }
  public String toString() { return ""+id; }
}