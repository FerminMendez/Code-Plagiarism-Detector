/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author portz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void readFile(String filename,String outFile){
//        Buffer inpfile=new Buffer() {}
        Scanner scanner=null;

         Writer out=null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(outFile));
        } catch (FileNotFoundException ex) {
System.out.println(ex.toString());
        }

        try {
            scanner = new Scanner(new FileInputStream(filename));
            try {
                  String text="";
                  int i=0;
                  int limit=0;
                  String []abstr;int A;int B;
                  while (scanner.hasNextLine()){

                    text=scanner.nextLine();
                    if(i==0){
                        i=1;
                        limit=Integer.parseInt(text);
                    }else{
                        if(i<=limit){
                            try {
                                abstr=text.split(" ");
                                A=Integer.parseInt(abstr[0]);
                                B=Integer.parseInt(abstr[1]);
                                out.write("Case #"+i+": "+getrecycle( A, B));
                                if(i!=limit){
                                    out.write("\n");
                                }
                                i++;
                            } catch (IOException ex) {
System.out.println(ex.toString());
                            }
                        }
                    }
                  }
             }
            finally{
                 if(out!=null){
                    try {
                        out.close();
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
                 }
                  scanner.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int getrecycle(int A,int B){
        String nostr;//=""+n;
        int digitno;//=nostr.length();
        int m;//=n;
        String temp;//=""+n;
        int j=0;

        for(int n=A;n<=B;n++){
            //System.out.println("---------------------------------");
             nostr=""+n;
             digitno=nostr.length();
             m=n;
             temp=""+n;
             //j=0;
          // System.out.println(temp);
           if(temp.charAt(0)=='0'){

           }else{
            for(int i=0;i<digitno-1;i++){
                temp=temp.charAt(digitno-1)+temp;
                temp=temp.substring(0, digitno);
                if(temp.charAt(0)=='0'){

                }else{
                   m=Integer.parseInt(temp);

                   if(m>n&&m<=B&&m>=A){
                       System.out.println(m);
                       j++;
                   }
                }
            }
           }
        }
        return j;
    }
    public static void main(String[] args) {
        readFile("C-small-attempt0.in", "C-small-attempt0.out");
        // TODO code application logic here
//        System.out.println(getrecycle( 1, 9));//1 9 10 40 100 500 1111 2222
//        System.out.println(getrecycle( 10, 40));//1 9 10 40 100 500 1111 2222
//        System.out.println(getrecycle( 100, 500));//1 9 10 40 100 500 1111 2222
//        System.out.println(getrecycle( 1111, 2222));//1 9 10 40 100 500 1111 2222
    }

}
