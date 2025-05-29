import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;


public class RecycleNumber_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/kushal/Downloads/C-small-attempt1.in"));
			PrintWriter pr = new PrintWriter("/Users/kushal/Desktop/recycle.out");
			String line = "";
			br.readLine();
			int start;
			int end;
			int count;
			int number = -1;
			int temp , p1, p2;
			String str;
			int z = 1;
			HashSet<String> hash = new HashSet<String>();
			ArrayList<Integer> digits;
			while((line = br.readLine()) != null)
			{
				start = Integer.parseInt(line.split(" ")[0]);
				end = Integer.parseInt(line.split(" ")[1]);
				digits = new ArrayList<Integer>();
				count = 0;
				hash.clear();
				for(int i=start; i<=end; i++)
				{
				
					number = i;
					//hash.add(i);
					
					if(i == 121)
					{
						//System.out.println(i+"kk");
					}
					digits = new ArrayList<Integer>();
					while(number > 0)
					{
						digits.add(number%10);
						number /= 10;
					}
					number = digits.get(digits.size() - 1);
					for(int j = digits.size() - 2 ;j >= 0; j--)
					{
						str = "" + digits.get(j);
						if(j == 0 )
						{
							p1 = digits.size() -1;
						}
						else
						{
							p1 = j - 1;
						}
						str += "" + digits.get(p1);
						while(true)
						{							
							if(p1 == 0)
							{
								p1 = digits.size() -1;
							}
							else
							{
								p1 = p1 - 1;
							}
							if(p1 == j)
							{
								break;
							}
							str += "" + digits.get(p1);
						}
						//System.out.print(str + "\t");
						if(!str.startsWith("0"))
						{
							temp = Integer.parseInt(str);
							if((temp < i) && (temp >= start) && (temp <= end))
							{
								if(!hash.contains(i+"_"+temp))
								{
									hash.add(i+"_"+temp);
									//System.out.println(i + " "+ count);
									//continue;
									count++;
								}
							}
						}
					}
					//System.out.println();
				}
				System.out.println("Case #"+z+": "+count);
				z++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
