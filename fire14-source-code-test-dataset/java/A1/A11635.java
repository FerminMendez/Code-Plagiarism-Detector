import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Dancing {
	public static void main(String[] args){
		Dancing d = new Dancing();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("B-small-attempt7.in");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  
			  int numOfTests = Integer.parseInt(br.readLine());
			  int N,S,p;
			  
			  for(int i=1; i<=numOfTests; i++){
				  String itemString =br.readLine();
				  String[] items = itemString.split(" ");
				  System.out.print("Case #"+i+": ");
				  N=Integer.parseInt(items[0]);
				  S=Integer.parseInt(items[1]);
				  p=Integer.parseInt(items[2]);
				  int[] scores = new int[N];
				  for(int j=3; j<N+3; j++){
					  scores[j-3]=Integer.parseInt(items[j]);
				  }
				  
				  d.getMaxGooglers(N, S, p, scores);
				  System.out.println();
			  }
			  //Close the input stream
			  in.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
	}

	private void getMaxGooglers(int N, int S, int p, int[] scores) {
		int count =0;
		for(int i=0; i<N; i++){
			if(scores[i]==0){
				if(p==0){
					count++;
					continue;
				}
				else
					continue;
			}
				
			int rem = scores[i]%3;
			int div = scores[i]/3;
 			if(rem ==0){
				if(div>=p)
					count++;
				else{
					if(S>0 && ((div+1)>=p)){
						count++;
						S--;
					}
				}
			}
			else if (rem==1){
				if(div+1>=p)
					count++;
			}
			else if (rem==2){
				if(div+1 >=p)
					count++;
				else if (S>0 && ((div+2)>=p)){
					count++;
					S--;
				}
			}
			else;
		}

		
		System.out.print(count);
		
	}

}
