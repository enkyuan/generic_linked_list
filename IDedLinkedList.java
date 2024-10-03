/*
 *  Desc.:    
 */

public class IDedLinkedList <T extends IDedObject> {
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    private IDedLinkedList() {}

    public static <T extends IDedObject> IDedLinkedList<T> create() {
        return new IDedLinkedList<>();
    }

    public IDedLinkedList(Node head) {
        this.head = head;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void makeEmpty() {
        head = null;
    }

    public T findID(int ID) {
        Node current = head;
        while (current != null) {
            if (((IDedObject) current.data).getID() == ID) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    } 

    public boolean insertAtFront(T x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            return true; 
        } else {
            newNode.next = head;
            head = newNode;
            return false;
        }
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

    private boolean checkExistence(int ID) {
        Node current = head;
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
        if (!checkExistence(ID)) {
            return null;
        } else if (head.data == null) {
            head = head.next;
            return null;
        } else if (((IDedObject) head.data).getID() == ID) {
            T result = head.data;
            head = head.next;
            return result;
        }

        Node current = head;

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
