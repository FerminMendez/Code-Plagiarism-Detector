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
public class Recycled {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        Integer number=0;
        Integer total=0;
        Integer a,b;
        String numbers[];
        Integer result;
        String current;
        String pair;
        String previous;
        try{
        BufferedReader fin=new BufferedReader(new InputStreamReader(new FileInputStream(new File("C-small-attempt1.in"))));
        PrintWriter fout = new PrintWriter (new BufferedWriter (new FileWriter ("C-small-attempt1.out")));
        total=Integer.parseInt(fin.readLine());
        for (int i=0;i<total;i++){
            result=0;
            previous="1,1";
            numbers=fin.readLine().split(" ");
            a=Integer.parseInt(numbers[0]);
            b=Integer.parseInt(numbers[1]);
            if (b>9) {
            for(int j=a;j<=b;j++){
                current=j+"";
                for(int k=1; k<current.length(); k++){
                    pair=current.substring(k)+current.substring(0,k);
                    if(pair.startsWith("0") || current.startsWith("0")){
                        continue;
                    }
                    if(Integer.parseInt(pair)<=b && Integer.parseInt(pair)>Integer.parseInt(current) && Integer.parseInt(current)>=a && previous.compareTo(current+","+pair)!=0){
                        result++;
                        previous=current+","+pair;
                    }
                }
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
