package com.ford.practice.graphs;

import java.util.*;

public class DFS {

    public static void depthFirstTraversal(Map<Integer, List<Integer>> graph, int startNode){
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        while(!(stack.empty())){
            int item = stack.pop();
            System.out.println(item);
            List<Integer> neighbours = graph.get(item);
            for(int a: neighbours){
                stack.push(a);
            }
        }

    }

    public static void depthFirstTraversalForUndirectedGraphs(List<List<Integer>> edgeList, int startNode){
        Map<Integer,List<Integer>> graph = convertEdgeListToAdjacencyList(edgeList);
        System.out.println(graph);
        Stack<Integer> stack = new Stack<>();
        List<Integer> visited = new LinkedList<>();
        stack.push(startNode);
        visited.add(startNode);
        while(!(stack.empty())){
            int item = stack.pop();
            System.out.println(item);
            List<Integer> neighbours = graph.get(item);
            for(int a: neighbours){
                if(!(visited.contains(a))){
                    visited.add(a);
                    stack.push(a);
                }
            }
        }

    }

    public static void depthFirstTraversalUsingRecursion(Map<Integer, List<Integer>> graph, int current){
        List<Integer> neighbours = graph.get(current);
        System.out.println(current);
        for(int a: neighbours){
            depthFirstTraversal(graph,a);
        }

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
        directedGraph.put(1,new ArrayList<>(){{add(3);add(2);}});
        directedGraph.put(2,new ArrayList<>(){{add(4);}});
        directedGraph.put(3,new ArrayList<>(){{add(5);}});
        directedGraph.put(4,new ArrayList<>(){{add(6);}});
        directedGraph.put(5,new ArrayList<>());
        directedGraph.put(6,new ArrayList<>());
//        System.out.println(directedGraph);

        List<List<Integer>> undirectedGraph = new ArrayList<>();
        undirectedGraph.add(new ArrayList<>(){{add(1);add(2);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(1);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(3);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(6);add(7);}});
        System.out.println(undirectedGraph);
        depthFirstTraversalForUndirectedGraphs(undirectedGraph,1);

        //depthFirstTraversal(graph,1);
//        depthFirstTraversalUsingRecursion(directedGraph,1);
    }
}
