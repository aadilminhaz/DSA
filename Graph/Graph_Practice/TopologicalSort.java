package Graph.Graph_Practice;

import java.util.*;

/**Using simple graph, without custom Nodes */
public class TopologicalSort {


    public static void topologicSort(List<LinkedList<Integer>> graph, int origin) {
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> sortingStack = new Stack<Integer>();

        for (int i=0; i<graph.size(); i++) {
            if (!visited[i]) {
                topologicSort(graph, i, visited, sortingStack);
            }      
        }

        //Print the stack or take stacks content in an array and print
        List<Integer> topologicalSorted = new ArrayList<Integer>();
        while(!sortingStack.isEmpty()) {
            topologicalSorted.add(sortingStack.pop());
        }

        System.out.println("TopologicalLY SORTED : ");
        topologicalSorted.stream().forEach(v -> System.out.print(v+" - "));

    }

    public static void topologicSort(List<LinkedList<Integer>> graph, int node, boolean[] visited, Stack<Integer> sortingStack) {
        visited[node] = true;
        System.out.print(node+" - ");

        for(Integer neigbhour : graph.get(node)) {
            if (visited[neigbhour] == false) {
                topologicSort(graph, neigbhour, visited, sortingStack);
            }
        }

        sortingStack.push(node);
    }

    public static void addEdge(List<LinkedList<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
        
    }

    public static void dfsTraversal(List<LinkedList<Integer>> graph, int origin) {
        boolean[] visited = new boolean[graph.size()];
        dfs(graph, origin, visited);
    }

    public static void dfs(List<LinkedList<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node+" - ");
        for (Integer neigbour : graph.get(node)) {
            if (visited[neigbour] == false) {
                dfs(graph, neigbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        List<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<v; i++) {
            graph.add(new LinkedList<Integer>());
        }

        addEdge(graph, 0, 3);
        addEdge(graph, 0, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);
        addEdge(graph, 1, 4);
        addEdge(graph, 5, 1);
        addEdge(graph, 5, 4);

        dfsTraversal(graph, 0);
        System.out.println("");
        dfsTraversal(graph, 5);

        topologicSort(graph, v);
    }

    
    
}
