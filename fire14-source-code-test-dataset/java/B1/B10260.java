package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ExtendedBufferedReader extends BufferedReader {

	public ExtendedBufferedReader(Reader iReader) {
		super(iReader);
	}

	public String getLine(){
		
		try {
			return readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// Get int from line
	public int getIntFL(){
		try {
			return new Integer(readLine()).intValue();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Error check entry data");
		} catch (IOException e) {
			System.out.println("Error check entry data");
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Integer> getIntListFL(){
		
		String[] aRead;
		try {
			aRead = readLine().split(" ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		List<Integer> aList = new ArrayList<Integer>();
		for (String num:aRead) {
			aList.add(new Integer(num));
		}
		return aList;
		
	}
	
	public List<Long> getLongListFL(){
		
		String[] aRead;
		try {
			aRead = readLine().split(" ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		List<Long> aList = new ArrayList<Long>();
		for (String num:aRead) {
			aList.add(new Long(num));
		}
		return aList;
		
	}
	
	
}
