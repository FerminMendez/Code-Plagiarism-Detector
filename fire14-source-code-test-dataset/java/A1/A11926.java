/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google.code.jam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bogatinovi
 */
public class B {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int T = in.nextInt();
            int br=0;
            for(int i=1;i<=T;i++){
                int Googlers = in.nextInt();
                int suprising = in.nextInt();
                int p = in.nextInt();
                    for(int j=0;j<Googlers;j++){
                        int res=in.nextInt();
                      if(res>=p){
                        if(p*3<=res){++br;}
                        else if((res-p)>=(2*p-2)){
                            br++;
                        }
                        else if(suprising>0){
                            res-=p;
                            if((2*p-4)<=res){
                                br++;
                                suprising--;
                            }
                        }
                      }
                      }
            System.out.println("Case #"+i+": "+br);
            br=0;
            }
    }
}
