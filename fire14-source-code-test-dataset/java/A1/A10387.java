package dancing;

import java.io.*;
import java.util.StringTokenizer;

public class Dancing {

	/**
	 * @param args
	 */

	private static int[] values = null;
	private static int[] googlers= null;
	private static int total =0;
	
	public static void main(String[] args) {
		
		BufferedReader fin = null;
		int t = 0;
		StringTokenizer str = null;
		
		try {
			fin = new BufferedReader(new FileReader(new File("/home/bamdad/NetBeansProjects/Dancing/src/dancing/B-small-attempt0.in")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
			
			try {
				t = Integer.parseInt(fin.readLine());
				//System.out.println(t);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			values = new int[3];
			
			
			for(int i=0;i<t;i++){
				System.out.print("Case #"+(i+1)+": ");
				try {
					total = 0;
					str=new StringTokenizer(fin.readLine());
					
					int ctr =0;
				while(ctr<3) {
					 
					values[ctr]=Integer.parseInt(str.nextToken());
					ctr++;
					
					}
				//System.out.print(values[0]+" "+values[1]+" "+values[2]+" ");
				ctr=0;
				googlers = new int[values[0]];
				while(str.hasMoreElements()){
					googlers[ctr]=Integer.parseInt(str.nextToken());
					//System.out.print(googlers[ctr]+" ");
					ctr++;
				}
				//System.out.println();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				calculate();
				
			}
	}


	private static void calculate() {
		
		int value = 0 ;
		int remainder = 0;
		for(int i=0;i<values[0];i++){			
			value = googlers[i]/3;
			remainder = googlers[i]%3;
			
			if (googlers[i]==0&&values[2]!=0)
				continue;
			
			if(value>=values[2])
				total++;
			else if(remainder==0&&values[1]>0&&(value+1)>=values[2]){
				values[1]--;
				total++;
			}
			else if(remainder>0&&(value+1)>=values[2])
				total++;
			
			else if(remainder==2&&(value+2)>=values[2]&&values[1]>0){
				total++;
				values[1]--;
			}	
		}
		System.out.println(total);
	}

}
