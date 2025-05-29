import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class googler {
	
	private static File f = new File("C:/Users/Cybermask/Desktop/myfile.txt");
	private static File outfile = new File("C:/Users/Cybermask/Desktop/out.txt");
	
	
	private static BufferedReader reader;
	private static int getMaximum(int element,int surprisingindex){
		if(element==0)return 0;
		boolean surprising;
		if(surprisingindex==0)surprising=false;
		else surprising=true;
		if(!surprising){
			if(element%3 ==0)return element/3;
			if(element%3 ==1)return ((element-1)/3)+1;
			else return ((element-2)/3)+1;
		}else{
		  if(element%3 ==0 )return (element/3)+2;
		  else if(element%3 == 1 ) return ((element-1)/3)+2;
		  else return ((element-2)/3)+2;
		}
		
	}
	private static String read() throws Exception{
		return reader.readLine();
	}
	private static int toint(String s){
		return Integer.parseInt(s);
	}
	private static ArrayList<Object> reverse(ArrayList<Object>list){
		ArrayList<Object> result = new ArrayList<Object>();
		for(int i=0;i<list.size();i++)
			result.add(list.get(list.size()-i-1));
		return result;
		
	}
/*	private static int count(int element){
		int count=0;
		while(true){
			count+=element%2;
			element=(int)(element/2.0);
			if(element==0)return count;
		}
	}*/
	
	private static int[] count = new int[100];
	
public static void main(String args[])throws Exception{
	//System.out.println(getMaximum(23,1)+":"+getMaximum(23,0));
	reader = new BufferedReader(new FileReader(f));
	BufferedReader countreader = new BufferedReader(new FileReader("C:/Users/Cybermask/Desktop/count.txt"));
	for(int i=0;i<100;i++)count[i]=toint(countreader.readLine());
	PrintWriter pw = new PrintWriter(outfile);
	int n = toint(read());
	
	for(int i=0;i<n;i++){
		Scanner scanner = new Scanner(read());
		scanner.useDelimiter(" ");
		int googlerscount = scanner.nextInt();
		int surprising = scanner.nextInt();
		int max = scanner.nextInt();
		int googlers [] =new int[googlerscount];
		for(int k=0;k<googlerscount;k++)googlers[k]=scanner.nextInt();
		
		
		int totalmax=0;
		//if(googlerscount>3)googlerscount=3;
		int total = (int)Math.pow(2,googlerscount);
		for(int j=0;j<total;j++){
			if(count[j]!=surprising)continue;
			int max1=0;
			
			int jc = j;
			int z = 0;
			int o = ((int)(j/2.0))%2;
			int t = ((int)(j/4.0))%2;
		/*	if(getMaximum(googlers[0],z)>=max)max1=1;
		    if(googlerscount>1)if(getMaximum(googlers[1],o)>=max)max2=1;
	        if(googlerscount>2)if(getMaximum(googlers[2],t)>=max)max3=1;*/
	        for(int k=0;k<googlerscount;k++){
	        z = jc%2;
	        if(getMaximum(googlers[k],z)>=max)max1++;
	        jc = (int)(jc/2.0);
	        }
			if(max1>totalmax)totalmax=max1;
		} 
		pw.println("Case #"+(i+1)+": "+totalmax);
		
	}
	pw.flush();
	
}
}
