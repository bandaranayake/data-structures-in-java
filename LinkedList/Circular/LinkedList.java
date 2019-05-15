public class LinkedList {
    private Node head;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.setNext(head);
            head.setPrev(head);
        } else {
            newNode.setNext(head);
            newNode.setPrev(head.getPrev());
            head.getPrev().setNext(newNode);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.setNext(head);
            head.setPrev(head);
        } else {
            newNode.setNext(head);
            newNode.setPrev(head.getPrev());
            head.getPrev().setNext(newNode);
            head.setPrev(newNode);
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

                    newNode.setPrev(tmp);
                    newNode.setNext(tmp.getNext());
                    tmp.getNext().setPrev(newNode);
                    tmp.setNext(newNode);
                    return true;
                }
                tmp = tmp.getNext();
            } while (tmp != head);
        }
        return false;
    }

    public void deleteFirst() {
        if (head == head.getNext()) {
            head = null;
        } else {
            head.getNext().setPrev(head.getPrev());
            head.getPrev().setNext(head.getNext());
            head = head.getNext();
        }
    }

    public void deleteLast() {
        if (head == head.getNext()) {
            head = null;
        } else {
            head.getPrev().getPrev().setNext(head);
            head.setPrev(head.getPrev().getPrev());
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
                if (index == count++) {
                    tmp.getPrev().setNext(tmp.getNext());
                    tmp.getNext().setPrev(tmp.getPrev());
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