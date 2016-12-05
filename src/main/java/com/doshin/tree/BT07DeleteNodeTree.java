package com.doshin.tree;

public class BT07DeleteNodeTree {

	static Node rootStat = null;

	public static void delete(Node root, int value) {
		rootStat = root;
		ParentChielTuple tuple = new ParentChielTuple(null, root);
		tuple = search(tuple, value);
		deleteNode(tuple);
	}

	private static void deleteNode(ParentChielTuple tuple) {
		
		Node current = tuple.getChild();
		Node parent = tuple.getParent();

		BTreePrinter.printNode(rootStat);
		if (current.getLeftNode() == null && current.getRightNode() == null) {
			if (parent.getLeftNode() != null
					&& parent.getLeftNode().getValue() == current.getValue()) {
				parent.setLeftNode(null);
			}
			if (parent.getRightNode() != null
					&& parent.getRightNode().getValue() == current.getValue()) {
				parent.setRightNode(null);
			}
		} else {
			parent = current;
			if (current.getRightNode() == null) {
				current.setValue(current.getLeftNode().getValue());
				parent = current;
				current = current.getLeftNode();
			} else if (current.getLeftNode() == null) {
				current.setValue(current.getRightNode().getValue());
				parent = current;
				current = current.getRightNode();
			} else {
				tuple = getLeftMost(tuple);
				current.setValue(tuple.getChild().getValue());
				parent = tuple.getParent();
				current = tuple.getChild();
			}
			deleteNode(new ParentChielTuple(parent, current));
		}

	}

	private static ParentChielTuple getLeftMost(ParentChielTuple tuple) {
		Node leftMost = tuple.getChild();
		Node parent = tuple.getParent();
		
		while (leftMost.getLeftNode() != null) {
			parent = leftMost;
			leftMost = leftMost.getLeftNode();
		}
		return new ParentChielTuple(parent, leftMost);
	}

	public static ParentChielTuple search(ParentChielTuple tuple, int value) {
		Node current = tuple.getChild();
		if (current == null) {
			return null;
		} else if (current.getValue() == value) {
			return tuple;
		} else if (value < current.getValue()) {
			return search(new ParentChielTuple(current, current.getLeftNode()), value);
		} else {
			return search(new ParentChielTuple(current, current.getRightNode()), value);
		}
	}

}

class ParentChielTuple {
	Node parent;
	Node child;
	
	public ParentChielTuple(Node parent, Node child) {
		super();
		this.parent = parent;
		this.child = child;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

}