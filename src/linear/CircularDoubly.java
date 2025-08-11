package linear;
class CircDubNode {

	int data;
	CircDubNode prev;
	CircDubNode next;

	public CircDubNode(int data) {

		this.data = data;

		next = null;

	}

}

class CircDubMethods {

	static CircDubNode head, tail;

	public static void insertAtbeg(int data) {

		CircDubNode newnode = new CircDubNode(data);

		if (head == null && tail == null) {

			head = newnode;
			tail = newnode;
			newnode.next = head;
			newnode.prev = tail;
			return;

		}

		else {

			newnode.next = head;
			head = newnode;
			tail.next = head;
			head.prev = tail;
		}

	}

	public static void display() {

		int count = 0;

		CircDubNode ptr = head;

		do {

			System.out.println(ptr.data + " ");

			ptr = ptr.next;

			count++;

		} while (ptr != head);

		System.out.println("length is:" + count);

	}

	public static void insertAtend(int data) {

		CircDubNode newnode = new CircDubNode(data);

		if (head == null && tail == null) {

			head = newnode;
			tail = newnode;
			newnode.next = head;
			newnode.prev = tail;
			return;

		}

		else {

			tail.next = newnode;
			tail = newnode;
			newnode.next = head;
			head.prev = tail;

		}

	}

	public static void insertAtpos(int pos, int data) {

		CircDubNode newnode = new CircDubNode(data);

		CircDubNode prev_ptr = null;

		CircDubNode ptr = head;

		if (head == null && tail == null) {

			head = newnode;

			tail = newnode;

			newnode.next = head;
			newnode.prev = tail;
			return;

		}

		else {

			for (int i = 0; i < pos; i++) {

				prev_ptr = ptr;

				ptr = ptr.next;

			}

			prev_ptr.next = newnode;

			newnode.next = ptr;

		}

	}

	public static void deleteAtbeg() {

		CircDubNode ptr = head;

		if (head == null && tail == null) {

			return;

		}

		else if (head == tail) {

			head = null;

			tail = null;

		}

		else {

			tail.next = head.next;

			head = head.next;
			head.prev = tail;
			ptr.next = null;

		}

	}

	public static void deleteAtend() {

		CircDubNode ptr = head;

		if (head == null && tail == null) {

			return;

		}

		else {

			do {

				ptr = ptr.next;

			} while (ptr.next.next != head);

			ptr.next = head;

			tail = ptr;

		}

	}

	public static void deleteAtpos(int pos) {

		CircDubNode prev_ptr = null;

		CircDubNode ptr = head;

		if (head == null && tail == null) {

			return;

		}

		else {

			for (int i = 0; i < pos; i++) {

				prev_ptr = ptr;

				ptr = ptr.next;

			}

			prev_ptr.next = ptr.next;

			ptr.next = null;

		}

	}

}

public class CircularDoubly extends CircDubMethods {

	public static void main(String[] args) {

		insertAtbeg(10);

		insertAtbeg(30);

		insertAtbeg(20);

		insertAtend(23);

		insertAtpos(1, 45);

		insertAtpos(2, 45);

		deleteAtend();

		deleteAtbeg();

		deleteAtpos(1);

		display();

	}

}
