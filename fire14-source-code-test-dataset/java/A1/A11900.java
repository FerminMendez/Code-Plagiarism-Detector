
import java.util.Scanner;


public class Dancer{
     private static int t;

     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         t=in.nextInt();
         in.nextLine();
//         System.out.println(t+" Cases");
         for (int i=0;i<t;i++){
        	 int n=in.nextInt();
        	 int s=in.nextInt();
        	 int p=in.nextInt();
        	 int t[]=Dancer.getTotalPoints(in,n);
        	 if(in.hasNextLine()){
        		 in.nextLine();
        	 }
        	 int y=Dancer.maxNumGooglers(s,p,t);
             System.out.print("Case #"+(i+1)+": "+y+"\n");
         }
    }

    public static int maxNumGooglers(int s,int p,int []t){
    	int limits[]=calcLimits(p);
//    	System.out.println(limits[0]+"-"+limits[1]);
    	int y=0;    	
    	for(int i=0;i<t.length;i++){
    		if(t[i]==0&&p>0){
    			continue;
    		}
    		if(t[i]>=limits[0]){
    			y++;
    		}
    		else{
    			if(t[i]>=limits[1]&&s>0){
    				s--;
    				y++;
    			}
    		}
    	}
    	return y;
    }
    
    public static int[] calcLimits(int p){
    	int limits[]=new int[2];
    	limits[0]=p+2*(p-1);
    	limits[1]=p+2*(p-2); 
    	if(limits[0]<0){
    		limits[0]=0;
    	} 
    	if(limits[1]<0){
    		limits[1]=0;
    	} 
    	return limits;
    }
    
    
    
    
     public static int[] getTotalPoints(Scanner in,int n){
    	 int[] array=new int[n];
    	 for(int i=0;i<n;i++){
    		 array[i]=in.nextInt();
//    		 System.out.println(array[i]);
    	 }    	 
    	 return array;
     }


}