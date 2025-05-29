/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ndproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Find f=new Find();
        f.find();
    }

}

class Find
{

int size;
int start=1;
     
    public void find()
    {
            try {

                File inputFile = new File("input.txt");
                File tempFile = new File("out.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                FileOutputStream fos=new FileOutputStream(tempFile);

            String currentLine;
            int size;
            int tno,sur,max;
            int count=0,no,no3;

            while((currentLine = reader.readLine()) != null) {

                    count=0;
                    String[] sArray = currentLine.split(" ");

                    if(sArray.length<=1)
                    {
                        size=Integer.parseInt(sArray[0]);
                        System.out.println("size="+size);
                        writer.write(currentLine);
                    }
                    else
                    {
                        tno=Integer.parseInt(sArray[0]);
                        sur=Integer.parseInt(sArray[1]);
                        max=Integer.parseInt(sArray[2]);
                        no3=max*3;

                        System.out.print("tno"+tno+"sur"+sur+"max"+max);
                      //  writer.write("tno"+tno+"sur"+sur+"max"+max);
                        for(int i=3;i<sArray.length;i++)
                        {
                            no=Integer.parseInt(sArray[i]);
                            if(no==0 )
                            {
                                
                            }
                            else if(no >= no3 - 2)
                            {
                                count++;
                            }
                            else if(no==no3-3 || no==no3-4)
                            {
                                if(sur>0)
                                {
                                    count++;
                                }
                                sur--;
                            }

                        }
                        String s1="Case #"+ start++ +": "+count+"\n";
                        System.out.println(s1);
                        byte b1[]=s1.getBytes();
                        fos.write(b1);
                        
                        
                    }
                    
                }
            
        } catch (Exception ex) {
            System.err.println("FileStreamsTest: " + ex);
        } 
    }
}
