package repetition.ex5;

public class ProperCase {

    public String properCase(String sentence){
        if(sentence.equals(sentence.toUpperCase())){
            return sentence;
        }
        
        String[] words=sentence.split(" ");
        String result="";
        for (String word :words){
            if (word.length()>3) {
                word=word.toLowerCase();
                String first=word.substring(0,1).toUpperCase();
                word=first+word.substring(1);
            } else {
                word=word.toLowerCase();
            }
            result=result+word+" ";
        }
        return result;
    }

    public static void main(String[] args) {
        ProperCase w = new ProperCase();
        System.out.println(w.properCase("HELLO WORLD"));
        System.out.println(w.properCase("hello world"));
        System.out.println(w.properCase("Hel"));
        System.out.println(w.properCase("Hello world"));
    }
}
