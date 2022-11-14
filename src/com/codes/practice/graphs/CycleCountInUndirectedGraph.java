package com.ford.practice.graphs;

import java.util.*;

import static com.ford.practice.graphs.DFS.convertEdgeListToAdjacencyList;

public class CycleCountInUndirectedGraph {

    public static int cycleCountInUndirectedGraph(List<List<Integer>> edgeList){
        Map<Integer,List<Integer>> graph = convertEdgeListToAdjacencyList(edgeList);
        System.out.println(graph);
        Set<Integer> keys = graph.keySet();
        int[] parent = new int[keys.size()];
        List<Integer> visited = new ArrayList<>();
        int count = 0;
        for(int a : keys){
            if(!visited.contains(a)){
                if(countCyclesSecondWay(graph,a,parent,visited))
                    count+=1;
            }
        }
//        System.out.println(visited);
//        System.out.println(parent);
        return count;
    }

    private static boolean countCycles(Map<Integer, List<Integer>> graph, int a, int parent,List<Integer> v) {
        v.add(a);
        List<Integer> neighbours = graph.get(a);
        for(int n : neighbours){
            if(!v.contains(n)) {
                if (countCycles(graph, n, a, v))
                    return true;
            }
            else if(n!=parent)
                return true;
        }
        return false;
    }

    private static boolean countCyclesSecondWay(Map<Integer, List<Integer>> graph, int a, int[] parent,List<Integer> v) {
        if(v.contains(a))
            return false;
        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        v.add(a);
        while(!stack.empty()){
            int current = stack.pop();
            List<Integer> neighbours = graph.get(current);
            for(int n : neighbours){
                if(!v.contains(n)) {
                    v.add(n);
                    stack.push(n);
                    parent[n-1] = current;
                }
                else if(n!=parent[current-1])
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<List<Integer>> undirectedGraph = new ArrayList<>();
        undirectedGraph.add(new ArrayList<>(){{add(1);add(3);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(2);add(5);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(6);}});
        undirectedGraph.add(new ArrayList<>(){{add(6);add(7);}});
        undirectedGraph.add(new ArrayList<>(){{add(7);add(8);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(8);}});
        System.out.println(cycleCountInUndirectedGraph(undirectedGraph));

    }
}
