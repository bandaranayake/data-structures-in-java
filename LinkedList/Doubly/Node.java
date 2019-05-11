public class Node {
    private Node prev;
    private Node next;
    private int value;

    public Node(int value) {
        this.prev = null;
        this.next = null;
        this.value = value;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(int value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }
}