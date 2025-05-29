package problem1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;





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
        int googlers=0,surprising=0,least=0;
        for(int i=0;i<cases;i++){
            int counter=0;
            googlers=TextIO.getInt();
            surprising=TextIO.getInt();
            least=TextIO.getInt();
            int score[]=new int[googlers];
            for(int j=0;j<googlers;j++){
                score[j]=TextIO.getInt();
                 }
            
            
            
            
            Arrays.sort(score);
            int temp=0;
            int sup[]=new int[surprising];
            
          for(int j=0;j<googlers && surprising>0;j++){
               if(biggestNS(score[j])<least && biggestS(score[j])==least){
                   surprising--;
                   counter++;
                }
               }
           
            for(int j=0;j<googlers;j++){
                if(surprising==0)temp=biggestNS(score[j]);
                    
                else {
                    temp=biggestS(score[j]);
                    surprising--;     
                } 
                   if(temp>=least)counter++;
           
             }
            
             ps.println("Case #"+(i+1)+": "+counter);
        }
    }
    
   static int biggestNS(int x){
       if(x==0)return 0;
       if(x==1)return 1;
       return ((x-1)/3)+1;
   }
   
   static int biggestS(int x){
       if(x==0)return 0;
       if(x==1)return 1;
       return ((x-2)/3)+2;
   }
}