package com.tradeshift.impl;

import com.tradeshift.Matrix;
import com.tradeshift.util.Helper;

/**
 * Simple 2D character array type implementation of Matrix Interface
 * @author Satyen Shimpi
 */
public class MatrixImpl implements Matrix{
	/**
	 * Data structure to hold Matrix
	 */
	private char[][] matrix;
	
	public MatrixImpl(String[] puzzle){
		matrix = Helper.createMatrix(puzzle);
	}
	
	@Override
	public char charAt(int row, int column) throws ArrayIndexOutOfBoundsException{
		return matrix[row][column];
	}
	
	@Override
	public int getRowCount(){
		return matrix.length;
	}
	
	@Override
	public int getColumnCount(int rowNum){
		return matrix[rowNum].length;
	}
}
