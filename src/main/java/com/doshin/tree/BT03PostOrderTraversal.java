package com.doshin.tree;

import java.util.Stack;

public class BT03PostOrderTraversal {

	public static void postOrderTraversal(Node current) {
		if (current != null) {
			postOrderTraversal(current.getLeftNode());
			postOrderTraversal(current.getRightNode());
			System.out.print(current.getValue() + ", ");
		}
	}

	public static void postOrderTraversalStackWay(Node current) {
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

}
