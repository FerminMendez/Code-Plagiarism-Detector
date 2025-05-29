import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 * @author MASTERMIND
 *
 */
public class Prog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr;
		try 
		{
			fr = new FileReader("C-small-attempt0.in");
			FileWriter f1 = new FileWriter("C-small.out");
			
			BufferedReader br = new BufferedReader(fr);
			
			int i=1;
			String s;
			StringBuffer strbuf = new StringBuffer();
			
			br.readLine();
			while((s = br.readLine())!=null)
			{
				
				int count = 0; 
				strbuf.delete(0, strbuf.length());
				StringTokenizer st = new StringTokenizer(s," ");
				int no1 = Integer.parseInt(st.nextToken());
				System.out.print(no1+"\t");
				int no2 = Integer.parseInt(st.nextToken());
				System.out.println(no2);
				int current = no1;
				while(current < no2)
				{
					String s1 = String.valueOf(current);
																		
					for(int next=current+1 ; next<=no2 ; next++)
					{
						//System.out.println(current+"   "+next);
						String s2 = String.valueOf(next);
						for(int j=1;j<s2.length();j++)
						{
							String p1 = s2.substring(s2.length()-j, s2.length());
							String p2 = s2.substring(0, s2.length()-j);
							String cat = p1+p2;
							//System.out.println(p1+"   "+p2+"   "+cat+"   "+s1);
							if(cat.equals(s1))
								count++;
						}
					}
					
				current++;
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
