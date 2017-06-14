package com.tradeshift;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.tradeshift.util.Dictionary;
import com.tradeshift.util.Helper;

public class WordsFinder {
	static Logger log = Logger.getLogger(WordsFinder.class.getName());
	/**
	 * Returns list of all words found in given string matrix
	 * @param args
	 * @return
	 */
	public static List<String> findWords(String[] args, Dictionary dict) {
		Set<String> ret = new HashSet<String>();
		char[][] matrix = Helper.makeMatrix(args);
		Helper.printMatrix(matrix);
		
		//starting from each char, check if we can derive word or not 
		for(int row=0; row< matrix.length; row++){
			for(int column=0; column< matrix[row].length; column++){
				ret.addAll(searchWords(matrix, row, column, dict));
			}
		}
		return new LinkedList<String>(ret);
	}

	/**
	 * Check if we can find a word from given index in matrix, vertically and horizontally
	 * @param matrix
	 * @param row
	 * @param column
	 * @param dict
	 * @return
	 */
	private static List<String> searchWords(char[][] matrix, int row, int column, Dictionary dict) {
		log.info("Searching word row:" + row + " , column:"+ column);
		List<String> ret = new LinkedList<String>();
		traverseHorizontally(matrix, row, column, dict, ret);
		
		traverseVertically(matrix, row, column, dict, ret);
		
		return ret;
	}

	/**
	 * Starting from given index till end, check if we can derive word
	 * @param matrix
	 * @param row
	 * @param column
	 * @param dict
	 * @param ret
	 */
	private static void traverseHorizontally(char[][] matrix, int row, int column, Dictionary dict, List<String> ret) {
		StringBuilder sb = new StringBuilder();
		for(;column < matrix[row].length; column++){
			sb.append(matrix[row][column]);
			//check if there are any words starting the prefix
			String prefix = sb.toString();
			Dictionary.Node n = dict.hasWordsFrom(prefix.toLowerCase());
			
			//if words found
			if( n != null){
				//check if the word found is complete word or not.
				if(n.isCompleteWord()){
					ret.add(prefix);
				}
			}else{
				log.info("No words starting from: " + prefix);
				return;
			}
		}
	}

	private static void traverseVertically(char[][] matrix, int row, int column, Dictionary dict, List<String> ret) {
		StringBuilder sb = new StringBuilder();
		for(;row < matrix.length; row++){
			sb.append(matrix[row][column]);
			String prefix = sb.toString();
			Dictionary.Node n = dict.hasWordsFrom(prefix.toLowerCase());
			
			if( n != null){
				if(n.isCompleteWord()){
					ret.add(prefix);
				}
			}else{
				log.info("No words starting from: " + prefix);
				return;
			}
		}
	}
}
