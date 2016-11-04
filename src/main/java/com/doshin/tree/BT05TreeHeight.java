package com.doshin.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BT05TreeHeight {

	public static int height(Node current) {
		if (current == null)
			return 0;
		int leftHeight = 1 + height(current.getLeftNode());
		int rightHeight = 1 + height(current.getRightNode());
		return leftHeight < rightHeight ? rightHeight : leftHeight;
	}
}
