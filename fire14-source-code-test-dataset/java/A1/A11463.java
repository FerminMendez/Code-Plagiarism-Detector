package it.simone.google.code.jam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GoogleCodeJamManager {
	
	public static void main(String[] args) {
//		GoogleCodeExercise tm = new Translator();
//		GoogleCodeJamManager.execute("inputFile_Translator.in","outputFile_Translator.out",tm);
		GoogleCodeExercise dancer = new Dancer();
		GoogleCodeJamManager.execute("inputFile_Dancer.in","outputFile_Dancer.out",dancer);
	}

	public static void execute(String inputFile,String outputFile,GoogleCodeExercise exercise) {

		BufferedReader br = null;
		BufferedWriter bw=null;
		int testNumber=0;
		
		try {
			exercise.initialize();
			br = new BufferedReader(new FileReader(inputFile));
			bw=new BufferedWriter(new FileWriter(outputFile));
			String line = br.readLine();
			testNumber=Integer.parseInt(line);
			line=br.readLine();
			int testCounter=1;
			while (line != null) {
				System.out.println("Test" +testCounter +"/"+testNumber+ "\t Line=" + line);
				String translatedLine=exercise.execute(line);
				bw.write("Case #"+testCounter+": "+translatedLine+"\n");
				line=br.readLine();
				testCounter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			try {
				if (br != null)
					br.close();
				if(bw!=null)
					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
