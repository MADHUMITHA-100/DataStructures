package linear;
class DubNode{
	int data;
	DubNode next;
	DubNode prev;
	public DubNode(int data) { 
		this.data=data;
		next=null;
		prev=null;
	}
}
class DubMethods{
	static DubNode head,tail;
	public static void insertAtbeg(int data) {
		DubNode newnode=new DubNode(data);
		if(head==null && tail==null)  {
			head=newnode;
			tail=newnode;
			return ;
		}
		else {
			newnode.next=head;
			head.prev=newnode;
			head=newnode;
		}
		
	}
	public static void display() {
		int count=0;
		DubNode ptr=head;
		while(ptr!=null) {
			System.out.println(ptr.data+" ");
			ptr=ptr.next;	
			count++;
		}	
		System.out.print("length of the linked list:" + count);
	}
	public static void insertAtend(int data) {
		DubNode newnode=new DubNode(data);
		if(head==null && tail== null) {
			head=newnode;
			tail=newnode;
		}
		else {
			newnode.prev=tail;
			tail.next=newnode;
			tail=newnode;
		}
	}
	public static void insertAtpos(int pos,int data) {
		DubNode newnode=new DubNode(data);
		DubNode prev_ptr=null;
		DubNode ptr=head;
		if(head==null && tail==null) {
			head=newnode;
			tail=newnode;
		}
		else {
			for(int i=0;i<pos;i++) {
				prev_ptr=ptr;
				ptr=ptr.next;				
			}
			prev_ptr.next=newnode;
			newnode.prev=prev_ptr;
			newnode.next=ptr;
			ptr.prev=newnode;
			
		}
	}
	public static void deleteAtbeg() {
		DubNode ptr=head;
		if(head==null && tail==null) {
			return;
		}
		else {
			head=head.next;
			head.prev=null;
			ptr.next=null;
		}
	}
	public static void deleteAtend() {
		DubNode ptr=tail;
		if(head==null && tail==null) {
			return;
		}
		else {
			tail=tail.prev;
			tail.next=null;
			ptr.prev=null;
		}
	}
	public static void deleteAtpos(int pos) {
		DubNode ptr=head;
		DubNode prev_ptr=null;
		if(head==null && tail==null) {
			return;
		}
		else {
			for(int i=0;i<pos;i++) {
				prev_ptr=ptr;
				ptr=ptr.next;
			}
			prev_ptr.next=ptr.next;
			ptr.next=null;
			ptr.prev=null;
		}
		
	}
}

public class Doubly extends DubMethods {
	public static void main(String[]args) {
		insertAtbeg(10);
		insertAtbeg(54);
		insertAtbeg(89);
		insertAtend(34);
		insertAtpos(1,23);
		deleteAtpos(1);
		deleteAtbeg();
		deleteAtend();
		display();
	
	}

}
