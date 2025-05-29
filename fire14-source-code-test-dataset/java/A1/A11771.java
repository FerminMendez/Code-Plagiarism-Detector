

package sabriel;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


import java.util.StringTokenizer;

/**
 *
 * @author sabriel
 */
public class DanceIt {

    
    public static void main(String[] args) {
        try {
            FileInputStream fstream =
                new FileInputStream("C:\\Users\\sabriel\\Documents\\NetBeansProjects\\Sabriel\\p2\\input.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader  br = new BufferedReader(new InputStreamReader(in));
            String          strLine;
            BufferedWriter  out1 = new BufferedWriter(
                                      new FileWriter(
                                          "C:\\Users\\sabriel\\Documents\\NetBeansProjects\\Sabriel\\p2\\out.out",
                                          true));
            String times = br.readLine();
            int    n     = Integer.valueOf(times);

            System.out.println("number of test cases : " + n);

            // will be used vars
            
            int    currentCase = 0;
            int G;
            int S ;
            int P;
            int fav;
            int s = 0;
            
            // processor starts 
            
            while ((strLine = br.readLine()) != null) {
                
                ++currentCase;
               
                
                StringTokenizer st=new StringTokenizer(strLine," ");
                G=Integer.valueOf(st.nextToken());
                int scores[]=new int[G];
                S=Integer.valueOf(st.nextToken());
                P=Integer.valueOf(st.nextToken());
                int tmp=0;
                
                  System.out.println("\n"+G+" "+P+" "+P);
                
               while(st.hasMoreTokens()){
                
                scores[tmp]=Integer.valueOf(st.nextToken());
                System.out.print(scores[tmp]+" ");   
                ++tmp;
                
               }
               
               
               //  logic 
               fav=0;
               s=0;
              
               
               for (int i=0;i<G;++i)
               {
                 
                   System.out.println("\nchecking score  :  "+scores[i]+"  for  : "+P);
                   
               if (P*3==scores[i]){
                   ++fav;System.out.println("set is : "+ P+"*"+3);
                   
               }
               
               else if ((P+(P+1)+(P-1))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P+(P+1)+(P-1))");
               }
               
               else if ((P*2+(P-1))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P*2+(P-1))");
               }
               
               else if ((P*2+(P-2))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P*2+(P-2))");
                   ++s;System.out.println("***  s incremented  ****");
               }
               
               else if ((P+(P-2)+(P-1))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P+(P-2)+(P-1)");
                   ++s;System.out.println("***  s incremented  ****");
               }
               
               
               else if ((P+(P+1)+(P+2))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P+(P+1)+(P+2))");
                   ++s;System.out.println("***  s incremented  ****");
               }
               
               else if ((P+(P+2)+(P+2))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P+(P+2)+(P+2))");
                   ++s;System.out.println("***  s incremented  ****");
               }
               
               else if ((P+(P-2)+(P-2))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P+(P-2)+(P-2))");
                   ++s;System.out.println("***  s incremented  ****");
               }
               
               else if ((P*2+(P+2))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P*2+(P+2))");
                   ++s;System.out.println("***  s incremented  ****");
               }
               
               else if ((P*2+(P+1))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P*2+(P+1))");
                   ++s;System.out.println("***  s incremented  ****");
               }
               else if ((P+(P-1)+(P-1))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P+(P-1)+(P-1))");
               }
               
               
               
               else if ((P+(P+1)+(P+1))==scores[i]){
                   ++fav;System.out.println("set is : "+ "(P+(P+1)+(P+1))");
               }
               
               
             
               
               }
               // logic ends
               if(s==S){
               System.out.println("favoooo  :  "+fav  + "  s :  " +s);  
               }
               else{
                   System.out.println("S was "+S  + " and   s :  " +P+"   where fav is : "+fav);  
                System.out.println("\n*******************\n*******************\n*******************\n");
            }
            }

            //out1.newLine();
            //out1.flush();

            // Close the input stream
            in.close();
            //out1.close();
        } catch (Exception e) {    // Catch exception if any
            System.out.println("Error: " + e.getMessage() + "   " + e);
        }
    }
}



