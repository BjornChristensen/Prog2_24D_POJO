package repetition.ex3;

import java.util.Scanner;

public class Grass {
    public int daysToCutGrass(double length, double max){
        double days = max - length / 0.8;
        return (int)days;
    }
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.print("How long is the grass today? ");
        double length = input.nextDouble();
        System.out.print("How long is the max length of the grass? ");
        double max = input.nextDouble();
        
        double days = daysToCutGrass(length, max);
        System.out.println(days + " days until grass has to be cut!");
    }

    public static void main(String[] args) {
        Grass grass = new Grass();
        grass.input();
    }
}
