import java.lang.*;
import java.io.*;
import java.util.*;

public class rotate{

public static void main(String args[])throws Exception{

int i,j,k,m;
int n_test_case;
FileInputStream fin = new FileInputStream("C-small-attempt0.in");
DataInputStream in = new DataInputStream(fin);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
String str,tempN,tempM;
String ABstr[]=new String[2];
            FileWriter fout = new FileWriter("output.txt");
            BufferedWriter out = new BufferedWriter(fout);

            str = br.readLine();
            n_test_case=Integer.parseInt(str);

            for(i=0;i<n_test_case;i++)
            {
                int count=0;
                str = br.readLine();    
                ABstr = str.split(" ");
                //System.out.println(ABstr[0]+" "+ABstr[1]);
                int A,B;
                A=Integer.parseInt(ABstr[0]);//n
                B=Integer.parseInt(ABstr[1]);//m
                    for(j=A;j<B;j++)
                    {
                        ArrayList<Object> arl=new ArrayList<Object>();
                        for(k=j+1;k<=B;k++)
                        {
                            tempN= new Integer(j).toString();//n
                            tempM= new Integer(k).toString();//m
                            if(ABstr[0].length()>1)
                            {

                                 for(m=0;m<ABstr[0].length();m++)
                                 {
                                 
                                 //rotate
                                 if(tempN.equals(tempM) && arl.indexOf(tempN)==-1)
                                 {
                                     //System.out.println(tempN+" "+tempM);
                                     arl.add(tempN);
                                     count++;
                                     
                                 }
                                 else
                                 tempN=tempN.substring(tempN.length()-1,tempN.length())+tempN.substring(0,tempN.length()-1);
                                 while(tempN.charAt(0)=='0')    
                                 tempN=tempN.substring(tempN.length()-1,tempN.length())+tempN.substring(0,tempN.length()-1);
                                 }
                                
                            }
                            
                        }
                                                
                    }//each value of n is compared
                //System.out.println(count);
            if(i==n_test_case-1)
            str="Case #"+(i+1)+": "+count;
            else
            str="Case #"+(i+1)+": "+count+"\n";
            out.write(str);

            }//outer n_test_cases loop
            out.close();
}
}