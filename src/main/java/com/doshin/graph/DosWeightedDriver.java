package com.doshin.graph;


public class DosWeightedDriver {

	public static void main(String[] args) {

		DosGraph<String> stringGraph = new DosGraph<String>(true);

		stringGraph.addEdge("V0", "V1", 2);
		
		stringGraph.addEdge("V1", "V2", 1);
		stringGraph.addEdge("V1", "V4", 6);
		
		stringGraph.addEdge("V2", "V3", 2);

		stringGraph.addEdge("V3", "V4", 1);

		DosDijkstraSearch<String> dijkstraSearch = new DosDijkstraSearch<String>(stringGraph);
		
		System.out.println(dijkstraSearch.dijkstraSearch("V0", "V4"));

		

	}

}
