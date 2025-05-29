package R2012;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RecycledNumbers {

	public static boolean isCycle(int a,int b) {
		String aa=String.valueOf(a);
		StringBuffer ba=new StringBuffer(String.valueOf(b));
		if(aa.length()!=ba.length())
			return false;
		int l=aa.length();
		for(int i=0;i<l;++i)
		{
			if(aa.equals(ba.toString()))
				return true;
			ba.append(ba.charAt(0));
			ba.deleteCharAt(0);
		}
		return false;
	}
	public static boolean sameLen(int a,int b) {
		return String.valueOf(a).length()==String.valueOf(b).length();
	}
	public static void main(String[] args) {
		int T,count,a,b,num;
		try {
			FileWriter out = new FileWriter("d://test//Cs.out");  
			//Scanner in=new Scanner(System.in);
			Scanner in=new Scanner(new File("d://test//Cs.in"));
			T=in.nextInt();
			count=0;
			while((++count)<=T)
			{
				a=in.nextInt();
				b=in.nextInt();
				num=0;
				for(int i=a;i<=b;++i)
					for(int j=i+1;sameLen(i, j)&&j<=b;++j)
						if(isCycle(i, j))
							++num;
				
				out.write("Case #"+count+": "+num+"\r\n"); 
			}
			
			in.close(); 
			out.close();  
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
