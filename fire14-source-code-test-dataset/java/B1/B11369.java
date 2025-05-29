import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class recycle {
	static int A=1111;
	static int B=2222;
	static int counter=0;
	static int cases=0;
	public static void main(String args[]) throws NumberFormatException, IOException{
		String temp,temp1[];
		FileReader in=new FileReader(new File("in"));
		BufferedReader br=new BufferedReader(in);
		FileOutputStream out=new FileOutputStream("out"); 
		cases=Integer.parseInt(br.readLine());
		for(int k=0;k<cases;k++){
			counter=0;
			temp=br.readLine();
			temp1=temp.split(" ");
			A=Integer.parseInt(temp1[0]);
			B=Integer.parseInt(temp1[1]);
		for(int i=A;i<B;i++)
			for(int j=i+1;j<=B;j++)
			{
				if(isRecycled(i,j))
					counter++;
			}
			out.write(("Case #"+(k+1)+": "+counter+"\n").getBytes());
		}
		System.out.println("\nans"+counter);
	}
	static boolean isRecycled(int n,int m){
		String ns=new Integer(n).toString();
		String ms=new Integer(m).toString();
		String temp;
		if(ns.length()==ms.length()){
		
			for(int i=0;i<ns.length();i++){
				temp=ns.substring(i)+ns.substring(0,i);
				if(temp.equals(ms))
					return true;
			}
		}
		return false;
	}
}
