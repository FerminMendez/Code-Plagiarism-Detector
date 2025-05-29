package jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Dance {
	
	public static void main(String[] x)throws IOException{
        File file=new File("A.in");
        Writer output = null;
        File out=new File("A.out");
        output = new BufferedWriter(new FileWriter(out));
        BufferedReader fileIn = new BufferedReader(new FileReader(file));
        String fileLine,delims,outs;
        String[] tokens;
        int cases,num,surprise,goal,ans,indA,indB,i;
        int [] items;
        
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
        num = Integer.parseInt(tokens[0]);
        surprise = Integer.parseInt(tokens[1]);
        goal = Integer.parseInt(tokens[2]);
        items = new int[tokens.length-3];
        transfer(items,tokens);
        ans = solve(goal,surprise,items);
        output.write(Integer.toString(ans));
        output.write("\r\n");
        System.out.println(ans);
        }
        output.close();
  }

	
private static int solve(int goal, int surprise, int[] items) {
		int rej,acc,i,out,s;
		s = surprise;
		out = 0;
		rej = 3*goal-4;
		if(rej<1)
		{
			rej = 1;
		}
		acc = 3*goal-3;
		for(i=0;i<items.length;++i)
		{
			if(items[i]>acc)
			{
				++out;
			}
			else if(items[i]>=rej&&s>0)
			{
				++out;
				--s;
			}
			else
			{
				
			}
		}
		return out;
	}


private static  void transfer(int[] items, String[] tokens) {
		
		int size = tokens.length;
		int i = 3;
		for(i = 3;i<size;++i)
		{
			items[i-3] = Integer.parseInt(tokens[i]);
		}
		return;
	}
}
