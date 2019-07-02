package br.ufc.carteus.st;
public class LeftistHeap<T extends Comparable<T>> {

	private Node root;

	private class Node {
		T element;
		Node left;
		Node right;
		int h;

		Node(T element) {
			this(element, null, null);
		}

		Node(T element, Node left, Node right) {
			this.element = element;
			this.left = left;
			this.right = right;
			this.h = 0;
		}
	}

	public LeftistHeap() {
		root = null;
	}

	public LeftistHeap(T value) {
		root = new Node(value);
	}

	public void merge(LeftistHeap<T> heap) {
		if (this == heap || heap == null)
			return;

		root = merge(root, heap.root);
	}

	public void insert(T value) {
		if (root == null) {
			root = new Node(value);
			return;
		}

		root = merge(new Node(value), root);
	}

	public T getMin() {
		if (root == null) {
			return null;
		}
		return root.element;
	}

	public T deleteMin() {
		if (isEmpty())
			return null;
		T min = getMin();
		root = merge(root.left, root.right);
		return min;
	}

	public boolean isEmpty() {
		return root == null;
	}

	private Node merge(Node h1, Node h2) {
		if (h1 == null)
			return h2;
		if (h2 == null)
			return h1;
		if (h1.element.compareTo(h2.element) < 0)
			return merge1(h1, h2);
		else
			return merge1(h2, h1);
	}

	private Node merge1(Node h1, Node h2) {
		if (h1.left == null)
			h1.left = h2;
		else {
			h1.right = merge(h1.right, h2);
			if (h1.left.h < h1.right.h)
				swapChildren(h1);
			h1.h = h1.right.h + 1;
		}
		return h1;
	}

	private void swapChildren(Node t) {
		Node left = t.left;
		t.left = t.right;
		t.right = left;
	}

	public void teste() {
		inorder(root);
	}

	private void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}
}
