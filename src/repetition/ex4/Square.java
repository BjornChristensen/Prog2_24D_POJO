package repetition.ex4;

public class Square {

    // version 1
//    public void printSquare(int number){
//        for(int i = 0; i < number; i++){
//            for(int j = 0; j < number; j++){
//                System.out.print("*  ");
//            }
//            System.out.println();
//        }
//    }

    // Version 2
    public void printSquare(int number, String sign){
        for(int i = 0; i < number; i++){
            for(int j = 0; j < number; j++){
                System.out.print(sign + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Square sq = new Square();
        sq.printSquare(6, ">");
    }
}
