/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gjam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author iNahoo
 */
public class GJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/iNahoo/Desktop/C-small-attempt0.in"));
        String line="";
        int i=1;
        
        File output=new File("/Users/iNahoo/Desktop/gtest/test_.out");
        FileWriter fw = new FileWriter(output.getName());
    	    BufferedWriter bw = new BufferedWriter(fw);
    	    

        
        
        line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
               String out_="Case #"+i+": "+reclyC(line);
               System.out.println(out_);
               bw.write(out_);
               i++;
        }
        
        
        bw.close();
        
        
        
        //System.out.print(reclyString("2"));
        //System.out.println("Case #"+1+": "+langVert("ejp mysljylc kd kxveddknmc re jsicpdrysi"));
        // TODO code application logic here
    }
    
    public static int reclyC(String s){
        String[] ij=s.split(" ");
        int i=Integer.parseInt(ij[0]);
        int j=Integer.parseInt(ij[1]);
        int temp=0;
        String[] input=new String[j-i+1];
        for(int k= 0;k<input.length;k++){
            input[k]=""+i;
            i++;
        }
        ArrayList past=new ArrayList();
        
        for(int k= 0;k<input.length;k++){
            String temp_t=input[k];

            if(!temp_t.equals("xxx")){
            for(int l=1;l<input[k].length();l++){

                if(l==1)temp_t=reclyString(input[k]);
                else temp_t=reclyString(temp_t);
                
                String temp_=""+Integer.parseInt(temp_t);
                
                //System.out.println(input[k]+"-->"+temp_);                
                for(int m=0;m<input.length;m++){
                    if(temp_.equals(input[m])){

                      if((k!=m)&&(!past.contains(""+input[m]+input[k]))){
                          //System.out.println(input[k]+"::"+input[m]);  
                          past.add(""+input[k]+input[m]);
                          temp++;
                      }
                    }
                }
            }}
        }
        
        
        return temp;
    }
    
    public static String reclyString(String s){
        String temp="";
        temp = s.substring(1)+s.charAt(0);
        return temp;
        
    }
    
    
    public static String langVert(String s){
        String temp="";
        String[] spl=s.split(" ");
        
        for(int i=0;i<spl.length;i++){
            for(int j=0;j<spl[i].length();j++){
              temp=temp+charVert(spl[i].charAt(j));
            }
            temp=temp+" ";
        }
        
        return temp;
    }
    
    public static Character charVert(char ch){
        Character temp=null;
        switch(ch){
            case 'a':temp='y';break;
            case 'b':temp='h';break;
            case 'c':temp='e';break;
            case 'd':temp='s';break;
            case 'e':temp='o';break;
            case 'f':temp='c';break;
            case 'g':temp='v';break;
            case 'h':temp='x';break;                
            case 'i':temp='d';break;
            case 'j':temp='u';break;
            case 'k':temp='i';break;
            case 'l':temp='g';break;                
            case 'm':temp='l';break;
            case 'n':temp='b';break;
            case 'o':temp='k';break;
            case 'p':temp='r';break;
            case 'q':temp='z';break;
            case 'r':temp='t';break;
            case 's':temp='n';break;
            case 't':temp='w';break;                
            case 'u':temp='j';break;
            case 'v':temp='p';break;
            case 'w':temp='f';break;
            case 'x':temp='m';break;
            case 'y':temp='a';break;
            case 'z':temp='q';break;                 
        
        }
        return temp;
    } 
}
