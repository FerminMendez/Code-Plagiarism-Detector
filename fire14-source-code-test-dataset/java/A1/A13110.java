import java.io.*;
public class better {

	public static void main(String[] args) throws Exception
	{
		int i=0;
		FileReader fin=new FileReader("B-small-attempt0.in");
		BufferedReader br=new BufferedReader(fin);
		FileWriter fout=new FileWriter("Output12.in");
		BufferedWriter bw=new BufferedWriter(fout);
		int test=Integer.parseInt(br.readLine());
		while(i<test)
		{
			int count=trial(br.readLine());
			bw.write("Case #"+(i+1)+": "+count);
			bw.newLine();
			bw.flush();
			i++;
		}
	}
   static int trial(String str)
   {
	   int count=0;
	   String s[]=str.split(" ");
	   int N=Integer.parseInt(s[0]);
	   int S=Integer.parseInt(s[1]);
	   int P=Integer.parseInt(s[2]);
	   int score[]=new int[N];
	   int i=0;
	   while(i<N)
	   {
		   score[i]=Integer.parseInt(s[3+i]);
		   i++;
	   }
	   i=0;
	   while(i<N)
	   {
		   if(score[i]>=3*P-2)
			   {
			   count++;			   
			   }
		   else if(score[i]==(3*P-3)||score[i]==(3*P-4))
		   {
			   if(S>0 && score[i]!=0)
			   {
				   count++;
				   S--;
			   }
		   }			   
			   i++;
	   }
	   return count;
   }
}
