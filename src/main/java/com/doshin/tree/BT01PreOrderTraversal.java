package com.doshin.tree;

import java.util.Stack;

public class BT01PreOrderTraversal {
	
	
	
	public static void preOrderTraversal(Node current) {
		if (current != null) {
			System.out.print(current.getValue() + ", ");
			preOrderTraversal(current.getLeftNode());
			preOrderTraversal(current.getRightNode());
		}
	}

	public static void preOrderTraversalStackWay(Node current) {
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

}
