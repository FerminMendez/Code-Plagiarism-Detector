package gcj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RecycledNumbers {

	private static int a;
	private static int b;
	private static int total=0;
	private static boolean[] values;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader fin = null;
		int t = 0;
		StringTokenizer str = null;
		
		try {
			fin = new BufferedReader(new FileReader(new File("C-small-attempt0.in")));
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
			
			
			
			for(int i=0;i<t;i++){
				System.out.print("Case #"+(i+1)+": ");
				try {
					total = 0;
					str=new StringTokenizer(fin.readLine());
					
					 
					a=Integer.parseInt(str.nextToken());
					b=Integer.parseInt(str.nextToken());
					
					if(a<b){
					values = new boolean[b-a+1];
					Arrays.fill(values, false);
					
					}
					else
					{
						values = new boolean[a-b+1];			
						Arrays.fill(values, false);
							
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				
				calculate();
				
			}
		}

	private static void calculate() {
		// TODO Auto-generated method stub
		
		int start,end,location;
		String current=null,val=null,s=null;
		if(a>b){
			start=b;
			end = a;
		}
		else{
			start=a;
			end=b;
		}
		for(int i=start;i<=end;i++){
			location = i-start;
			if(values[i-start]==true)
				continue;
			values[location]=true;
			current = Integer.toString(i);
			s=current;
			
			do{
				val=s;
				s=val.charAt(val.length()-1)+val.substring(0,val.length()-1);
				location=Integer.parseInt(s)-start;
				if(Integer.parseInt(s)<=end&&Integer.parseInt(s)>=start&&current.compareTo(s)!=0&&values[location]!=true){
					total++;
				}
				
			}while(current.compareTo(s)!=0);
		}
		
		System.out.println(total);
	}
	

}	
