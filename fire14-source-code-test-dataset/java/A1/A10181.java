/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
/**
 *
 * @author GERALD
 * JDK 7.0
 */
public class GoogleDancing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        PrintWriter output = null;
         try{
         scanner = new Scanner(new FileInputStream(args[0]));
         output = new PrintWriter(new FileOutputStream("resultGoogleDancing.txt"));
         int noOfCases = scanner.nextInt();
         int noOfGooglers, minBestScore, surpScrs, count;
         //prior initializations if any
         List<Integer> totalScoresList = new Vector<>();
         int [] buffer;
         for(int i=1; i<= noOfCases;++i){
             // TODO code application logic here
             noOfGooglers= scanner.nextInt();
             surpScrs = scanner.nextInt();
             minBestScore = scanner.nextInt();
             buffer = new int [noOfGooglers];
             totalScoresList.clear();
             for(int j=0; j<noOfGooglers; ++j){
                 buffer[j] = scanner.nextInt();
                 
             }
             Arrays.sort(buffer);
             for(int j=noOfGooglers-1; j>=0; --j){
                 totalScoresList.add(buffer[j]);
             }
             count = 0;
             count = checkListNormally(totalScoresList,minBestScore,count);
             //System.out.println(Arrays.toString(totalScoresList.toArray()));
             count = checkListWithSurprise(totalScoresList,minBestScore,count,surpScrs);
             //System.out.println(Arrays.toString(totalScoresList.toArray()));
             //System.out.println("*****");
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

    private static int checkListNormally(List<Integer> totalScoresList, int minBestScore, int count) {
        int  num, ave,mod; 
        Iterator ite = totalScoresList.iterator();
        while(ite.hasNext()){
            //System.out.println("____________");
            num = (int) ite.next();
            ave = num/3;
            mod = num%3;
            if(num == 0&& 0==minBestScore){
                count ++;
                ite.remove();
            }else if(mod == 1 && ave ==0 && ave+1>= minBestScore){
                count ++;
                ite.remove();
            }else if(mod == 2 && ave ==0 && ave+1>=minBestScore){
                count++;
                ite.remove();
            }
            else{
                if(ave!=0){
                if(mod == 0 && ave >= minBestScore ){
                    count ++;
                    ite.remove();
                }
                else if( mod == 1 || mod == 2){
                    if(ave+1 >= minBestScore){
                        count++;
                        ite.remove();
                    }
                }
                }
            }
              //  System.out.println(Arrays.toString(totalScoresList.toArray()));
               // System.out.println("_____________");
            
            }
           
        //System.out.println(Arrays.toString(totalScoresList.toArray()));
        return count;
    }

    private static int checkListWithSurprise(List<Integer> totalScoresList, int minBestScore, int count, int surpScrs) {
        int num, ave, mod;
        int i=0;
        Iterator ite = totalScoresList.iterator();
        while(ite.hasNext() && i<surpScrs ){
            num = (int) ite.next();
            ave = num/3;
            mod = num%3;
            if(num ==0 && 0==minBestScore){
                count ++;
                ite.remove();
            }else if(mod == 1 && ave ==0 && ave+1>= minBestScore){
                count ++;
                ite.remove();
            }else if(mod == 2 && ave ==0 && ave+2>=minBestScore){
                count++;
                ite.remove();
            }
            else{
                if(ave!=0){
                if(mod == 2 && ave+2 >= minBestScore ){
                    count ++;
                    ite.remove();
                }
                else if( mod == 0 || mod == 1){
                    if(ave+1 >= minBestScore){
                        count++;
                        ite.remove();
                    }
                }
                }
                
            }
            i++;
            }
          
        return count;
    }

}
