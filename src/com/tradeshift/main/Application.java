package com.tradeshift.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import com.tradeshift.util.Constants;
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
		System.out.println(dict.toString());
		createAndShowGUI();
		//Run console app if console is available
		if(System.console() != null){
			runFromConsole();
		}
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
	
    /**
     * Populate Dictionary from dictionary file
     */
	private static void populateDictionary(){
		FileReader fr;
		try {
			File f = new File(Constants.EN_US_DICTIONARY);
			System.out.println(f.getAbsolutePath());
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while( (line = br.readLine()) != null){
				dict.addWord(line.trim());
			}
			br.close();
		} catch (FileNotFoundException e) {
			log.error("Could not find dictionary file", e);
		} catch (IOException e) {
			log.error("Exception", e);
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

}
