import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;


public class Second {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr;
		try 
		{
			fr = new FileReader("B-small-attempt5.in");
			FileWriter f1 = new FileWriter("B-small.out");
			
			BufferedReader br = new BufferedReader(fr);
			
			int i=1;
			String s;
			StringBuffer strbuf = new StringBuffer();
			
			br.readLine();
			while((s = br.readLine())!=null)
			{
				int count=0;
				strbuf.delete(0, strbuf.length());
				StringTokenizer st = new StringTokenizer(s," ");
				
				int no = Integer.parseInt(st.nextToken());
				int buf = Integer.parseInt(st.nextToken());
				int max = Integer.parseInt(st.nextToken());
				
				System.out.println(no+"  "+buf+"   "+max);
				
				
				for(int j=0;j<no;j++)
				{
					int cur = Integer.parseInt(st.nextToken());
				
					if(cur>=max)
					{	
						if(cur >= ((max*3)-2))
						{
							count++;
							continue;
						}else if((cur+4 >= (max*3)) && buf>0)
						{
							buf--;
							count++;
						}
					}	
						
					
				}
				
				strbuf.insert(0, "Case #"+i+": "+count+"\n");
				i++;
			
				char[] buffer = new char[strbuf.length()];
				s = strbuf.toString();
				System.out.println(s);
				s.getChars(0, s.length(), buffer, 0);
				
				f1.write(buffer);
			}
			f1.close();
			fr.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
