package com.tradeshift.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;

import com.tradeshift.Matrix;
import com.tradeshift.WordsFinder;
import com.tradeshift.impl.DictionaryImpl;
import com.tradeshift.util.Constants;
import com.tradeshift.util.Helper;
import com.tradeshift.util.WordsFinderFactory;

public class AppWindow extends JFrame{
	private static final long serialVersionUID = 8051350093377042993L;
	private DictionaryImpl dict;
	private JTextPane textPane;
	private AbstractDocument doc;
	private JTextArea results;
 
    public AppWindow(DictionaryImpl dict) {
        super("AppWindow");
        this.dict = dict;
        
        //Create the text pane and configure it.
        textPane = new JTextPane();
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5,5,5,5));
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(200, 200));
 
        //Create the text area for the status log and configure it.
        results = new JTextArea(15, 30);
        results.setEditable(false);
        JScrollPane scrollPaneForLog = new JScrollPane(results);
 
        //Create a split pane for the change log and the text area.
        JSplitPane splitPane = new JSplitPane(
                                       JSplitPane.VERTICAL_SPLIT,
                                       scrollPane, scrollPaneForLog);
        splitPane.setOneTouchExpandable(true);
        JButton find = new JButton("Find Words");
        find.addMouseListener(getFindMouseListener());
         
        //Add the components.
        getContentPane().add(splitPane, BorderLayout.CENTER);
        getContentPane().add(find, BorderLayout.PAGE_END);
        
        //Put the initial text into the text pane.
//        initDocument();
        textPane.setCaretPosition(0);
    }

    private MouseListener getFindMouseListener() {
    	return new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}			
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String txt = textPane.getText();
				String[] input = txt.split(Constants.LINE_SEPERATOR);
				
				Matrix matrix = Helper.getMatrixInstance(input, com.tradeshift.WordsFinder.Type.CRISS_CROSS);
				WordsFinder wf = WordsFinderFactory.getInstance(com.tradeshift.WordsFinder.Type.CRISS_CROSS, dict, matrix);
				List<String> lst = wf.findWords();
				
				Helper.printMatrix(matrix);
				System.out.println("\n\n\n----Following words found in the given Matrix------\n");
				results.setText("");
				for(String s : lst){
					results.setText(results.getText()+ (!results.getText().equals("") ? Constants.LINE_SEPERATOR : "") + s);
					System.out.println(s);
				}
			}
		};
	}
    
}
