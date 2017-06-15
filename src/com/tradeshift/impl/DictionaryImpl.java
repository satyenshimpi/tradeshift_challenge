package com.tradeshift.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tradeshift.Dictionary;

/**
 * This is Trie implementation of Dictionary interface.
 * We will store all words a lower case letters in this Dictionary
 * @author Satyen Shimpi
 */
public class DictionaryImpl implements Dictionary{
	Node root = new Node('*');
	static Logger log = Logger.getLogger(DictionaryImpl.class.getName());
	
	@Override
	public boolean isValidWord(String word) {
		log.debug("Finding word: " + word);
		Node n = root;
 		for(int i=0; i< word.length(); i++){
			char charAt = word.charAt(i);
			if(!n.getChildren().containsKey(charAt)){
				return false;
			}
			n = n.getChildren().get(charAt);
		}
 		//if the node has flag isCompleteWord, else its not a word
 		return n.isCompleteWord();
	}
	
	@Override
	public boolean hasWordsFrom(String prefix){
		log.debug("finding words from : " + prefix);
		Node n = root;
 		for(int i=0; i< prefix.length(); i++){
			char charAt = prefix.charAt(i);
			if(!n.getChildren().containsKey(charAt)){
				return false;
			}
			n = n.getChildren().get(charAt);
		}
		return true;
	}
	
	@Override
	public void addWord(String str){
		Node n = root;
		str = str.toLowerCase();		// make all lowercase
		for(int i=0; i< str.length(); i++){
			char charAt = str.charAt(i);
			if(!n.getChildren().containsKey(charAt)){
				n.getChildren().put(str.charAt(i), new Node(str.charAt(i)));
			}
			n = n.getChildren().get(charAt);
		}
		n.setCompleteWord(true);
	}
		
	@Override
	/**
	 * Overridden for debug purpose
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder("Dictionary{\n");
		for(String s: getWords("", root)){
			sb.append("\t").append(s).append(",\n");
		}
		sb.append("}");
		return sb.toString();
	}
	
	private List<String> getWords(String prefix, Node n){
 		for(int i=0; i< prefix.length(); i++){
			char charAt = prefix.charAt(i);
			if(!n.getChildren().containsKey(charAt)){
				return Collections.emptyList();
			}
			n = n.getChildren().get(charAt);
		}
		return findWordsFrom(prefix, n);
	}
	
	/**
	 * Finds word starting with given prefix
	 * @param prefix
	 * @param n
	 * @return
	 */
	private List<String> findWordsFrom(String prefix, Node n){
		List<String> ret = new LinkedList<String>();
		if(n.isCompleteWord()){
			ret.add(prefix);
		}		
		for(Node x : n.getChildren().values()){
			String str = prefix + x.getPrefix();
			List<String> tmp = findWordsFrom(str, x);
			ret.addAll(tmp);
		}
		return ret;
	}
}
