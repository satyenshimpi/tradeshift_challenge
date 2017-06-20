package com.tradeshift.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.tradeshift.Matrix;
import com.tradeshift.WordsFinder;
import com.tradeshift.WordsFinder.Type;
import com.tradeshift.util.Helper;
import com.tradeshift.util.WordsFinderFactory;

public class WordsFinderCrissCross_Test extends TestBase {
	static Logger log = LogManager.getLogger(WordsFinderCrissCross_Test.class.getName());

	@Test
	public void testWordsFinderGraph_DefaultPuzzle() {
		log.debug(dict.toString());
		Matrix matrix = Helper.getMatrixInstance(DEFAULT_PUZZLE, Type.CRISS_CROSS);
		
		WordsFinder wf = WordsFinderFactory.getInstance(Type.CRISS_CROSS, dict, matrix);
		List<String> lst = wf.findWords();
		
		Helper.printMatrix(matrix);
		log.info("\n\n\n----Following words found in the given Matrix------\n");
		for(String s : lst){
			log.info(s);
		}
	}
	
	@Test
	public void testWordsFinderGraph_BasePuzzle() {
		log.debug(dict.toString());
		Matrix matrix = Helper.getMatrixInstance(BASE_PUZZLE_CRISSCROSS, Type.CRISS_CROSS);
		
		WordsFinder wf = WordsFinderFactory.getInstance(Type.CRISS_CROSS, dict, matrix);
		List<String> lst = wf.findWords();
		
		Helper.printMatrix(matrix);
		log.info("\n\n\n----Following words found in the given Matrix------\n");
		for(String s : lst){
			log.info(s);
		}
	}
}
