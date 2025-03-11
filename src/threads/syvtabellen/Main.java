package threads.syvtabellen;

import java.util.Scanner;

public class Main {
    // Signal from main() to Syvtabellen to stop
    static boolean stop = false;

    public static void main(String[] args) {
        new Syvtabellen().start();
        Scanner input = new Scanner(System.in);
        input.nextLine();
        stop=true; // signal to thread to stop
    }
}

class Syvtabellen extends Thread {
    public void run() {
        while (!Main.stop){
            for (int i=1; i<=10; i++){
                System.out.print(i*7+" ");
//                System.out.flush();
            }
            System.out.println();
        }
    }
}
