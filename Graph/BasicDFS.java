package Graph;

import java.util.*;


/*Implementation of Graph with ArrayList of ArrayList of Integers */
public class BasicDFS {
    
    public static void dfsPrinterCaller(ArrayList<LinkedList<Integer>> graph, int src) {
        System.out.println();
        boolean[] visited = new boolean[graph.size()];
        dfsPrinter(graph, src, visited);
        System.out.println();
    }

    public static void dfsPrinter(ArrayList<LinkedList<Integer>> graph, int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src+" - ");

        for (Integer neighbour : graph.get(src)) {
            if (visited[neighbour] == false) {
                dfsPrinter(graph, neighbour, visited);
            }
        }
    }

    /*Will add two-way edge*/
    public static void add(ArrayList<LinkedList<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    public static void main(String[] args) {
        int v = 7;


        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
        
        //Initialise the internal linkedlists
        for (int i=0; i<v; i++) {
            graph.add(new LinkedList<Integer>());
        }

        //Create the graph
        
        add(graph, 0, 1);
        add(graph, 0, 4);
        add(graph, 1,2);
        add(graph, 1,3);
        add(graph, 2,5);
        add(graph, 3,4);
        add(graph, 3,6);
        add(graph, 3,6);
        add(graph, 5, 6);

        dfsPrinterCaller(graph, 0);
       


    }
}
