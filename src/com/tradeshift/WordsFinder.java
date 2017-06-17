package com.tradeshift;

import java.util.List;

/**
 * WordsFinder Interface so that we can implement it different ways 
 * @author Satyen S Shimpi
 */
public interface WordsFinder {
	public List<String> findWords();
	
	public enum Type {
		BASIC, CRISS_CROSS;
	}
}
