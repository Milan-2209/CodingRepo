package src.com.codes.practice.graphs;

import java.util.*;

import static src.com.codes.practice.graphs.UnionFindAlgo.find;
import static src.com.codes.practice.graphs.UnionFindAlgo.union;

public class KruskalAlgo {

    public static void main(String[] args) {
        Map<List<Integer>,Integer> graphWithEdgeWeight = new HashMap<>();
        graphWithEdgeWeight.put(new ArrayList<>(){{add(0);add(1);}},4);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(1);add(2);}},8);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(2);add(3);}},7);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(3);add(4);}},9);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(4);add(5);}},10);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(5);add(6);}},2);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(6);add(7);}},1);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(7);add(8);}},7);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(2);add(8);}},2);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(2);add(5);}},4);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(8);add(6);}},6);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(0);add(7);}},8);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(3);add(5);}},14);
        graphWithEdgeWeight.put(new ArrayList<>(){{add(1);add(7);}},11);
        System.out.println(findMinSpanningTree(graphWithEdgeWeight));
        int minEdgeValue = 0;
        for(Integer i : findMinSpanningTree(graphWithEdgeWeight).values())
            minEdgeValue+=i;
        System.out.println(minEdgeValue);
    }

    private static Map<List<Integer>,Integer> findMinSpanningTree(Map<List<Integer>, Integer> graphWithEdgeWeight) {
        List<Integer> vertices = new ArrayList<>();
        //sorting the map by values
        List<Map.Entry<List<Integer>,Integer>> graph = new ArrayList<>(graphWithEdgeWeight.entrySet());
        Collections.sort(graph,Map.Entry.comparingByValue());
        //System.out.println(graph);
        //storing the sorted entry set into a linked hashmap
        Map<List<Integer>,Integer> undirectedGraph = new LinkedHashMap<>();
        for(Map.Entry<List<Integer>,Integer> e : graph)
            undirectedGraph.put(e.getKey(),e.getValue());
        //System.out.println(undirectedGraph);
        //fetching all the edges from the graph
        Set<List<Integer>> edgeList = undirectedGraph.keySet();
        System.out.println(edgeList);
        Map<List<Integer>,Integer> minSpanningTree = new LinkedHashMap<>();
        int countEdge = 0;
        //counting the number of vertices and storing them in a list
        for(List<Integer> l:edgeList){
            if(!vertices.contains(l.get(0)))
                vertices.add(l.get(0));
            if(!vertices.contains(l.get(1)))
                vertices.add(l.get(1));
        }
        Collections.sort(vertices);
        int[] parent = new int[vertices.size()+1];
        for(int v:vertices){
            parent[v] = v;
        }
        for(List<Integer> l:edgeList){
            int x = find(parent,l.get(0));
            int y = find(parent,l.get(1));
            if(countEdge > vertices.size()-1)
                break;
            if(x!=y) {
                minSpanningTree.put(l, undirectedGraph.get(l));
                countEdge+=1;
                union(parent, x, y);
            }
        }
        return minSpanningTree;
    }
}
