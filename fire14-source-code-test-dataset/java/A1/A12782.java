/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeJam2012;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asha.j
 */
public class DancingGooglers {
    
    
    public static void main(String[] args) throws IOException {
        String filename= "B-small-attempt0";
        Scanner scanner= new Scanner(new File("D:\\codejam\\"+filename+".in"));
        BufferedWriter writer= new BufferedWriter(new FileWriter("D:\\codejam\\"+filename+".out"));
        int numOfCases = scanner.nextInt();
        int noOfGooglers;
        int surpriseScoreCount;
        int p;
        int countAboveP=0;
        ArrayList<Integer> list= new ArrayList<Integer>();
        for(int i=1;i<=numOfCases;i++){
            list.clear();
            countAboveP=0;
            noOfGooglers= scanner.nextInt();
            surpriseScoreCount= scanner.nextInt();
            p= scanner.nextInt();
            for(int m=0;m<noOfGooglers;m++){
                    int data= scanner.nextInt();
                    list.add(data);
            }
            countAboveP= processCase(list, surpriseScoreCount, p);
            writer.write("Case #"+(i)+": "+countAboveP+"\n");
            writer.flush();
        }

    }
    
    private static int processCase(ArrayList<Integer> list,int surprising, int p){
        //System.out.println("processCase:"+list+"  sur:"+surprising+" p:"+p);
        int third;
        int reminder;
        int countAboveP=0;
        for(int score: list){
            third= score/3;
            reminder= score%3;
            if(score==0){
                if(p==0){
                    ++countAboveP;
                }
                continue;
            }
            if(third>=p){
                ++countAboveP;
            }else if(reminder==0){
                if(third+1 >=p && surprising>0){
                    --surprising;
                    ++countAboveP;
                }
            }else if(reminder==1){
                if(third+1 >=p){
                    ++countAboveP;
                }
            }else if(reminder==2){
                if(third+1 >=p){
                    ++countAboveP;
                }else if(third+2 >=p && surprising>0){
                    --surprising;
                    ++countAboveP;
                }
            }
        }
        return countAboveP;
    }
}
