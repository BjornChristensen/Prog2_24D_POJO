package threads.w3s;

public class Main extends Thread {
    public static int amount = 0;

    public static void main(String[] args)   {
        Main thread = new Main();
        thread.start();
        System.out.println(amount);
        amount++;
        try {
            thread.join();
        } catch(InterruptedException e) {
            System.out.println("Hovsa");
        }
        System.out.println(amount);
    }

    public void run() {
        amount++;
    }
}