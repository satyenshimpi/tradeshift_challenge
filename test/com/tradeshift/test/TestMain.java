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

/**
 * Test class for WordsFinderBasic
 * example char matrix
 * c a t 
 * a t o 
 * n e m 
 * has words cat, can, tom, ate
 * @author Satyen S Shimpi
 */
public class TestMain extends TestBase {
	static Logger log = LogManager.getLogger(TestMain.class.getName());
	
	@Test
	public void testWordsFinderDefaultPuzzle() {
		log.debug(dict.toString());
		Matrix matrix = Helper.getMatrixInstance(DEFAULT_PUZZLE, Type.BASIC);
		
		WordsFinder wf = WordsFinderFactory.getInstance(Type.BASIC, dict, matrix);
		List<String> lst = wf.findWords();
		
		Helper.printMatrix(matrix);
		log.info("\n\n\n----Following words found in the given Matrix------\n");
		for(String s : lst){
			log.info(s);
		}
	}
	
	@Test
	public void testWordsFinderBasePuzzle() {
		log.debug(dict.toString());
		Matrix matrix = Helper.getMatrixInstance(BASE_PUZZLE, Type.BASIC);
		
		WordsFinder wf = WordsFinderFactory.getInstance(Type.BASIC, dict, matrix);
		List<String> lst = wf.findWords();
		
		Helper.printMatrix(matrix);
		log.info("\n\n\n----Following words found in the given Matrix------\n");
		for(String s : lst){
			log.info(s);
		}
	}
}
