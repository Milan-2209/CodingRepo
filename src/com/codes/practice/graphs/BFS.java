package com.ford.practice.graphs;

import java.util.*;

public class BFS {

    public static void breadthFirstTraversal(Map<Integer, List<Integer>> graph, int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while(!(queue.isEmpty())){
            int item = queue.remove();
            System.out.println(item);
            List<Integer> neighbours = graph.get(item);
            for(int a: neighbours){
                queue.add(a);
            }
        }

    }

    public static void breadthFirstTraversalForUndirectedGraph(List<List<Integer>> edgeGraph, int startNode){
        Map<Integer,List<Integer>> graph = convertEdgeListToAdjacencyList(edgeGraph);
        System.out.println(graph);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visited = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);
        while(!(queue.isEmpty())){
            int item = queue.remove();
            System.out.println(item);
            List<Integer> neighbours = graph.get(item);
            for(int a: neighbours){
                if(!(visited.contains(a))){
                    visited.add(a);
                    queue.add(a);
                }

            }
        }

    }

    public static Map<Integer, List<Integer>> convertEdgeListToAdjacencyList(List<List<Integer>> edgeList){
        Map<Integer,List<Integer>> adjacencyList = new HashMap<>();
        for(List<Integer> value:edgeList){
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
        Map<Integer,List<Integer>> graph = new HashMap<>();
        graph.put(1,new ArrayList<>(){{add(3);add(2);}});
        graph.put(2,new ArrayList<>(){{add(4);}});
        graph.put(3,new ArrayList<>(){{add(5);}});
        graph.put(4,new ArrayList<>(){{add(6);}});
        graph.put(5,new ArrayList<>());
        graph.put(6,new ArrayList<>());
//        System.out.println(graph);
//        breadthFirstTraversal(graph,1);

        List<List<Integer>> undirectedGraph = new ArrayList<>();
        undirectedGraph.add(new ArrayList<>(){{add(1);add(2);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(1);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(3);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(6);add(7);}});
        System.out.println(undirectedGraph);
        breadthFirstTraversalForUndirectedGraph(undirectedGraph,1);
    }
}
