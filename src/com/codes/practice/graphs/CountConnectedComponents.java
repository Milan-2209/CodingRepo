package com.ford.practice.graphs;

import java.util.*;

public class CountConnectedComponents {

    public static int countConnectedComponents(Map<Integer, List<Integer>> graph){
        Set<Integer> keys = new TreeSet<>();
        keys.addAll(graph.keySet());
        //System.out.println(keys);
        int count = 0;
        List<Integer> visited = new ArrayList<>();
        for(int a: keys){
            if(traverseComponentsUsingRecursion(graph,a,visited)){
                count+=1;
            }
        }
        return count;
    }

    private static boolean traverseComponents(Map<Integer, List<Integer>> graph, int node,List<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        if(visited.contains(node))
            return false;
        stack.push(node);
        visited.add(node);
        while(!(stack.empty())){
            int current = stack.pop();
            List<Integer> neighbours = graph.get(current);
            for(int a : neighbours){
                if(!(visited.contains(a))){
                    visited.add(a);
                    stack.push(a);
                }
            }
        }
        return true;
    }

    public static boolean traverseComponentsUsingRecursion(Map<Integer, List<Integer>> graph, int node,List<Integer> visited){
        if(visited.contains(node))
            return false;
        visited.add(node);
        List<Integer> neighbours = graph.get(node);
        for(int a : neighbours){
            traverseComponentsUsingRecursion(graph,a,visited);
        }
        return true;
    }

    public static void main(String[] args) {
        Map<Integer,List<Integer>> undirectedGraph = new HashMap<>();
        undirectedGraph.put(3,new ArrayList<>());
        undirectedGraph.put(4,new ArrayList<>(){{add(6);}});
        undirectedGraph.put(6,new ArrayList<>(){{add(4);add(5);add(7);add(8);}});
        undirectedGraph.put(8,new ArrayList<>(){{add(6);}});
        undirectedGraph.put(7,new ArrayList<>(){{add(6);}});
        undirectedGraph.put(5,new ArrayList<>(){{add(6);}});
        undirectedGraph.put(1,new ArrayList<>(){{add(2);}});
        undirectedGraph.put(2,new ArrayList<>(){{add(1);}});
        System.out.println(undirectedGraph);
        System.out.println(countConnectedComponents(undirectedGraph));
    }
}
