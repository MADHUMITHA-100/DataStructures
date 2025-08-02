package linear_ds;

class Node{
	int data;
	Node next;
	//he initialize the instance variable
	public Node(int data) {
		this.data=data;
		next=null;
		
	}
}
//method class
class Methods{
	static Node head=null;
	public static void insertAtbeg(int data) {
		Node newnode=new Node(data);
		if(head==null ) {
			head=newnode;
			return;
		}
		else {
			newnode.next=head;
			head=newnode;
		}
	}
	public static void display() {
		Node ptr=head;
		while(ptr!=null) {
			System.out.println(ptr.data+" ");
			ptr=ptr.next;	
		}		
	}
	public static void insertAtend(int data) {
		Node newnode=new Node(data);
		Node ptr=head;
		if(head==null) {
			head=newnode;
			return;
		}
		else {
			while(ptr.next!=null) {
				ptr=ptr.next;
			}
			ptr.next=newnode;
		}
	}
	public static void insertAtpos(int pos,int data) {
		Node newnode=new Node(data);
		Node prev_ptr=null;
		Node ptr=head;
		if(head==null) {
			head=newnode;
		}
		else if(pos==0) {
			insertAtbeg(data);
		}
		else {
			for(int i=0;i<pos;i++) {
				prev_ptr=ptr;
				ptr=ptr.next;		
			}
			prev_ptr.next=newnode;
			newnode.next=ptr;
		}
	}
	public static void deleteAtbeg() {
		Node ptr=head;
		if(head==null) {
			return;
		}
		else {
			head=head.next;
			ptr.next=null;
		}	
		}

	public static void deleteAtend() {
		Node ptr=head;
	    Node prev_ptr=null;
		if(head==null) {
			return;
		}
		else {
			while(ptr.next!=null) {
				prev_ptr=ptr;
				ptr=ptr.next;
			}
			prev_ptr.next=null;
			ptr.next=null;
			
		}
	}
	public static void deleteAtpos(int pos) {
		Node prev_ptr=null;
		Node ptr=head;
		if(head==null) {
			return;
		}
		else {
			for(int i=0;i<pos;i++) {
				prev_ptr=ptr;
				ptr=ptr.next;
			}
			prev_ptr.next=ptr.next;
			ptr.next=null;		
			
		}
	}	
}
public class SinglyLinkedList extends Methods{
	public static void main(String[]args) {
	    insertAtbeg(10);
	    insertAtbeg(30);
		insertAtbeg(20);
		insertAtend(12);
		deleteAtpos(2);
		deleteAtbeg();
		deleteAtend();
		display();
	}

}
