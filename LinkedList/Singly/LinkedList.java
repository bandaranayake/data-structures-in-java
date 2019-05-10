public class LinkedList{
	private Node head;
	private Node tail;

	public void addFirst(int value){
		Node newNode = new Node(value);
		if(head==null){
			head = tail = newNode;
		}
		else{
			newNode.setNext(head);
			head = newNode;
		}
	}

	public void addLast(int value){
		Node newNode = new Node(value);
		if(head==null){
			head = tail = newNode;
		}
		else{
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public boolean add(int index, int value){
		if(index == 0){
			addFirst(value);
			return true;
		}

		int count = 0;
		Node tmp = head;

		while(tmp!=null){
			if(index == ++count){
				Node newNode = new Node(value);
				newNode.setNext(tmp.getNext());
				tmp.setNext(newNode);
				if(tail==tmp){
					tail = newNode;
				}
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

	public void deleteFirst(){
		if(head==tail){
			head = tail = null;
		}
		else{
			head = head.getNext();
		}
	}

	public void deleteLast(){
		if(head==tail){
			head = tail = null;
		}
		else{
			Node tmp = head;
			while(tmp.getNext()!=tail){
				tmp = tmp.getNext();
			}
			tmp.setNext(null);
			tail = tmp;
		}
	}

	public boolean delete(int index){
		if(index == 0 && head!=null){
			deleteFirst();
			return true;
		}

		Node tmp = head;
		int count = 0;

		while(tmp!=null){
			if(tmp.getNext()!=null && index == ++count){
				tmp.setNext(tmp.getNext().getNext());
				if(tmp.getNext()==tail){
					tail = tmp;
				}
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

	public boolean contains(int value){
		Node tmp = head;
		while(tmp!=null){
			if(tmp.getValue() == value){
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

	public void print(){
		Node tmp = head;
		while(tmp!=null){
			System.out.print(tmp.getValue() + " ");
			tmp = tmp.getNext();
		}
		System.out.println();
	}
}
