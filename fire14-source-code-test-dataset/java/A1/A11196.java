/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author malgia
 */
public class Triplets {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        Integer number=0;
        Integer total=0;
        String newLine="";
        String text;
        String data[];
        Integer googlers;
        Integer surprising;
        Integer value;
        Integer result;
        Integer score;
        Integer difference;
        try{
        BufferedReader fin=new BufferedReader(new InputStreamReader(new FileInputStream(new File("B-small-attempt0.in"))));
        PrintWriter fout = new PrintWriter (new BufferedWriter (new FileWriter ("B-small-attempt0.out")));
        total=Integer.parseInt(fin.readLine());
        for (int i=0;i<total;i++){
            result=0;
            data=fin.readLine().split(" ");
            googlers=Integer.parseInt(data[0]);
            surprising=Integer.parseInt(data[1]);
            value=Integer.parseInt(data[2]);
            for(int j=3; j<3+googlers;j++){
                score=Integer.parseInt(data[j]);
                difference=score%3;
                if(score==0){
                    if(score>=value){
                        result++;
                    }
                    continue;
                }
                if(difference==0 && score/3>=value){
                    result++;
                    continue;
                }
                if((difference==1 || difference==2) && score/3+1>=value){
                    result++;
                    continue;
                }
                if(difference>=2 && score/3+2>=value && surprising>0){
                    result++;
                    surprising--;
                    continue;
                }
                if(difference==0 && score/3+1>=value && surprising>0){
                    result++;
                    surprising--;
                    continue;
                }
            }
            number=i+1;
            fout.println("Case #"+number+": "+result);
        }
        fin.close();
        fout.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
