package com.ford.practice.Tree;

public class IdenticalTrees {

    public static boolean checkIdenticalTrees(BinarySearchTree root1,BinarySearchTree root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.getData() != root2.getData())
            return false;
        return checkIdenticalTrees(root1.getLeftNode(),root2.getLeftNode())
                && checkIdenticalTrees(root1.getRightNode(),root2.getRightNode());
    }

    public static void main(String[] args) {
        BinarySearchTree root1 = new BinarySearchTree(10);
        root1 = root1.insertNode(11,root1);
        root1 = root1.insertNode(6,root1);
        root1 = root1.insertNode(4,root1);
        root1 = root1.insertNode(7,root1);
        root1 = root1.insertNode(12,root1);

        BinarySearchTree root2 = new BinarySearchTree(10);
        root2 = root2.insertNode(11,root2);
        root2 = root2.insertNode(6,root2);
        root2 = root2.insertNode(5,root2);
        root2 = root2.insertNode(7,root2);
        root2 = root2.insertNode(12,root2);

        if(checkIdenticalTrees(root1,root2))
            System.out.println("Trees are identical");
        else
            System.out.println("Trees are not identical");
    }
}
