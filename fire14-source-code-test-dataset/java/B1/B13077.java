import java.io.*;
import java.util.*;


public class RecyledNumbers {
	public static void main(String args[]) throws IOException{
	   	 Scanner scan=new Scanner(new File("C-small-attempt0.in"));
	   	 PrintWriter pw=new PrintWriter(new File("result.txt"));
	   	 int caseNum=Integer.parseInt(scan.nextLine());
	   	 for(int i=1;i<=caseNum;i++){
	   		 String a=scan.nextLine();
	   		 //System.out.println(a);
	   		 int result=0;
	   		 String[] temp=new String[2];
	   		 temp=parseString(a);
	   		 //System.out.println(temp);
	   		 String A=temp[0];
	   		 String B=temp[1];
	   		 for(int j=Integer.parseInt(A);j<Integer.parseInt(B);j++){
	   			 String t=""+j;
	   			 result=result+judgeRecycle(t,B);
	   		 }
	   		 pw.println("Case #"+i+": "+result);
	   		 System.out.println("Case #"+i+": "+result);
	   	 }
	   	 pw.flush();
	   	 pw.close();
	    }
		
		public static String[] parseString(String s){
			String[] result=new String[2];
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)==' ') {
					result[0]=s.substring(0, i);
					//System.out.println(result[0]);
					result[1]=s.substring(i+1, s.length());
					//System.out.println(result[1]);
					break;
				}
				if(i==s.length()-1) result[0]=s;
				result[1]=s.substring(i, s.length());
			}
			//System.out.println(result);
			return result;
		}
		
		public static int judgeRecycle(String toBeJudged, String B){
			
			List<Integer> movedNum=new ArrayList<Integer>();
			for(int i=1;i<toBeJudged.length();i++){
				int temp=Integer.parseInt(toBeJudged.substring(i, toBeJudged.length())+toBeJudged.substring(0, i));
				if(temp>Integer.parseInt(toBeJudged) && temp<=Integer.parseInt(B)) {
					if(!movedNum.contains(temp)) movedNum.add(temp);
					System.out.println(toBeJudged+" "+temp);
				}
			}
			return movedNum.size();
		}
}
