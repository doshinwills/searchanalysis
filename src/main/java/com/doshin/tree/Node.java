package com.doshin.tree;

public class Node {

	private int value;

	private Node parent;
	private Node leftNode;
	private Node rightNode;

	public Node() {
		super();
	}
	
	public Node(int value) {
		super();
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}

	public Node(int value, Node leftNode, Node rightNode) {
		super();
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public String toString() {
		return "" + value;
	}

}
