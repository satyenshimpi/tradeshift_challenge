package com.tradeshift.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.tradeshift.WordsFinder;
import com.tradeshift.util.DictionaryImpl;

public class TestMain {
	static Logger log = Logger.getLogger(TestMain.class.getName());
	
	private static final String[] BASE_PUZZLE = new String[] {
			 "cat","ato", "nem"
	};
	
	private static final String[] BASE_PUZZLE2 = new String[] {
			 "xcat","xato", "xnem"
	};
	
	private static final String[] SINGLE_PUZZLE = new String[] {
			 "xbatey"
	};
	
	private static final String[] DEFAULT_PUZZLE = new String[] {
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

	DictionaryImpl dict = new DictionaryImpl();
	
	@Before
	public void populateDictionary(){
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
		
		//diagonally right
		dict.addWord("jdsv");
		//diagonally left
		dict.addWord("faij");
		
		dict.addWord("cat");
		dict.addWord("dog");
		dict.addWord("bat");
		dict.addWord("can");
		dict.addWord("ate");
		dict.addWord("tom");
	}
	
	@Before
	public void setUp(){
		System.setProperty("java.util.logging.SimpleFormatter.format", 
	            //"%1$tF %1$tT %4$s %2$s "+ 
				"%5$s%6$s%n");
	}
	
	@Test
	public void testWordsFinderBase() {
		log.info(dict.toString());
		List<String> lst = WordsFinder.findWords(DEFAULT_PUZZLE, dict);
		log.info("Words found as below");
		for(String s : lst){
			log.info(s);
		}
	}
	
//	@Test
	public void testWordsFinderDefault() {
		WordsFinder.findWords(BASE_PUZZLE, dict);
	}
}
