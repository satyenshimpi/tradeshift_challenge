package com.tradeshift.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tradeshift.Dictionary;
import com.tradeshift.Matrix;
import com.tradeshift.WordsFinder;
import com.tradeshift.util.Constants;

/**
 * This implementation searches for words in basic horizontally right, vertically down and diagonally down ways
 * 
 * @author Satyen S Shimpi
 */
public class WordsFinderBasic implements WordsFinder {
	private static Logger log = LogManager.getLogger(WordsFinderBasic.class.getName());
	
	private Dictionary dict;
	private List<String> wordsFound;
	private Matrix matrix;
	
	public WordsFinderBasic(Dictionary dict, Matrix matrix) {
		this.dict = dict;
		this.matrix = matrix;
		this.wordsFound = new LinkedList<String>();
	}

	/**
	 * Returns list of all words found in given string matrix
	 * @param args
	 * @return
	 */
	@Override
	public List<String> findWords() {
		Set<String> ret = new HashSet<String>();
		
		//from each char in matrix, check if we can derive word horizontally , vertically and diagonally
		//this will loop 'M x N' times for traverseAndSearchWords
		for(int row=0; row< matrix.getRowCount(); row++){
			for(int column=0; column< matrix.getColumnCount(row); column++){
				traverseAndSearchWords(row, column);
			}
		}
		ret.addAll(wordsFound);
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
	private void traverseAndSearchWords(int row, int column) {
		log.debug("Searching word row:" + row + " , column:"+ column);

		//for horizontal traverse max complexity is O(M)
		traverseHorizontally(row, column);
		//for vertical traverse max complexity is O(N)
		traverseVertically(row, column);
		
		traverseDiagonallyLeft(row, column);
		traverseDiagonallyRight(row, column);
	}

	/**
	 * Starting from given index till end, check if we can derive word
	 * @param matrix The input matrix
	 * @param row row index to search for
	 * @param column column index to search for
	 * @param dict Use this dictionary
	 * @param wordsFound add words to this list
	 */
	private void traverseHorizontally(int row, int column) {
		StringBuilder prefixBuilder = new StringBuilder();
		
		for(;column < matrix.getColumnCount(row); column++){
			if(!checkPrefixAndContinue(row, column, prefixBuilder)) break;
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
	private boolean checkPrefixAndContinue(int row, int column, StringBuilder prefixBuilder) {
		prefixBuilder.append(matrix.charAt(row, column));
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
			log.debug("No words starting from: " + prefix);
			return false;
		}
	}

	private void traverseVertically(int row, int column) {
		StringBuilder prefixBuilder = new StringBuilder();
		
		for(;row < matrix.getRowCount(); row++){
			if(!checkPrefixAndContinue(row, column, prefixBuilder)) break;
		}
	}
	
	private void traverseDiagonallyRight(int row, int column) {	
		StringBuilder prefixBuilder = new StringBuilder();
		
		for(;row < matrix.getRowCount() && column < matrix.getColumnCount(row); row++, column++){
			if(!checkPrefixAndContinue(row, column, prefixBuilder)) break;
		}
	}

	private void traverseDiagonallyLeft(int row, int column) {
		StringBuilder prefixBuilder = new StringBuilder();
		
		for(;row < matrix.getRowCount() && column > 0; row++, column--){
			if(!checkPrefixAndContinue(row, column, prefixBuilder)) break;
		}
	}
}
