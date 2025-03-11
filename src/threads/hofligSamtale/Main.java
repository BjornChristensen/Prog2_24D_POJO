package threads.hofligSamtale;
// Fire tråde udskriver samtidigt.
// Der er ikke nogen afbrydelser mellem linjeskift.
// Det er fordi at println() er synchronized
// Bjørn Christensen, 31/1-2025

public class Main {
    public static void main(String[] args) {
        new Speaker("Jeg er fra Danmark. Jeg taler dansk").start();
        new Speaker("I am from England. I speak English").start();
        new Speaker("Ich komme aus Deutschland. Ich spreche Deutsch").start();
        new Speaker("Je suis de la France. Je parle français").start();
    }
}

class Speaker extends Thread {
    String word;
    Speaker(String w){
        word=w;
    }
    public void run(){
        for (int i=1; i<=5; i++){
            System.out.println(word);
        }
    }
}