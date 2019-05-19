public class Stack {
    private Node top;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
    }

    public int pop() {
        Node tmp = top;
        top = top.getNext();
        return tmp.getValue();
    }

    public int peek() {
        return top.getValue();
    }

    public boolean isEmpty() {
        return (top == null) ? true : false;
    }

    public boolean contains(int value) {
        Node tmp = top;
        while (tmp != null) {
            if (tmp.getValue() == value) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    public void print() {
        Node tmp = top;
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }
}