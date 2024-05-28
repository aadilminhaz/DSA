package Graph;

import java.util.*;

/*Implementation of Undirected Graph using List Adjacent method, 
 - ArrayList of ArrayLists<Integers>
 - ArrayList represents vertices and inner arraylist represents neighbours 
 - With DFS and BFS printers
 */

public class BasicGraphExample {

    //Add neighbours to a vertex
    public static void add(ArrayList<ArrayList<Integer>> graph, int src, int dest, int weight) {
        
        graph.get(src).add(dest);
        graph.get(dest).add(src);

    }


    public static void printViaDFS(ArrayList<ArrayList<Integer>> graph, int origin) {
        System.out.println();
        boolean[] visited = new boolean[graph.size()];
        dfsPrinter(graph, origin, visited);
        System.out.println();
    }
    /*Printing via recursion - DFS, can be implemented with stack as well */
    public static void dfsPrinter(ArrayList<ArrayList<Integer>> graph, int origin, boolean[] visited) {

        visited[origin] = true;
        System.out.print(origin+" - ");
        for (Integer neighbour : graph.get(origin)) {
            if (visited[neighbour] == false) {
                dfsPrinter(graph, neighbour, visited);
            }
        }
    } 

    /*Impmenetation of BFS (shorted path in case of se) using a queue */
    public static void printViaBFS(ArrayList<ArrayList<Integer>> graph, int origin) {
        boolean[] visited = new boolean[graph.size()];
        System.out.println();
        
        //using a queue
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(origin);
        
        while(!queue.isEmpty()) {
            //Poll 
            Integer polled = queue.poll();
            System.out.print(polled+" - ");
            visited[polled] = true;

            //Insert the neighbours into the queue, repeat both steps
            for (Integer neighbour : graph.get(polled)) {
                if (visited[neighbour] == false) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }

        }
        System.out.println();
    }

    public static void bfsPrinter(ArrayList<ArrayList<Integer>> graph, int origin, boolean[] visited) {

        visited[origin] = true;
        System.out.print(origin+" - ");
        for (Integer neighbour : graph.get(origin)) {
            if (visited[neighbour] == false) {
                bfsPrinter(graph, neighbour, visited);
            }
        }
    }


    public static void main(String[] args) {

        int numVertices = 7;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //Initialise the internal lists
        for(int i = 0; i<numVertices; i++) {
            graph.add(new ArrayList<Integer>());
        }

        add(graph, 0, 1, 10);    
        add(graph, 0, 4, 10);
        add(graph, 1, 2, 10);
        add(graph, 1, 3, 10);
        add(graph, 2, 5, 10);
        add(graph, 5, 6, 10);
        add(graph, 6, 3, 10);
        add(graph, 3, 4, 10);
        

        int origin = 0;
        printViaDFS(graph, origin);

        printViaBFS(graph, origin);
    }  
}


