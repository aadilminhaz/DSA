package Graph.Graph_Practice;

import java.util.*;

/*Topological Sorting using BFS is Kahn's ALGORITHM, based on in-degree */
/*In a Directd Acyclic graph, there must be atleast one vertex with in-degress 0 and atleast 1 vertex with out-degree 0 */
public class KahnsAlgorithm {

    public static void kahnsSorting(List<LinkedList<Integer>> graph) {

        //Based on in-degree of the nodes
        // In a Directed Acyclic graph, there must be at least 1 vertex with 0 in-degree and at least 1 vertex with 0 out-degree
        
        //First create the in-degree array, how to calculate the in-degree, traverse the map and count the occurence of vertex in the linked-List
        //Don't worry about the O(N^2), this would be O(number of egdes) - O(E)
        int[] inDegree = new int[graph.size()];
        
        for (LinkedList<Integer> list : graph) {
            for (Integer v : list) {
                inDegree[v]++;
            }
        }

        //1. Cre<ate a queue, push all the vertex with in-degree 0
        //2. Now normal BFS - Poll the node- collect the data in a list (final result list), 
        //3. and decrement the in-degree of neighbours by 1
        //4.  the neighbour left with 0 in-degree goes in the queue
        //5. Repeat
        Queue<Integer> queue = new LinkedList<>();
        //boolean[] visited = new boolean[graph.size()];

        //1. Find node/vertex with 0 in-degress and push in the queue
        for (int i=0; i<graph.size(); i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);             
            }
        }

        List<Integer> kahnsSorted = new ArrayList<>();
        
        //2. Normal BFS, on in-degree instead of visited
        while(!queue.isEmpty()) {

            //2. Poll the node, collect the node for result 
            Integer node = queue.poll();
            kahnsSorted.add(node);
            for (Integer neighbour : graph.get(node)) {
                     //3.  and decrement the in-degree of neighbours by 1
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        //4.  the neighbour left with 0 in-degree goes in the queue
                        queue.add(neighbour);
                    }
            }
        }

        System.out.println("Kahn's Sroted : ");
        kahnsSorted.stream().forEach(v -> System.out.print(v+" - "));
    
    }

    public static void addDirectedEdge(List<LinkedList<Integer>> graph, Integer src, Integer dest) {
        graph.get(src).add(dest);
    }

    public static void bfsTraversal(List<LinkedList<Integer>> graph, Integer origin) {

        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> traversalQueue = new LinkedList<>();
        traversalQueue.offer(origin);
        visited[origin] = true;

        while(!traversalQueue.isEmpty()) {
            
            Integer node = traversalQueue.poll();
            System.out.print(node+" - ");
            

            for (Integer neighbour : graph.get(node)) {
                if (visited[neighbour] == false) {
                    traversalQueue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        int noOfVertex = 6;
        
        List<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<noOfVertex;  i++) {
            graph.add(new LinkedList<Integer>());
        }


        addDirectedEdge(graph, 0, 3);
        addDirectedEdge(graph, 0, 2);
        addDirectedEdge(graph, 2, 3);
        addDirectedEdge(graph, 3, 1);
        addDirectedEdge(graph, 2, 1);
        addDirectedEdge(graph, 1, 4);
        addDirectedEdge(graph, 5, 4);

        bfsTraversal(graph, 0);

        kahnsSorting(graph);
    }
    
}
