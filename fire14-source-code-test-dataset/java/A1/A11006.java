import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class DancingGooglers {
	public static void main(String[] args) {
		File file  = new File("C:\\Users\\aadi\\Desktop\\DancingGooglers\\B-small-attempt0.in");
		try{
			FileWriter fstream = new FileWriter("C:\\Users\\aadi\\Desktop\\DancingGooglers\\out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
		    Scanner scanner = new Scanner(file);
		    int numOfCases = Integer.parseInt(scanner.nextLine());
		    for(int i =0 ;i< numOfCases ; i++){
		    	int sCount= 0;
		    	int non_sCount = 0;
		    	String line = scanner.nextLine();
		    	Scanner scanner2 = new Scanner(line);
		    	scanner2.useDelimiter(" ");
		    	int n =  scanner2.nextInt();
		    	int s =  scanner2.nextInt();
		    	int p =  scanner2.nextInt();
		    	while(scanner2.hasNext()){
		    		int tot = scanner2.nextInt();
		    		if(tot>=Math.max((p*3-2), 0)){
		    			non_sCount++;
		    		}else if(tot>=(p + Math.max((p-2),0) + Math.max((p-2),0)) ){
		    			sCount++;
		    		}
		    	}
		    	out.write("Case #"+(i+1)+": ");
		    	if(sCount<s){
	    			//System.out.println(non_sCount+sCount);
	    			out.write(""+(non_sCount+sCount));
	    		}else{
	    			//System.out.println(non_sCount+s);
	    			out.write(""+(non_sCount+s));
	    		}
		    	//System.out.println("");
		    	out.write(System.getProperty("line.separator"));
		    }
		    out.close();
		}catch(FileNotFoundException f){
			f.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
