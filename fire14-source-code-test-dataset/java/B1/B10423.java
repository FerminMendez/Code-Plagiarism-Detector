import java.io.*;
import java.util.*;
public class RecycledNumbers {
	public static void main(String[] args){
		try{
			Scanner scan = new Scanner(new File("C:/personal/InterviewResource/GoogleCode2012/recycled/C-small-attempt0.in"));
			BufferedWriter output = new BufferedWriter(new FileWriter(new File("C:/personal/InterviewResource/GoogleCode2012/recycled/output.txt")));
			boolean isFirstLine=true;
			int n =0;
			int linecount=0;
			while(scan.hasNextLine()){
				if(isFirstLine){
					isFirstLine=false;
					n= Integer.parseInt(scan.nextLine());
					continue;
				}
				
				String line = scan.nextLine();
				String[] vals = line.split(" ");
				String result="";

				linecount++;
				output.write("Case #"+Integer.toString(linecount)+": "+ getCount(Integer.parseInt(vals[0]), Integer.parseInt(vals[1])));
				output.newLine();
				
			}
			output.close();
			System.out.println("Done");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	public static String getCount(int a, int b){
		int count=0;
		TreeSet<String> repeats = new TreeSet<String>();
		for(int i=a; i<=b; i++){
			//int digits = getDigits(i);
			String astr = Integer.toString(i);
			int n = astr.length();
			for(int j=1; j<n; j++){
				
				String bstr = astr.substring(n-j,n) + astr.substring(0,n-j);
				
				if(isEqual(astr, bstr, b)){
					//System.out.println(astr+ " "+ bstr);
					//System.out.println(bstr);
					if(!repeats.add(astr+bstr)){
						//System.out.println("whoa");
					}
					
					count++;
				}
			}
		}
		String res = Integer.toString(repeats.size());
		return res; 	
	}
	
	public static boolean isEqual(String A, String B, int limit){
		boolean result = false;
		//String A = Integer.toString(a);
		//String B = Integer.toString(b);
		if(B.startsWith("0")) return false;
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		if(a==b || b>limit || b<=a) return false;
		
		char[] Achar = A.toCharArray();
		Arrays.sort(Achar);
		String Astr = new String(Achar);
		
		char[] Bchar = B.toCharArray();
		Arrays.sort(Bchar);
		String Bstr = new String(Bchar);
		
		if(Astr.equals(Bstr)){
			return true;
		}
		return false;
	}
	
	public static int getDigits(int x){
		int res=0;
		while (x>0){
			int z =x%10;
			if(z>0) res++;
			x=x/10;
		}
		return res;
	}
}
