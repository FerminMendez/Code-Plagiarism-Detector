/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package a2012;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author G
 */
public class B {
    static File home=new File("F:/Documents/Downloads/");
    public static void main(String...args)throws Exception{
        Scanner sc = new Scanner(new File(home,"B-small-attempt0.in"));
        new File(home,"B").mkdir();
        System.setOut(new PrintStream(new File("b.out")));
        final int casos=sc.nextInt();
        for(int caso=1;caso<=casos;caso++){
            int N=sc.nextInt();
            int S=sc.nextInt();
            int p =sc.nextInt();
            int m=0;
            int[] ns=new int[40];
            for(int e=0;e<N;e++)ns[sc.nextInt()]++;
            surprising:{
                for(;S>0;m++,S--){
                    if(p>2&&p+p+p-4>=0&&ns[p+p+p-4]>0)ns[p + p + p - 4]--;
                    else if(p>1&&p+p+p-3>=0&&ns[p + p + p - 3] > 0)ns[p + p + p - 3]--;
                    else{
                        break;
                    }
                }
            }
            for(int e=Math.max(p + p + p - 2,0);e<ns.length;e++)m+=ns[e];
            System.out.println("Case #"+caso+": "+m);
        }
        System.out.close();
    }
}
