import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class DancingGooglers {

	/**
	 * @param args
	 */
	
	
	public int maxDancer(int N,int S,int p,int score[])
	{
		int maxNo=0;
		int q=p-1;
		int A,B,C;
		for (int i = 0; i < N; i++) {
			int X=score[i];
			
			A=X/3;
			B=(X-A)/2;
			C=X-(A+B);
			//System.out.println("X="+X+"A="+A+"B="+B+"C="+C);
			if(A>=p || B>=p || C>=p)
				maxNo++;
			else
			{
				if(S>0 && X!=0)
				{
					if(A==q)
					{
						if(B==q || C==q)
						{
							maxNo++;
							S--;
						}
					}
					else
					{
						if(B==q && C==q)
						{
							maxNo++;
							S--;
						}
							
					}
				}
			}
				
			
			
		}
		
		
		//System.out.println(maxNo);
		return maxNo;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DancingGooglers dg=new DancingGooglers();
		
		FileInputStream fis = new FileInputStream("c:/small.txt");
        DataInputStream dis = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        
        FileWriter fstream = new FileWriter("c:/out.txt");
        BufferedWriter out = new BufferedWriter(fstream);
               
        
        String str=br.readLine();
        int[] score=new int[100];
        int T=Integer.parseInt(str);
        int maxNo=0;
        int S=0,p=0;
        int caseNo=1;
        int N=0;
        while( (str = br.readLine()) != null && T>0) 
        {
        	if(caseNo>1)
        		out.newLine();
        	
        	String[] line=str.split(" ");
        	
        	N=Integer.parseInt(line[0]);
        	S=Integer.parseInt(line[1]);
        	p=Integer.parseInt(line[2]);
        	
        	
        	for (int i = 3,j=0; i < line.length; i++,j++) {
				
        		score[j]=Integer.parseInt(line[i]);
			}
        	maxNo=dg.maxDancer(N,S, p, score);
        	
        	out.write("Case #"+caseNo+": "+maxNo);
        	

        	caseNo++;
        	T--;
        }
		
        //Close the output stream
        out.close();
		

	}

}
