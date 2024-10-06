package Tree;

import java.util.Scanner;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        /// we will create this tree, for null we will use -1
        //  3,5,1,6,2,0,8,null,null,7,4
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4};

        for (int i=0; i<input.length; i++) {
            
        }
        


    }


    public Node createTree(Scanner sc) {
        System.out.println("Enter node : ");
        int rootData = sc.nextInt();

        if (rootData == -1) {
            return null;
        }

        Node node = new Node(rootData);
        
        System.out.println("Enter left : ");
        node.left = createTree(sc);
    
        System.out.println("Enter right : ");
        node.right = createTree(sc);
    
        return node;
    }
    
}


class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}