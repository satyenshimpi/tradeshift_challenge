package com.tradeshift.main;

import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tradeshift.Matrix;
import com.tradeshift.WordsFinder;
import com.tradeshift.WordsFinder.Type;
import com.tradeshift.impl.DictionaryImpl;
import com.tradeshift.ui.AppWindow;
import com.tradeshift.util.Helper;
import com.tradeshift.util.WordsFinderFactory;

/**
 * Main class to run application
 * @author Satyen S Shimpi
 *
 */
public class Application {
	static Logger log = LogManager.getLogger(Application.class.getName());
	static DictionaryImpl dict = new DictionaryImpl();
	
	public static void main(String[] args) {
		populateDictionary();
		createAndShowGUI();
		//Run console app if console is available
		if(System.console() != null){
			runFromConsole();
		}
	}

	/**
	 * If Console is available then we can have Console version of app
	 */
	private static void runFromConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the the number of Strings.");
		int cnt = sc.nextInt();
		sc.nextLine();
		int i=0;
		String[] input = new String[cnt];
		while(i < cnt){
			input[i] = sc.nextLine();
			i++;
		}

		Matrix matrix = Helper.getMatrixInstance(input, Type.CRISS_CROSS);
		WordsFinder wf = WordsFinderFactory.getInstance(Type.CRISS_CROSS, dict, matrix);
		List<String> lst = wf.findWords();
		
		Helper.printMatrix(matrix);
		System.out.println("\n\n\n----Following words found in the given Matrix------\n");
		for(String s : lst){
			System.out.println(s);
			log.info(s);
		}
		sc.close();
	}
	
	/**
     * Create the GUI for application.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        final AppWindow frame = new AppWindow(dict);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	private static void populateDictionary(){
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
