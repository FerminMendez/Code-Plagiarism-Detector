import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class B {

public static void main(String args[]){
		
		try{
		
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String strTmp = br.readLine();
			BufferedWriter bw = new BufferedWriter(new FileWriter( new File("output.txt"),false));
			
			
			int inputSize = Integer.parseInt(strTmp);
			
			for(int i=0;i<inputSize;i++  ){

				// processing inputline
				strTmp = br.readLine();
				String[] line = strTmp.split(" ");
				int N = Integer.parseInt(line[0]);
				int S = Integer.parseInt(line[1]);
				int p = Integer.parseInt(line[2]);
				
				int[] points = new int[N];
				for(int j=0;j<N;j++){
					points[j] = Integer.parseInt(line[j+3]);
				}
				
				int lim1 = p*3 - 2 ;
				int lim2 = p*3 - 4 ;
				
				int res = 0;
				
				if(p==0){
					res = N;
				}else if(p==1){
					for(int j=0;j<N;j++){
						if (points[j]>=1){
							res++;
						}
					}
				}else{
				    for(int j=0;j<N;j++){
						if (points[j]>=lim1){
							res++;
						}else if ( points[j]>=lim2 && S>0 ){
							res++;
							S--;
						}
					}
				}
				
				// produce output
                //System.out.println("Case #"+(i+1)+": " + res );			
				bw.write("Case #"+(i+1)+": " + res );
				bw.newLine();
			}
			
			bw.close();
			br.close();
		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
