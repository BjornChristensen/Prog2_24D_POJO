package collections;

public class ArrayList_vs_LinkedList {
    static int Max=1000000;
/*
    public static void main(String[] args) {
        System.out.println("ArrayList_vs_LinkedList");
        System.out.println("ArrayList.addFirst: "+testAddFirst(new ArrayList<Integer>()));
        System.out.println("LinkedList.addFirst: "+testAddFirst(new LinkedList<Integer>()));
        System.out.println("ArrayList.addLast: "+testAddLast(new ArrayList<Integer>()));
        System.out.println("LinkedList.addLast: "+testAddLast(new LinkedList<Integer>()));
        System.out.println("ArrayList.get: "+testGet(new ArrayList<Integer>()));
        System.out.println("LinkedList.get: "+testGet(new LinkedList<Integer>()));
    }

    static double testAddFirst(List<Integer> list) {
        double start=System.currentTimeMillis();
        for (int i = 0; i < Max; i++) list.addFirst(i);
        double stop=System.currentTimeMillis();
        return stop-start;
    }

    static double testAddLast(List<Integer> list) {
        double start=System.currentTimeMillis();
        for (int i = 0; i < Max; i++) list.addLast(i);
        double stop=System.currentTimeMillis();
        return stop-start;
    }

    static double testGet(List<Integer> list) {
        testAddLast(list);  // put some elements in the list
        double start=System.currentTimeMillis();
        for (int i = 0; i < Max; i++) list.get(i);
        double stop=System.currentTimeMillis();
        return stop-start;
    }
*/

}