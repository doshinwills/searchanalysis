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
		nextVisit.add(new WeightedPathNode<V>(from, 0));
		V current = null;
		List<V> path = new ArrayList<V>();

		

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
					nextVisit.add(new WeightedPathNode<V>(next, currentWeight
							+ neigbors.get(next)));
					parent.put(next, current);
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

class WeightedPathNode<V> implements Comparable<WeightedPathNode<V>> {
	V node;
	double weight;

	public WeightedPathNode(V node, double weight) {
		super();
		this.node = node;
		this.weight = weight;
	}

	public int compareTo(WeightedPathNode<V> o) {
		return Double.valueOf(this.weight).compareTo(o.weight);
	}

	public V getNode() {
		return node;
	}

	public void setNode(V node) {
		this.node = node;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return "(" +  node + "," + weight + ")";
	}

}
