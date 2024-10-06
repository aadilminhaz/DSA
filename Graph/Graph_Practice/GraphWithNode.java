package Graph.Graph_Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphWithNode {

    public static Node addNode(Map<String, Node> graph, String nodeId) {
        
        if (graph.get(nodeId) == null) {
            Node node = new Node(nodeId);
            graph.put(nodeId, node);
        }
        return graph.get(nodeId);
    }

    public static void addEdge(Map<String, Node> graph, String srcNodeId, String destNodeId) {    
        Node srcNode = addNode(graph, srcNodeId);
        Node destNode = addNode(graph, destNodeId);

        srcNode.neighbours.add(destNode);
        destNode.neighbours.add(srcNode);
    }

    public static void dfsPrinter(Map<String, Node> graph, String node) {

        System.out.println("\nDFS Printer");
        Set<String> visited = new HashSet<String>();
        dfs(graph, node, visited);
        
    }

    public static void dfs(Map<String, Node> graph, String nodeId, Set<String> visited) {
    
        visited.add(nodeId);
        System.out.print(nodeId+ " - ");

        for (Node neighbour : graph.get(nodeId).neighbours) {
            if (!visited.contains(neighbour.getNodeId())) {
                dfs(graph, neighbour.getNodeId(), visited);
            }
        }
    }

    public static void BFSPrinter(Map<String, Node> graph, String origin) {
        System.out.println("\nBFS Printer");
        Set<String> visited = new HashSet<>();
        BFS(graph, origin, visited);
    }
    public static void BFS(Map<String, Node> graph, String nodeId, Set<String> visited) {
       
        Queue<Node> queue = new LinkedList<>();

        queue.add(graph.get(nodeId));
        visited.add(nodeId);

        while(!queue.isEmpty()) {

            Node node = queue.poll();
            
            System.out.print(node.getNodeId()+" - ");
            
            for (Node neighbour : node.neighbours) {
                if (!visited.contains(neighbour.getNodeId())) {
                    queue.add(neighbour);
                    visited.add(neighbour.getNodeId());
                }
            }
        }
    }



    public static void main(String[] args) {
        Map<String , Node> graph = new HashMap<>();

        addNode(graph, "A");
        addNode(graph, "B");
        addNode(graph, "C");
        addNode(graph, "D");

        addEdge(graph, "A", "B");
        addEdge(graph, "A", "C");
        addEdge(graph, "B", "C");
        addEdge(graph, "C", "D");

        
        dfsPrinter(graph, "A");
        BFSPrinter(graph, "A");


    }
    
}

class Node {
    String nodeId;
    List<Node> neighbours;
    
    Node(String nodeId) {
        this.nodeId = nodeId;
        neighbours = new ArrayList<>();
    }

    public String getNodeId() {
        return this.nodeId;
    }
}
