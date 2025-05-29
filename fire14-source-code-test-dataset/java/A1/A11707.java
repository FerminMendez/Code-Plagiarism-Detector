import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;



public class test1 {
	ArrayList<String > result=new ArrayList<String>();
	
	Hashtable<Character, Character> h=new Hashtable<Character, Character>();
	int count =0;
	
	public void read_file() throws Exception {
		FileReader g = new FileReader("B-small-attempt0.in");
		BufferedReader br = new BufferedReader(g);
		int No_of_Cases = Integer.parseInt(br.readLine());
		String s;
		for(int i=0;i<No_of_Cases;i++)
		{
			s=br.readLine();									// ha2ra el lines hena 
			solve2(s);
		}
		g.close();
		write_file();
	}
	
	public void solve2(String s)
	{
		String [] g=s.split(" ");
		int googleres=Integer.parseInt(g[0]);
		int sur=Integer.parseInt(g[1]);
		int target=Integer.parseInt(g[2]);
		if(target==0)
		{
			result.add(g.length-3+"");
			return;
		}
		int min_target=target*3-4;;
		int max_target=target*3-2;
		int counta=0;
		int countb=0;
		int temp;
		for(int i=3;i<g.length;i++)
		{
			temp=Integer.parseInt(g[i]);
			if (temp!=0 || target!=1)
			{
				if(temp>=min_target)
				{
					if(temp >=max_target)
					{
						counta++;
					}else
					{
						countb++;
					}
				}
			}
		}
		if(countb<sur)
		{
			counta+=countb;
		}else
		{
			counta+=sur;
		}
		result.add(counta+"");
		
	}
	
	
	
	public void Equal(String s1,String s2)
	{
		for (int i=0;i<s1.length();i++)
		{
			if(h.get(s1.charAt(i))==null)
			{
				h.put(s1.charAt(i), s2.charAt(i));
			}
		}
	}
	
	public void Main1() throws Exception
	{
		tet1();
		read_file();
		write_file();
	}
	
	public String op1(String s)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++)
		{
			sb.append(h.get(s.charAt(i)));
		}
		return sb.toString();
	}
	
	public void tet1()
	{
		String [] s={"ejp mysljylc kd kxveddknmc re jsicpdrysi","rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd","de kr kd eoya kw aej tysr re ujdr lkgc jv"};
		String [] s1={"our language is impossible to understand","there are twenty six factorial possibilities","so it is okay if you want to just give up"};
		for (int i=0;i<3;i++)
		{
			Equal(s[i], s1[i]);
		}
		h.put('z', 'q');
		h.put('q', 'z');
		System.out.println(h.size());
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
		test1 t=new test1();
//		t.read_file();
//		t.write_file();
		t.read_file();
	}
	
}
