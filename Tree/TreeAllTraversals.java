package Tree;

import java.util.*;

public class TreeAllTraversals {
    

    /* PreOrder Node-Left-Right */
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /* InOrder Left-Node-Right */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    /* PostOrder Left-Right-Node */
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /*We are creating 2 4 7 -1 -1 -1 1 8  -1 -1 3 -1 -1(Entry sequence representation)*/
        Node root = createTree(sc); 
        
        /*PreOrder traversal */
        System.out.println("preOrder traversal ");
        preOrder(root);


        
        /*InOrder traversal*/
        System.out.println("inOrder traversal ");
        inOrder(root);

        /*PostOrder traversal */
        System.out.println("postOrder traversal ");
        postOrder(root);
        

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
