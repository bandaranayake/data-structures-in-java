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
		Node newNode = new Node(value);
		int count = 0;
		Node tmp = head;

		if(index == 0){
			addFirst(value);
			return true;
		}

		while(tmp!=null){
			if(index == ++count){
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
		else if(head!=null){
			head = head.getNext();
		}
	}

	public void deleteLast(){
		if(head==tail){
			head = tail = null;
		}
		else if(tail!=null){
			Node tmp = head;
			while(tmp.getNext()!=tail){
				tmp = tmp.getNext();
			}
			tmp.setNext(null);
			tail = tmp;
		}
	}

	public boolean delete(int index){
		Node tmp = head;
		int count = 0;

		if(index == 0 && head!=null){
			deleteFirst();
			return true;
		}
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

	public void print(){
		Node tmp = head;
		while(tmp!=null){
			System.out.print(tmp.getValue() + " ");
			tmp = tmp.getNext();
		}
		System.out.println();
	}
}
