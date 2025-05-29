package codejam;
import java.io.*;
public class FileWrite {
	String fileName;
	BufferedWriter bw;
	FileWriter fw;
	FileWrite(String fileName){
		this.fileName=fileName;
		File f=new File("K:\\CodeJam\\Results\\"+fileName);
	    try{
	    	fw=new FileWriter(f);
	        bw=new BufferedWriter(fw);
	    }catch(Exception e){
	    	System.out.println("Invalid file name.");
	    }
	}
	
	public void writeLine(String str){
		try {
			bw.write(str+"\n");
		} catch (IOException e) {
			System.out.println("Error writing to file");
		}
		
	}
	
	public void close(){
		try {
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
