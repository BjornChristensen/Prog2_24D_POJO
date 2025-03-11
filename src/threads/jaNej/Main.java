package threads.jaNej;
// Opgave JaNej
// Bjørn Christensen, 26/1-2025
public class Main {
  public static void main(String[] args) {
    new JaNej("Ja").start();
    new JaNej("Nej").start();
  }
}

class JaNej extends Thread {
  String word;
  JaNej(String w){
    word=w;
  }
  public void run(){
    for (int i=1; i<=10; i++){
      System.out.println(word);
    }
  }
}
