import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class Jam2 
{
	
	public static String dancers(int g, int s, int best, List<Integer> totals){
		
		int couldbe = 0;
		int s_left = s;
		for(int i=0; i < totals.size(); i++){
			int total = totals.get(i);
			
			int check = total - (best*3);
			
			//p("check: " + check + " best: " + best + " total: " + total);
			
			if(total < best)
				continue;
			if(check >= -2){
				couldbe++;
				continue;
			}
			if((check ==-4 || check==-3) && s_left>0){
				couldbe++;
				s_left--;
			}
				
			
					
		}
		
		
		return ""+couldbe;
	}
	
	public static String solveLine(String in){
		String[] s = in.split(" ");
		int dancers = Integer.parseInt(s[0]);
		int surp = Integer.parseInt(s[1]);
		int bestresult = Integer.parseInt(s[2]);
		List<Integer> totals = new ArrayList<Integer>();
		for(int i=3; i<s.length;i++){
			totals.add(Integer.parseInt(s[i]));
		}
		//System.out.println(totals);
		
		return dancers(dancers, surp, bestresult, totals);
	}
	
	public static void solveStrings(String[] input)
	{		
		for(int i=1; i<input.length; i++){
			String out = "Case #" + i + ": " + solveLine(input[i]);
			System.out.println(out);
		}
		
	}
	
	public static String[] getLines(String fileName)
	{
		String[] lines  = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			int nxtchar = 0;
			StringBuffer sb = new StringBuffer();
			while((nxtchar=fis.read())!=-1){
				sb.append((char)nxtchar);
			}
			lines = sb.toString().split("\r\n|\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;		
	}
	
	public static void main(String[] args) 
	{
		solveStrings(getLines(args[0]));
	}
	
	public static void p(Object a){
		System.out.println(""+a);
	}

}
