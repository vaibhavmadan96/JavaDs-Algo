//package Graphs1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

	ArrayList<Vertex> vertices;

	Graph(){
		vertices = new ArrayList<>();
	}

	public int numVertices(){
		return vertices.size();
	}


	public int numEdges(){
		int count = 0;
		for(Vertex v : vertices){
			count += v.numEdges();
		}
		return count/2;
	}


	public void print(){
		for(Vertex v : vertices){
			v.print();
		}
	}

	public void addVertex(String name){

		if(isVertexPresent(name)){
			return;
		}
		Vertex v = new Vertex(name);
		vertices.add(v);
	}

	private boolean isVertexPresent(String name) {
		for(Vertex v : vertices){
			if(v.getName().equals(name)){
				return true;
			}	
		}
		return false;
	}

	private Vertex getVertex(String name) {
		for(Vertex v : vertices){
			if(v.getName().equals(name)){
				return v;
			}	
		}
		return null;
	}

	public void addEdge(String name1, String name2){
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);

		/*if(!isVertexPresent(name1) || !isVertexPresent(name2)){
			return;
		}*/
		if(v1 == null || v2 == null){
			return;
		}

		if(areAdjacent(name1,name2)){
			return;
		}		

		Edge e = new Edge(v1,v2);
		v1.addEdge(e);
		v2.addEdge(e);

	}


	public  boolean areAdjacent(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);

		if(v1 == null || v2 == null){
			return false;
		}
		return v1.isAdjacent(name2);
	}

	public void removeEdge(String name1, String name2){
		if(!areAdjacent(name1, name2)){
			return;
		}
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);

		v1.removeEdgeWith(v2);
		v2.removeEdgeWith(v1);	
	}


	public void removeVertex(String name){
		Vertex v = getVertex(name);
		if(v == null){
			return ;
		}

		ArrayList<Vertex> adjacent = v.getAdjacent();
		for(Vertex adj : adjacent){
			adj.removeEdgeWith(v);
		}
		vertices.remove(v);
	}
	public boolean hasPath(String name1,String name2)//revise
	{
		HashMap<Vertex,Integer> map=new HashMap<>();
		Vertex v = getVertex(name1);
		map.put(v, 1);
		return this.hasPathHelper(name1, name2, map);
	}
	private boolean hasPathHelper(String name1,String name2,HashMap<Vertex,Integer> map)
	{
		Vertex v = getVertex(name1);
//		map.put(v, 1);
		if(areAdjacent(name1, name2)){
			return true;
		}
		else 
		{
			//Vertex v = getVertex(name1);
			ArrayList<Vertex> adjacent = v.getAdjacent();
			for(Vertex adj : adjacent){
				if(!map.containsKey(adj))
				{
					map.put(adj, 1);
					return areAdjacent(adj.getName(),name2);
				}

			}
		}
		return false;	
	}
	public void DFS()
	{
		HashMap<Vertex,Integer> visited=new HashMap<>();
		Vertex curr=vertices.get(0);
		visited.put(curr, 1);
		DFS_Helper(curr,visited);
	}
	private void DFS_Helper(Vertex curr,HashMap<Vertex,Integer> visited)
	{
		System.out.print(curr.getName()+"=>");
		ArrayList<Vertex> adjacent=curr.getAdjacent();
		for(Vertex adj:adjacent)
		{
			if(!visited.containsKey(adj))
			{
				visited.put(adj, 1);
				DFS_Helper(adj,visited);
			}
		}
	}
//	public boolean hasPathBFS()
//	{
//		Queue<Vertex> queue=new Queue<>();
//
//	}
	public void bfs()
	{
		Queue<Vertex> q=new Queue<>();
		HashMap<Vertex,Boolean> map=new HashMap<>();
		int i=0;
		while(map.size()<this.vertices.size())
		{
			q.enqueqe(vertices.get(i));//change i for complete traversal
			map.put(vertices.get(i), true);
			while(!q.isEmpty())
			{
				Vertex curr=q.dequeue();
				System.out.print(curr.getName()+" ");

				ArrayList<Vertex> adjacent=curr.getAdjacent();
				for(Vertex adj: adjacent)
				{
					if(!map.containsKey(adj))
					{
						q.enqueqe(adj);
						map.put(adj, true);
					}
				}

			}
			System.out.println(" ");
			int j=0;
			for(Vertex v3: vertices)
			{
				if(!map.containsKey(v3))
				{
					i=j;
					break;
				}
				j++;
			}
		}
	}

	//map vertex arrayli comp
	//return cnnect comp arraylist<arrayli>
	public boolean isConnected()
	{
		Queue<Vertex> q=new Queue<>();
		HashMap<Vertex,Boolean> map=new HashMap<>();
		q.enqueqe(vertices.get(0));
		map.put(vertices.get(0), true);
		while(!q.isEmpty())
		{
			Vertex curr=q.dequeue();
			//System.out.print(curr.getName()+" ");

			ArrayList<Vertex> adjacent=curr.getAdjacent();
			for(Vertex adj: adjacent)
			{
				if(!map.containsKey(adj))
				{
					q.enqueqe(adj);
					map.put(adj, true);
				}
			}

		}

		for(Vertex v3: vertices)
		{
			if(!map.containsKey(v3))
			{
				return false;
			}

		}
		return true;

	}//bipartite
	//check cycle
	public boolean isBipartite()
	{
		//true/false instead of 2 arrayli
		Queue<Vertex> q=new Queue<>();
		HashMap<Vertex,Integer> visited=new HashMap<>();
		ArrayList<Vertex> part1=new ArrayList<>();
		ArrayList<Vertex> part2=new ArrayList<>();
		q.enqueqe(vertices.get(0));
		visited.put(vertices.get(0), 1);
		part1.add(vertices.get(0));
		while(!q.isEmpty())
		{
			Vertex curr=q.dequeue();
//			if(!part2.contains(curr) && !part1.contains(curr))
//				part1.add(curr);
			ArrayList<Vertex> adjacent=curr.getAdjacent();
			for(Vertex adj: adjacent)
			{
				if(part1.contains(curr) && part1.contains(adj))
				{
					return false;
				}
				else if(part2.contains(curr) && part2.contains(adj))
				{
					return false;
				}
				if(!visited.containsKey(adj))
				{
					q.enqueqe(adj);
					if(part1.contains(curr) && !part2.contains(adj))
						part2.add(adj);
					else if(part2.contains(curr) && !part1.contains(adj))
					{
						part1.add(adj);
					}
					visited.put(adj, 1);
				}
			}
		}
		return true;
	}
	public void iscycle()
	{
		//bfs traverse until node repeat..+++h
		Queue<Vertex> q=new Queue<>();
		HashMap<Vertex,Vertex> edgeTo=new HashMap<>();
		HashMap<Vertex,Boolean> map=new HashMap<>();
		q.enqueqe(vertices.get(0));
		map.put(vertices.get(0), true);
		int count=0;
		while(!q.isEmpty())
		{
			Vertex curr=q.dequeue();
			//System.out.print(curr.getName()+" ");

			ArrayList<Vertex> adjacent=curr.getAdjacent();
			for(Vertex adj: adjacent)
			{
				if(map.containsKey(adj) && !(edgeTo.get(curr)==adj))
				{
					count++;
				}
				if(!map.containsKey(adj))
				{
					q.enqueqe(adj);
					edgeTo.put(adj, curr);
					map.put(adj, true);
				}
			}

		}
		System.out.println("No.of cycles:"+count/2);
	}

	
	
	

}
