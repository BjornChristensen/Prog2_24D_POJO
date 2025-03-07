package threads.light_the_candle;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Resource[] res=new Resource[2];

    public static void main(String[] args) throws InterruptedException{
        System.out.println("main() startet");
        res[0]=new Resource("candle");
        res[1]=new Resource("lighter");
        Student s1=new Student("Per");
        Student s2=new Student("Pia");
        s1.start();
        s2.start();
        s1.join();
        s2.join();
        System.out.println("main() ended");
    }
}

class Student extends Thread {
    static Random gen=new Random();
    String name;

    Student(String name) {this.name=name;}

    public void run(){
        System.out.println(name+" started");
        try {
            boolean keepGoing=true;
            while (keepGoing){
                int resNo=gen.nextInt(2);
                Thread.sleep(gen.nextInt(10000));
                Main.res[resNo].lock();
                System.out.println(name+" got the "+Main.res[resNo]);

                resNo=(resNo+1)%2;
                Thread.sleep(gen.nextInt(10000));
                if (Main.res[resNo].tryLock(1, TimeUnit.SECONDS)){
                    System.out.println(name+" got the "+Main.res[resNo]);
                    System.out.println(name+" lights the candle");
                    keepGoing=false;
                }
                if (Main.res[0].isHeldByCurrentThread()) Main.res[0].unlock();
                if (Main.res[1].isHeldByCurrentThread()) Main.res[1].unlock();
            } // while
        } catch (InterruptedException e) {}
        System.out.println(name+" ended");
    }
}

class Resource extends ReentrantLock {
    String name;
    Resource(String name) {this.name=name;}

    @Override
    public String toString() {
        return name;
    }
}
