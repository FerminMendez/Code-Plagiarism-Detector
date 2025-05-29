import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class C {
public static void main(String args[]){
		
		try{
		
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String strTmp = br.readLine();
			BufferedWriter bw = new BufferedWriter(new FileWriter( new File("output.txt"),false));
			
			
			int inputSize = Integer.parseInt(strTmp);
			
			
			for(int i=0;i<inputSize;i++  ){

				String[] line = br.readLine().split(" ");
				int pos = 0;
				// processing inputline
				
				int len = line[0].length();
				int min = Integer.parseInt(line[0]);
				int max = Integer.parseInt(line[1]);
				
				if(min<10){
					pos = 0;
				}else{
					
					for(int j=min ; j <= max ; j++ ){
				
						String st = Integer.toString(j);
						ArrayList<Integer> uniqList = new ArrayList<Integer>();
						for(int k=0;k<len-1;k++){
							char tmp = st.charAt(len-1);
							st = st.charAt(len-1) + st.substring(0,len-1);
							
							int i1 = Integer.parseInt(st);
							
							if(j<i1 && i1<=max && !uniqList.contains(i1) ){
								pos++;
								uniqList.add(i1);
							}
							
						}
					}
				}
				// produce output
                //System.out.println("Case #"+(i+1)+": " + pos );			
				bw.write("Case #"+(i+1)+": " + pos );
				bw.newLine();
			}
			
			bw.close();
			br.close();
		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
