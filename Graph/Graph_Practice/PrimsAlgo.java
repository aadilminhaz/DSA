package Graph.Graph_Practice;

import java.util.*;

/* Prim's Algorithm - or Find Minimum spanning tree in the Undirected graph */
/* Using priority queue, with comparator to sort based on the weight */
public class PrimsAlgo {
    
}


class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;
    List<Edge> neigbhours;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
        neigbhours = new ArrayList<>();
    }

    @Override
    public int compareTo(Edge o) {
      
       return Integer.compare(this.weight, o.weight);
    }
}