package Tree;

public class IsBST {

Node prev = null;
    public boolean isBST(Node root) {

        if (root != null) {
            if (!isBST(root.left)) {
                return false;
            }
            if (prev != null && root.right)

        }


        return true;
    }
    


    public static void main(String[] args) {

    }
}

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
    }
}