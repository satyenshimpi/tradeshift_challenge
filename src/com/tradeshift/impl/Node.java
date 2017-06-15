package com.tradeshift.impl;

import java.util.HashMap;

/**
 * Dictionary Node
 * @author Satyen Shimpi
 */
public class Node{
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