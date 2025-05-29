import java.io.*;
import java.util.*;

public class Recycled {
	
	class Case{
		int[] limits = null;
		HashSet<String> counted = new HashSet<String>();
		public Case(int[] limits){
			this.limits = limits;
		}

		public int getResult(){
			int k = 0;
			for(int i = limits[0]; i<=limits[1]; i++){
				for(int j=1; j<(""+i).length(); j++){
						try{
							k = shift(i, j);					
							updateCount(limits[0], limits[1], i, k);
							updateCount(limits[0], limits[1], k, i);
						}
						catch(RuntimeException re){
							continue;
						}
				}
			}
			return counted.size();
		}

		public void updateCount(int A, int B, int n, int m){
			if((!counted.contains(n+","+m)) && ( A <= n && m > n && m <= B)){
				counted.add(n+","+m);
			}
		}

		public int shift(int i, int shiftby){
			String input = ""+i;
			int shifted = Integer.parseInt(input.substring(input.length()-shiftby) + input.substring(0,input.length()-shiftby));
			if((""+shifted).length() != input.length()){
				throw new RuntimeException("INVALIDSHIFT");
			}
			return shifted;
		}
	}

	public Recycled(String file){
		BufferedReader in = null;
		PrintWriter out = null;

		try{
		    in = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file+"/input.txt"))));
			out = new PrintWriter(new BufferedWriter(new FileWriter(file+"/output.txt")), true);

			int caseId = 1;
			int result = 0;
			String line = null;
			Case c = null;

			in.readLine(); //no of cases

			while ((line = in.readLine()) != null)   {
				c = new Case(getIntArray(line));
				result = c.getResult();
				System.out.println("Case #"+caseId+ ": "+result);
				out.println("Case #"+caseId+ ": "+result);

				caseId++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{ out.close(); } catch(Exception ignored){}
			try{ in.close(); } catch(Exception ignored){}
		}

	}

	public String[] getStringArray(String str){
		return str.split("\\s+");
	}

	public int[] getIntArray(String str){
		String[] sArray = getStringArray(str);
		int[] iArray = new int[sArray.length];
		for(int i=0; i<sArray.length; i++){
			iArray[i] = Integer.parseInt(sArray[i]);
		}

		return iArray;
	}
		
	public static void main(String args[]) throws Exception {
		Recycled obj = new Recycled(args[0]);
	}
	
}