
import java.util.*;
import java.io.*;

public class RecycledNum{
	public static LinkedList<String> routeList;
	public static LinkedList<String> routeForOList;
	public static LinkedList<String> routeForBList;
	
	public static List<Integer> processed=new ArrayList<Integer>();
	
	public static void main(String[] args){
		
		String fn = "C:\\Users\\Ashu\\Desktop\\C-small-attempt0.in";
		String fnOut = toFnOut(fn);
		String out=null;
		try{
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new FileReader(fn));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fnOut));
			String line = null;
			int NCase = Integer.valueOf(br.readLine());
			int start=0;
			int end=0;
					
			for(int icase=0;icase<NCase;icase++){
				line=br.readLine();
				StringTokenizer st=new StringTokenizer(line);
				if(st.hasMoreTokens()){
					start=Integer.valueOf(st.nextToken());
					end=Integer.valueOf(st.nextToken());
				}
				
				int result = findNumbers(start,end);
				out = "Case #"+(icase+1)+": "+result;
				System.out.println(out);
				bw.write(out,0,out.length());
				bw.newLine();
			  
			}
			
			br.close();
			bw.close();
			//stdin.close();
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	
	static int findNumbers(int start, int end){
		int result =0;
		int m=0;
		start=start>10?start:12;
		for(int i=start;i<=end;i++){
			List<Integer> digits=getDigits(i);
			
			for(int j=1;j<digits.size();j++){
				
				//m =moveDigits(j,digits.size(),digits);
				m=getMovedNumber(digits,j);
					
				System.out.println("n="+i+" m="+m);
				if(countNoOfNonZeroDigits(i)!=countNoOfNonZeroDigits(m)){
					continue;
				}else if(i>=start && i<m&& m<=end){
					System.out.println("Recyled pair found");
					result++;
				}
			}
	}
		return result;
  }
	
	
	static int getMovedNumber(List<Integer> digits, int digitsMoved){
		int result=0;
		int size=digits.size();
		int num1=0,num2=0;
		for(int i=digitsMoved,j=1;i>0;i--,j++){
			num1=num1+ digits.get(i-1)*(int)Math.pow(new Double(10), new Double(digits.size()-j));
		}
		
		for(int i=size-1;i>=digitsMoved;i--){
			num2=num2+ digits.get(i)*(int)Math.pow(new Double(10), new Double(i-digitsMoved));
		}
		
		result=num1+num2;
		return result;
	}
	
	/**
	 * 
	 * @param noOfDigits no of digits to be moved
	 * @param num - total no of digits
	 * @param digits - list of digits 
	 * @return
	 */
	static int moveDigits(int moveDigits, int totalDigits,List<Integer> digits){
		int result = 0;
		if(moveDigits==1){
			if(totalDigits==2){
				result = digits.get(0)*10+digits.get(1);
			}
			
			
		}else if(moveDigits==2){
			
			
		}else if(moveDigits==3){
			
		}
		return result;
	}
	static List<Integer> getDigits(int num){
		List<Integer> digits = new ArrayList<Integer>();
		int t;
		while(num>0)
		{
		t=num%10;
		digits.add(t);
		num=num/10;
		}
		
		return digits;
	}
	
	static int countNoOfNonZeroDigits(int num){
		int t;
		int count =0;
		while(num>0)
		{
		t=num%10;
		if(t!=0){
			count=0;
		}else{
			count++;
		}
		num=num/10;
		}
		
		return count;
	}
	static String toFnOut(String fn){
		if(fn.lastIndexOf('.')!=-1){
			return fn.substring(0,fn.lastIndexOf('.'))+".out";
		}else return fn + ".out";
	}
}
