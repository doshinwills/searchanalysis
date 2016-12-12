package com.doshin.graph;

import java.util.List;

public class DosDriverPoint {

	public static void main(String[] args) {

		DosGraph<Point> pointGraph = new DosGraph<Point>(false);
		List<DosEdge<Point>> vEdges = null;

		
		
		pointGraph.addEdge(new Point(1,1), new Point(4,1), Double.POSITIVE_INFINITY);
		
		pointGraph.addEdge(new Point(4,1), new Point(4,2), Double.POSITIVE_INFINITY);
		pointGraph.addEdge(new Point(4,1), new Point(7,3), Double.POSITIVE_INFINITY);
		pointGraph.addEdge(new Point(4,1), new Point(5,1), Double.POSITIVE_INFINITY);
		pointGraph.addEdge(new Point(4,1), new Point(4,0), Double.POSITIVE_INFINITY);
		
		pointGraph.addEdge(new Point(7,3), new Point(8,-1), Double.POSITIVE_INFINITY);

		pointGraph.addEdge(new Point(5,1), new Point(6.5,0), Double.POSITIVE_INFINITY);
		pointGraph.addEdge(new Point(5,1), new Point(4,0), Double.POSITIVE_INFINITY);
		
		pointGraph.addEdge(new Point(4,0), new Point(4,-1), Double.POSITIVE_INFINITY);
		
		pointGraph.addEdge(new Point(6.5,0), new Point(8,-1), Double.POSITIVE_INFINITY);

		
		pointGraph.addEdge(new Point(4,-1), new Point(8,-1), Double.POSITIVE_INFINITY);
		

//		vEdges = new ArrayList<DosEdge<String>>();
//		vEdges.add(new DosEdge<String>("E", 4));
//		vEdges.add(new DosEdge<String>("D", 5));
//		stringGraph.addVertxWithEdges("A", vEdges);



		System.out.println(pointGraph.toString());

		DosDfsSearch<Point> dfs = new DosDfsSearch<Point>(pointGraph);

		System.out.println("DFS is " + dfs.dfsSearch(new Point(1,1), new Point(8,-1)));

		DosBfsSearch<Point> bfs = new DosBfsSearch<Point>(pointGraph);

		System.out.println("BFS is " + bfs.dfsSearch(new Point(1,1), new Point(8,-1)));

	}

}
