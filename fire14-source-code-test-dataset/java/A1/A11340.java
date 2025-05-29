import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.charset.*;

public class danzig
{
	//arrays store each Googler's score info
	private static int[] total;
	private static int[] max;
	private static int[] modulo;
	
	private static int[] results;
	
	public static void main(String args[])
	{
		//int linesRead=0;
		//fileRead();
		Path file = Paths.get("C:\\Users\\Elena\\Documents\\george\\code jam\\B-small-attempt0.in");
		Charset cs = Charset.forName("US-ASCII");
		
		try(BufferedReader reader = Files.newBufferedReader(file, cs)){
			//#test cases setup
			int T = Integer.valueOf(reader.readLine());
			results = new int[T];
			
			//the 'main' loop
			for(int i=0; i<T; i++)
			{
				String lineStr = reader.readLine();
				//System.out.println(lineStr);
				String strAry[] = lineStr.split(" ");
				int N = Integer.valueOf(strAry[0]); //#Googlers
				int S = Integer.valueOf(strAry[1]); //#surprising scores
				int p = Integer.valueOf(strAry[2]); //target value
				
				//set array size
				total = new int[N];
				max = new int[N];
				modulo = new int[N];
				
				for(int j=0; j<N; j++)
					total[j] = Integer.valueOf(strAry[j+3]);
				
				Arrays.sort(total);
				//max and remainder
				for(int j=0; j<N; j++){
					modulo[j] = total[j]%3;
					if(modulo[j]==0)
						max[j] = total[j]/3;
					else
						max[j] = total[j]/3+1;
				}
				//System.out.println(S+"..."+Arrays.toString(max));
				
				//finds largest max values < p
				int n=0; //number of surprisings selected so far
				for(int j=N-1; j>=0; j--){
					if(n>=S) //do not exceed
						break;
					if(max[j]<p){
						if(modulo[j]!=1 && total[j]>=2){ //if remainder 0|2 then can increase
							n++;
							max[j]++;
						}
					}
				}
				/*System.out.println(Arrays.toString(total));
				System.out.println(p+"..."+Arrays.toString(max));
				System.out.println(Arrays.toString(modulo));*/
				
				//count number of matches
				tally(i,p);
				
				//System.out.print("\n");
			}
		} catch(IOException x) {
			System.out.println("oops read");
		}
		
		//System.out.println(Arrays.toString(results));
		fileWrite();
		
	}
	
	public static void tally(int pos, int target){
		int instances=0;
		for(int i=0; i<max.length; i++){
			if(max[i]>=target)
				instances++;
		}
		results[pos]=instances;
	}
	
	public static void fileWrite(){
		Path file = Paths.get("C:\\Users\\Elena\\Documents\\george\\code jam\\dancing.out");
		Charset cs = Charset.forName("US-ASCII");
		
		try(BufferedWriter writer = Files.newBufferedWriter(file, cs)){
			for(int i=0; i<results.length; i++){
				String line = "Case #" + (i+1) + ": " + results[i];
				writer.write(line);
				writer.newLine();
			}
		} catch(IOException x){
			System.out.println("oops write");
		}
	}
	
	/*public static void fileRead()
	{
		Path file = Paths.get("C:\\Users\\Elena\\Documents\\george\\code jam\\dancingsample.in");
		Charset cs = Charset.forName("US-ASCII");
		
		try(BufferedReader reader = Files.newBufferedReader(file, cs)){
			int T = Integer.valueOf(reader.readLine());
			//parses lines for meaningful numbers
			for(int i=0; i<T; i++)
			{
				String str = reader.readLine();
				String strAry = str.split()
			}
		} catch(IOException x) {
			System.out.println("oops read");
		}
	}*/
	
}