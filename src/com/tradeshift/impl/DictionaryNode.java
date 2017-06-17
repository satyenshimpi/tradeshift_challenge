package com.tradeshift.impl;

import java.util.HashMap;

/**
 * Dictionary Node
 * @author Satyen Shimpi
 */
public class DictionaryNode{
	private char prefix;
	private HashMap<Character, DictionaryNode> children;
	private boolean isCompleteWord;

	public char getPrefix() {
		return prefix;
	}
	public void setPrefix(char prefix) {
		this.prefix = prefix;
	}
	public HashMap<Character, DictionaryNode> getChildren() {
		return children;
	}
	public void setChildren(HashMap<Character, DictionaryNode> children) {
		this.children = children;
	}
	public boolean isCompleteWord() {
		return isCompleteWord;
	}
	public void setCompleteWord(boolean isCompleteWord) {
		this.isCompleteWord = isCompleteWord;
	}
	public DictionaryNode(char c){
		prefix = c;
		children = new HashMap<Character, DictionaryNode>();
		isCompleteWord = false;
	}
	
}