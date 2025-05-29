import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Pairs {

	/**
	 * @param args
	 */
	
	public static int counter=0;
	
	public static void checkhelper(String a,String b)
	{
		if(a.length()!=b.length())
			return;
		if(a.concat(a).contains(b))
			counter++;	
	}
	
	
	public static void check(int a,int b)
	{
		for(int i=a;i<=b;i++)
		{
			for(int j=i+1;j<=b;j++)
			checkhelper(""+i, ""+j);
			
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedWriter bw=new BufferedWriter(new FileWriter("out2.out"));
		BufferedReader bf=new BufferedReader(new FileReader("input.txt"));
		int count=Integer.parseInt(bf.readLine());
		for(int i=0;i<count-1;i++)
		{
			
			String line=bf.readLine();
		String []a=line.split(" ");
		
		check(Integer.parseInt(a[0]),Integer.parseInt(a[1]));
	
	bw.write("Case #"+(i+1)+": "+counter);
	bw.newLine();
	counter=0;
	}
		
		String line=bf.readLine();
		String []a=line.split(" ");
		
		check(Integer.parseInt(a[0]),Integer.parseInt(a[1]));
	
	
	bw.write("Case #"+(count)+": "+counter);
	bw.close();
	}

}
