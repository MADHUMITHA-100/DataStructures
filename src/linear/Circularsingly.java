package linear;
class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data=data;
		next=null;
	}
}
class Methods{
    static Node head,tail;
	public static void insertAtbeg(int data) {
		Node newnode=new Node(data);
		if(head==null && tail==null) {
			head=newnode;
			tail=newnode;
			newnode.next=head;
			return;
		}
		else {
			newnode.next=head;
			head=newnode;
			tail.next=head;
		}
	}
	public static void display() {
		int count=0;
		Node ptr=head;
		do {
			System.out.println(ptr.data + " ");
			ptr=ptr.next;
			count++;
		} while(ptr!=head);
		System.out.println("length is:" + count);
	}
	public static void insertAtend(int data) {
		Node newnode=new Node(data);
		if(head==null && tail==null) {
			head=newnode;
			tail=newnode;
			newnode.next=head;
			return;
		}
		else {
			tail.next=newnode;
			tail=newnode;
			newnode.next=head;
		}
	}
	public static void insertAtpos(int pos,int data) {
		Node newnode=new Node(data);
		Node prev_ptr=null;
		Node ptr=head;
		if(head==null && tail==null) {
			head=newnode;
			tail=newnode;
			newnode.next=head;
			return;
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
		if(head==null &&  tail==null) {
			return;
		}
		else if(head==tail) {
			head=null;
			tail=null;
		}
		else {
			tail.next=head.next;
			head=head.next;
			ptr.next=null;

		}
	}
	public static void deleteAtend(){
		Node ptr=head;
		if(head==null &&  tail==null) {
			return;
		}
		else {
			do {
				ptr=ptr.next;
			}while(ptr.next.next!=head); 
			ptr.next=head;
			tail=ptr;
			}	
		}
	public static void deleteAtpos(int pos) {
		Node prev_ptr=null;
		Node ptr=head;
		if(head==null &&  tail==null) {
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
	
	


public class Circularsingly extends Methods {
public static void main(String[]args) {
	insertAtbeg(10);
	insertAtbeg(30);
	insertAtbeg(20);
	insertAtend(23);
	insertAtpos(1,45);
	insertAtpos(2,45);
	deleteAtend();
	deleteAtbeg();
	deleteAtpos(1);
	display();
	
}
}
