import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class testC {

    public static void main(String args[]){
     
        
        
       int count=0;
       int A=1111;
       int B=2222;
       String str="";
       String a="";
       String b="";
       int n=0;
       int m=0;
       boolean flag=false;
       
       char s[] = ((B)+"").toCharArray();
       char t[];
       int digits = 0;
       List<Integer> list = new ArrayList<Integer>();
       try{
           FileReader fr = new FileReader("2.txt");
           BufferedReader br = new BufferedReader(fr);
           int size = Integer.parseInt(br.readLine());
           for(int loop=0;loop<size;loop++){
        	   count=0;
        	   flag=false;
        	   a="";
        	   b="";
        		 str= br.readLine();
        		 char arraychar[] = str.toCharArray();
        		 for(int mm=0;mm<str.length();mm++){
        			 if(arraychar[mm] == ' '){
        				 flag=true;
        				 continue;
        			 }
        			 if(!flag)
        				 a+=arraychar[mm];
        			 if(flag)
        				 b+=arraychar[mm];
        		 }
        		 A = Integer.parseInt(a);
        		 B = Integer.parseInt(b);
       for(int i=A;i<=B;i++)
       {
           s = ((i)+"").toCharArray();
           digits = s.length;
         
               t = new char[digits];
               for(int k = 0; k <digits; k++)
               {
                   
            	   t = findRecyclingNumber(s,k);
                   
            	   n =  Integer.parseInt(String.valueOf(t));
            	   if(n<=B && n>=A && n>i && !list.contains(n) && i>=A)
                   {
                        count++;
                       // System.out.println(i+" "+n);
                        list.add(n);
                   }
               }
               list.clear();
       }
       System.out.println("Case #"+(loop+1)+": "+count);
       //System.out.println("Case #"+(loop+1)+": "+count+"    For "+A+" "+B);
           }
       br.close();
       fr.close();
   
   }catch(IOException ex){
       ex.printStackTrace();
   }
      
}

	private static char[] findRecyclingNumber(char[] s,int digits) {
		// TODO Auto-generated method stub
		char t[] = new char[s.length];
		
		for(int i=0;i<=digits;i++){
			t[i] = s[s.length-digits-1+i];
		}
		int index=0;
		for(int i=digits+1;i<s.length;i++){
			t[i] = s[index++];
		}
		
		return t;
	}

}
