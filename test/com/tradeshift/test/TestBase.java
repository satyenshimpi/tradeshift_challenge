package com.tradeshift.test;

import org.junit.Before;

import com.tradeshift.impl.DictionaryImpl;

public class TestBase {
	DictionaryImpl dict = new DictionaryImpl();
	
	static final String[] BASE_PUZZLE = new String[] {
			 "cat","ato", "nem"
	};
	
	static final String[] BASE_PUZZLE2 = new String[] {
			 "xcat","xato", "xnem"
	};
	
	static final String[] SINGLE_PUZZLE = new String[] {
			 "xbatey"
	};
	
	static final String[] DEFAULT_PUZZLE = new String[] {
			 "akjbvaijdsbv_d_dbv",
			 "fjslkdfadsna_T_lfa",
			 "asdfasdfsdfa_r_ads",
			 "ckvsadfgfgjava_ajd",
			 "akjbvaijdsbv_d_dbv",
			 "cbvqiejdbfqi_e_qib",
			 "asdjnaquekjdwdfabd",
			 "asdk_word_kgrtuabd",
			 "asdjnaquekjfghbdbd",
			 "asewdfldfjdsfewrkf",
			 "as_Shift_ejdccgabd",
	};
	
	static final String[] BASE_PUZZLE_CRISSCROSS = new String[] {
			"abc", "xau", "zst"
	};
	
	@Before
	public void populateDictionary(){
		//few horizontal and vertical words
		dict.addWord("shift");
		dict.addWord("word");
		dict.addWord("trade");
		dict.addWord("fad");
		dict.addWord("sad");
		dict.addWord("java");
		dict.addWord("fab");
		dict.addWord("as");
		dict.addWord("bed");
		dict.addWord("avid");
		
		//diagonally right down words
		dict.addWord("nav");
		dict.addWord("did");
		dict.addWord("bia");
		dict.addWord("ide");

		//diagonally left down words
		dict.addWord("dad");
		dict.addWord("add");
		dict.addWord("via");
		dict.addWord("en");
		dict.addWord("babe");
		
		//horizontally lhs (left to right) words
		dict.addWord("ans");
		dict.addWord("jiav");
		dict.addWord("daf");
		dict.addWord("das");
		dict.addWord("avaj");
		dict.addWord("dba");
		dict.addWord("row");
		dict.addWord("gcc");
		dict.addWord("bag");
		
		//vertically up (from bottom to up) words
		dict.addWord("diva");
		dict.addWord("fed");
		dict.addWord("duru");
		dict.addWord("buf");
		dict.addWord("niva");
		
		//diagonally RHS upwards
		dict.addWord("css");
		dict.addWord("sadi");
		dict.addWord("vba");
		
		//diagonally LHS upwards
		dict.addWord("sai");
		dict.addWord("ed");
		dict.addWord("btw");
		dict.addWord("");
		
		//criss-cross words
		//adding only for debug purpose. These may not be reals words
		dict.addWord("asdvbia");
		dict.addWord("");
		
		//possible words
		dict.addWord("ada");
		dict.addWord("van");
		dict.addWord("awk");
		dict.addWord("bak");
		

		
		//words for other basic puzzles
		dict.addWord("cat");
		dict.addWord("dog");
		dict.addWord("bat");
		dict.addWord("can");
		dict.addWord("ate");
		dict.addWord("tom");
		
		dict.addWord("anaa");
		dict.addWord("tab");
		dict.addWord("net");
		dict.addWord("abacus");
		dict.addWord("tax");
		dict.addWord("cast");
		dict.addWord("cut");
	}
	
}
