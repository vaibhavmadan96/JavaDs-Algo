

import java.util.ArrayList;

public class Vertex {
	private String name;
	private ArrayList<Edge> edges;//Associated edges

	Vertex(String name){
		this.name = name;
		edges = new ArrayList<>();
	}

	public int numEdges() {

		return edges.size();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public void addEdge(Edge e) {
		this.edges.add(e);

	}

	public boolean isAdjacent(String name) {
		for(Edge e : edges){
			if(e.first.name.equals(name) || e.second.name.equals(name)){
				return true;
			}

		}
		return false;
	}

	public void removeEdgeWith(Vertex v2) {
		for(int i =0; i < edges.size(); i++){
			Edge currentEdge = edges.get(i);
			if(currentEdge.first == v2 || currentEdge.second == v2){
				this.edges.remove(i);
				return;
			}
		}	
	}

	public ArrayList<Vertex> getAdjacent()//returns all adjacent vertices
	{
		ArrayList<Vertex> adjacent = new ArrayList<>();
		for(Edge e : edges){
			if(e.first == this){
				adjacent.add(e.second);
			}
			else{
				adjacent.add(e.first);
			}
		}
		return adjacent;
	}

	public void print() //prints vertex with all its adjacent vertices
	{

		System.out.print(name +" : ");
		for(Edge e : edges){
			if(e.first == this){
				System.out.print(e.second.name+" , ");
			}
			else{
				System.out.print(e.first.name+" , ");
			}
		}
		System.out.println();
	}
}
