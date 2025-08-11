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
	 static Node front,tail;
	 public static void Dequeue() {
		 if(front==null && tail==null) {
			 return;
		 }
		 else {
			 Node ptr=front;
			 front=front.next;
			 ptr.next=null;
		 }
	 }
	 public static void Enqueue(int data) {
		 Node newnode=new Node(data);
		 if(front==null && tail==null) {
			 front=tail=newnode;
			 tail.next=null;
		 }
		 else {
			 tail.next=newnode;
			 tail=newnode;
		 }
	 }
	 public static void display() {
		 if(front==null && tail==null) {
			 return;
		 }
		 else {
			 Node ptr=front;
			 do {
				 System.out.println(ptr.data);
				 ptr=ptr.next;
			 }
			 while(ptr!=null);
		 }
	 }
	 public static void peek() {
		 if(front==null && tail==null) {
			 return;
		 }
		 
		 else {
			 System.out.println("peek is:"+front.data);
		 }
	 }
}
public class Queue_Ds extends Methods {
public static void main(String[]args) {
	Enqueue(10);
	Enqueue(20);
	Enqueue(30);
	Dequeue();
	display();
	peek();
	Dequeue();
	display();
	peek();
}
}
