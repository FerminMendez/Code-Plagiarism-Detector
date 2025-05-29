import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class rec1 {
	public static void main(String args[]) throws Exception{
		FileInputStream fs = new FileInputStream("input2.txt");
	    DataInputStream in = new DataInputStream(fs);
	    BufferedReader br=new BufferedReader(new InputStreamReader(in));
	    FileWriter fstream = new FileWriter("output2.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		int T=Integer.parseInt(br.readLine());
	    for(int i=0;i<T;i++){
	    	int temp=0;
	    	long [] found=new long[100000];
	    	int count=0;
	    	String str=br.readLine();
	    	String str1[]=str.split(" ");
	    	int nod=str1[1].length();
	    	int A=Integer.parseInt(str1[0]);
	    	int B=Integer.parseInt(str1[1]);
	    	for(int x=A;x<=B;x++){
	    		if(!isfound(x,found)){
	    			int t=1;
	    			int a=x;
	    			found[temp++]=a;
	    			int n1=nod-1;
	    			for(int k=0;k<n1;k++){
	    				int b=((a%10)*((int)Math.pow(10,n1)))+(a/10);
	    				if(b!=x && (!isfound(b,found)) && b<=B && A<=b){
	    					t++;
	    					found[temp++]=b;
	    				}
	    				a=b;	    			
	    			}
	    			count=count+((t*(t-1))/2);
	    		}
	    	}
	    	out.write("Case #"+(i+1)+": "+count);
			out.newLine();
	    }
	    out.close();
		br.close();
	   }
	public static boolean isfound(int current_no,long found[]){
		int len=found.length;
		for(int i=0;i<len;i++){
			if(found[i]==current_no)
				return true;
		}
		return false;
	}
}