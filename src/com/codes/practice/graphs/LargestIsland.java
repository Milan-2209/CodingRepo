package com.ford.practice.graphs;

import java.util.ArrayList;
import java.util.List;

public class LargestIsland {

    private static int largestIsland(char[][] arr){
        int max = 0;
        List<List<Integer>> visited = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                int sizeOfIsland = traverseIsland(arr,i,j,visited);
                if(sizeOfIsland>max)
                    max = sizeOfIsland;
            }
        }
        return max;
    }

    private static int traverseIsland(char[][] arr, int i, int j,List<List<Integer>> v) {
        if(!(i>=0 && i<arr.length) || !(j>=0 && j<arr[i].length))
            return 0;
        if(arr[i][j]=='W' || v.contains(new ArrayList<>(){{add(i);add(j);}}))
            return 0;
        v.add(new ArrayList<>(){{add(i);add(j);}});
        int size=1;
        size+=traverseIsland(arr,i,j-1,v);
        size+=traverseIsland(arr,i,j+1,v);
        size+=traverseIsland(arr,i-1,j,v);
        size+=traverseIsland(arr,i+1,j,v);

        return size;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'W','L','W','L','L','W'},
                {'L','L','W','W','W','L'},
                {'W','L','W','W','W','L'},
                {'W','W','W','L','L','W'},
                {'W','L','W','L','L','W'},
                {'W','W','W','W','W','W'}
        };

        System.out.println("Size of Largest Island: "+largestIsland(matrix));
    }
}
