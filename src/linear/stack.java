package linear;
class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data=data;
		next=null;
	}
}
class Method{
	static Node top;
	static Node bottom;
	static int count=-1;
	public static void pop() {
		if(count==-1) {
			System.out.println("Stack is empty");
			return;
		}
		if(count==0) { 
			System.out.println("popped data:"+top.data);
			count--;
			return;
		
		}
			Node temp=bottom;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			System.out.println("popped data ="+ top.data);
			top=temp;
			temp.next=null;
			count--;
		}	
		
	public static void push(int data) {
		Node node=new Node(data);
		if(top==null && bottom==null) {
			top=node;
			bottom=node;
			return;
		}
		else {
			top.next=node;
			top=node;
		}	
		count++;
	}
	public static void peak() {
		if(count==-1) {
			System.out.println("Stack is empty");
			return;
		}
		else {
			System.out.println(top.data);
		}
	}

	
	
}
public class stack extends Method{
public static void main(String[]args) {
	push(45);
	push(32);
	push(10);
	peak();
	pop();

}

}
