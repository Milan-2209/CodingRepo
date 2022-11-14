package com.ford.practice.Tree;

public class MirrorTrees {

    public static boolean checkMirrorTrees(BinarySearchTree root1,BinarySearchTree root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.getData() != root2.getData())
            return false;
        return checkMirrorTrees(root1.getLeftNode(),root2.getRightNode())
                && checkMirrorTrees(root1.getRightNode(),root2.getLeftNode());
    }


    public static void main(String[] args) {
        BinarySearchTree root1 = new BinarySearchTree(10);
        root1 = root1.insertNode(11,root1);
        root1 = root1.insertNode(6,root1);
        root1 = root1.insertNode(4,root1);
        root1 = root1.insertNode(7,root1);
        root1 = root1.insertNode(12,root1);
//        root1.inOrder(root1);
//        System.out.println("-----------------------------------");
        BinarySearchTree root2 = new BinarySearchTree(10);
        root2 = root2.insertNodeReverse(11,root2);
        root2 = root2.insertNodeReverse(6,root2);
        root2 = root2.insertNodeReverse(4,root2);
        root2 = root2.insertNodeReverse(7,root2);
        root2 = root2.insertNodeReverse(12,root2);

//        root2.inOrder(root2);

        if(checkMirrorTrees(root1,root2))
            System.out.println("Trees are mirror identical");
        else
            System.out.println("Trees are not identical");
    }
}
