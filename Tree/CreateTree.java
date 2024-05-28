package Tree;

import java.util.*;

public class CreateTree {
    
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        createTree(sc);
        
        
    }

    public static Node createTree(Scanner sc) {
        
        Node root = null;
        System.out.println("Enter data : ");
        int data = sc.nextInt();
        if(data == -1) {
            return null;
        }
        root = createNode(data);

        System.out.println("Enter left for : "+data);
        root.left = createTree(sc);

        System.out.println("Etner right for : "+data);
        root.right = createTree(sc);

        return root;
    }

    public static Node createNode(int data) {
        Node node = new Node(data);
        return node;
    }

}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}




