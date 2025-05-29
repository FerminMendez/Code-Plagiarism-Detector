import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


public class C {
	

	ArrayList<String > result=new ArrayList<String>();
	
	public void op(String A,String B)
	{
		Hashtable<String , Boolean> tet=new Hashtable<String, Boolean>();
		long current_n;
		long current_m;
		int i_A=Integer.parseInt(A);
		long i_B=Integer.parseInt(B);
		long diff=i_B-i_A;
		long temp=i_A;
		String s;
		if(A.length()==1  && B.length()==1)
		{
			result.add(0+"");
			return;
		}
		for(int i=0;i<diff;i++)
		{
			current_n=temp;
			current_m=temp;
			s=current_m+"";
			for(int j=0;j<(current_n+"").length()-1;j++)
			{
				s=s.charAt(s.length()-1)+s.substring(0,s.length()-1);
				current_m=Integer.parseInt(s);
				if(current_m <= i_B && current_m > current_n && current_m >=i_A)
				{
					//System.out.println(current_n+"   "+current_m);
					tet.put(current_n+""+current_m, true);
				}
			}
			temp++;
		}
		//System.out.println(tet.size());
		result.add(tet.size()+"");
	}
	
	public void read_file() throws Exception {
		FileReader g = new FileReader("C-small-attempt0.in");
		BufferedReader br = new BufferedReader(g);
		int No_of_Cases = Integer.parseInt(br.readLine());
		String s;
		String [] tete;
		for(int i=0;i<No_of_Cases;i++)
		{
			s=br.readLine();									// ha2ra el lines hena 
			tete=s.split(" ");
			op(tete[0],tete[1]);
		}
		g.close();
		write_file();
	}
	public void write_file() throws IOException
	{
		BufferedWriter br=new BufferedWriter(new FileWriter("test1.txt"));
		for(int i=0;i<result.size();i++)
		{
			br.write("Case #"+(i+1)+": "+result.get(i));
			if(i!=result.size()-1)
			{
				br.newLine();
			}
		}
		br.close();
	}
	
	
	public static void main (String [] args) throws Exception
	{
		C t=new C();
		t.read_file();
	}

}
