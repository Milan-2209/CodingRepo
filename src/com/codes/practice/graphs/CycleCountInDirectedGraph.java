package com.ford.practice.graphs;

import java.util.*;

public class CycleCountInDirectedGraph {
    public static int countCycleInDirectedGraphs(Map<Integer,List<Integer>> graph,int startNode){
        Stack<Integer> stack = new Stack<>();
        List<Integer> visited = new ArrayList<>();
        stack.push(startNode);
        visited.add(startNode);
        int count = 0;
        while(!(stack.empty())){
            int current = stack.pop();
            List<Integer> neighbours = graph.get(current);
            for(int a : neighbours){
                if(!(visited.contains(a))){
                    visited.add(a);
                    stack.push(a);
                }
                else
                    count+=1;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        Map<Integer,List<Integer>> directedGraph = new HashMap<>();
        directedGraph.put(1,new ArrayList<>(){{add(3);add(2);add(6);}});
        directedGraph.put(2,new ArrayList<>(){{add(5);}});
        directedGraph.put(3,new ArrayList<>(){{add(4);}});
        directedGraph.put(4,new ArrayList<>(){{add(1);add(8);}});
        directedGraph.put(5,new ArrayList<>(){{add(6);add(7);add(8);}});
        directedGraph.put(6,new ArrayList<>(){{add(7);add(2);}});
        directedGraph.put(7,new ArrayList<>());
        directedGraph.put(8,new ArrayList<>(){{add(7);}});
        System.out.println(directedGraph);
        System.out.println(countCycleInDirectedGraphs(directedGraph,1));
    }
}
