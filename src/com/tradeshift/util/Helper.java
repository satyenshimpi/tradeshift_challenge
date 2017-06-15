package com.tradeshift.util;

import com.tradeshift.Matrix;
import com.tradeshift.impl.MatrixImpl;

public class Helper {
	
	public static Matrix getMatrixInstance(String[] puzzle){
		return new MatrixImpl(puzzle);
	}

	/**
	 * Converts String array to char[][] Matrix
	 * @param arr String array
	 */
	public static char[][] createMatrix(String[] arr){
		char[][] matrix = new char[arr.length][arr[0].length()];
		for(int i=0; i< arr.length; i++){
			matrix[i] = arr[i].toCharArray();
		}
		return matrix;
	}
	
	/**
	 * Prints matrix. For debug purpose
	 * @param matrix
	 */
	public static void printMatrix(Matrix matrix){
		System.out.println("the char matrix");
		for(int i=0; i< matrix.getRowCount(); i++){
			for(int j=0; j< matrix.getColumnCount(i); j++){
				System.out.print(matrix.charAt(i, j) + " ");
			}
			System.out.print("\n");
		}
	}
}
