package Jam;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class ProblemC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProblemC p = new ProblemC();
		p.readAndOutput();
	}
	
	public int cmp(byte[] s1,int start,byte[]s2)
	{
		int tmp = 0;
		for( int i = 0;i<s2.length;i++ )
		{
			tmp = (i + start )%s1.length;
			if( s1[tmp] == s2[i] )
				continue;
			return s1[tmp] - s2[i];
		}
		return 0;
	}
	byte min[];
	byte max[];
	HashMap<String,Integer> hm;
	public void print(byte[] tmp,int st)
	{
		StringBuffer sb = new StringBuffer();
		for( int i = 0;i<tmp.length;i++ )
		{
			sb.append((char)tmp[i]);
		}
		for( int i = 0;i<tmp.length;i++ )
		{
			sb.append((char)tmp[(i + st )%tmp.length]);
		}
		String x = sb.toString();
		hm.put(x, 1);
	}
	
	public int l_cal(byte[] tmp,int pos,int st)
	{
		
		if( pos >= tmp.length )
		{
			if( st == -1 )
				return 0;
			if( cmp(tmp,0,min) >=0 && cmp(tmp,0,max) <=0 && cmp(tmp,st,min) >=0 && cmp(tmp,st,max) <=0 )
			{
				print(tmp,st);
				return 1;
			}else
			{
				return 0;
			}
		}
		int sum = 0;
		byte k;
		if( st == -1 )
		{
			k = (byte) (tmp[0] + 1);
			for(;k<=max[0];k++)
			{
				tmp[pos] = k;
				sum += l_cal(tmp,pos+1,pos);
			}
		}
		for( k = '0'; k <= '9'; k++ )
		{
			tmp[pos] = k;
			sum += l_cal(tmp,pos+1,st);
		}
		return sum;
	}
	
	public int m_cal(byte[] tmp,int pos,int st)
	{
		
		if( pos >= tmp.length )
		{
			if( st == -1 )
				return 0;
			if( cmp(tmp,st,tmp) > 0 && cmp(tmp,0,min) >=0 && cmp(tmp,0,max) <=0 && cmp(tmp,st,min) >=0 && cmp(tmp,st,max) <=0 )
			{
				print(tmp,st);
				return 1;
			}else
			{
				return 0;
			}
		}
		int sum = 0;
		byte k;
		if( st == -1 )
		{
			tmp[pos] = tmp[0];
			sum += m_cal(tmp,pos+1,pos);
		}
		for( k = '0'; k <= '9'; k++ )
		{
			tmp[pos] = k;
			sum += m_cal(tmp,pos+1,st);
		}
		return sum;
	}
	public int cal()
	{
		int sum = 0;
		byte tmp[] = new byte[min.length];
		
		int range = max[0] - min[0] + 1;
		int len = min.length;
		
		hm = new HashMap<String,Integer>();
		
		for( int i = 0; i<range;i++ )
		{
			tmp[0] = (byte) (min[0] + i);
			sum += l_cal(tmp,1,-1);
			sum += m_cal(tmp,1,-1);
		}
		return hm.size();
	}
	
	public String doChange(String in)
	{
		String[] test = in.split(" ");
		min = test[0].getBytes();
		max = test[1].getBytes();
		return Integer.toString(cal());
	}
	
	public void readAndOutput()
	{
		File file = new File("C-small-attempt0.in");
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
