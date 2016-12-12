package com.doshin.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DosBfsSearch<V> {

	DosGraph<V> graph;
	Queue<V> nextVisit;
	Set<V> visited;
	Map<V, V> parent;

	public DosBfsSearch(DosGraph<V> graph) {
		this.graph = graph;
		nextVisit = new LinkedList<V>();
		visited = new HashSet<V>();
		parent = new HashMap<V, V>();
	}

	public List<V> dfsSearch(V from, V to) {
		List<V> path = new ArrayList<V>();
		nextVisit.add(from);
		boolean pathExists = false;
		V currentNode = null;

		while (!nextVisit.isEmpty()) {
			currentNode = nextVisit.remove();
			if (currentNode.equals(to)) {
				pathExists = true;
				break;
			}

			visited.add(currentNode);
			Set<V> neigbors = graph.getNeigbors(currentNode).keySet();

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
			Collections.reverse(path);
		}
		return path;
	}
}
