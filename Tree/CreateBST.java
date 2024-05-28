package Tree;

public class CreateBST {

    public static Node createBST(int[] input, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low+high)/2;
        
        int data = input[mid];
        Node leftTree = createBST(input, low, mid-1);
        Node rightTree = createBST(input, mid+1, high);


        Node node = new Node(data, leftTree, rightTree);
        return node;
    }

    public static Node addNode(Node root, int data) {

        if (root == null) {
            return new Node(data, null , null);
        }

        if (data > root.data) {
            root.right = addNode(root.right, data);
        } else if(data < root.data) {
            root.left = addNode(root.left, data);
        }
        return root;
        
    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);

    }

    public static void main(String[] args) {

        int[] sortedArray = {12,25,27,50,62,75,87};
        Node root = createBST(sortedArray, 0, sortedArray.length-1);
        printInOrder(root);
        System.out.println("Adding new node 55");
        Node addedTree = addNode(root, 55);
        printInOrder(addedTree);
            
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