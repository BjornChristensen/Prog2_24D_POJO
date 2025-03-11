package threads.primenumbersJavabog17_3opg2;
// Opgave Javabog.dk kap 17.3 opg2 - Primtal i separat tråd
// Bjørn Christensen 30/12-2024

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // Signal from main() to SieveOfEratosthenes to stop
    static boolean stop = false;
    // Number of tested integers sent from SieveOfEratosthenes to main()
    static int maxPrime=0;

    public static void main(String[] args) throws InterruptedException {
        int maxNumbers = 10000;
        boolean[] isPrime = new boolean[maxNumbers+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 aren't prime numbers

        SieveOfEratosthenes sieve=new SieveOfEratosthenes(maxNumbers, isPrime);
        sieve.start();
        System.out.println("To stop press any key and ENTER");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        stop=true; // signal to thread to stop
//        sieve.join();

        System.out.println("Prime numbers up to " + maxPrime + ":");
        for (int i = 0; i<=maxPrime; i++)
            if (isPrime[i]) System.out.print(i + " ");
        System.out.println();
    }
}

class SieveOfEratosthenes extends Thread {
    int max;
    boolean[] isPrime;

    public SieveOfEratosthenes(int max, boolean[] isPrime) {
        this.max = max;
        this.isPrime = isPrime;
    }

    public void run() {
        System.out.println("SieveOfEratosthenes is running");
        for (int i=2; i*i<=max; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j<=max; j+= i) {
                    isPrime[j] = false;
                }
            }
            System.out.println(i);
            Main.maxPrime=i;
            try { Thread.sleep(1000); }
            catch (InterruptedException e) {}
            if (Main.stop) break;
        }
        System.out.println("SieveOfEratosthenes is done");
    }
}