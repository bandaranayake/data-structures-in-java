public class LinkedList {
    private Node head;
    private Node tail;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public boolean add(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return true;
        }

        int count = 0;
        Node tmp = head;

        while (tmp != null) {
            if (index == ++count) {
                Node newNode = new Node(value);

                if (tmp.getNext() != null) {
                    newNode.setNext(tmp.getNext());
                    tmp.getNext().setPrev(newNode);
                } else {
                    tail = newNode;
                }

                newNode.setPrev(tmp);
                tmp.setNext(newNode);
                return true;
            }
            tmp = tmp.getNext();
        }

        return false;
    }

    public void deleteFirst() {
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
    }

    public void deleteLast() {
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
    }

    public boolean delete(int index) {
        if (index == 0 && head != null) {
            deleteFirst();
            return true;
        }

        Node tmp = head;
		int count = 0;

		while (tmp != null) {
            if(index == count++){
                if(tmp.getNext()==null){
                    tmp.getPrev().setNext(null);
                    tail = tmp.getPrev();
                }
                else{
                    tmp.getPrev().setNext(tmp.getNext());
                    tmp.getNext().setPrev(tmp.getPrev());
                }
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    public boolean contains(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.getValue() == value) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }
}