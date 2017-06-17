package com.tradeshift.util;

import com.tradeshift.Matrix;
import com.tradeshift.WordsFinder;
import com.tradeshift.WordsFinder.Type;
import com.tradeshift.impl.MatrixImpl;
import com.tradeshift.impl.MatrixNodeArray;

public class Helper {
	
	public static Matrix getMatrixInstance(String[] puzzle, WordsFinder.Type type){
		if(type.equals(Type.CRISS_CROSS)){
			return new MatrixNodeArray<Character>(Helper.createMatrix(puzzle));
		}
		return new MatrixImpl(puzzle);
	}

	/**
	 * Converts String array to char[][] Matrix
	 * @param arr String array
	 */
	public static Character[][] createMatrix(String[] arr){
		Character[][] matrix = new Character[arr.length][arr[0].length()];
		for(int i=0; i< arr.length; i++){
			for (int j = 0; j < arr[i].length(); j++) {
				matrix[i][j] =  (Character) arr[i].charAt(j);
			}
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
