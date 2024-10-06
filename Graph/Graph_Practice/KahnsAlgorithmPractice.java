package Graph.Graph_Practice;

import java.util.*;

/*Kahns Algorithm is topological sort in a directed graph */
/* In a Directed Acyclic graph, there must be minimum 1 vertex with 0 In-Degree and 1 vertex with 0 Out-Degree */

//Algorithm
/*
 * 1.  Idea is to make an array of In-Degree of all the nodes
 * 2. Take a min heap and push the nodes with IN-Degree as 0
 * 3. iterate over the min-heap 
 *  3.1 Poll the element - collect in a an answer list, and decrement the neighbours In-Degree by -1
 *  3.2 Push the neighbours with IN-Degres as 0 in the min-Heap. Reapeat. 
 * 
 */
public class KahnsAlgorithmPractice {


    public static List<Integer> KahnsSortingAlgo(List<LinkedList<Integer>> graph) {

        int[] inDegree = new int[graph.size()];
        //Create the In-Degree Array
        //Time Complexity - O(Number of edges) not - O(N^2)
        for (int i=0; i<graph.size(); i++) {
            for (Integer edge : graph.get(i)) {
                inDegree[edge]++;
            }
        }

        
       
        List<Integer> topologialSorted = new ArrayList<>();

        bfs(graph, inDegree, topologialSorted);
        return topologialSorted;

    }
    
    /* Normal BFS, but instead of visisted we will use inDegree and look for value 0 in IN-DEgree */
    public static void bfs(List<LinkedList<Integer>> graph, int[] inDegree, List<Integer> sorted) {
        //Create a MIN-HEAP
        Queue<Integer> minHeap = new PriorityQueue<>();
         
        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                minHeap.offer(i);
            }
        }

        while (!minHeap.isEmpty()) {

            //Poll the element 
            int polled = minHeap.poll();
            sorted.add(polled);
            for (int neighbour : graph.get(polled)) {
                //Decrement in-degree of all the neighbours
                inDegree[neighbour]--;

                //push the neighbour with 0 in-degree
                if (inDegree[neighbour] == 0) {
                    minHeap.offer(neighbour);
                }
            }
        }
    }

    

    public static void addDirectedEdge(List<LinkedList<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
    }
    
    public static void dfsTraversal(List<LinkedList<Integer>> graph, int origin) {
        boolean[] visited = new boolean[graph.size()];
        dfsTraversal(graph, origin, visited);

    }
    public static void dfsTraversal(List<LinkedList<Integer>> graph, int node, boolean[] visited) {

        visited[node] = true;
        System.out.print(node+" - ");

        for (Integer neighbour : graph.get(node)) {
            if (visited[neighbour] ==  false ){
                dfsTraversal(graph, neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        int numberOfVertex = 6;
        List<LinkedList<Integer>> graph = new ArrayList<>();

        //Initialise the graph
        for (int i=0; i<numberOfVertex; i++) {
            graph.add(new LinkedList<Integer>());
        }
        
        addDirectedEdge(graph, 0, 2);
        addDirectedEdge(graph, 0, 3);
        addDirectedEdge(graph, 3, 1);
        addDirectedEdge(graph, 2, 3);
        addDirectedEdge(graph, 2, 1);
        addDirectedEdge(graph, 5, 1);
        addDirectedEdge(graph, 1, 4);
        addDirectedEdge(graph, 5, 4);
        dfsTraversal(graph, 0);

        System.out.println("Applying Kahns algo, performing topological sorting...");
        List<Integer> topologicalSorted = KahnsSortingAlgo(graph);
        topologicalSorted.forEach(e -> System.out.print(e+" - "));
    }


}
