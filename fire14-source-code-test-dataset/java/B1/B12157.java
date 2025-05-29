
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karim
 */
public class RecycledNumbers {

    public static boolean checkNumbers(int n, int m){
        String x=""+n;
        String y=""+m;
        for (int i=0;i<x.length()-1;i++){
            String temp=""+x.charAt(x.length()-1);
            String rest=x.substring(0,x.length()-1);
            temp+=rest;
            x=""+temp;
            if (temp.equals(y)){
                return true;
            }
        }
        return false;
    }
    
    public static int range(int a, int b){
        int counter=0;
        for (int i=a;i<b;i++){
            for (int j=(i+1);j<=b;j++){
                if (checkNumbers(i, j)==true)
                    counter++;
            }
        }
        return counter;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner r=new Scanner(System.in);
        String s=r.nextLine();
        PrintWriter out=new PrintWriter("RecycledNumbers.out");
        int t=Integer.parseInt(s);
        for (int i=0;i<t;i++){
            String start=r.next();
            String end=r.next();
            int number=range(Integer.parseInt((start)), Integer.parseInt(end));
            out.write("Case #"+(i+1)+": "+number+"\n");
            out.flush();
//            System.out.println("Case #"+(i+1)+": "+number);
        }
    }
}
