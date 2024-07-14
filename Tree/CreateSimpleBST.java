package Tree;

public class CreateSimpleBST {

    public static Node createBST(int[] input, int low, int high) {

        
        //Apply binary approach
        if (low > high) {
            return null;
        }

        //Calculate the mid and store the data at mid
        int mid = (low+high)/2;
        int data = input[mid];

        //Create left tree
        Node leftTree = createBST(input, low, mid-1);
    
        //Create right tree
        Node rightTree = createBST(input, mid+1, high);

        //Create root node with mid-data and already created left and right tree
        Node root = new Node(data, leftTree, rightTree);
        return root;
    }
  
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);

    }

   


    public static void main(String[] args) {
       int[] sortedInput = {12,25,27,50,62,75,87};

        Node root = createBST(sortedInput, 0, sortedInput.length-1);
        inOrder(root);

    }
}

class Node {
    int data;
    Node left, right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
