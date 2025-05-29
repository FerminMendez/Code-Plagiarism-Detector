/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
/**
 *
 * @author Joydeep
 */
public class J3 {
    public static void main(String[] args) throws IOException{
        String test = "150";

        DataInputStream ds = new DataInputStream(new FileInputStream("d:/C-small-attempt0.in"));
        Writer os = new BufferedWriter(new FileWriter("d:/output.txt"));
        int N = Integer.parseInt(ds.readLine());
        for(int i = 1;i<=N;i++)
        {
            int A=0,B=0,l,counter=0,n,m,pairs=0;
            String temp="";
            String output="Case #"+i+": ";
            String AB = ds.readLine()+" ";
            
            l = AB.length();
            for(int j = 0;j<l;j++)
            {
                char c = AB.charAt(j);
                if(c != ' ')
                {
                    temp = temp+c;
                }    
                else
                {
                  if(counter == 0)  
                  {
                      A = Integer.parseInt(temp);
                      temp = "";
                  }
                  else
                  {
                      B = Integer.parseInt(temp);
                      break;
                  }
                  counter++;
                 
                }
            }    

          
           
            for(n = A;n<=B;n++)
            {
                String check3=""+n;
                String part1,part2;
                String[] matches = new String[100];
                int c = 0;

                    String check = ""+n;

                    int l2 = check.length();
                    int p1 = l2-2;
                    int p2 = l2-1;
                    for(int x = 1;x<l2;x++)
                    {
                        if(p1==0)
                        {
                            part1 =""+ check.charAt(0);
                        }
                        else
                        {
                            part1=check.substring(0, p2);
                        }
                        
                      part2 = ""+check.charAt(p2);
                      check = part2+part1;
                      int num = Integer.parseInt(check);
                      if(num>n && num<=B)
                      {
                          int flag = 0;
                          for(int y = 0 ;y<c;y++)
                          {
                              if(check.equals(matches[y]))
                              {
                               flag = 1 ;  
                               break;
                              }
                          }
                          if(flag == 0)
                          {
                              pairs++;
                              matches[c++]=check;
                          }
                      }
                    }
            }
            output = output +pairs;
            os.write(output);
            String newLine = System.getProperty("line.separator");
            os.write(newLine);
        }
        ds.close();
        os.close();
    }
}