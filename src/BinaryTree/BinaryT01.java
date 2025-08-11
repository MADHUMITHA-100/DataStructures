package BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

class Tnode{
	int data;
	Tnode left,right;
	public Tnode(int data) {
		this.data=data;
		left=right=null;
	}	
} 
public class BinaryT01 {
static Tnode root=null;
public static void insert(int data) {
   Tnode node=new Tnode(data);
   if(root==null) {
	   root=node;
   }
   else 
   {
	   Queue<Tnode> track=new LinkedList<>();
	   track.add(root);
	   while(!track.isEmpty()) {
		   Tnode current =track.poll();
		   if(current.left==null) {
			   current.left=node;
			   break;
		   }
		   else {
			   track.add(current.left);
		   }
		   if(current.right==null) {
			   current.right=node;
			   break;
		   }
		   else {
			   track.add(current.right);
		   }
	   }	   
   }
	}
public static void preorder(Tnode root) {
	if(root!=null) {
		System.out.print(root.data +" ");
		preorder(root.left);
		preorder(root.right);
	}
}
public static void postorder(Tnode root) {
	if(root!=null) {
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
}
public static void inorder(Tnode root) {
	if(root!=null) {
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
		
	}
}
public static boolean search(Tnode root,int data) {
	if(root!=null) {
		if(root.data==data) {
			return true;
		}
		return search(root.left,data)|| search(root.right,data);
	}
	return false;
}
public static void main(String[]args) {
	 insert(15);
	 insert(8);
	 insert(20);
	 insert(12);
	 insert(6);
	 insert(4);
	 insert(16);
	 preorder(root);
	 postorder(root);
	 inorder(root);
	 search(root,20);
}
}
