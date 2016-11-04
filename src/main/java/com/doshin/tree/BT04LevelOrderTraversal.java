package com.doshin.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BT04LevelOrderTraversal {

	public static void levelOrderTraversal(Node root) {
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
	
	public static void levelOrderTraversalByCoRecursion(List<Node> nodes) {
		List<Node> nextNodes = new ArrayList<Node>();
		for (Node node : nodes) {
			System.out.print(node.getValue() + ", ");
			if (node.getLeftNode() != null)
				nextNodes.add(node.getLeftNode());
			if (node.getRightNode() != null)
				nextNodes.add(node.getRightNode());
		}
		if (!nextNodes.isEmpty())
			levelOrderTraversalByCoRecursion(nextNodes);
	}

}
