import java.io.*;
import java.util.StringTokenizer;

public class q2
{
	public static int spl,threshold,players,output;
	public static void main(String []args) throws IOException
	{
		
		 PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
	   BufferedReader br=new BufferedReader(new FileReader("input.txt"));
		
		int arr[]=new int[107];
		 int limit=Integer.parseInt(br.readLine());
		 String x1;
		 String word="";
		 for(int li=1;li<=limit;li++)
	   {
	   	   x1=br.readLine();
	   	  int j=0;
	   	   StringTokenizer st =new StringTokenizer(x1);
	   	   while (st.hasMoreElements()) {

              String token = st.nextElement().toString();
               arr[j]=Integer.parseInt(token);
                 j++;
           }
            
            spl=arr[1];
            threshold=arr[2];
            players=arr[0];  
	   	    output=find(arr);
	        pw.println("Case #"+li+": "+output);
	   arr=new int[107];
	   }
	    pw.close();
  }
	
	public static int find(int arr[])
	{
		int a=0,b=0,c=0;
		int op=0;	
		for(int i=3;i<(players+3);i++)
		{
		   int num=arr[i];
		   int num2=num;
		   boolean check=true;
	  	a=num/3;
	     b=a;
		c=a;
		int diff=num2-(a*3);
			
		if(diff==0)
		{   if(a>=threshold||b>=threshold||c>=threshold)
	 	      op++;
	 	else
	 	 { 	 	
	 	 	if(spl>0)
	 	 	{
	 	 	 	if((a-1)>0)
	 	      	{
	 	 	 	 	if((a-1)>=threshold||b>=threshold||(c+1)>=threshold)
	 	             {
	 	             	  op++;
	 	                   spl--;
	 	              }
	 	         }
	 	      }
	 	   }
	 	 
		 }
		
		 if(diff==1)
		 { 	 if((a+1)>=threshold||b>=threshold||c>=threshold)
	 	       {      op++;
	 	        }
	 	       
	 	       else
	 	 { 	 	
	 	 	if(spl>0)
	 	 	{
	 	 	  	 	if((a+1)>=threshold||(b-1)>=threshold||(c+1)>=threshold)
	 	             {
	 	             	  op++;
	 	                   spl--;
	 	              }
	 	         
	 	      }
	 	   } 
	 	        
	 	 }
	     if(diff==2)
	     {	 
	 	      if((a+1)>=threshold||(b+1)>=threshold||c>=threshold){
	 	  	 op++;
	 	 }
	 	 else
	 	 { 	if(spl>0)
	 	 	{
	 	 	   if((a+2)>=threshold||b>=threshold||c>=threshold)
	 	        { 
	 	          op++;
	 	           spl--;
	 	      }
	 	   }
	 	 }
	 	 
	 	 }
	 	 }
	     
	    return op;
	}
}