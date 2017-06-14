package com.tradeshift.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class DictionaryImpl implements Dictionary{
	Node root = new Node('*');
	static Logger log = Logger.getLogger(DictionaryImpl.class.getName());
	
	@Override
	public boolean isValidWord(String word) {
		log.info("Finding word: " + word);
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
	
	/**
	 * Insert word in a dictionary
	 * @param str
	 */
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
	
	public List<String> getWords(String prefix, Node n){
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
	public List<String> findWordsFrom(String prefix, Node n){
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
	
	@Override
	public Node hasWordsFrom(String prefix){
		log.info("finding words from : " + prefix);
		Node n = root;
 		for(int i=0; i< prefix.length(); i++){
			char charAt = prefix.charAt(i);
			if(!n.getChildren().containsKey(charAt)){
				return null;
			}
			n = n.getChildren().get(charAt);
		}
		return n;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("Dictionary{\n");
		for(String s: getWords("", root)){
			sb.append("\t").append(s).append(",\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
