
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.add(0);
        myList.add(2);
        myList.add(4);
        myList.add(6);
        myList.add(8);

        System.out.println("Size: " + myList.size());
        System.out.println("n-element: " + myList.get(2));
        System.out.println("Print");
        System.out.println(myList);
        System.out.println();

        myList.remove(4);
        System.out.println("After removing n-element");
        System.out.println("Size: " + myList.size());
        System.out.println(myList);
        System.out.println();

        System.out.println("Reverse print");
        myList.reversePrint();
        System.out.println();

        myList.reverse();
        System.out.println("Regular print after reversing the linkedList");
        System.out.println(myList);
    }
}