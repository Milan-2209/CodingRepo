package com.ford.practice.graphs;

import java.util.*;

public class LargestConnectedComponents {

    public static int sizeOfLargestComponent(Map<Integer, List<Integer>> graph){
        Set<Integer> keys = graph.keySet();
        List<Integer> visited = new ArrayList<>();
        int max = 0;
        for(int a : keys){
            int s = 1;
            int size = traverseComponents(graph,a,visited,s);
            if(size > max)
                max = size;
        }
        return max;
    }

    private static int traverseComponents(Map<Integer, List<Integer>> graph, int a,List<Integer> visited, int size) {
        if(visited.contains(a))
            return 0;

        visited.add(a);

        List<Integer> neighbours = graph.get(a);
        for(int val : neighbours){
            size+=1;
            traverseComponents(graph,val,visited,size);
        }
        return size;
    }

    public static void main(String[] args) {
        Map<Integer,List<Integer>> undirectedGraph = new HashMap<>();
        undirectedGraph.put(0,new ArrayList<>(){{add(8);add(1);add(5);}});
        undirectedGraph.put(1,new ArrayList<>(){{add(0);}});
        undirectedGraph.put(5,new ArrayList<>(){{add(0);add(8);}});
        undirectedGraph.put(8,new ArrayList<>(){{add(0);add(5);}});
        undirectedGraph.put(2,new ArrayList<>(){{add(3);add(4);}});
        undirectedGraph.put(3,new ArrayList<>(){{add(2);add(4);}});
        undirectedGraph.put(4,new ArrayList<>(){{add(3);add(2);}});
        System.out.println(undirectedGraph);
        System.out.println(sizeOfLargestComponent(undirectedGraph));
    }
}
