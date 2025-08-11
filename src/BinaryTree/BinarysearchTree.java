package BinaryTree;

class Bst {
	int data;
	Bst left, right;

	public Bst(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinarysearchTree {
	static Bst root;

	public static void insert(int data) {
		Bst node = new Bst(data);
		if (root == null) {
			root = node;
			return;
		} else {
			Bst current = root;
			while (true) {
				if (data > current.data) {
					if (current.right == null) {
						current.right = node;
						break;
					} else {
						current = current.right;
					}
				} else {
					if (current.data > data) {
						if (node.left == null) {
							root.left = node;
						} else {
							current = current.left;
						}
					}
				}

			}
		}
	}

	public static void preorder(Bst root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(Bst root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void inorder(Bst root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);

		}
	}

	public static boolean search(int data, Bst root) {
		Bst current = root;
		while (current != null) {
			if (current.data == data) {
				return true;
			} else {
				if (current.data > data) {
					current = current.left;
					if (current.left == null)
						break;
				} else {
					if (current.data < data) {
						current = current.right;
					}
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {
		insert(10);
		insert(32);
		insert(67);
		insert(32);
		insert(80);
		preorder(root);
		postorder(root);
		search(0, root);
	}
}
