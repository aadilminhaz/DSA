

import java.util.*;

public class BasicGraph {

    public static void addEdge(ArrayList<LinkedList<Integer>> graph, Integer src, Integer dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    public static void dfsPrinter(ArrayList<LinkedList<Integer>> graph, Integer origin) {

        boolean[] visited = new boolean[graph.size()];
        dfs(graph, origin, visited);

    }
    public static void dfs(ArrayList<LinkedList<Integer>> graph, Integer node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node+" - ");

        for (Integer neighbour : graph.get(node)) {
            if (visited[neighbour] == false) {
                dfs(graph, neighbour, visited);
            }
        }   
    }
   

    public static void main(String[] args) {

        int v = 7;

        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();

        //Initialise internal linkedList
        for (int i=0; i<v; i++) {
            graph.add(new LinkedList<Integer>());
        }

        

        addEdge(graph, 0,1);
        addEdge(graph, 1,2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 0);
        addEdge(graph, 4, 3);
        addEdge(graph, 5, 3);
        
        

        dfsPrinter(graph, 0);
        
    }
}