package com.ford.practice.graphs;

import java.util.*;

public class HasPath {

    public static boolean hasPathForUndirectedGraphs(List<List<Integer>> edgeGraph , int source, int destination){
        Map<Integer,List<Integer>> vertexGraph = convertEdgeListToAdjacencyList(edgeGraph);
        Stack<Integer> stack = new Stack<>();
        List<Integer> visited = new LinkedList<>();
        stack.push(source);
        visited.add(source);
        if(source==destination)
            return true;
        while(!(stack.empty())){
            int current = stack.pop();
            List<Integer> neighbours = vertexGraph.get(current);
            for(int a : neighbours){
                if(!(visited.contains(a))){
                    visited.add(a);
                    stack.push(a);
                }
                if(a==destination)
                    return true;
            }
        }
        return false;
    }

    public static boolean hasPathForDirectedGraphs(Map<Integer, List<Integer>> graph, int source,int destination){
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        if(source==destination)
            return true;
        while(!(stack.empty())){
            int current = stack.pop();
            List<Integer> neighbours = graph.get(current);
            for(int a: neighbours){
                stack.push(a);
                if(a==destination){
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<Integer, List<Integer>> convertEdgeListToAdjacencyList(List<List<Integer>> edgeGraph){
        Map<Integer,List<Integer>> adjacencyList = new HashMap<>();
        for(List<Integer> value:edgeGraph){
            if(!(adjacencyList.containsKey(value.get(0))))
                adjacencyList.put(value.get(0),new ArrayList<>());
            if(!(adjacencyList.containsKey(value.get(1))))
                adjacencyList.put(value.get(1),new ArrayList<>());
            adjacencyList.get(value.get(0)).add(value.get(1));
            adjacencyList.get(value.get(1)).add(value.get(0));

        }
        return adjacencyList;
    }


    public static void main(String[] args) {

        Map<Integer,List<Integer>> directedGraph = new HashMap<>();
        directedGraph.put(1,new ArrayList<>(){{add(2);add(4);}});
        directedGraph.put(2,new ArrayList<>(){{add(3);}});
        directedGraph.put(3,new ArrayList<>());
        directedGraph.put(4,new ArrayList<>(){{add(2);add(6);}});
        directedGraph.put(5,new ArrayList<>(){{add(4);}});
        directedGraph.put(6,new ArrayList<>());
//        System.out.println(directedGraph);
//        if(hasPathForDirectedGraphs(directedGraph,1,6))
//            System.out.println("Path exists");
//        else
//            System.out.println("Path does not exist");


        List<List<Integer>> undirectedGraph = new ArrayList<>();
        undirectedGraph.add(new ArrayList<>(){{add(1);add(2);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(1);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(3);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(6);add(7);}});
        System.out.println(undirectedGraph);
        System.out.println(hasPathForUndirectedGraphs(undirectedGraph,1,3));
    }
}
