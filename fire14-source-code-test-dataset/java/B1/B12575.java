package problem1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;





public class Problem1 {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        try {
             TextIO.readFile("L:\\Coodejam\\Input\\Input.txt");
        }
        catch (IllegalArgumentException e) {
              System.out.println("Can't open file ");
              System.exit(0);
         }
        
        FileOutputStream fout = new FileOutputStream("L:\\Coodejam\\Output\\output.txt");
        PrintStream ps=new PrintStream(fout);
        
        int cases=TextIO.getInt();

        for(int i=0;i<cases;i++){
            int counter=0;
            int num1=TextIO.getInt();
            int num2=TextIO.getInt();

            for(int j=num1;j<num2;j++){
                for(int k=j+1;k<num2+1;k++){
                    String A=j+"";
                    String B=k+"";
                    char x[]=A.toCharArray();
                    char y[]=B.toCharArray();  
                    if(isrecycled(x, y))counter++;
                }
            }
            ps.println("Case #"+(i+1)+": "+counter);
        }
       
    }
    

  public static void cShiftLeft(char[] x) {
        if (x.length == 0)
            return;
        
        char el = x[0];
        System.arraycopy(x, 1, x, 0, x.length - 1);
        x[x.length - 1] = el;
    }
  
  public static boolean isrecycled(char[] x,char[] y){
      if(x.length==y.length){
          for(int j=0;j<x.length;j++){
            cShiftLeft(x);
             boolean flag=true;
             for(int i=0;i<x.length;i++){
                 if(x[i]!=y[i])flag=false;
             }
             if(flag)return true;
          }
      }
      return false;
  }

}




