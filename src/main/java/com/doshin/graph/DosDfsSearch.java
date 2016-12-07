package com.doshin.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DosDfsSearch<V> {

	DosGraph<V> graph;
	Stack<V> nextVisit;
	Set<V> visited;
	Map<V, V> parent;

	public DosDfsSearch(DosGraph<V> graph) {
		this.graph = graph;
		nextVisit = new Stack<V>();
		visited = new HashSet<V>();
		parent = new HashMap<V, V>();
	}

	public List<V> dfsSearch(V from, V to) {
		List<V> path = new ArrayList<V>();
		nextVisit.add(from);
		boolean pathExists = false;
		V currentNode = null;

		while (!nextVisit.isEmpty()) {
			currentNode = nextVisit.pop();
			if (currentNode.equals(to)) {
				pathExists = true;
				break;
			}

			visited.add(currentNode);
			List<V> neigbors = graph.getNeigbors(currentNode);

			for (V nextNode : neigbors) {
				if (!visited.contains(nextNode)) {
					nextVisit.add(nextNode);
					parent.put(nextNode, currentNode);
				}
			}
		}
		if (pathExists) {
			while (!from.equals(currentNode)) {
				path.add(currentNode);
				currentNode = parent.get(currentNode);

			}
			path.add(currentNode);
		}
		return path;
	}
}
