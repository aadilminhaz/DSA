package Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation is based on Adjacent List.
 * An Array of Lists of nodes
 * where 
 * Array represents Vertices
 * Lists represent edges of the vertex
 * each edge has - source, neighbour and weight, all int values 
 */

public class GraphWithEdge {

    
    public static void addToGraph(ArrayList<Edge>[] graph, int v1, int v2, int weight) {
        graph[v1].add(new Edge(v1, v2, weight));
        graph[v2].add(new Edge(v2, v1, weight));
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int source) {

        visited[source] = true;
        System.out.print(source+ " - ");    
        for (Edge edge : graph[source]) {
            //CHeck if the neighbours are already visited
            if (visited[edge.neighbour] == false) {
                dfs(graph, visited, edge.neighbour);  
            }  
        }
    }

    public static boolean pathExists(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

        if (src == dest) {
            return true;
        }

        visited[src] = true;
        System.out.print(src+"-");
        for (Edge edge : graph[src]) {   // all the edges from this vertex
            if (visited[edge.neighbour] == false) {
                boolean pathFound = pathExists(graph, edge.neighbour, dest, visited);
                if (pathFound == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int sizeOfGraph = 7;
        ArrayList<Edge>[] graph = new ArrayList[sizeOfGraph];
        for (int i=0; i<sizeOfGraph; i++) {
            graph[i] = new ArrayList<>();
        }

        int source = 0;
        boolean[] visited = new boolean[graph.length];

        //Creating a graph
        // 0-1 0-3, 1-0 1-2, 2-1 2-3 2-5, 3-0 3-2, 5-2 5-4 5-6, 4-5 4-6, 6-4 6-5 
        //or clean way
        // 0-1, 0-3, 1-2, 2-3, 2-5, 5-4, 5-6 4-6
        //edge 0-1
        graph[0].add(new Edge(0,1,10));  //vertex 0
        graph[1].add(new Edge(1,  0, 10));  //vertex 1

        //edge 0-3
        graph[0].add(new Edge(0,3,10));
        graph[3].add(new Edge(3, 0, 10));

        //edge 1-2
        graph[1].add(new Edge(1, 2, 10));
        graph[2].add(new Edge(2, 1,10));


        //edge 2-3
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 2, 10));

        //edge 2-5
        graph[2].add(new Edge(2, 5, 10));
        graph[5].add(new Edge(5, 2, 10));

        //edge 5-4
        graph[5].add(new Edge(5,4, 10));
        graph[4].add(new Edge(4, 5, 10));

        //edge 5-6
        graph[5].add(new Edge(5, 6, 10));
        graph[6].add(new Edge(6, 5, 10));

        //edge 4-6
        graph[4].add(new Edge(4,6, 10));
        graph[6].add(new Edge(6,4, 10));

        System.out.println("");
        //Print all the edges of the graph
        dfs(graph, visited, source);

        //Resetting visited array to perform other operations
        Arrays.fill(visited, false);

        System.out.println("");
        //dfs(graph, visited, source);
        boolean result = pathExists(graph, 0, 6, visited);
       
        System.out.println(result);

       

    }
}




class Edge {
    int weight;
    int source;
    int neighbour;

    public Edge(int source, int neighbour, int weight) {
        this.weight = weight;
        this.source = source;
        this.neighbour = neighbour;
    }
}
