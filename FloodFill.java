import java.io.*;
import java.util.*;

public class FloodFill{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
            arr[i][j] = scn.nextInt();
        }
    }
    boolean[][] visited = new boolean[n][m];  //for implementing visiting
    floodfill(arr,0,0,"",visited);
}

public static void floodfill(int[][] maze, int row,int col, String psf, boolean[][] visited){  //psf-path so far
    if(row<0 || col<0 || row == maze.length || col==maze[0].length || 
    maze[row][col] == 1 || visited[row][col]==true){  //1 is obstruction,visited = true
        return;
    }

    if(row == maze.length - 1 && col == maze[0].length - 1){
        System.out.println(psf);
        return;
    }

    visited[row][col] = true;  //tick check by default so dir doesnt come back
    floodfill(maze, row - 1, col, psf + 't',visited); //top
    floodfill(maze, row, col - 1, psf + 'l',visited); //left
    floodfill(maze, row + 1, col, psf + 'd',visited); //down
    floodfill(maze, row, col + 1, psf + 'r',visited); //right
    visited[row][col] = false;  // for clearing tick check in order to find more ways
}
}