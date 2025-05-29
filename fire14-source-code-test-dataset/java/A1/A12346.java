package trupti;
import java.io.*;
import java.util.*;
public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	char c[];
		int count=0;
		try {
			FileOutputStream out=new FileOutputStream("out7.out");
			Scanner inFIle=new Scanner(new FileReader("B-small-attempt2.in") );
			int t=inFIle.nextInt();
			
			while (t!=0) {
				count++;
				int a=0,b=0;
				int n=inFIle.nextInt();
				int s=inFIle.nextInt();
				int p=inFIle.nextInt();
				int ti[]=new int[n];
				int m[][]=new int[n][3];
				int cn=0;
				for(int i=0;i<n;i++)
				{
					ti[i]=inFIle.nextInt();
					m[i][0]=ti[i]/3;
					m[i][1]=ti[i]/3;
					m[i][2]=ti[i]/3;
					//System.out.println(m[i][0]+" "+m[i][3]+" "+m[i][2]);
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
						/*if(a==2 & s>0)
							if((m[i][0]==m[i][1])&(m[i][1]==m[i][2]))
						{
							m[i][0]+=2;
							m[i][1]--;
							m[i][2]--;
							s--;
						}*/
						if(a==1 & s>0)
						{
							if((m[i][0]==m[i][1])&(m[i][1]==m[i][2]))
							{
								m[i][0]+=1;
								m[i][1]--;
							//	m[i][2]--;
								s--;
							}
							else
							{
								if((m[i][0]==m[i][1])&((m[i][1]-m[i][2])==1))
								{
									m[i][0]+=1;
									m[i][1]--;
								//	m[i][2]--;
									s--;
								}
							}
						}
					}
					System.out.println(m[i][0]);
					if(m[i][0]>=p)
						cn++;
				}
				
				
					out.write(("Case #"+count+": "+cn+"\n").getBytes());
					System.out.print("case #"+count+": "+cn+"\n");
				
				//System.out.println(str);
				t--;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
