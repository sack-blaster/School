/**
 *  Program 1d
 *  This program reads a 1xN matrix A and an NxN matrix B from input and outputs the 1xN matrix product, C.
 *  CS160-1001
 *  5/26/24
 *  @author  Jacob Archer
  */

import java.util.Scanner;

public class Program1d {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int N = scnr.nextInt();
      int[] A = new int[N];
      int[][] B = new int[N][N];
      int[] C = new int[N];
      
      // Fill array A with N values from input
      for(int i = 0; i < N; ++i) {
         A[i] = scnr.nextInt();
      }
      
      // Fill matrix B with N rows of N values from input
      for(int i = 0; i < N; ++i) {
         for(int j = 0; j < N; ++j) {
            B[i][j] = scnr.nextInt();
         }
      }
      
      // Multiply matrix A by matrix B
      for(int i = 0; i < N; ++i) {
         for(int j = 0; j < N; ++j) {
            C[i] += A[j] * B[j][i];
         }
      }
      
      // Output matrix C
      for(int i = 0; i < N; ++i) {
         System.out.print(C[i] + " ");
      }
      System.out.println();
   }
}