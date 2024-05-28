package Tree;
import java.util.*;
import java.util.stream.Stream;

public class LevelOrderAndViews {


    /* O(N) complexity using Queue */
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        
        while(!queue.isEmpty()) {

            Node node = queue.poll();

            System.out.println(node.data);
            if(node.left != null) {
                queue.offer(node.left);
            }
            
            if(node.right != null) {
                queue.offer(node.right);
            }
            
        }

    }

    /* O(N) complexity using Queue */
    public static void recLevelOrder(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.data);
        }

        if (level > 1) {
            recLevelOrder(root.left, level - 1);
            recLevelOrder(root.right, level-1);
        }
    }

    /*Left view using a HashMap where key is the level and value is the left value on that level */
    public static void printLeftView(Node root) {
        Node[] levelMap = new Node[10];
    
        leftView(root, levelMap, 0);
       // for (Node node: levelMap) {
        //    System.out.println(node.data);
       // }
    }

    public static void leftView(Node node, Node[] levelMap, int level) {
        if (node == null) {
            return;
        }
        if (levelMap[level] == null) {          //Right view approach 1 - remove this null check, it will just update the element with the last value of the level
            levelMap[level] = node;
            System.out.println(node.data);
        }
        leftView(node.left, levelMap, level+1);   // Or Right view approach 2 - REVERSE THESE TWO LINES FOR RIGHT VIEW
        leftView(node.right, levelMap, level+1);

    }

   public static void topView(Node root) {

    if (root == null) {
        return;
    }

    Queue<Pair> queue = new LinkedList<>();
    Map<Integer, Node> viewMap = new TreeMap<Integer, Node>();
    
    queue.offer(new Pair(0, root));

    while(!queue.isEmpty()) {

        Pair current = queue.poll();
        if (!viewMap.containsKey(current.hzLevel)) {
            viewMap.put(current.hzLevel, current.node);
        }
        if (current.node.left != null)
            queue.offer(new Pair(current.hzLevel-1, current.node.left));
        if (current.node.right != null)
            queue.offer(new Pair(current.hzLevel+1, current.node.right));
    }

    for (Integer hzLevel : viewMap.keySet()) {
        System.out.println(viewMap.get(hzLevel).data);
    }
    

   }
   
   
   

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        /*We are creating 2 4 7 -1 -1 -1 1 8  -1 -1 3 -1 -1(Entry sequence representation)*/
        Node root = createTree(sc); 
        
        /*Level Order O(N) */
        System.out.println("Level Order Traversal O(N): ");
        levelOrder(root);


        /*Level Order O(N^2) */
        System.out.println("Level Order Traversal O(N^2): ");
        recLevelOrder(root, 3);

        System.out.println("Left View");
        printLeftView(root);

        System.out.println("Top View");
        topView(root);
    }

    /*Basic method to create a Binary Tree */
    public static Node createTree(Scanner sc) {
        Node root = null;

        System.out.println("Enter data : ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        
        root = new Node(data);

        System.out.println("Enter left for  : "+data);
        root.left = createTree(sc);
        System.out.println("Enter right for : "+data);
        root.right = createTree(sc);
        
        return root;
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class Pair {
    int hzLevel;
    Node node;

    public Pair(int hzLevel, Node node) {
        this.hzLevel = hzLevel;
        this.node = node;
    } 
}
