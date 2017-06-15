package com.tradeshift;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.tradeshift.util.Constants;
import com.tradeshift.util.Dictionary;
import com.tradeshift.util.Helper;

public class WordsFinder {
	private static Logger log = Logger.getLogger(WordsFinder.class.getName());
	/**
	 * Returns list of all words found in given string matrix
	 * @param args
	 * @return
	 */
	public static List<String> findWords(String[] args, Dictionary dict) {
		Set<String> ret = new HashSet<String>();
		char[][] matrix = Helper.createMatrix(args);
		Helper.printMatrix(matrix);
		
		//from each char in matrix, check if we can derive word horizontally , vertically and diagonally
		//this will loop 'M x N' times for traverseAndSearchWords
		for(int row=0; row< matrix.length; row++){
			for(int column=0; column< matrix[row].length; column++){
				ret.addAll(traverseAndSearchWords(matrix, row, column, dict));
			}
		}
		return new LinkedList<String>(ret);
	}

	/**
	 * Check if we can find a word from given index in matrix, vertically and horizontally
	 * @param matrix The input matrix
	 * @param row row index to search for
	 * @param column column index to search for
	 * @param dict Use this dictionary
	 * @return words Found a List
	 */
	private static List<String> traverseAndSearchWords(char[][] matrix, int row, int column, Dictionary dict) {
		log.info("Searching word row:" + row + " , column:"+ column);
		List<String> ret = new LinkedList<String>();

		//for horizontal traverse max complexity is O(M)
		traverseHorizontally(matrix, row, column, dict, ret);
		//for vertical traverse max complexity is O(N)
		traverseVertically(matrix, row, column, dict, ret);
		
		traverseDiagonallyLeft(matrix, row, column, dict, ret);
		traverseDiagonallyRight(matrix, row, column, dict, ret);
		return ret;
	}

	/**
	 * Starting from given index till end, check if we can derive word
	 * @param matrix The input matrix
	 * @param row row index to search for
	 * @param column column index to search for
	 * @param dict Use this dictionary
	 * @param wordsFound add words to this list
	 */
	private static void traverseHorizontally(char[][] matrix, int row, int column, Dictionary dict, List<String> wordsFound) {
		StringBuilder prefixBuilder = new StringBuilder();
		
		for(;column < matrix[row].length; column++){
			if(!checkPrefixAndContinue(matrix, row, column, dict, wordsFound, prefixBuilder)) break;
		}
	}

	/**
	 * check if there is word staring from given prefix. Also add any word if found.
	 * @param matrix The input matrix
	 * @param row row index to search for
	 * @param column column index to search for
	 * @param dict Use this dictionary
	 * @param wordsFound add words to this list
	 * @param prefixBuilder StringBuilder with prefix String found so far
	 * @return true if we need to continue checking next char
	 */
	private static boolean checkPrefixAndContinue(char[][] matrix, int row, int column, Dictionary dict, List<String> wordsFound, StringBuilder prefixBuilder) {
		prefixBuilder.append(matrix[row][column]);
		//check if there are any words starting the prefix
		String prefix = prefixBuilder.toString();
		
		//Check if there are words starting from given prefix
		//if not found then we don't need to continue checking till end
		//example: there are no words starting from X in our dictionary. 
		//So if the first char is X then we don't need to check for rest of the chars 
		if( dict.hasWordsFrom(prefix.toLowerCase()) ){
			if(prefix.length() < Constants.MIN_WORD_LENGTH) return true;				//Exclude single character words. slightly Optimizes time complexity .
			
			//check if the word found is complete word or not.
			if(dict.isValidWord(prefix.toLowerCase())){
				wordsFound.add(prefix);
			}
			return true;
		}else{
			log.info("No words starting from: " + prefix);
			return false;
		}
	}

	private static void traverseVertically(char[][] matrix, int row, int column, Dictionary dict, List<String> wordsFound) {
		StringBuilder prefixBuilder = new StringBuilder();
		
		for(;row < matrix.length; row++){
			if(!checkPrefixAndContinue(matrix, row, column, dict, wordsFound, prefixBuilder)) break;
		}
	}
	
	private static void traverseDiagonallyRight(char[][] matrix, int row, int column, Dictionary dict, List<String> wordsFound) {	
		StringBuilder prefixBuilder = new StringBuilder();
		
		for(;row < matrix.length && column < matrix[row].length; row++, column++){
			if(!checkPrefixAndContinue(matrix, row, column, dict, wordsFound, prefixBuilder)) break;
		}
	}

	private static void traverseDiagonallyLeft(char[][] matrix, int row, int column, Dictionary dict, List<String> wordsFound) {
		StringBuilder prefixBuilder = new StringBuilder();
		
		for(;row < matrix.length && column > 0; row++, column--){
			if(!checkPrefixAndContinue(matrix, row, column, dict, wordsFound, prefixBuilder)) break;
		}
	}
}
