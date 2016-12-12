package com.doshin.graph;

public class DosEdge<V> {
	V vertex;
	double weight;

	public DosEdge(V vertex, double weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}

	public V getVertex() {
		return vertex;
	}

	public void setVertex(V vertex) {
		this.vertex = vertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public boolean equals(Object otherObject) {
		return otherObject.equals(this.vertex);
	}

	public String toString() {
		return "( " + vertex + ", " + weight + " )";
	}

}
