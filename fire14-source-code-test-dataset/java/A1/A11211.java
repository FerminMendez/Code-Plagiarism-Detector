package Jam;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class ProblemB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProblemB p = new ProblemB();
		p.readAndOutput();
	}
	public String doChange(String in)
	{
		StringBuffer sb = new StringBuffer();
		String[] tmp = in.split(" ");
		int count = Integer.parseInt(tmp[0]);
		int sp = Integer.parseInt(tmp[1]);
		int max = Integer.parseInt(tmp[2]) - 1;
		//int score[] = new int[count];
		int score = 0,t=0;
		int i=3;
		int sum = 0;
		for( ; i < count+3;i++ )
		{
			score = Integer.parseInt(tmp[i]);
			t = score%3;
			if( t == 0 )
			{
				t = score / 3;
				if( t > max )
				{
					sum++;
				}else if(sp>0&&t>0&&t+1>max)
				{
					sp--;
					sum++;
				}
			}else if( t == 1 )
			{
				t = (score + 2 )/3;
				if( t > 1 && t > max )
				{
					sum++;
				}
			}else
			{
				t = (score + 1)/3;
				if( t > max )
				{
					sum++;
				}else if( sp > 0 && t > 0 && t+1 > max )
				{
					sp--;
					sum++;
				}
			}
			
			
		}
		
		System.out.println(sum);
		sb.append(sum);
		return sb.toString();
	}
	
	public void readAndOutput()
	{
		File file = new File("B-small-attempt0.in");
		File out = new File("out.txt");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		int i = 0;
        try {
        	reader = new BufferedReader(new FileReader(file));
        	writer = new BufferedWriter(new FileWriter(out));
            String temp;
            while ((temp = reader.readLine()) != null) {
            	
            	if( i == 0 )
            	{
            		i = 1;
            		continue;
            	}
        		writer.write("Case #" + i +": " + doChange(temp)+"\n");
        		i++;
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}

}
