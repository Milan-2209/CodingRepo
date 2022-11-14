package com.ford.practice.graphs;

import java.util.*;

import static com.ford.practice.graphs.DFS.convertEdgeListToAdjacencyList;

public class HamiltonianPath {

    private static boolean checkHamiltonianPath(List<List<Integer>> edgeList){
        Map<Integer,List<Integer>> graph = convertEdgeListToAdjacencyList(edgeList);
        System.out.println(graph);
        Set<Integer> keys = graph.keySet();
        List<Integer> vertices = new ArrayList<>();
        vertices.add(1);
        vertices.add(2);
        vertices.add(3);
        vertices.add(4);
        vertices.add(5);
        vertices.add(6);
        vertices.add(7);
        for(int k : keys){
            List<Integer> visited = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            if(findPath(graph,k,path,visited,vertices))
                return true;
        }
        return false;
    }

    private static boolean findPath(Map<Integer, List<Integer>> graph, int k, List<Integer> path, List<Integer> visited,List<Integer> vertices) {
        if(path.size()==7)
            return true;
        visited.add(k);
        for(int n : graph.get(k)) {
            if(!visited.contains(n)){
                visited.add(n);
                path.add(n);
                if(findPath(graph,n,path,visited,vertices))
                    return true;
                visited.remove(n);
                path.remove(n);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> undirectedGraph = new ArrayList<>();
        undirectedGraph.add(new ArrayList<>(){{add(1);add(6);}});
        undirectedGraph.add(new ArrayList<>(){{add(1);add(2);}});
        undirectedGraph.add(new ArrayList<>(){{add(1);add(5);}});
        undirectedGraph.add(new ArrayList<>(){{add(1);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(2);add(6);}});
        undirectedGraph.add(new ArrayList<>(){{add(2);add(5);}});
        undirectedGraph.add(new ArrayList<>(){{add(2);add(3);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(5);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(7);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(4);add(5);}});
        undirectedGraph.add(new ArrayList<>(){{add(4);add(7);}});
        System.out.println(checkHamiltonianPath(undirectedGraph));
    }


}
