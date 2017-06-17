package com.tradeshift.impl;

import com.tradeshift.Matrix;

/**
 * Matrix implementation to be used in WordsFinderNodeArray
 * @author Satyen S Shimpi
 *
 * @param <E>
 */
public class MatrixNodeArray<E> implements Matrix {
	private MatrixNode<E>[][] matrix;
	
	public MatrixNodeArray(E[][] puzzle) {
		matrix = new MatrixNode[puzzle.length][puzzle[0].length];
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				matrix[i][j] =  new MatrixNode<E>(puzzle[i][j]);
			}
		}
	}
	
	public MatrixNode<E> nodeAt(int row, int column) throws ArrayIndexOutOfBoundsException {
		return matrix[row][column];
	}

	@Override
	public char charAt(int row, int column) throws ArrayIndexOutOfBoundsException {
		return (Character) matrix[row][column].getValue();
	}

	@Override
	public int getRowCount() {
		return matrix.length;
	}

	@Override
	public int getColumnCount(int rowNum) {
		return matrix[rowNum].length;
	}

	public class MatrixNode<T>{
		private E value;
		private boolean visited;

		public MatrixNode(E value){
			this.value = value;
			visited = false;
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}
		
		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean flag) {
			this.visited = flag;
		}
	}
}
