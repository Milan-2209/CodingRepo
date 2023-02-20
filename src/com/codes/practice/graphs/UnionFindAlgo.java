package src.com.codes.practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnionFindAlgo {

    public static void main(String[] args) {
        List<List<Integer>> undirectedGraph = new ArrayList<>();
        undirectedGraph.add(new ArrayList<>(){{add(1);add(3);}});
        undirectedGraph.add(new ArrayList<>(){{add(3);add(4);}});
        undirectedGraph.add(new ArrayList<>(){{add(2);add(5);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(6);}});
        undirectedGraph.add(new ArrayList<>(){{add(6);add(7);}});
        undirectedGraph.add(new ArrayList<>(){{add(7);add(8);}});
        undirectedGraph.add(new ArrayList<>(){{add(5);add(8);}});
        System.out.println(countCycleInUndirectedGraph(undirectedGraph));//expected = 1
    }

    private static int countCycleInUndirectedGraph(List<List<Integer>> undirectedGraph) {
        List<Integer> vertices = new ArrayList<>();
        int count = 0;
        for(List<Integer> l:undirectedGraph){
            if(!vertices.contains(l.get(0)))
                vertices.add(l.get(0));
            if(!vertices.contains(l.get(1)))
                vertices.add(l.get(1));
        }
        Collections.sort(vertices);
        //System.out.println(vertices);
        int[] parent = new int[vertices.size()+1];
        // Initialize all subsets as single element sets
        for(int v:vertices){
            parent[v] = v;
        }
//        System.out.println(Arrays.toString(parent));
        // Iterate through all edges of graph, find subset
        // of both vertices of every edge, if both subsets
        // are same, then there is cycle in graph.
        for(List<Integer> l:undirectedGraph){
            int x = find(parent,l.get(0));
            int y = find(parent,l.get(1));
            if(x==y)
                count+=1;
            union(parent,x,y);
        }
        return count;
    }

    // A utility function to do union of two subsets
    public static void union(int[] parent, int x, int y) {
        parent[x] = y;
    }

    // A utility function to find the subset of an element v
    public static int find(int[] parent, int v) {
        if(parent[v] == v)
            return v;
        else
            return find(parent,parent[v]);
    }


}
