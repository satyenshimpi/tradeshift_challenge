package com.tradeshift.util;

import com.tradeshift.Dictionary;
import com.tradeshift.Matrix;
import com.tradeshift.WordsFinder;
import com.tradeshift.WordsFinder.Type;
import com.tradeshift.impl.MatrixNodeArray;
import com.tradeshift.impl.WordsFinderBasic;
import com.tradeshift.impl.WordsFinderNodeArray;

/**
 * Factory for getting different implementations of WordsFinder
 * @author Satyen S Shimpi
 */
public class WordsFinderFactory{
	public static WordsFinder getInstance(Type type, Dictionary dict, Matrix matrix){
		if(type.equals(Type.CRISS_CROSS)){
			return new WordsFinderNodeArray(dict, (MatrixNodeArray<Character>)matrix);
		}
		return new WordsFinderBasic(dict, matrix);
	}
}