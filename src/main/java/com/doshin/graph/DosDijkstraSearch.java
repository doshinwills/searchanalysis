package com.doshin.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DosDijkstraSearch<V> {

	DosGraph<V> graph;
	PriorityQueue<WeightedPathNode<V>> nextVisit;
	Set<V> visited;
	Map<V, V> parent;

	public DosDijkstraSearch(DosGraph<V> graph) {
		this.graph = graph;
		nextVisit = new PriorityQueue<WeightedPathNode<V>>();
		visited = new HashSet<V>();
		parent = new HashMap<V, V>();
	}

	public List<V> dijkstraSearch(V from, V to) {

		boolean pathExists = false;
		V current = null;
		List<V> path = new ArrayList<V>();
		nextVisit.add(new WeightedPathNode<V>(from, 0));
		List<WeightedPathNode<V>> allNodes = new ArrayList<WeightedPathNode<V>>();
		

		for(V node : graph.getAllNodes()) {
			allNodes.add(new WeightedPathNode<V>(node, Double.POSITIVE_INFINITY));
		}
		
		

		while (!nextVisit.isEmpty()) {
			WeightedPathNode<V> currentWeightedPathNode = nextVisit.poll();
			current = currentWeightedPathNode.getNode();
			double currentWeight = currentWeightedPathNode.getWeight();
			
			
			if (current.equals(to)) {
				pathExists = true;
				break;
			}
			
			visited.add(current);

			Map<V, Double> neigbors = graph.getNeigbors(current);

			for (V next : neigbors.keySet()) {
				if(!visited.contains(next)) {
					WeightedPathNode nextWeightedPathNode = new WeightedPathNode<V>(next, currentWeight);
					nextWeightedPathNode = allNodes.get(allNodes.indexOf(nextWeightedPathNode));
					if((neigbors.get(next) + currentWeight) <nextWeightedPathNode.getWeight() ) {
						nextWeightedPathNode.setWeight(neigbors.get(next) + currentWeight);
						nextVisit.add(nextWeightedPathNode);
						if(parent.containsKey(next)) {
							parent.remove(next);
						}
						parent.put(next, current);
					}
				}
			}			
		}
		
		if (pathExists) {
			while (!from.equals(current)) {
				path.add(current);
				current = parent.get(current);

			}
			path.add(current);
			Collections.reverse(path);
		}

		return path;
	}
}
