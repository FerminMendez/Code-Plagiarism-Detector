import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class GoogleC {
	public String szamol(String input){
		String result="";
		String a=input;
		Integer min=Integer.parseInt(a.substring(0,a.indexOf(' ')));
		a=a.substring(a.indexOf(' ')+1);
		Integer max=Integer.parseInt(a);
		Long count=0l;
		for(Integer i=min; i<=max; i++){
			String e1=i.toString();
			Set<Integer> db=new HashSet<Integer>(); 
			for (int j=1; j<e1.length();j++){
				
				String e2=e1.substring(j)+e1.substring(0,j);
				Integer k=Integer.parseInt(e2);
				if (k>i && k<=max){
					db.add(k);
					//System.out.println(e1+"\t"+e2);
				}
				
			}
			count+=db.size();
		}
		
		return count.toString();
	}
	public static void main(String[] args) {
		GoogleC a=new GoogleC();
		//String filename="input.txt";
		String filename="C-small-attempt0.in";
		//String filename="B-large.in";
		String thisLine;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter bw= new BufferedWriter(new FileWriter(filename+".out"));
			thisLine=br.readLine();
			Integer tnum=Integer.parseInt(thisLine);
		     for(int i=0;i<tnum;i++) { // while loop begins here
		    	 	thisLine=br.readLine();
		           System.out.println(thisLine);
		           System.out.println("Case #"+(i+1)+": "+a.szamol(thisLine)+"\n");
		           bw.write("Case #"+(i+1)+": "+a.szamol(thisLine)+"\n");
		         } // end while 
		        // end try
		     br.close();
		     bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
