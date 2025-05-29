package shakti;

import java.io.*;
import java.util.*;
public class DancingG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			File file = new File("B-small-attempt0.in");
			FileOutputStream out=new FileOutputStream("output.out");
			Scanner in=new Scanner(new FileReader(file) );
			int t=in.nextInt();
			
			while (t!=0) {
				count++;
				int a=0;
				int n=in.nextInt();
				int s=in.nextInt();
				int p=in.nextInt();
				int ti[]=new int[n];
				int m[][]=new int[n][3];
				int cn=0;
				for(int i=0;i<n;i++)
				{
					ti[i]=in.nextInt();
					m[i][0]=ti[i]/3;
					m[i][1]=ti[i]/3;
					m[i][2]=ti[i]/3;
					if((ti[i]%3)==2)
					{
						m[i][0]++;
						m[i][1]++;
					}
					if((ti[i]%3)==1)
						m[i][0]++;
					
					if((m[i][0]<p) &(m[i][0]>=1))
					{
						a=p-m[i][0];
						if(a==1 & s>0)
						{
							if((m[i][0]==m[i][1])&(m[i][1]==m[i][2]))
							{
								m[i][0]+=1;
								m[i][1]--;
								s--;
							}
							else
							{
								if((m[i][0]==m[i][1])&((m[i][1]-m[i][2])==1))
								{
									m[i][0]+=1;
									m[i][1]--;
									s--;
								}
							}
						}
					}
					if(m[i][0]>=p)
						cn++;
				}
				
				
					out.write(("Case #"+count+": "+cn+"\n").getBytes());
					System.out.print("case #"+count+": "+cn+"\n");
					t--;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
