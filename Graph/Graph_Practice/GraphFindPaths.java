package Graph.Graph_Practice;

import java.util.*;

public class GraphFindPaths {



    public static void findPath(Map<String, Node> graph, String srcId, String destId) {
            List<String> path = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            findPath(graph, srcId, destId, visited, path);
            path.stream().forEach(System.out::println);
    }

    public static void findPath(Map<String, Node> graph, String srcId, String destId, Set<String> visited,List<String> path) {
        
        //path.add(srcId);
        if (srcId == destId) {
            System.out.println(path);
            return;
        }
        visited.add(srcId);
        
        for (Node neighbour : graph.get(srcId).neighbours) {
            if (!visited.contains(neighbour.nodeId)) {
                path.add(neighbour.nodeId);
                findPath(graph, neighbour.nodeId, destId, visited, path);
            }
        }
    }

    public static Node addNode(Map<String, Node> graph, String nodeId) {
        
        if (!graph.containsKey(nodeId)) {
            graph.put(nodeId, new Node(nodeId));
        }
        return graph.get(nodeId);
    }

    public static void addEdge(Map<String, Node> graph, String srcId, String destId) {
        Node srcNode = addNode(graph, srcId);
        Node destNode = addNode(graph, destId);

        srcNode.neighbours.add(destNode);
        destNode.neighbours.add(srcNode);
    }

    public static void bfsTraversal(Map<String, Node> graph, String origin) {
        Set<String> visited =  new HashSet<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(graph.get(origin));
        visited.add(origin);

        while(!queue.isEmpty()) {

            Node node = queue.poll();
            System.out.print(node.nodeId+" - ");

            for (Node neighbour : node.neighbours) {
                if (!visited.contains(neighbour.nodeId)) {
                    queue.add(neighbour);
                    visited.add(neighbour.nodeId);
                }
            }
        }
    }

    public static void main(String[] args) {

        Map<String, Node> graph = new HashMap<String, Node>();

        ////Add nodes ABCDEF
        addNode(graph, "A");
        addNode(graph, "B");
        addNode(graph, "C");
        addNode(graph, "D");

        addNode(graph, "E");
        addNode(graph, "F");

        //Add EDGES A-B-C-D  E-F
        /*addEdge(graph, "A", "B");
        addEdge(graph, "B", "C");
        addEdge(graph, "D", "C");
        addEdge(graph, "D", "B");*/

        addEdge(graph, "A", "B");
        addEdge(graph, "B", "C");
        addEdge(graph, "C", "D");
        addEdge(graph, "D", "B");

        addEdge(graph, "E", "F");

        System.out.println("\nPrinting via BFS traversal");
        bfsTraversal(graph, "A");
        System.out.println("\nPrinting via BFS traversal");
        bfsTraversal(graph, "E");
        System.out.println("\nPrinting Path betwen B-C");
        findPath(graph, "B", "C");

    }

    
}

class Node {
    String nodeId;
    List<Node> neighbours;

    public Node(String nodeId) {
        this.nodeId = nodeId;
        neighbours = new ArrayList<>();
    }
}
