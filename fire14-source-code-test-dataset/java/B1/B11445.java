import java.io.FileInputStream;
import java.util.HashSet;


public class Jam3 
{
	
	public static String recycled(int start, int end){
			
		int cnt = 0;
		HashSet<String> seenit = new HashSet<String>();
		for(int i=start; i <= end; i++){
			String x = ""+i;
			cnt += permutationsInRange(i, start , end, seenit);
		}
		return ""+cnt;
	}
	
	public static String rev(String in){
		//p("in: " + in);
		StringBuffer sb = new StringBuffer();
		for(int i=in.length()-1; i>=0; i--){
			sb.append(in.charAt(i));
		}
		String out = sb.toString();
		//p("o: " + out);
		return out;
	}
	
	public static String solveLine(String in){
		String[] s = in.split(" ");
		int start = Integer.parseInt(s[0]);
		int end   = Integer.parseInt(s[1]);

		//System.out.println(totals);
		
		return recycled(start, end);
	}
	
	public static void solveStrings(String[] input)
	{		
		for(int i=1; i<input.length; i++){
			String out = "Case #" + i + ": " + solveLine(input[i]);
			System.out.println(out);
		}		
	}
	
	public static int permutationsInRange(int in, int min, int max, HashSet<String> seenit)
	{		
		int count = 0;
		p("in: " + in +  " min_s " + min + " " + max);
		String in_s = ""+in;
		StringBuffer sb = new StringBuffer(in_s);
		String rev = rev(sb.toString());
		for(int i=0; i <in_s.length()-1; i++){
			char first = sb.charAt(0);
			sb.replace(0, 1, "").append(first);
			int test = Integer.parseInt(sb.toString());
			p("p: " + sb.toString());
							
			if(sb.toString().startsWith("0")){
				continue;
			}
			int low = Math.min(in, test);
			int hi = Math.max(in, test);
			if(seenit.contains(low+"_"+hi)){
				continue;
			}
			if(test==in)
				continue;
			if(test>=min && test<=max){
				p("match: " + test + " in: " + in);
				seenit.add(low + "_" + hi);				
				count++;
			}
		}
		return count;
		
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
		//System.out.println(""+a);
	}

	public static void p2(Object a){
		System.out.println(""+a);
	}
	
}
