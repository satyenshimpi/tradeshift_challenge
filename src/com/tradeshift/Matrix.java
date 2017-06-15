package com.tradeshift;

/**
 * Matrix representing the character matrix used to find words.
 * <p>The implementation can vary from simple 2d char array to ...
 * @author Satyen Shimpi
 */
public interface Matrix {
	/**
	 * returns character at the specified row and column index
	 * @param row Row number
	 * @param column Column number
	 * @return character at the specified row and column index
	 * @throws ArrayIndexOutOfBoundsException
	 */
	
	public char charAt(int row, int column) throws ArrayIndexOutOfBoundsException;
	/**
	 * Number of rows in the matrix
	 * @return count of rows
	 */
	
	public int getRowCount();
	/**
	 * Count of columns for specified row number
	 * @param rowNum Row Number to find Column count at
	 * @return number of columns
	 */
	public int getColumnCount(int rowNum);
}
