package com.ford.practice.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private int data;
    private BinarySearchTree leftNode;
    private BinarySearchTree rightNode;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinarySearchTree leftNode) {
        this.leftNode = leftNode;
    }

    public BinarySearchTree getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinarySearchTree rightNode) {
        this.rightNode = rightNode;
    }

    BinarySearchTree(int data){
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public BinarySearchTree insertNode(int value, BinarySearchTree root){
        if(root==null){
            return new BinarySearchTree(value);
        }
        else{
            if(value<root.getData())
                root.leftNode = insertNode(value,root.leftNode);
            else
                root.rightNode = insertNode(value,root.rightNode);
        }
        return root;
    }

    public static BinarySearchTree insertNodeReverse(int data,BinarySearchTree root){
        if(root == null)
            return new BinarySearchTree(data);
        else{
            if(data < root.getData())
                root.setRightNode(insertNodeReverse(data,root.getRightNode()));
            else
                root.setLeftNode(insertNodeReverse(data,root.getLeftNode()));
        }
        return root;
    }

    public void inOrder(BinarySearchTree root){
        if(root == null)
            return;
        inOrder(root.leftNode);
        System.out.println(root.getData());
        inOrder(root.rightNode);
    }

    public void preOrder(BinarySearchTree root){
        if(root==null)
            return;
        System.out.println(root.getData());
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    public void postOrder(BinarySearchTree root){
        if(root==null)
            return;
        preOrder(root.leftNode);
        preOrder(root.rightNode);
        System.out.println(root.getData());

    }

    public void levelOrderTraversal(BinarySearchTree root){
        Queue<BinarySearchTree> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            BinarySearchTree current = stack.remove();
            System.out.println(current.getData());
            if(current.getLeftNode()!=null)
                stack.add(current.getLeftNode());
            if(current.getRightNode()!=null)
                stack.add(current.getRightNode());
        }
    }


    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(10);
        root = root.insertNode(11,root);
        root = root.insertNode(6,root);
        root = root.insertNode(4,root);
        root = root.insertNode(7,root);
        root = root.insertNode(12,root);
        System.out.println("----------Inorder---------");
        root.inOrder(root);
        System.out.println("-----------PreOrder--------");
        root.preOrder(root);
        System.out.println("-----------PostOrder-------");
        root.postOrder(root);
        System.out.println("-----------Level Order Traversal------------");
        root.levelOrderTraversal(root);
    }

}


