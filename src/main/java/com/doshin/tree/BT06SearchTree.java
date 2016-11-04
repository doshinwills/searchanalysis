package com.doshin.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BT06SearchTree {
	public static Node search(Node current, int value) {
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

	public static Node searchPath(Node current, int value, List<Node> path) {
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
