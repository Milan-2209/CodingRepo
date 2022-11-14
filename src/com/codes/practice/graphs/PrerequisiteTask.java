package com.ford.practice.graphs;


import java.util.*;

public class PrerequisiteTask {

    private static int findPossibleToFinishTasks(List<List<Integer>> edgeList){
        Map<Integer, List<Integer>> graph = edgeListToAdjacencyList(edgeList);
        System.out.println(graph);
        Set<Integer> keys = graph.keySet();
        System.out.println(keys);
        List<Integer> visited = new ArrayList<>();
        int count = 0;
        for(int a : keys){
            if(tasksDependency(graph,a,visited))
                count+=1;
        }
        return count;
    }

    private static boolean tasksDependency(Map<Integer, List<Integer>> graph, int a, List<Integer> visited) {
        if(visited.contains(a))
            return false;
        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        visited.add(a);
        while(!stack.empty()){
            int current = stack.pop();
            List<Integer> neighbours = graph.get(current);
            if(neighbours == null)
                return false;
            for(int n : neighbours){
                if(!visited.contains(n)){
                    visited.add(n);
                    stack.push(n);
                }
                else
                    return true;
            }
        }
        return false;
    }

    private static Map<Integer, List<Integer>> edgeListToAdjacencyList(List<List<Integer>> edgeList){
        Map<Integer, List<Integer>> adjacencylist = new HashMap<>();
        for(List<Integer> l : edgeList){
            if(!adjacencylist.containsKey(l.get(0)))
                adjacencylist.put(l.get(0),new ArrayList<>());
            adjacencylist.get(l.get(0)).add(l.get(1));
        }

        return adjacencylist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Nodes: ");
        int n = sc.nextInt();
        System.out.println("Number of pairs: ");
        int p = sc.nextInt();
        List<List<Integer>> edgeList = new ArrayList<>();
        for(int i=0;i<p;i++){
            edgeList.add(new ArrayList<>(){{add(sc.nextInt());add(sc.nextInt());}});
        }
        if(findPossibleToFinishTasks(edgeList) > 0)
            System.out.println("Task completion not possible");
        else
            System.out.println("Task completion possible");
    }
}
