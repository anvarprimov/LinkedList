
public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int ind = -1;

    class Node<T>{
        T item;
        Node<T> next;
        public Node(T e){
            item = e;
        }

        boolean hasNext() {
            return next != null;
        }
    }


    public void add(T i) {
        if (ind >= 0){
            tail.next = new Node<>(i);
            tail = tail.next;
        } else {
            head = new Node<>(i);
            tail = head;
        }
        ind++;
    }

    public T get(int index) {
        if (index > ind)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + (ind + 1));
        Node<T> current = head;
        int cnt = 0;
        while (cnt < index) {
            current = current.next;
            cnt++;
        }
        return current.item;
    }

    public void remove(int index) {
        if (index > ind)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + (ind + 1));
        if (index == 0)
            head = head.next;
        else {
            Node<T> current = head;
            int cnt = 0;
            while (cnt < index - 1) {
                current = current.next;
                cnt++;
            }
            current.next = current.next.next;
        }
        ind--;
    }

    public int size() {
        return ind + 1;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        tail = head;
        while (current != null) {
            Node<T> nextElement = current.next;
            current.next = prev;
            prev = current;
            current = nextElement;
        }
        head = prev;
    }

    public void reversePrint() {
        System.out.print("[");
        if(head != null) {
            if (head.hasNext()){
                Node<T> current = head.next;
                reversePrintRec(current);
            }
            System.out.print(head.item);
        }
        System.out.print("]");
    }

    private void reversePrintRec(Node<T> current) {
        if (current.hasNext())
            reversePrintRec(current.next);
        System.out.print(current.item + ", ");
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append("[");
        Node<T> current = head;
        if (ind >= 0)
            ans.append(current.item);
        if (head != null) {
            while (current.hasNext()) {
                current = current.next;
                ans.append(", ").append(current.item);
            }
        }
        ans.append("]");
        return ans.toString();
    }
}
