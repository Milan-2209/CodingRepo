package com.ford.practice.graphs;
//A province is a group of directly or indirectly connected cities and no other cities of the group
import java.util.*;

public class NumberOfProvinces {

    private static int numberOfProvinces(int[][] matrix,int rows,int cols){
        Map<Integer,List<Integer>> graph = matrixToAdjacencyList(matrix,rows,cols);
        System.out.println(graph);
        Set<Integer> keys = graph.keySet();
        List<Integer> visited = new ArrayList<>();
        int count = 0;
        for(int a:keys){
            if(traverseProvinces(graph,a,visited))
                count+=1;
        }
        return count;
    }

    private static boolean traverseProvinces(Map<Integer, List<Integer>> graph, int a,List<Integer> v) {
        Stack<Integer> stack = new Stack<>();
        if(v.contains(a))
            return false;
        stack.push(a);
        v.add(a);
        while(!stack.empty()){
            int current = stack.pop();
            List<Integer> neighbours = graph.get(current);
            for(int n:neighbours){
                if(!v.contains(n)){
                    stack.push(n);
                    v.add(n);
                }
            }
        }
        return true;

    }

    public static Map<Integer,List<Integer>> matrixToAdjacencyList(int[][] matrix,int r,int c){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==1){
                    if(!graph.containsKey(i+1))
                        graph.put(i+1,new ArrayList<>());
//                    if(!graph.containsKey(j+1))
//                        graph.put(j+1,new ArrayList<>());
                    graph.get(i+1).add(j+1);
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1,0,1,0},
                {0,1,0,1},
                {1,0,1,0},
                {0,0,1,0}
        };
        System.out.println(numberOfProvinces(m,4,4));
    }
}
