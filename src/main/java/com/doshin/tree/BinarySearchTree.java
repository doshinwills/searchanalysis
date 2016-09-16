package com.doshin.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public boolean search() {
		return false;
	}

	// Public Methods
	public void insert(int value) {
		Node element = new Node(value);

		if (root == null) {
			root = element;
		} else {
			Node checkNext = root;
			while (true) {
				if (checkNext.getValue() == element.getValue()) {
					throw new IllegalArgumentException("Element already exists");
				} else if (checkNext.getValue() < element.getValue()) {
					if (checkNext.getRightNode() == null) {
						checkNext.setRightNode(element);
					} else {
						checkNext = checkNext.getRightNode();
					}
				} else if (element.getValue() < checkNext.getValue()) {
					if (checkNext.getLeftNode() == null) {
						checkNext.setLeftNode(element);
					} else {
						checkNext = checkNext.getLeftNode();
					}
				}
			}
		}
	}

	public void insertRecursive(int value) {
		Node element = new Node(value);
		if (this.root == null) {
			this.root = element;
		} else {
			insert(root, element);
		}

	}

	public void preOrderTraversal() {
		System.out.println("\nPre Order Traversal  is");
		preOrderTraversal(root);
		System.out.println("");
	}

	public void preOrderTraversalStackWay() {
		System.out.println("\nPre Order Traversal in stack is");
		preOrderTraversalStackWay(root);
		System.out.println("");
	}

	public void inOrderTraversal() {
		System.out.println("\nIn Order Traversal  is");

		inOrderTraversal(root);
		System.out.println("");
	}

	public void inOrderTraversalStackWay() {
		System.out.println("\nIn Order Traversal Stack way is");
		inOrderTraversalStackWay(root);
		System.out.println("");
	}

	public void postOrderTraversal() {
		System.out.println("\nPost Order Traversal  is");
		postOrderTraversal(root);
		System.out.println("");
	}

	public void postOrderTraversalStackWay() {
		System.out.println("\nPost Order Traversal Stack way is");
		postOrderTraversalStackWay(root);
		System.out.println("");
	}

	public void levelOrderTraversal() {
		System.out.println("\nLevel Order Traversal Queue way is");

		Queue<Node> traversalOrder = new LinkedList<Node>();
		Node current = null;
		traversalOrder.add(root);
		while (!traversalOrder.isEmpty()) {
			current = traversalOrder.remove();
			System.out.print(current.getValue() + ", ");
			if (current.getLeftNode() != null)
				traversalOrder.add(current.getLeftNode());
			if (current.getRightNode() != null)
				traversalOrder.add(current.getRightNode());
		}
		System.out.println("");
	}

	public void levelOrderTraversalByCoRecursion() {
		List<Node> nodes = new ArrayList<Node>();
		System.out.println("\nLevel Order Traversal Co recurssion way is");
		nodes.add(this.root);
		levelOrderTraversalByCoRecursion(nodes);
		System.out.println("");

	}

	public void levelOrderTraversalByCoRecursion(List<Node> nodes) {
		List<Node> nextNodes = new ArrayList<Node>();
		for(Node node : nodes) {
			System.out.print(node.getValue() + ", ");
			if(node.getLeftNode() != null)
				nextNodes.add(node.getLeftNode());
			if(node.getRightNode() != null)
				nextNodes.add(node.getRightNode());
		}
		if(!nextNodes.isEmpty())
			levelOrderTraversalByCoRecursion(nextNodes);
	}

	public int height() {
		int height = height(root);
		System.out.print("\nDepth is " + height);
		System.out.println("");
		return height;

	}

	public void search(int value) {
		System.out.print("\nValue " + value + " is " + search(root, value));
		System.out.println("");
	}

	public void searchPath(int value) {
		List<Node> searchPath = new ArrayList<Node>();
		Node searchNode = searchPath(root, value, searchPath);
		if (searchNode == null) {
			System.out.println("\nNo search Path!!");
		} else {
			System.out.println("\nSearch path is");
			for (Node node : searchPath) {
				System.out.print(node.getValue() + " -> ");
			}
		}
		System.out.println("");
	}

	public void displayTree() {

	}

	// Private Methods

	private void insert(Node current, Node element) {
		if (element.getValue() < current.getValue()) {
			if (current.getLeftNode() == null) {
				current.setLeftNode(element);
			} else {
				insert(current.getLeftNode(), element);
			}
		} else if (current.getValue() < element.getValue()) {
			if (current.getRightNode() == null) {
				current.setRightNode(element);
			} else {
				insert(current.getRightNode(), element);
			}
		} else {
			throw new IllegalArgumentException("Element already exists");
		}
	}

	public void delete() {

	}

	private void preOrderTraversal(Node current) {
		if (current != null) {
			System.out.print(current.getValue() + ", ");
			preOrderTraversal(current.getLeftNode());
			preOrderTraversal(current.getRightNode());
		}
	}

	private void preOrderTraversalStackWay(Node current) {
		Stack<Node> traversalOrder = new Stack<Node>();
		traversalOrder.push(current);
		while (!traversalOrder.isEmpty()) {
			current = traversalOrder.pop();
			System.out.print(current.getValue() + ", ");

			if (current.getRightNode() != null) {
				traversalOrder.push(current.getRightNode());
			}
			if (current.getLeftNode() != null) {
				traversalOrder.push(current.getLeftNode());
			}

		}
	}

	private void inOrderTraversal(Node current) {
		if (current != null) {
			inOrderTraversal(current.getLeftNode());
			System.out.print(current.getValue() + ", ");
			inOrderTraversal(current.getRightNode());
		}
	}

	private void inOrderTraversalStackWay(Node current) {
		Stack<Node> traversalOrder = new Stack<Node>();

		while (!traversalOrder.isEmpty() || current != null) {

			if (current != null) {
				traversalOrder.push(current);
				current = current.getLeftNode();

			} else {
				current = traversalOrder.pop();
				System.out.print(current.getValue() + ", ");
				current = current.getRightNode();
			}

		}
	}

	private void postOrderTraversal(Node current) {
		if (current != null) {
			postOrderTraversal(current.getLeftNode());
			postOrderTraversal(current.getRightNode());
			System.out.print(current.getValue() + ", ");
		}
	}

	private void postOrderTraversalStackWay(Node current) {
		Stack<Node> traversalOrder = new Stack<Node>();
		Node lastVistitedNode = null;

		while (!traversalOrder.isEmpty() || current != null) {

			if (current != null) {
				traversalOrder.push(current);
				current = current.getLeftNode();

			} else {
				current = traversalOrder.peek();
				if (current.getRightNode() != null
						&& lastVistitedNode != current.getRightNode()) {
					current = current.getRightNode();
				} else {
					current = traversalOrder.pop();
					System.out.print(current.getValue() + ", ");
					lastVistitedNode = current;
					current = null;
				}
			}

		}
		System.out.println("");
	}

	private int height(Node current) {
		if (current == null)
			return 0;
		int leftHeight = 1 + height(current.getLeftNode());
		int rightHeight = 1 + height(current.getRightNode());
		return leftHeight < rightHeight ? rightHeight : leftHeight;
	}

	private Node search(Node current, int value) {
		if (current == null) {
			return null;
		} else if (current.getValue() == value) {
			return current;
		} else if (value < current.getValue()) {
			return search(current.getLeftNode(), value);
		} else {
			return search(current.getRightNode(), value);
		}
	}

	private Node searchPath(Node current, int value, List<Node> path) {
		if (current == null) {
			return null;
		} else if (current.getValue() == value) {
			path.add(current);
			return current;
		} else if (value < current.getValue()) {
			path.add(current);
			return searchPath(current.getLeftNode(), value, path);
		} else {
			path.add(current);
			return searchPath(current.getRightNode(), value, path);
		}
	}

}
