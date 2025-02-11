package repetition.ex7;

public class Searching {

    // 1. solution
//    public int search(String[] arr, String str){
//        for(int i = 0; i < arr.length; i++){
//            if(str.equals(arr[i])){
//                return i;
//            }
//        }
//        return -1;
//    }
    // alternative
    public int search(String[] arr, String str) {
        for(int i = 0; i < arr.length; i++){
            if(str.equals(arr[i])){
                return i;
            }
            if(i == arr.length -1 ){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        // searching 1. solution
//        Searching s = new Searching();
//        String[] arr  = {"Hello", "World", "This", "is", "it"};
//        var index = s.search(arr, "iii");
//        System.out.println(index);

        // searcing alternative

        Searching s = new Searching();
        String[] arr  = {"Hello", "World", "This", "is", "it"};
        int index = 0;
        try {
            index = s.search(arr, "it");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(index);
    }
}
