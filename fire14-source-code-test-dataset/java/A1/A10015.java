package R2012;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DancingGooglers {

	
	public static void main(String[] args) {
		int T,count,n,s,p,num,snum,tem;
		try {
			FileWriter out = new FileWriter("d://test//Bs.out");  
			//Scanner in=new Scanner(System.in);
			Scanner in=new Scanner(new File("d://test//Bs.in"));
			T=in.nextInt();
			count=0;
			while((++count)<=T)
			{
				n=in.nextInt();
				s=in.nextInt();
				p=in.nextInt();
				num=snum=0;
				for(int i=0;i<n;++i)
				{
					tem=in.nextInt();
					if(tem>=3*p-2)
						++num;
					if(snum<s&&p!=1&&(tem==3*p-3||tem==3*p-4))
					{
						++num;
						++snum;
					}
				}
				out.write("Case #"+count+": "+num+"\r\n"); 
			}
			
			in.close(); 
			out.close();  
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
