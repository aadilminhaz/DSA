package Graph.Graph_Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Solution based on recursion stack, to handle directed graph case */

public class DirectedGraphCycle {



    public static void detectDirectedCycle(Map<String, Node> graph) {
        Set<String> visited = new HashSet<>();
        boolean isCycleDetected = false;
        
        Set<String> cycleStack = new HashSet<>();
        for (String nodeId :  graph.keySet()) {

            System.out.println("\nCycle stack starts with : "+nodeId);
            if (isCycle(graph, nodeId, visited, cycleStack)) {
                isCycleDetected = true;
                break;
            }
        }
        System.out.println("Cycle detected : "+isCycleDetected);

    }

    public static boolean isCycle(Map<String, Node> graph, String nodeId, Set<String> visited, Set<String> cycleStack) {
        
        visited.add(nodeId);
        cycleStack.add(nodeId);

        System.out.print(nodeId+" - ");

        for (Node neighbour : graph.get(nodeId).neibhours) {
            if (!visited.contains(neighbour.nodeId)) {
                if (isCycle(graph, neighbour.nodeId, visited, cycleStack)) {
                    return true;
                }
            } else if(cycleStack.contains(neighbour.nodeId)) { //If it is visited and in the same stack, then it forms a cycle
                return true;
            }
            
        }

        cycleStack.clear();
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

        srcNode.neibhours.add(destNode);
    }
    
    public static void dfsTraversal(Map<String, Node> graph, String origin) {
        Set<String> visited = new HashSet<String>();
        dfsTraversal(graph, origin, visited);
    }

    public static void dfsTraversal(Map<String, Node> graph, String nodeId, Set<String> visited) {
        visited.add(nodeId);

        System.out.print(nodeId+" - ");
        for (Node neibhour : graph.get(nodeId).neibhours) {
            if (neibhour != null && !visited.contains(neibhour.nodeId)) {
                dfsTraversal(graph, neibhour.nodeId, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Node> graph = new HashMap<String, Node>();

        addNode(graph, "A");
        addNode(graph, "B");
        addNode(graph, "C");
        addNode(graph, "D");
        addNode(graph, "E");

        //Unidirectional
        addEdge(graph, "A", "B");

        addEdge(graph, "C", "D");
        addEdge(graph, "D", "E");
        addEdge(graph, "E", "C");

        System.out.println("\nPrinting directed from A");
        dfsTraversal(graph, "A");
        System.out.println("\nPrinting directed from C");
        dfsTraversal(graph, "C");

        System.out.println("\nPrinting directed from B");
        dfsTraversal(graph, "B");

        detectDirectedCycle(graph);
    }


}

class Node {
    String nodeId;
    List<Node> neibhours;
    
    public Node(String nodeId) {
        this.nodeId = nodeId;
        neibhours = new ArrayList<>();
    }
}