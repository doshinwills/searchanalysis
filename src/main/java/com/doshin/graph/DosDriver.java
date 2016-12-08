package com.doshin.graph;

import java.util.ArrayList;
import java.util.List;

public class DosDriver {

	public static void main(String[] args) {

		DosGraph<String> stringGraph = new DosGraph<String>(true);
		List<DosEdge<String>> vEdges = null;

		stringGraph.addEdge("E", "A", 4);

		vEdges = new ArrayList<DosEdge<String>>();
		vEdges.add(new DosEdge<String>("E", 4));
		vEdges.add(new DosEdge<String>("D", 5));
		stringGraph.addVertxWithEdges("A", vEdges);

		vEdges = new ArrayList<DosEdge<String>>();
		vEdges.add(new DosEdge<String>("A", 5));
		vEdges.add(new DosEdge<String>("C", 2));
		vEdges.add(new DosEdge<String>("B", 3));
		stringGraph.addVertxWithEdges("D", vEdges);

		stringGraph.addEdge("B", "D", 3);
		stringGraph.addEdge("B", "C", 3);

		stringGraph.addEdge("C", "D", 2);

		System.out.println(stringGraph.toString());

		DosDfsSearch<String> dfs = new DosDfsSearch<String>(stringGraph);

		System.out.println(dfs.dfsSearch("A", "C"));

		DosBfsSearch<String> bfs = new DosBfsSearch<String>(stringGraph);

		System.out.println(bfs.dfsSearch("A", "C"));

	}

}
