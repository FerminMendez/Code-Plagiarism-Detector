import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class done {
	public static void main(String args[]) throws IOException
	{
Hashtable a = new Hashtable();
ArrayList<Integer> f = new ArrayList();


Scanner in = new Scanner(System.in);



DataInputStream d = new DataInputStream(new BufferedInputStream(new FileInputStream("C:/Users/ANKIT/Desktop/C-small-attempt0.in")));

//DataInputStream d = new DataInputStream(new BufferedInputStream(new FileInputStream("C:/Users/ANKIT/Desktop/hj.txt")));

String num = d.readLine();

int num1;

num1 = Integer.parseInt(num);
for(int i=0;i<num1;i++)
{

String  j = (d.readLine());

String [] a1 = j.split(" ");

Integer A = Integer.parseInt(a1[0]);
Integer B = Integer.parseInt(a1[1]);




int o=0;
String m = "" ;

for(Integer k=A;k<=B;k++)
{
	
	for (Integer y= k+1;y<=B;y++)
	{
	
		String a11 = Integer.toString(k);
		String b11 =Integer.toString(y);

		
		for(int t=1;t<a11.length();t++)
		{
			
			 if((a11.substring(t, a11.length())+a11.substring(0,t)).equals(b11))
			{
				o++;
				break;
			}
			
			
		
		}
}

}
f.add(o);
PrintWriter f11 =new PrintWriter("hello");

for(int y=0;y<f.size();y++)
	
{
	
	
	Integer h  = f.get(y);

f11.print("Case #"+(1+y)+": "+h+'\n');

}
f11.close();
	}
	
	}
}