package Tree;

import java.util.*;

public class TreeHeight {

    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }
    
    public static int getTreeSize(Node root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.left) + getHeight(root.right) +1;
    }

    public static void main(String[] args) {
       
       
        Scanner sc = new Scanner(System.in);
        
        /*We are creating 2 4 7 -1 -1 -1 1 8  -1 -1 3 -1 -1(Entry sequence representation)*/
        Node root = createTree(sc); 
        
        /*Tree Height */
        System.out.println("Height : ");
        System.out.println(getHeight(root));

        /*Tree Height */
        System.out.println("Size of the Tree, number of nodes : ");
        System.out.println(getTreeSize(root));

      


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
