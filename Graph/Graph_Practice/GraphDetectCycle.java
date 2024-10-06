package Graph.Graph_Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphDetectCycle {

    public static void detectCycle(Map<String, Node> graph, String origin) {
        Set<String> visited = new HashSet<String>();
        
        System.out.println("Cycle detected : "+isCycleDFS(graph, origin, null, visited ));


    }

    public static boolean isCycleDFS(Map<String, Node> graph, String origin, String parent, Set<String> visited) {
        visited.add(origin);

        for(Node neibhour: graph.get(origin).neighbours) {
            if(!visited.contains(neibhour.nodeId)) {
                if (isCycleDFS(graph, neibhour.nodeId, origin, visited)) {
                    return true;
                }
            } else if(parent != neibhour.nodeId) {
                return true;
            }
        } 
        return false;
    }

    public static Node addNode(Map<String, Node> graph, String nodeId) {
        if (!graph.containsKey(nodeId)) {
            Node node = new Node(nodeId);
            graph.put(nodeId, node);
        }
        return graph.get(nodeId);
    }

    public static void addEdge(Map<String, Node> graph, String srcId, String destId) {
        Node srcNode = addNode(graph, srcId);
        Node destNode = addNode(graph, destId);

        srcNode.neighbours.add(destNode);
        destNode.neighbours.add(srcNode);
    }

    public static void dfsTraversal(Map<String, Node> graph, String origin) {
        Set<String> visited = new HashSet<>();

        dfs(graph, origin, visited);
    }

    public static void dfs(Map<String, Node> graph, String nodeId, Set<String> visited) {

        visited.add(nodeId);
        System.out.print(nodeId+" - ");
       
        for (Node neighbour: graph.get(nodeId).neighbours) {
            if (!visited.contains(neighbour.nodeId)) { 
                dfs(graph, neighbour.nodeId, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Node> graph = new HashMap<String, Node>();

        addNode(graph, "A");
        addNode(graph, "B");
        addNode(graph, "C");
        addNode(graph, "D");
        
        addEdge(graph, "A", "B");
        addEdge(graph, "B", "C");
        //addEdge(graph, "C", "D");
        addEdge(graph, "B", "D");

        dfsTraversal(graph, "A");
        detectCycle(graph, "A");
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
