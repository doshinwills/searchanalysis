package com.doshin.graph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class DosGraph<V> {

	Map<V, List<DosEdge<V>>> graph;

	boolean isDirected;

	public DosGraph(boolean isDirected) {
		super();
		graph = new Hashtable<V, List<DosEdge<V>>>();
		this.isDirected = isDirected;
	}
	
	public void addEdge(V start, V end, double weight) {
		addOneSideArc(start, end, weight);
		if(!isDirected) {
			addOneSideArc(end, start, weight);
		}
	}
	

	public void addVertxWithEdges(V start, List<DosEdge<V>> vEdges) {
		for(DosEdge<V> edge : vEdges){
			addEdge(start, edge.vertex, edge.weight);
		}
		
	}
	
	public List<V> getNeigbors(V vertex) {
		List<DosEdge<V>> startEdge = graph.get(vertex);
		List<V> adjacentVertices = new ArrayList<V>();
		for(DosEdge<V> edge : startEdge) {
			adjacentVertices.add(edge.getVertex());
		}
		return adjacentVertices;
	}
	
	private void addOneSideArc(V start, V end, double weight) {

		if (!graph.containsKey(start)) {
			graph.put(start, new ArrayList<DosEdge<V>>());
		}
		if (!graph.containsKey(end)) {
			graph.put(end, new ArrayList<DosEdge<V>>());

		}
		if (!graph.get(start).contains(new DosEdge<V>(end, weight))) {
			List<DosEdge<V>> startEdge = graph.get(start);
			startEdge.add(new DosEdge<V>(end, weight));
			graph.put(start, startEdge);
		}

		
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
