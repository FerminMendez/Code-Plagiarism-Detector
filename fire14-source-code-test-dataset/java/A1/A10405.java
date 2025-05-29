package codejam;
import java.io.*;
public class FileRead {
	String fileName;
	FileReader fr;
	BufferedReader br;
	FileRead(String fileName)
	{
		this.fileName=fileName;
		File f=new File("K:\\CodeJam\\Input\\"+fileName);//Create a file object
		
			FileReader fr;
			try {
				fr = new FileReader(f);
				br=new BufferedReader(fr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    	
	}
	//function to read next line.
	public String readNextLine(){
		String text=null;
		try {
			text=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return text;
	}
	public int readNextInt(){
		int n = 0;
		try{
			n=Integer.parseInt(br.readLine().trim());
		}catch(Exception e){
			System.out.println("Invalid integer");
		}
		return n;
	}
	public int [] readNextIntArray(){
		int []n=null;
		try{
			String []numarray=br.readLine().split(" ");
			n=new int[numarray.length];
			for(int i=0;i<numarray.length;i++){
				n[i]=Integer.parseInt(numarray[i].trim());								
			}
		}catch(Exception e){
			System.out.println("Invalid integer");
		}
		
		return n;
	}
	public void close(){
		try {
			//fr.close();
			br.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
	