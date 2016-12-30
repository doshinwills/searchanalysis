package com.doshin.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DosGraph<V> {

	Map<V, Set<DosEdge<V>>> graph;

	boolean isDirected;

	public DosGraph(boolean isDirected) {
		super();
		graph = new Hashtable<V, Set<DosEdge<V>>>();
		this.isDirected = isDirected;
	}

	public void addEdge(V start, V end, double weight) {
		addOneSideArc(start, end, weight);
		if (!isDirected) {
			addOneSideArc(end, start, weight);
		}
	}

	public void addVertxWithEdges(V start, List<DosEdge<V>> vEdges) {
		for (DosEdge<V> edge : vEdges) {
			addEdge(start, edge.vertex, edge.weight);
		}

	}

	private void addOneSideArc(V start, V end, double weight) {

		if (!graph.containsKey(start)) {
			graph.put(start, new HashSet<DosEdge<V>>());
		}
		if (!graph.containsKey(end)) {
			graph.put(end, new HashSet<DosEdge<V>>());

		}
		if (!graph.get(start).contains(new DosEdge<V>(end, weight))) {
			Set<DosEdge<V>> startEdge = graph.get(start);
			startEdge.add(new DosEdge<V>(end, weight));
			graph.put(start, startEdge);
		}
	}
	
	public Map<V, Double> getNeigbors(V vertex) {
		Set<DosEdge<V>> startEdge = graph.get(vertex);
		Map<V, Double> adjacentVertices = new HashMap<V, Double>();
		for (DosEdge<V> edge : startEdge) {
			adjacentVertices.put(edge.getVertex(),
					Double.valueOf(edge.getWeight()));
		}
		return adjacentVertices;
	}
	
	public Set<V> getAllNodes() {
		return graph.keySet();
	}

	public String toString() {
		String s = "";
		for (V vertex : graph.keySet()) {
			s += vertex.toString();
			s += " : ";
			s += graph.get(vertex);
			s += "\n";
		}
		return s;
	}

}


