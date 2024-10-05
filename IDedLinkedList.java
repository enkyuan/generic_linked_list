/*
 *  Desc.:  Linked List class that stores objects of generic type T that implement the IDedObject interface and handles insertions, deletion, queries, etc.
 */

public class IDedLinkedList <T extends IDedObject> {
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    public IDedLinkedList() {
       this.head = null; 
    }
    
    public IDedLinkedList(Node head) {
        this.head = head;
    }

    private boolean isEmpty() {
       return this.head == null; 
    }

    public void makeEmpty() {
        head = null;
    }

    public T findID(int ID) {
        Node<T> current = head;
        while (current != null) {
            if (((IDedObject) current.data).getID() == ID) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    } 

   public boolean insertAtFront(T x) {
        Node<T> newNode = new Node<> (x);

        if (head == null || !exists(((IDedObject) newNode.data).getID())) {
            newNode.next = head;
            head = newNode;

            return true;    
        }
        return false; 
    } 

    public T deleteFromFront() {
        if (isEmpty()) {
            return null;
        } else {
            T result = head.data;
            head = head.next;
            return result;
        }
    }

    public boolean exists(int ID) {
        Node<T> current = head;

        while (current != null) {
            if (((IDedObject) current.data).getID() == ID) {
                return true;             
            }
            current = current.next;
        }
        return false;     
    }

    public T delete(int ID) {
        if (isEmpty()) {
            return null;
        }
        if (!exists(ID)) {
            return null;
        } else if (head.data == null) {
            head = head.next;
            return null;
        } else if (((IDedObject) head.data).getID() == ID) {
            T result = head.data;
            head = head.next;
            return result;
        }

        Node<T> current = head;

        while (current.next != null) {
            if (((IDedObject) current.next.data).getID() == ID) {
                T result = current.next.data;
                current.next = current.next.next;
                return result;
            }
            current = current.next;
        }

        return null;
    } 

    public int printTotal() {
        if (isEmpty()) {
            return -1;
        } else {
            int total = 0;
            Node current = head;
            while (current != null) {
                total += ((IDedObject) current.data).getID();
                current = current.next;
            }
            return total;
        }
    } 
}
