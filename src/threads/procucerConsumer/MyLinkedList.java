// Exercise: MyLinkedlist (Patrick)
// Bjørn 28/12 2024

package threads.procucerConsumer;

public class MyLinkedList {
    Node head=null;
    Node tail=null;

    synchronized
    public void addFirst(int value){
        Node n=new Node(value);
        if (head==null) {
            head=n;
            tail=n;
        }
        else {
            head.prev=n;
            n.next=head;
            head=n;
        }
    }

    synchronized
    public void addLast(int value){
        Node n=new Node(value);
        if (tail==null) {
            head=n;
            tail=n;
        }
        else {
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
    }

    synchronized
    public void addAtIndex(int index, int value) throws MyLinkedListException {
        // index=0 means first item in the list
        // index=1 means second item in the list - and so on
        if (index<0 || size()<index)
            throw new MyLinkedListException("Index must be in [0,"+size()+"]");
        if (index==0) {  // we must modify head
            addFirst(value);
        }
        else {
            Node it=head;   // iterator
            for (int i=1; i<index; i++) it=it.next;
            Node n=new Node(value);
            n.prev=it;
            n.next=it.next;
            it.next=n;
            if (n.next!=null)
                n.next.prev=n;
            else
                tail=n;
        }
    }

    synchronized
    public void removeFirst() throws MyLinkedListException {
        if (isEmpty()) throw new MyLinkedListException("List is empty");
        if (size()==1) {
            head=null;
            tail=null;
        }
        else {
            head=head.next;
            head.prev=null;
        }
    }

//    synchronized
    public void removeLast() throws MyLinkedListException {
        if (isEmpty()) throw new MyLinkedListException("List is empty");
        System.out.println("Removing "+ tail.elm);  // Added for testing
        if (size()==1) {
            head=null;
            tail=null;
        }
        else {
            tail=tail.prev;
            tail.next=null;
        }
    }

    synchronized
    public void removeAtIndex(int index) throws MyLinkedListException {
        // index=0 means first item in the list
        // index=1 means second item in the list - and so on
        if (index<0 || (size()-1)<index)
            throw new MyLinkedListException("Index must be in [0,"+(size()-1)+"]");
        if (index==0) {  // we must update head
            removeFirst();
        } else if (index==size()-1) { // we must update tail
            removeLast();
        } else {
            Node it=head;   // iterator
            for (int i=0; i<index; i++) it=it.next;
            it.prev.next=it.next;
            it.next.prev=it.prev;
            it.prev=null;
            it.next=null;
        }
    }

    synchronized
    public int get(int index) throws MyLinkedListException {
        // index=0 means first item in the list
        // index=1 means second item in the list - and so on
        if (index<0 || (size()-1)<index)
            throw new MyLinkedListException("Index must be in [0,"+(size()-1)+"]");
        Node it=head;   // iterator
        for (int i=0; i<index; i++) it=it.next;
        return it.elm;
    }

    synchronized
    public boolean isEmpty(){
        return (head==null);
    }

    synchronized
    public int size(){
        int result=0;
        Node n=head;
        while (n!=null){
            result++;
            n=n.next;
        }
        return result;
    }

    synchronized
    public String toString(){
        String result="[";
        Node n=head;
        while (n!=null){
            if (n!=head) result=result+",";
            result=result+n.elm;
            n=n.next;
        }
        result=result+"]"+" ("+size()+")";
        return result;
    }

    class Node {
        Node next=null;
        Node prev=null;
        int elm;
        Node(int value){ elm=value; }
    }

}

class MyLinkedListException extends Exception {
    String errortext;
    MyLinkedListException(String text){
        errortext=text;
    }
    public String toString(){
        return "LinkedListException: "+errortext;
    }
}
