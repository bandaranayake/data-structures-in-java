public class LinkedList {
    private Node head;

    private Node getTail() {
        Node tmp = head;
        if (tmp != null) {
            while (tmp.getNext() != head) {
                tmp = tmp.getNext();
            }
        }
        return tmp;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            newNode.setNext(head);
            getTail().setNext(newNode);
            head = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            newNode.setNext(head);
            getTail().setNext(newNode);
        }
    }

    public boolean add(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return true;
        }

        int count = 0;
        Node tmp = head;

        if (tmp != null) {
            do {
                if (index == ++count) {
                    Node newNode = new Node(value);
                    newNode.setNext(tmp.getNext());
                    tmp.setNext(newNode);
                    return true;
                }
                tmp = tmp.getNext();
            } while (tmp != head);
        }
        return false;
    }

    public void deleteFirst() {
        if (head != null) {
            if (head == head.getNext()) {
                head = null;
            } else {
                getTail().setNext(head.getNext());
                head = head.getNext();
            }
        }
    }

    public void deleteLast() {
        if (head != null) {
            if (head == head.getNext()) {
                head = null;
            } else {
                Node tmp = head;
                Node tail = getTail();
                while (tmp.getNext() != tail) {
                    tmp = tmp.getNext();
                }
                tmp.setNext(head);
            }
        }
    }

    public boolean delete(int index) {
        if (index == 0 && head != null) {
            deleteFirst();
            return true;
        }

        Node tmp = head;
        int count = 0;

        if (tmp != null) {
            do {
                if (index == ++count) {
                    tmp.setNext(tmp.getNext().getNext());
                    return true;
                }
                tmp = tmp.getNext();
            } while (tmp != head);
        }
        return false;
    }

    public boolean contains(int value) {
        Node tmp = head;
        if (tmp != null) {
            do {
                if (tmp.getValue() == value) {
                    return true;
                }
                tmp = tmp.getNext();
            } while (tmp != head);
        }
        return false;
    }

    public void print() {
        Node tmp = head;
        if (tmp != null) {
            do {
                System.out.print(tmp.getValue() + " ");
                tmp = tmp.getNext();
            } while (tmp != head);
            System.out.println();
        }
    }
}