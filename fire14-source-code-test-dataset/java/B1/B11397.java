/* @Gayan Kaushalya
 * 14-04-2012
 * */

import java.util.Scanner;
import java.io.*;
  
public class Numbers{
  
  static String[] inp;
  static String[] inpp;
  static String oo;
  
  public static void main(String args[])throws IOException{
    
    FileInputStream in =  new FileInputStream("C-small-attempt0.in");
    DataInputStream inn = new DataInputStream(in);
    BufferedReader br = new BufferedReader(new InputStreamReader(inn));
    
    FileWriter out = new FileWriter("out1.txt");
    BufferedWriter bw = new BufferedWriter(out);
    
    int num = Integer.parseInt(br.readLine());
    inp = new String[num];
    inpp = new String[num];
    
    for(int i=0; i<num; i++){
      inp[i] = br.readLine();
    }
    
    for(int j=0; j<num; j++){
      inpp = inp[j].split(" ");
      oo = "Case #" + (j+1) + ": " + calc( Integer.parseInt(inpp[0]), Integer.parseInt(inpp[1]) );
      System.out.println( oo );
      bw.write(oo);
      bw.newLine();
    }
      
    br.close();
    bw.close();
    in.close();
    out.close();
  }
  
  static int calc(int A, int B){
    int ret=0;
    int c;
    
    for(int i=A; i<B; i++){
      for(int j=1; (i+j)<=B; j++){
        c = 0;
        c = check(i, (i+j) );
        if(c!=0)
          ret+=c;
      }
    }
    return ret;
  }
  
  static int check(int n, int m){
    String nn = Integer.toString(n);
    String mm = Integer.toString(m);
    String[] list = new String[20];
    String fin;
    int count=0;
    
    if(m==n)
      return 0;
    if(n>m)
      return 0;
    if( (nn.substring(0,1)=="0") || (mm.substring(0,1)=="0") )
      return 0;    
    if(mm.length()!=nn.length())
      return 0;
    if(mm.length()==1)
      return 0;
    else{
      for(int i=1; i<mm.length(); i++){
        fin = mm.substring(i, mm.length()) + mm.substring(0,i);
        
        if(Integer.parseInt(fin)==n){
          int skip=0;
          int j;
          for(j=0; list[j]!=null; j++){
            if( fin.equals(list[j]) ){
              skip=1;
            }
          }
          if(skip==0){
            list[j]=fin;
            count++;
          }
        }
      }
    }
    return count;
      
  }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    