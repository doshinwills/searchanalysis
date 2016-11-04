package com.doshin.tree;

import java.util.Stack;

public class BT02InOrderTraversal {

	public static void inOrderTraversal(Node current) {
		if (current != null) {
			inOrderTraversal(current.getLeftNode());
			System.out.print(current.getValue() + ", ");
			inOrderTraversal(current.getRightNode());
		}
	}

	public static void inOrderTraversalStackWay(Node current) {
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

}
