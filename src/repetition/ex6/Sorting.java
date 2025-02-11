package repetition.ex6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sorting {

    public void input(){
        Scanner input = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();

        for(int i = 1; i <= 5; i++){
            System.out.print("Word number " + i);
            strings.add(input.next());
        }

        Collections.sort(strings);

        for(int i =4; i >= 0; i--){
            System.out.println(strings.get(i));
        }

    }

    public static void main(String[] args) {
        Sorting sort = new Sorting();
        sort.input();
    }
}
