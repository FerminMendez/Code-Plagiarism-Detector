package com.rahul.codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	private int inputlength;
	private int counter;
	
	public App(String filename) {
		fFileName = filename;
	}
	
    public static void main( String[] args ) throws IOException
    {
    	String fileName = args[0];
		String encoding = "utf-8";
		App test = new App(fileName);
		test.process();
    }
    
    protected void process() throws IOException {
		log("Reading from file.");

		StringBuilder text = new StringBuilder();
		String NL = System.getProperty("line.separator");
		Scanner scanner = new Scanner(new FileInputStream(fFileName), fEncoding);
		try {
			while (scanner.hasNextLine()) {
				if (inputlength == 0) {
					inputlength = Integer.parseInt(scanner.nextLine());
				} else {
					counter++;
					String output = String.format("Case #%d: %s", counter,processLine(scanner.nextLine()));
					System.out.println(output);
					text.append(output + NL);
				}
				//text.append(scanner.nextLine() + NL);
			}
			log("Writing to file named " + fFileName+".out" + ". Encoding: " + fEncoding);
		    Writer out = new OutputStreamWriter(new FileOutputStream(fFileName + ".out"), fEncoding);
		    try {
		      out.write(text.toString());
		    }
		    finally {
		      out.close();
		    }
		} finally {
			scanner.close();
		}
		log("Text read in: " + text);
	}
    
    protected String processLine(String s) {
		//Logic goes here
		String comp[] = s.split(" ");
		int googlers = Integer.parseInt(comp[0]);
		int maxsurprises = Integer.parseInt(comp[1]);
		int surprises = 0;
		int chasingScore = Integer.parseInt(comp[2]);
		int googlersGotChasingScores = 0;
		String scores[] = Arrays.copyOfRange(comp, 3, comp.length);
		System.out.println("scores length: " + scores.length);
		for(int i = 0; i < scores.length && i < googlers; i++) {
			if(checkChasingScore(Integer.parseInt(scores[i]), chasingScore)) {
				googlersGotChasingScores++;
			} else if(surprises < maxsurprises) {
				if(checkChasingScoreWithSurprise(Integer.parseInt(scores[i]), chasingScore)) {
					surprises++;
					googlersGotChasingScores++;
				}
			}
		}
		System.out.print(googlersGotChasingScores);
		return googlersGotChasingScores+"";
	}
    
    protected boolean checkChasingScore(int totalScore, int chasingScore) {
		boolean gotScore = false;
		switch (totalScore %3) {
		case 0:
			gotScore = totalScore/3 >= chasingScore;
			break;
		case 1:
		case 2:
			if(totalScore/3 + 1 <= totalScore)
				gotScore = (totalScore/3 + 1) >= chasingScore;
			break;
		}
		return gotScore;
	}
    
    protected boolean checkChasingScoreWithSurprise(int totalScore, int chasingScore) {
		boolean gotScore = false;
		switch (totalScore % 3) {
		case 0:
		case 1:
			if(totalScore/3 + 1 <= totalScore)
				gotScore = (totalScore/3 + 1) >= chasingScore;
			break;
		case 2:
			if(totalScore/3 + 2 <= totalScore)
			gotScore = (totalScore/3 + 2) >= chasingScore;
			break;
		}
		return gotScore;
	}

// PRIVATE
	private final String fFileName;
	private final String fEncoding = "utf-8";

	private void log(String aMessage) {
		System.out.println(aMessage);
	}
}
