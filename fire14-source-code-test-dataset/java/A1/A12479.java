import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Dancing {
	public static void main(String[] args){
		List<String> input=new ArrayList<String>();
		List<String> output=new ArrayList<String>();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("c:/input/B-small-attempt0.in");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  input.add(strLine);
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		/*input done*/
		for(int j=1;j<input.size();j++){
			String a=input.get(j);
			//System.out.println("getting input as"+a);
			String b[]=a.split(" ");
			int n,s,p,t[]=null;
			n=Integer.parseInt(b[0]);
			s=Integer.parseInt(b[1]);
			p=Integer.parseInt(b[2]);
			t=new int[n];
			for(int i=3;i<b.length;i++){
				t[i-3]=Integer.parseInt(b[i]);
			}
			int count=0,div,mod;
			for(int i=0;i<t.length;i++){
				div=t[i]/3;
				mod=t[i]%3;
				if(div>=p){
					count++;
					//System.out.println("normal"+t[i]);
				}else if((div+Math.min(mod,1)>=p)){
					count++;
					//System.out.println("with increment"+t[i]);
				}else if((div+Math.min(mod,2)>=p)&&(s>0)){
					count++;
					if(mod>=2){
						s--;
						//System.out.println("surprised"+t[i]+"remaining s"+s);
					}
				}else if((div+1>=p)&&(div>0)&&(s>0)){
					count++;
					s--;
					//System.out.println("superficial"+t[i]);	
				}else{
					//System.out.println("noting happened"+t[i]+" div is "+div+"mod is"+mod);
				}
			}
			output.add(count+"");
			/*counting done*/
			//System.out.println(count);
		}
		try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:/output/Dancing.out"), true));
            for(int i=0;i<output.size();i++){
            	bw.write("Case #"+(i+1)+": "+output.get(i));
            	bw.newLine();
            }
            bw.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
	}

}
