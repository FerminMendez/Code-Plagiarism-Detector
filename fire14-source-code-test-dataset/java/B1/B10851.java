import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecycleNumbers {
    private static int T,m,A,B,a,b,k,count=0;
  
   private static int[] M;
    
    
      public static void main (String args[]){
        
        try{
            Scanner sc=new Scanner(new File("input.txt"));
            FileWriter f0=new FileWriter("output.txt");
            T=sc.nextInt();
            for(int j=1;j<=T;j++){
                count=0;
            A=sc.nextInt();
            B=sc.nextInt();
          
            k=Integer.toString(A).length();
            for(int i=A;i<B;i++){
                for(int l=1;l<k;l++){
                        b= (int) (i/Math.pow(10,l)+(i%Math.pow(10,l))*Math.pow(10,k-l));
                        if( b > i && b<= B && Integer.toString(b).length()==Integer.toString(i).length()){
                        count++; //System.out.println(i+" "+b);
                        }
                }  
            }
            f0.write("Case #"+j+": "+count+"\n");
            }
             f0.close();
        }catch(FileNotFoundException fnfe){
            System.err.println(fnfe);
        }catch(IOException ioe){
            System.out.println(ioe);
                    
        }
}
}
