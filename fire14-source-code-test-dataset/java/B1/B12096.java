import java.io.*;

public class Recycle {
	public void cal(String filename) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bar.txt")));
		int count = 1;
		String s = in.readLine();
		int all = Integer.parseInt(s);
		while((s = in.readLine()) != null)
		{
			int result = 0;
			if(count > all)
			{
				System.out.println("error");
				break;
			}
			String[] elements = s.split(" ");
			int start = Integer.parseInt(elements[0]);
			int end = Integer.parseInt(elements[1]);
			for(int i = start; i < end; i++)
			{
				for(int j = i + 1; j <= end; j++)
				{
					if(isRecycle(i,j))
					{
						result = result + 1;
					}
				}
			}
			out.println("Case #" + count +": " + result);
			count = count + 1;
		}
		out.close();
	}
	
	public Boolean isRecycle(Integer a, Integer b)
	{
		String a_string = a.toString();
		String b_string = b.toString();
		if(a_string.length() != b_string.length())
			return false;
		for(int i = 1; i < a_string.length(); i++)
		{
			String temp = a_string.substring(i, a_string.length());
			temp = temp.concat(a_string.substring(0, i));
			if(temp.equals(b_string))
				return true;
		}
		return false;			
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Recycle r = new Recycle();
		r.cal("C-small-attempt0.in");
	}

}
