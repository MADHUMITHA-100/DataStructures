package Tree;


class Anode{
	int data,height;
	Anode right,left;
	public Anode(int data) {
		this.data=data;
		height=1;
		left=right=null;
	}
}
public class Avl{
	static Anode root;
	static Anode createNode(int data) {
		return new Anode(data);
	}
	public static Anode rightRotate(Anode y) {

		 Anode x=y.left;

		 Anode t2=x.right;

		 x.right=y;

		 y.left=t2;

		 y.height=Math.max(height(y.left),height(y.right));

		 x.height=Math.max(height(x.left),height(x.right));

		 

		return x;

	 }
	public static Anode leftRotate(Anode x) {
		Anode y=x.left;
		 Anode t2=y.right;
		 y.left=x;
		 x.right=t2;
		 x.height=Math.max(height(x.left),height(x.right))+1;
		 y.height=Math.max(height(y.left),height(y.right))+1;
      return y;

	 }
	
	static int height(Anode root) {
		return root==null?0:root.height;
	}
	public static int balance(Anode root) {
		return root==null?0:height(root.left)-height(root.right);
	}
	 public static Anode insert(Anode root,int data) {
		if(root==null)return createNode(data);
		if(data<root.data) {
			root.left=insert(root.left,data);
		}
		else if(data>root.data) {
			root.right=insert(root.right,data);
		}
		else return root;
		root.height=1+Math.max(height(root.left),height(root.right));
		int bal=balance(root);
		//LL
		 if(bal>1 && data <root.left.data) {
			 return rightRotate(root);
		 }
		 //RR
		 if(bal<-1 && data>root.right.data) 
			 return leftRotate(root);
		 //LR
		 if(bal>1 && data<root.left.data) {
			 root.left=leftRotate(root.left);
			 return rightRotate(root);
		 
		 }
		 //RL
		 if(bal<-1 && data<root.right.data) {
			 root.right=rightRotate(root.right);
			 return leftRotate(root);
		 }
		 return root;
	}
		 public static void preorder(Anode root) {
				if(root!=null) {
					System.out.print(root.data +" ");
					preorder(root.left);
					preorder(root.right);
				}
			}
			public static void postorder(Anode root) {
				if(root!=null) {
					postorder(root.left);
					postorder(root.right);
					System.out.print(root.data+" ");
				}
			}
			public static void inorder(Anode root) {
				if(root!=null) {
					inorder(root.left);
					System.out.print(root.data+" ");
					inorder(root.right);
					
				}
} 
	public static void insertAtnode(int data) {
		root=insert(root,data);
	}
	public static void main(String[]args) {
		insertAtnode(50);
		insertAtnode(67);
	     preorder(root);
	     postorder(root);
	}
}

