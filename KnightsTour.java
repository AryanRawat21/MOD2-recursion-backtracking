import java.io.*;
import java.util.*;

public class KnightsTour{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] chess = new int[n][n];
        printKnightsTour(chess, r,c,1);
       
    }

    public static void printKnightsTour(int[][] chess,int r,int c,int move){
        if(r < 0 || c < 0 || r>=chess.length || c>=chess.length || chess[r][c]> 0){ //not a filled 1 position
            return;
    }   else if(move == chess.length * chess.length){
        chess[r][c] = move; //use the move
        displayBoard(chess);
        chess[r][c] = 0;
        return;
    }

   chess[r][c] = move;
   printKnightsTour(chess, r - 2, c + 1, move + 1);
   printKnightsTour(chess, r - 1, c + 2, move + 1);
   printKnightsTour(chess, r + 1, c + 2, move + 1);
   printKnightsTour(chess, r + 2, c + 1, move + 1);
   printKnightsTour(chess, r + 2, c - 1, move + 1);
   printKnightsTour(chess, r + 1, c - 2, move + 1);
   printKnightsTour(chess, r - 1, c - 2, move + 1);
   printKnightsTour(chess, r - 2, c - 1, move + 1);
   chess[r][c] = 0;
    }
    

public static void displayBoard(int[][] chess){
    for(int i = 0; i < chess.length; i++){
        for(int j = 0; j < chess[0].length; j++){
            System.out.print(chess[i][j] + " ");
        }
        System.out.println();
    }
      
      System.out.println();

    }
}