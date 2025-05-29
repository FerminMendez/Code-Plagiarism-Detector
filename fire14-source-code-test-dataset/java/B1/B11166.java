package jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Recycled {
	
	public static void main(String[] x)throws IOException{
        File file=new File("A.in");
        Writer output = null;
        File out=new File("A.out");
        output = new BufferedWriter(new FileWriter(out));
        BufferedReader fileIn = new BufferedReader(new FileReader(file));
        String fileLine,delims,outs;
        String[] tokens;
        int cases,lower,higher,surprise,goal,ans,indA,indB,i;
        int [] items;
        int [] dat = new int[2000001];
        for(i=0;i<2000001;++i)
        {
        	dat[i]=-1;
        }
        fileLine=fileIn.readLine();
        cases = Integer.parseInt(fileLine);
        delims = "[ ]+";
        System.out.println("Cases = "+cases);
        for	(i=0;i<cases;++i)
        {
        output.write("Case #");
        output.write(Integer.toString(i+1));
        output.write(": ");
    	fileLine=fileIn.readLine();
    	tokens = fileLine.split(delims);
        lower = Integer.parseInt(tokens[0]);
        higher = Integer.parseInt(tokens[1]);
        ans = solveb(lower,higher,dat);
    
        output.write(Integer.toString(ans));
        output.write("\r\n");
        System.out.println(ans);
        ans = solve(lower,higher,dat);
        System.out.println(ans);
        }
       // prt(dat,2222);
        output.close();
  }

	private static void prt(int[] dat, int i) {
		int j  =0;
		while(j<=i)
		{
			System.out.println(" dat"+j+" :"+dat[j]);
			++j;
		}
		
	}

	private static int solve(int lower, int higher, int[] dat) {
		return (get(higher,dat)-get(lower,dat));
		
	}

	private static int solveb(int lower, int higher, int[] dat) {
		int count = 0;
		int [] gar;
		int maincount = 0;
		int i = 0;int j =0;
		int temp =0;
		int dig = digits(higher);
		int [] arr = new int[higher-lower+1];
		for(i=lower;i<=higher;++i)
		{
			if(arr[i-lower]==0)
			{
				count = 1;
				gar = new int[dig-1];
				for(j=0;j<dig-1;++j)
				{
					temp=(i/(int)Math.pow(10,(j+1)))+(i%(int)Math.pow(10,(j+1))*(int)Math.pow(10,(dig-(j+1))));
					if(temp<=higher&&temp>=lower&&temp!=i&&notin(gar,temp))
					{
						arr[temp-lower]=1;
						++count;
						gar[j]=temp;
					}
				}
			//	System.out.println("i is "+i);
			//	System.out.println("count is "+count);
				maincount = maincount+comb(count,2);
			//	System.out.println("maincount is "+maincount);
			}
		}
		
		return maincount;
		
	}
	
	private static int comb(int count, int i) {
		if(count<i)
		{
			return 0;
		}
		else
		{
			return (fact(count)/(fact(i)*fact(count-i)));
		}
	}

	private static int fact(int i) {
		if(i==0)
		{	
			return 1;
		}
		else
		{
			return i*fact(i-1);
		}
		
	}

	private static int get(int val, int[] dat) {
		if(dat[val]!=-1)
		{
			return dat[val];
		}
		else if(val==0)
		{
			return 0 ;
		}
		else
		{
			dat[val]= find(val)+get(val-1,dat);
			return dat[val];
		}
		
		
	}

	private static int find(int val) {
		int dig,i,temp,count;
		int [] garb;
		dig = digits(val);
		count=0;
		if (dig==1)
		{
			return 0;
		}
		else
		{
			garb = new int[dig-1];
			for(i=0;i<dig-1;++i)
			{
				temp=(val/(int)Math.pow(10,(i+1)))+(val%(int)Math.pow(10,(i+1))*(int)Math.pow(10,(dig-(i+1))));
				if(temp<val&&digits(temp)==dig&&notin(garb,temp))
				{
		//			System.out.println("pair :"+val+" , "+temp);
					garb[i]=temp;
					++count;
				}				
			}
			return count;
		}
	}

	private static boolean notin(int[] garb, int temp) {
		int i =0;
		for (i=0;i<garb.length;++i)
		{
			if(temp==garb[i])
			{
				return false;
			}
		}
		return true;
	}

	private static int digits(int val) {
		
		if(val/10==0)
		{
			return 1;
		}
		else
		{
			return digits(val/10)+1;
		}
		
	}
	
	
}
