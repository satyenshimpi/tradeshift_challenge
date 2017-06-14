package com.tradeshift.util;

import java.util.HashMap;

public interface Dictionary {
	/**
	 * Check if the given word is valid dictionary word or not
	 * @param word
	 * @return
	 */
	boolean isValidWord(String word);
	/**
	 * Check if there are words starting given prefix.
	 * @param prefix
	 * @return null if no word starting from prefix
	 */
	Node hasWordsFrom(String prefix);
	
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
