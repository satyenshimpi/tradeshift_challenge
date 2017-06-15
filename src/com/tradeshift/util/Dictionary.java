package com.tradeshift.util;

import java.util.HashMap;

/**
 * @author Satyen Shimpi
 */
public interface Dictionary {
	/**
	 * Check if the given word is valid dictionary word or not
	 * @param word
	 * @return
	 */
	boolean isValidWord(String word);
	
	/**
	 * Check if there are words starting from given prefix
	 * if not found then we don't need to continue checking till end
	 * for example: Suppose there are no words starting from X in our dictionary. 
	 * So if the prefix is X then we will return false. 
	 * This way it will help us not to check for rest of the chars in matrix.
	 * @param prefix 
	 * @return true if word starting from prefix
	 */
	boolean hasWordsFrom(String prefix);
	
	/**
	 * Dictionary Node
	 * @author Satyen Shimpi
	 */
	class Node{
		private char prefix;
		private HashMap<Character, Node> children;
		private boolean isCompleteWord;

		public char getPrefix() {
			return prefix;
		}
		public void setPrefix(char prefix) {
			this.prefix = prefix;
		}
		public HashMap<Character, Node> getChildren() {
			return children;
		}
		public void setChildren(HashMap<Character, Node> children) {
			this.children = children;
		}
		public boolean isCompleteWord() {
			return isCompleteWord;
		}
		public void setCompleteWord(boolean isCompleteWord) {
			this.isCompleteWord = isCompleteWord;
		}
		public Node(char c){
			prefix = c;
			children = new HashMap<Character, Node>();
			isCompleteWord = false;
		}
		
	}
}
