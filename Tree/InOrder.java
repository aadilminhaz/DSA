package Tree;
import java.util.*;

public class InOrder {


    //Inorder - L Node R
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        /*We are creating 2 4 7 -1 -1 -1 1 8  -1 -1 3 -1 -1(Entry sequence representation)*/
        Node root = createTree(sc);

        System.out.println("Printing InOrder");
        inOrder(root);

    }

    //Basic methods to create the tree
    public static Node createTree(Scanner sc) {

        Node root  = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        root = createNode(data);

        System.out.println("Enter left for :"+data);
        root.left = createTree(sc);

        System.out.println("Etner right for : "+data);
        root.right = createTree(sc);
    
        return root;
    }

    public static Node createNode(int data) {
        return new Node(data);
    } 
}

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
    }
}
