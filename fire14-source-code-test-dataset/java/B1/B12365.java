/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author linlin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File file=new File("C-small-attempt0.in");
        FileOutputStream o=new FileOutputStream("a.txt");
        Scanner s=new Scanner(file);
        int t=Integer.valueOf(s.nextLine());
        for(int i=1;i<=t;i++){
            String line=s.nextLine();
            String[] num=line.split(" ");
            int a=Integer.valueOf(num[0]);
            int b=Integer.valueOf(num[1]);
            int d=1;
            int tens=10;
            for(;tens<=a;tens=tens*10)
                    d++;
            tens=tens/10;

            int[] total=new int[d];
            for(int q=a;q<=b;q++){
                int correct=0;
                int q1=q;
                boolean shift=true;
                for(int k=0;k<d;k++){

                    int r1=q1%10;
                    q1=q1/10+r1*tens;
                    if((q1==q)&&shift)
                        break;
                    else if((q1>=a)&&(q1<=b)){
                        correct++;
                        //System.out.println(q1);
                    }
                    shift=false;
                    
                }
                if(correct>1){
                    total[correct-1]=total[correct-1]+1;
                   
                }

            }
            int result=0;
            for(int n=1;n<d;n++){
                result=result+(total[n]*n/2);
                
            }
            String out="Case #"+i+": "+result+"\r\n";
            o.write(out.getBytes());



        }
    }

}
