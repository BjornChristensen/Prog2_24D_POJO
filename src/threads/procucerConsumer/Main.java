package threads.procucerConsumer;
// Producer/Consumer problem.
// MyLinkedList class is used as a stack
// main() thread is the producer and Class Consumer is consumer
// The program will crash with more than one consumer because they will
// both modify the head Node in the MyLinkedList class
// The problem is solved with synchronized on the add and remove methods
// in class MyLinkedList
// Bjørn Christensen 30/12-2024

public class Main {
    static MyLinkedList list = new MyLinkedList();
 //   static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        int N=2;
        System.out.println("Producer started");
        Consumer[] users = new Consumer[N];
        for (int i = 0; i < N; i++) {
            users[i]=new Consumer();
            users[i].start();
        }

        for (int i=0; i<5; i++) {
            list.addFirst(i);
            System.out.println("P "+i);
 //           Thread.sleep(100);
        }
    }
}

class Consumer extends Thread {
    public void run() {
        System.out.println("Consumer " + this.threadId() + " started");
        while (true) {
            try {
                Main.list.removeLast();
            } catch (Exception e){}
        }
    }
}
