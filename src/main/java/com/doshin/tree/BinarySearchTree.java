package com.doshin.tree;

import java.util.ArrayList;
import java.util.List;

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
		BT01PreOrderTraversal.preOrderTraversal(root);
		System.out.println("");
	}

	public void preOrderTraversalStackWay() {
		System.out.println("\nPre Order Traversal in stack is");
		BT01PreOrderTraversal.preOrderTraversalStackWay(root);
		System.out.println("");
	}

	public void inOrderTraversal() {
		System.out.println("\nIn Order Traversal  is");
		BT02InOrderTraversal.inOrderTraversal(root);
		System.out.println("");
	}

	public void inOrderTraversalStackWay() {
		System.out.println("\nIn Order Traversal Stack way is");
		BT02InOrderTraversal.inOrderTraversalStackWay(root);
		System.out.println("");
	}

	public void postOrderTraversal() {
		System.out.println("\nPost Order Traversal  is");
		BT03PostOrderTraversal.postOrderTraversal(root);
		System.out.println("");
	}

	public void postOrderTraversalStackWay() {
		System.out.println("\nPost Order Traversal Stack way is");
		BT03PostOrderTraversal.postOrderTraversalStackWay(root);
		System.out.println("");
	}

	public void levelOrderTraversalByCoRecursion() {
		List<Node> nodes = new ArrayList<Node>();
		System.out.println("\nLevel Order Traversal Co recurssion way is");
		nodes.add(this.root);
		BT04LevelOrderTraversal.levelOrderTraversalByCoRecursion(nodes);
		System.out.println("");

	}

	public int height() {
		int height = BT05TreeHeight.height(root);
		System.out.print("\nDepth is " + height);
		System.out.println("");
		return height;

	}

	public void search(int value) {
		System.out.print("\nValue " + value + " is "
				+ BT06SearchTree.search(root, value));
		System.out.println("");
	}

	public void searchPath(int value) {
		List<Node> searchPath = new ArrayList<Node>();
		Node searchNode = BT06SearchTree.searchPath(root, value, searchPath);
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

}
