package com.ford.practice.graphs;

import java.util.*;

import static com.ford.practice.graphs.DFS.convertEdgeListToAdjacencyList;

public class ShortestPath {

    public static int shortestPath(List<List<Integer>> edgeList, int source,int dest){
        Map<Integer,List<Integer>> graph = convertEdgeListToAdjacencyList(edgeList);
        System.out.println(graph);
        int min = 1000000;
        int path = findingShortestPath(graph,source,dest);
        if(path < min)
            min = path;
        return min;
    }

    private static int findingShortestPath(Map<Integer, List<Integer>> graph, int source, int dest) {
        int dist = 0;
        if(source==dest)
            return dist;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> visited = new HashMap<>();
        queue.add(source);
        visited.put(source,0);
        while (!(queue.isEmpty())){
            int current = queue.remove();
            List<Integer> neighbours = graph.get(current);
            for(int a : neighbours){
                int count = visited.get(current);
                if(!(visited.containsKey(a))){
                    visited.put(a,++count);
                    queue.add(a);
                }
                if(a==dest){
                    dist = visited.get(a);
                }
            }

        }
//        System.out.println(visited);
        return dist;
    }

    public static void main(String[] args) {
        List<List<Integer>> undirectedGraph = new ArrayList<>();
        undirectedGraph.add(new ArrayList<>(){{add(2);add(3);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(1);}});
        undirectedGraph.add(new ArrayList<>(){{add(2);add(1);}});
        System.out.println(undirectedGraph);
        System.out.println("Shortest Path: "+shortestPath(undirectedGraph,2,5));
    }
}
