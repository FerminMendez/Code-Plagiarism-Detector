package core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public abstract class Template {

	/************* TO BE IMPLEMENTED ******************************************/

	public abstract void feedData(ExtendedBufferedReader iR); 

	public abstract StringBuffer applyMethods();

	/**************************************************************************/

	public void readData(File iFile){

		try {

			FileReader aReader = new FileReader(iFile);
			ExtendedBufferedReader aBufferedReader = new ExtendedBufferedReader(aReader);

			feedData(aBufferedReader);

			aBufferedReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeResult(File iFile,StringBuffer iResult){

		System.out.println(iResult.toString());

		try {

			FileWriter aWriter = new FileWriter(iFile);

			aWriter.write(iResult.toString());

			aWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void play(String[] args) {

		if (args.length>1) {
			File  aFile = new File(args[0]);

			readData(aFile);

			StringBuffer result = applyMethods();

			File aResultFile= new File(args[1]);

			writeResult(aResultFile,result);

		} else {
			System.out.println("Your a bastard ! missing argument !");
		}	

	}

}
