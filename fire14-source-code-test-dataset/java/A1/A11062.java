import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Googlers {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		solve();
	}

	public static void solve() throws NumberFormatException, IOException
	{
		ArrayList<String> array=new ArrayList<String>();
		FileInputStream in = new FileInputStream("B-small-attempt0.in");
		Scanner s = new Scanner(in);
		String solved="";
		int num_cases=s.nextInt();
		int N=0,S=0,p=0;
		int R=0,x=0,y=0,z=0;		
		int count=0;
		
		
		for(int i=0;i<num_cases;i++)
		{
			N=s.nextInt();
			S=s.nextInt();
			p=s.nextInt();
			count=0;
			
			//System.out.println("N:"+N+" S:"+S+" p:"+p);
			//System.out.println("");
			 
			for(int j=0;j<N;j++){
				
				R=s.nextInt();
				for(int d=0;d<5;d++){
					x=(R+d)/3;					
					for(int k=0;k<2;k++)
					{
						z=(2*x-k-d)/2;
						y=z+k;
						if(x+y+z==R && (x>=0 && x<=10) && (y>=0 && y<=10) && (z>=0 && z<=10)){							
							if((x-y==2 || x-z==2 || y-z==2))
							{								
								if(x>=p || y>=p || z>=p){
									//System.out.println("x:"+x+" y:"+y+" z:"+z+" = "+R +"(S)");
									array.add("S"+i+j);
								}
							}else if(!(x-y==2 || x-z==2 || y-z==2)){
								if(x>=p || y>=p || z>=p){
									//System.out.println("x:"+x+" y:"+y+" z:"+z+" = "+R +"(R)");
									array.add("R"+i+j);
								}
							}
						}
					}
				}
			}
			for(int j=0;j<N;j++){
				if(array.contains("R"+i+j))
				{
					count+=(array.remove("R"+i+j) ? 1 : 0);
				}else if(array.contains("S"+i+j)){
					if(count<N && S>0)
					{
						count+=(array.remove("S"+i+j) ? 1 : 0);
						S-=1;
					}else{
						array.remove("S"+i+j);
					}
				}
			}
			
			solved+="Case #"+(i+1)+": "+count+"\n";
			System.out.println("Case #"+(i+1)+": "+count);
		}
		
		s.close();
		in.close();
		
		FileWriter fstream = new FileWriter("sollution.out");
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(solved);
		out.close();
		fstream.close();
	}

}
