import java.util.*;
import java.io.*;

public class DancingWithTheGooglers {
	public static void main(String args[]) throws IOException{
   	 Scanner scan=new Scanner(new File("B-small-attempt2.in"));
   	 PrintWriter pw=new PrintWriter(new File("result.txt"));
   	 int caseNum=Integer.parseInt(scan.nextLine());
   	 for(int i=1;i<=caseNum;i++){
   		 String a=scan.nextLine();
   		 System.out.println(a);
   		 int result=0;
   		 String[] temp=new String[2];
   		 temp=parseString(a);
   		 //System.out.println(temp);
   		 int pNum=Integer.parseInt(temp[0]);
   		 a=temp[1];
   		 temp=parseString(a);
   		 int surpriseNum=Integer.parseInt(temp[0]);
   		 System.out.println(surpriseNum);
   		 a=temp[1];
   		 temp=parseString(a);
   		 int bestScore=Integer.parseInt(temp[0]);
   		 a=temp[1];
   		 for(int j=0;j<pNum;j++){
   			 temp=parseString(a);
   			 int score=Integer.parseInt(temp[0]);
   			 a=temp[1];
   			 if(score>=(bestScore-1)*3+1 && score>=bestScore) result++;
   			 else if(score>=(bestScore-2)*3+2 && surpriseNum>0 && score>=bestScore){
   				 result++;
   				 surpriseNum--;
   			 }
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
}
