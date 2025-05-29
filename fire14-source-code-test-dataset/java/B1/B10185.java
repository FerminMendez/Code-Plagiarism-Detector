/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author GERALD
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        PrintWriter output = null;
         try{
         scanner = new Scanner(new FileInputStream(args[0]));
         output = new PrintWriter(new FileOutputStream("resultRecycledNumbers.txt"));
         int noOfCases = scanner.nextInt();
         
         //prior initializations if any
         int A, B,count;
         for(int i=1; i<= noOfCases;++i){
             // TODO code application logic here
             A = scanner.nextInt();
             B = scanner.nextInt();
             count = noOfRecycledPair(A, B);
             output.append(String.format("Case #%d: %d\n",i,count));
         }
         
         } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }  finally{
            if( output!= null)
                output.close();
            if(scanner!= null)
                scanner.close();
        }
        
    }
     public static int noOfRecycledPairWithSameOrder(long a, long b){
             int count = 0;
             int order = 0;
             long num = a;
             do{
                num = num/10;
                order++;
             }while(num!=0);
             order --;
             System.out.println(order);
             long tens = 10;
             long bigNines = Math.round( Math.pow(10, order+1) -1);
             int ordnum = 0;
             long buffer = 0;
             ArrayList<Long> numList = new ArrayList<>();
             for(long i=a; i<=b; ++i){
                 
                 tens = 10;
                 numList.clear();
                 for(int j=0; j<= order-1; ++j){
                     
                     num =  Math.round((double)(i + ((i%(Math.round(tens)))*bigNines))/(double)tens);
                     
                     if(num >=a && num<=b&& num !=i&& !numList.contains(num)){
                         buffer = num;
                         ordnum=0;
                         do{
                             buffer = buffer/10;
                             ordnum++;
                         }while(buffer !=0);
                         ordnum--;
                         if(ordnum == order)
                            count++;
                     }
                   numList.add(num);
                     tens = 10*tens;
                 }
             }
             return count/2;
         }
      public static int noOfRecycledPair(long a, long b){
          int count = 0;
          int orderA = 0, orderB=0;
           long num = a;
             do{
                num = num/10;
                orderA++;
             }while(num!=0);
             orderA --;
              num = b;
             do{
                num = num/10;
                orderB++;
             }while(num!=0);
             orderB --;
             if (orderA == orderB){
                 System.out.println("equals");
                 count = noOfRecycledPairWithSameOrder(a, b);
             } else{
                 System.out.println("not equals");
                 long aLimit = (long) (Math.pow(10,orderA) -1);
                 count = noOfRecycledPairWithSameOrder(a, aLimit) + noOfRecycledPair(aLimit, b);
             }
         return count;
      }
}
