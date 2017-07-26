//package Graphs1;

public class GraphUse {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("F");
		g.addEdge("A", "D");
		g.addEdge("A", "E");
		g.addEdge("B", "D");
		g.addEdge("B", "F");
		g.addEdge("A", "F");
		g.addEdge("C", "E");
		g.addEdge("C", "F");
		System.out.println(g.isBipartite());
//		g.bfs();
//		g.iscycle();
	//	g.removeEdge("A", "B");
//		g.removeVertex("A");
//		System.out.println();
//		g.print();
	}

}
