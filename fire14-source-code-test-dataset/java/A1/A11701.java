/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        int i=1;
        Scanner ss=new Scanner(new File("B-small-attempt1.in.txt"));
        PrintWriter x=new PrintWriter(new File("B-small-attempt1.out.txt"));
        if(ss.hasNext()) ss.next();
        while(ss.hasNextLine()&&i<=100){
            int n = 0;
            if(ss.hasNext()) n=Integer.parseInt(ss.next());
            int s = 0;
            if(ss.hasNext()) s=Integer.parseInt(ss.next());
            int p = 0;
            if(ss.hasNext()) p=Integer.parseInt(ss.next());
            LinkedList<Integer> l=new LinkedList<>();
            for(int index=0;index<n;index++) l.add(Integer.parseInt(ss.next()));
            x.println("Case #"+i+": "+Best.opt(n,s,p, l));
            i++;
        }
        x.close();
        }
    }
