package com.doshin.graph;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightedPathNode other = (WeightedPathNode) obj;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		return true;
	}
	
	

}
