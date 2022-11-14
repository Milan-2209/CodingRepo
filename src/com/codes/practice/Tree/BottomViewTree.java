package com.ford.practice.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomViewTree {

    private static void bottomViewOfTree(BinarySearchTree root){
        Queue<BinarySearchTree> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(root.getData());
        Map<Integer,Integer> nodeValue = new HashMap<>();
        Map<Integer,Integer> topView = new HashMap<>();
        nodeValue.put(root.getData(), 0);
        topView.put(root.getData(), 0);
        while(!queue.isEmpty()){
            BinarySearchTree current = queue.remove();
            int count = nodeValue.get(current.getData());
            if(current.getLeftNode()!=null){
                queue.add(current.getLeftNode());
                nodeValue.put(current.getLeftNode().getData(),count-1);
                if(!topView.containsValue(nodeValue.get(current.getLeftNode().getData())))
                    topView.put(current.getLeftNode().getData(),nodeValue.get(current.getLeftNode().getData()));
                else{

                }
            }
            if(current.getRightNode()!=null){
                queue.add(current.getRightNode());
                nodeValue.put(current.getRightNode().getData(),count+1);
                if(!topView.containsValue(nodeValue.get(current.getRightNode().getData())))
                    topView.put(current.getRightNode().getData(),nodeValue.get(current.getRightNode().getData()));
            }

        }
        //System.out.println(topView);
        System.out.println(topView.keySet());
    }

    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(20);
        root = root.insertNode(10,root);
        root = root.insertNode(28,root);
        root = root.insertNode(4,root);
        root = root.insertNode(12,root);
        root = root.insertNode(24,root);
        root = root.insertNode(30,root);
        root = root.insertNode(2,root);
        root = root.insertNode(11,root);
        root = root.insertNode(13,root);
        root = root.insertNode(1,root);
        bottomViewOfTree(root);

    }
}
