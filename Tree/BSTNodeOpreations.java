package Tree;

public class BSTNodeOpreations {

    /*Add a node to a given tree */
    public static Node addNode(Node root, int data) {
        if (root == null){
            return new Node(data, null, null);
        }  

        if (data > root.data) {    /*Move into rightTree, add add to the right tree */
             root.right = addNode(root.right, data);
        } else if (data < root.data) {  /*Move into leftTree, and add to the left tree */
            root.left = addNode(root.left, data);
        }
        return root;
    }

    /*Delete a node to a given tree */


    /*Driver main method */
    public static void main(String[] args) {
        int[] sortedInput = {10,20,30,40, 50, 60,70,80};
        Node root = createBST(sortedInput, 0, sortedInput.length-1);
        inOrder(root);
        root = addNode(root, 65);
        System.out.println("Node added");
        inOrder(root);

    }

    /*Supporting method - create BST */
    public static Node createBST(int[] input, int low, int high) {
        
        /*Apply Binary Search approach */
        if (low > high) {
            return null;
        }
        /*Calcualte mid and store the data at mid */
        int mid = (low+high)/2;
        int data = input[mid];
     
        Node leftTree = createBST(input, low, mid-1);    /*Create left Tree */
        Node rightTree = createBST(input, mid+1, high); /*Create right tree */

        /*Create root node with mid-data and already creatted leftTree and rightTree */
        Node root = new Node(data, leftTree, rightTree);
        return root;
    }

    /*In order traversal */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    
}

class Node {
    int data;
    Node left, right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
