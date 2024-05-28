package Graph;
import java.util.*;

public class GraphAllPath {

    public static Node addNode(HashMap<String, Node> graph, String id) {
        if (!graph.containsKey(id)) {
            graph.put(id, new Node(id));
        }
        return graph.get(id);
    }
 
    public static void addEdge(HashMap<String, Node> graph, String srcId, String destId) {
        graph.get(srcId).neighbours.add(graph.get(destId));
        graph.get(destId).neighbours.add(graph.get(srcId));
    }

    /*Basic Traversal using BFS - this will just print the elements */
    public static void traverse(HashMap<String, Node> graph, String srcId) {
        System.out.println("Traverse using BFS - ");

        HashSet<String> visited = new HashSet<>();
        traverse(graph, srcId, visited);

        System.out.println();
    }
    public static void traverse(HashMap<String, Node> graph, String srcId, HashSet<String> visited) {
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(graph.get(srcId));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.id + "  ");
            visited.add(node.id);

            for (Node neighbour : node.neighbours) {
                if (!visited.contains(neighbour.id)){
                    queue.offer(neighbour);
                    visited.add(neighbour.id);
                    
                }
            }
        }
    }   

    /*Return true if a path exists between src and destination using DFS*/
    public static  void findPath(HashMap<String, Node> graph, String srcId, String destId) {
        System.out.println("Find Path using DFS ");

        HashSet<String> visited = new HashSet<>();
        String path = srcId;
        boolean hasPath = findPath(graph, srcId, destId, visited, path);

        System.out.println("Path exists : "+hasPath);
    }
    public static boolean findPath(HashMap<String, Node> graph, String srcId, String destId, HashSet<String> visited, String path) {

        if (srcId == destId) {
            System.out.println(path);
            return true; 
        }

        visited.add(srcId);

        for (Node neighbour : graph.get(srcId).neighbours) {
            if (!visited.contains(neighbour.id)) {
                if (findPath(graph, neighbour.id, destId, visited, path+" - "+neighbour.id)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*Find all the possible paths Using DFS, this method witll return an arraylist with all the possible paths */
    public static void findAllPaths(HashMap<String, Node> graph, String srcId, String destId) {
        System.out.println();
        HashSet<String> visited = new HashSet<>();
        findAllPaths(graph, srcId, destId, visited, srcId);
        System.out.println();

    }
    public static void findAllPaths(HashMap<String, Node> graph, String srcId, String destId, HashSet<String> visited, String path) {

        if (srcId == destId) {
            System.out.println("Paths : "+path);
            return;
        }

        visited.add(srcId);
        for (Node neighbour : graph.get(srcId).neighbours) {
            if (!visited.contains(neighbour.id)) {
                findAllPaths(graph, neighbour.id, destId, visited, path+" - "+neighbour.id);
            }
        }
        //visited.remove(srcId);  /* The method doesn't return anything while doing recurrsion, so this is not required to print all paths */
    }

    public static void main(String[] args) {

        HashMap<String, Node> graph = new HashMap<String, Node>();

        addNode(graph, "A");
        addNode(graph, "B");
        addNode(graph, "C");
        addNode(graph, "D");

        addEdge(graph, "A", "B");
        addEdge(graph, "B", "C");
        addEdge(graph, "C", "D");
        addEdge(graph, "D", "B");

        traverse(graph, "A");

        findPath(graph, "A", "D");

        findAllPaths(graph, "A", "D");
    }
}

class Node {
    String id;
    LinkedList<Node> neighbours = new LinkedList<Node>();
    public Node(String id) {
        this.id = id;
    }
}
