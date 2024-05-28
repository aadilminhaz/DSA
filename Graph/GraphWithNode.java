package Graph;
import java.util.*;


public class GraphWithNode {
    

    public static Node addNode(HashMap<String, Node> graph, String id) {
        Node node = new Node(id);
        if (!graph.containsKey(id)) {
            graph.put(id, node);
        } 
        return graph.get(id);  
    }

    

    public static void addEdge(HashMap<String, Node> graph, String srcId, String destId) {
        Node src = addNode(graph, srcId);
        Node dest = addNode(graph, destId);

        src.neighbours.add(dest);       //Undirected - so two-way edge
        dest.neighbours.add(src);
    }

    public static void dfsPrinter(HashMap<String, Node> graph, String srcId, HashSet<String> visited) {
        visited.add(srcId);
        System.out.print(srcId+" - ");

        for (Node node : graph.get(srcId).neighbours) {
            if (!visited.contains(node.getId())) {
                dfsPrinter(graph, node.getId(), visited);
            }
        }

    }

    public static void bfsPrinter(HashMap<String, Node> graph, String srcId, HashSet<String> visited) {
        
        Queue<Node> queue = new LinkedList<Node>();

        queue.offer(graph.get(srcId));
        
        visited.add(srcId);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.getId()+" - ");
            for (Node neighbour : node.neighbours) {
                if (!visited.contains(neighbour.getId())) {
                    queue.offer(neighbour);
                    visited.add(neighbour.getId());
                }
            }
        }
    }



    /*Detect cycle using DFS */
    public static boolean detectCycle(HashMap<String, Node> graph, String srcId, HashSet<String> visited, String parent) {
        
        visited.add(srcId);
        

        for (Node neighbour : graph.get(srcId).neighbours) {
            if (!visited.contains(neighbour.getId())) {
                if (detectCycle(graph, neighbour.getId(), visited, srcId) == true) {
                    return true;
                }

            }
            else if (neighbour.getId() != parent) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        HashMap<String, Node> graph = new HashMap<String, Node>();
        
        addNode(graph, "A");
        addNode(graph, "B");
        addNode(graph, "C");
        addNode(graph, "D");

        addEdge(graph, "A", "E");
        addEdge(graph, "A", "B");
        addEdge(graph, "B", "C");
        addEdge(graph, "B", "D");
        addEdge(graph, "C", "D");
        addEdge(graph, "E", "F");
        

        HashSet<String> visited = new HashSet<String>();

        System.out.println();
        dfsPrinter(graph, "A", visited);
        System.out.println();

        //Reset visited set 
        visited.clear();
        System.out.println();
        bfsPrinter(graph, "A", visited);
        System.out.println();
        
        
        //Reset visited set 
        visited.clear();
        System.out.println(detectCycle(graph, "A", visited, null));
    }
    
}

class Node {
    private String id;
    LinkedList<Node> neighbours = new LinkedList<Node>();
    public Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}