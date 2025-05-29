
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author utp
 */
public class C {
    public static void main(String Args[]) throws IOException{
        Scanner sc = new Scanner (new File("input.in"));
        FileWriter fw = new FileWriter("output.out");
        int T = sc.nextInt();
        for (int k=0;k<T;k++){
            int A=sc.nextInt();
            int B = sc.nextInt();
            int count=0;
        for (int i=A;i<=B;i++){
            for (int j=i+1;j<=B;j++){
            String num1 = Integer.toString(i);
            String num2 = Integer.toString(j);
            if (j==1121){
              //  System.out.println("");
            }
             int c = calcular(num1.toCharArray(),num2.toCharArray());
             if (c>=0){
                 String sub2 = num2.substring(0, c);
                 String sub1 = num2.substring(c);
                 if (num1.equals(sub1.concat(sub2))){
                  //   System.out.println("Case #"+(k+1)+": "+sub1+" "+sub2+" "+num1+" "+num2);
                     count++;
                 }
             }
            }
            }
        fw.write("Case #"+(k+1)+": "+count+"\n");
        }
        fw.close();
    }
    
    public static int calcular(char cad1[], char cad2[]){
        for (int j=0;j<=cad1.length;j++){
            String temp1 = String.copyValueOf(cad1, j,cad1.length-j);
            String tmp2 = String.copyValueOf(cad2);
            if (tmp2.contains(temp1)){
                return temp1.length();
            }
            
        }
        return -1;
    }
}
