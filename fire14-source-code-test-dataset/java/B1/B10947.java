import java.io.*;
import java.util.*;
public class rn
{	
	static Integer rotate(Integer n)
	{	String str=n.toString();
		char[] a=str.toCharArray();
		Character tmp=a[a.length-1];
		for(int i=a.length-1;i>0;i--)
		{	a[i]=a[i-1];
		}
		a[0]=tmp;
		int i=0;
		String temp="";
		while(i<a.length)
		{	temp+=a[i];
			i++;
		}
		//System.out.println(temp+"##");
		return Integer.valueOf(temp);
	}

	static Integer drotate(Integer n)
	{	String str=n.toString();
		char[] a=str.toCharArray();
		Character tmp=a[0];
		for(int i=0;i<a.length-1;i++)
		{	a[i]=a[i+1];
		}
		a[a.length-1]=tmp;
		int i=0;
		String temp="";
		while(i<a.length)
		{	temp+=a[i];
			i++;
		}
		//System.out.println(temp+"##");
		return Integer.valueOf(temp);
	}

	public static void main(String agrs[]) throws IOException
	{	File inFile = null;
		File outFile = null;
		FileInputStream inFis = null;
		FileOutputStream outFos = null;
		BufferedInputStream inBis = null;
		BufferedOutputStream outBos = null;
		DataInputStream inDis = null;
		DataOutputStream outDos = null;
		inFile = new File("C:\\Users\\akhil\\akhil\\codejam12\\rn\\in.in");
		outFile = new File("C:\\Users\\akhil\\akhil\\codejam12\\rn\\out.out");
		inFis = new FileInputStream(inFile);
		outFos = new FileOutputStream(outFile);
		inBis = new BufferedInputStream(inFis);
		outBos = new BufferedOutputStream(outFos);
		inDis = new DataInputStream(inBis);
		outDos = new DataOutputStream(outBos);
		int t = Integer.parseInt(inDis.readLine());
		System.out.println(t);
		//int i=1;
		//int c, d, n;*/
		//int n,p;
		//string sent;
		String tmp=	null;
		//int outp=0;
		int cnt=1;
		Integer outp=null;
		String arr[];
		Integer a,b=null;
		int count=0;
		Integer temp;
		int c=0;
		while((inDis.available()!=0))// && i<=t)
		{	tmp=inDis.readLine();
			arr=tmp.split(" ");
			a=Integer.valueOf(arr[0]);
			b=Integer.valueOf(arr[1]);
			count=0;
			System.out.println(a+" "+b);
			for(Integer n=a;n<b;n++)
			{	temp=n;
				
				c=arr[0].split("").length-1;
				System.out.println("\nn="+n);
				//Integer.rotateRight(tmp,1);
				while(c>1)
				{	if(temp%10==0)
					{	temp=drotate(temp);	
					}
					else
					{	temp=rotate(temp);	
					}
					System.out.print(temp+" ");
					if(temp<=b && temp>n)
					{	count++;
						System.out.println("a");
					}
					c--;
				}
				//System.in.read();
			}//123,  312, 231, 123,
			
			outDos.writeBytes("Case #"+cnt+": "+count+"\r\n");
			//outDos.writeBytes(outp+"\r\n");
			//outDos.writeChars("\n");
			outDos.flush();
			outDos.flush();
			//outDos.writeChars("\r");
			//outDos.flush();
			//outDos.flush();
			cnt++;
			//i++;
		}
		outDos.close();
		inDis.close();
	}
}