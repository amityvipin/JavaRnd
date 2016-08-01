package careercup.chapter4;

import java.util.ArrayList;

public class RouteBetweenNodes {
	int vertices;
	int edges;
	ArrayList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public RouteBetweenNodes(int v){
		vertices = v;
		edges = 0;
		adj = (ArrayList<Integer>[])new ArrayList[v];
		for(int i=0;i<v;i++){
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public int vertices(){
		return vertices;
	}
	
	public int edges(){
		return edges;
	}
	
	public void addEdge(int v1, int v2){
		adj[v1].add(v2);
		edges++;
	}
	
	public String toString(){
		StringBuilder value = new StringBuilder();
		value.append("No of vertics : "+ vertices +" No of edges : "+edges+"\n");
		for (int v = 0; v < vertices; v++) {
			value.append(String.format("%d: ", v));
            for (Integer w : adj[v]) {
            	value.append(String.format("%d ", w));
            }
            value.append("\n");
        }
		return value.toString();
	}
	
	public boolean isRoute(int firstNode, int secondNode){
		for(Integer i : adj[firstNode]){
			if(i==secondNode){
				return true;
			}
			return isRoute(i,secondNode);
		}
		return false;
	}
	public static void main(String args[]){
		RouteBetweenNodes graph = new RouteBetweenNodes(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(0, 5);
		graph.addEdge(5, 3);
		graph.addEdge(0, 4);
		System.out.println(graph.isRoute(1, 4));
	}
}
