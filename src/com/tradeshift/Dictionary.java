package com.tradeshift;

/**
 * @author Satyen Shimpi
 */
public interface Dictionary {
	/**
	 * Check if the given word is valid dictionary word or not
	 * @param word
	 * @return true if the word is valid dictionary word
	 */
	public boolean isValidWord(String word);
	
	/**
	 * Check if there are words starting from given prefix
	 * if not found then we don't need to continue checking till end
	 * for example: Suppose there are no words starting from X in our dictionary. 
	 * So if the prefix is X then we will return false. 
	 * This way it will help us not to check for rest of the chars in matrix.
	 * @param prefix 
	 * @return true if word starting from prefix
	 */
	public boolean hasWordsFrom(String prefix);
	
	/**
	 * Add a word to dictionary
	 * @param str
	 */
	public void addWord(String str);
}
