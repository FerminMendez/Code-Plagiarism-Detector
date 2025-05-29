
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;


public class IOHelper{
	Scanner sc=null;
	Writer output=null;

	public IOHelper(String input,String ouptPut){
		try{
			sc=new Scanner(new File(input));
			output=new BufferedWriter(new FileWriter(ouptPut));
		}catch(Exception e){
				e.printStackTrace();
			}	
		}
	public String readLine(){
		String result=null;	
		result=sc.nextLine();
		while(sc.hasNextLine()&& (result==" " ||result==null|| result=="")){
			result=sc.nextLine();
		}		
		return result;		
	}	
	
	public void writeLine(String line){
		try{
		output.write(line);
		output.write('\n');
		output.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void close(){
		try{
		output.flush();
		output.close();
		sc.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
