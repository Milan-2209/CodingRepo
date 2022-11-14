package com.ford.practice.graphs;

import java.util.ArrayList;
import java.util.List;

public class IslandCount {

    public static int countNumberOfIslands(int[][] matrix,int rows,int cols){
        int count = 0;
        List<List<Integer>> visited = new ArrayList<>();
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(depthFirstTraverseIslands(matrix,i,j,visited))
                    count+=1;
            }
        }
        //System.out.println(visited);
        return count;

    }

    private static boolean depthFirstTraverseIslands(int[][] matrix, int i, int j,List<List<Integer>> v) {

        if(!(i>=0 && i<matrix.length) || !(j>=0 && j<matrix[i].length))
            return false;

        if((matrix[i][j]==0) || (v.contains(new ArrayList<>(){{add(i);add(j);}})))
            return false;

        v.add(new ArrayList<>(){{add(i);add(j);}});
        depthFirstTraverseIslands(matrix,i,j+1,v);
        depthFirstTraverseIslands(matrix,i,j-1,v);
        depthFirstTraverseIslands(matrix,i-1,j,v);
        depthFirstTraverseIslands(matrix,i+1,j,v);

        return true;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,0,1,1,0},
                {1,1,0,0,0,1},
                {0,1,0,0,0,1},
                {0,0,0,1,1,0},
                {0,1,0,1,1,0},
                {0,0,0,0,0,0}
        };
        System.out.println("Number of Islands: "+countNumberOfIslands(matrix,matrix.length,matrix[0].length));
    }
}
