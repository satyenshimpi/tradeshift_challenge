package com.tradeshift.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.tradeshift.Dictionary;
import com.tradeshift.WordsFinder;
import com.tradeshift.util.Constants;

/**
 * This implementation helps find words in Criss Cross way.
 * a b c 
 * x a u
 * z s t
 * has word abacus, cat, tab ...
 * @author Satyen S Shimpi
 *
 * @param <E>
 */
public class WordsFinderNodeArray<E> implements WordsFinder{
	private static Logger log = Logger.getLogger(WordsFinderNodeArray.class.getName());
	
	private Dictionary dict;
	private List<String> wordsFound;
	private MatrixNodeArray<E> matrix;
	
	public WordsFinderNodeArray(Dictionary dict, MatrixNodeArray<E> matrix) {
		this.dict = dict;
		this.matrix = matrix;
		this.wordsFound = new LinkedList<String>();
	}
	
	public List<String> findWords() {
		Set<String> ret = new HashSet<String>();
		for(int row=0; row< matrix.getRowCount(); row++){
			for(int column=0; column< matrix.getColumnCount(row); column++){
				StringBuilder prefixBuilder = new StringBuilder();
				traverseAndSearchWords(row, column, prefixBuilder);
				ret.addAll(wordsFound);
			}
		}
		return new LinkedList<String>(ret);
	}
	
	private void traverseAndSearchWords(int row, int column, StringBuilder prefixBuilder) {
//		log.debug("Searching word row:" + row + " , column:"+ column);
		if(row < 0 || row >= matrix.getRowCount() || column < 0 || column >= matrix.getColumnCount(row))
			return;
		if(matrix.nodeAt(row, column).isVisited()) return;
		
		prefixBuilder.append(matrix.charAt(row, column));
		matrix.nodeAt(row, column).setVisited(true);
		
		if(checkPrefixAndContinue(row, column, prefixBuilder)){
			traverseAndSearchWords(row, column+1, prefixBuilder);   //Horizontally RHS
			traverseAndSearchWords(row, column-1, prefixBuilder);   //Horizontally LHS
			traverseAndSearchWords(row-1, column, prefixBuilder);   //Vertically Up
			traverseAndSearchWords(row+1, column, prefixBuilder);   //Vertically Down
			traverseAndSearchWords(row+1, column+1, prefixBuilder);	//Diagonally RHS Down
			traverseAndSearchWords(row-1, column+1, prefixBuilder);	//Diagonally RHS UP
			traverseAndSearchWords(row+1, column-1, prefixBuilder);	//Diagonally LHS Down
			traverseAndSearchWords(row-1, column-1, prefixBuilder);	//Diagonally LHS UP
		}
		matrix.nodeAt(row, column).setVisited(false);
		prefixBuilder.deleteCharAt(prefixBuilder.length()-1);
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
//		prefixBuilder.append(matrix.charAt(row, column));
		//check if there are any words starting the prefix
		String prefix = prefixBuilder.toString();
//		log.debug("Finding words starting from: " + prefix);
		
		//Check if there are words starting from given prefix
		//if not found then we don't need to continue checking till end
		//example: there are no words starting from X in our dictionary. 
		//So if the first char is X then we don't need to check for rest of the chars 
		if( dict.hasWordsFrom(prefix.toLowerCase()) ){
			if(prefix.length() < Constants.MIN_WORD_LENGTH) return true;				//Exclude single character words. slightly Optimizes time complexity 
			if(prefix.length() > matrix.getRowCount()*matrix.getColumnCount(row)) return false;				//we cant go over m x n, size of matrix
			
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
}
