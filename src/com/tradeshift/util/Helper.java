package com.tradeshift.util;

public class Helper {
	/**
	 * Converts String array to Matrix
	 * @param arr
	 */
	public static char[][] makeMatrix(String[] arr){
		char[][] matrix = new char[arr.length][arr[0].length()];
		for(int i=0; i< arr.length; i++){
			matrix[i] = arr[i].toCharArray();
		}
		return matrix;
	}
	
	public static void printMatrix(char[][] matrix){
		System.out.println("the char matrix");
		for(int i=0; i< matrix.length; i++){
			for(int j=0; j< matrix[i].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static void printMatrixSwap(char[][] matrix){
		System.out.println("the char matrix");
		for(int i=0; i< matrix[i].length; i++){
			for(int j=0; j< matrix.length; j++){
				System.out.print(matrix[j][i] + " ");
			}
			System.out.print("\n");
		}
	}
}
