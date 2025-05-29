import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.String;


public class D
{

    public static void solve() throws Exception
    {
        int I,c=0;
        int l=0;
        String y="";
        String cmp ="";
        String min="",max="";
        int imin=0,imax=0;
        PrintWriter out =new PrintWriter(new File("D.out"));
        BufferedReader br=new BufferedReader(new FileReader(new File("D.in")));
        int testCase=Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++)
        {
            y="";
            String x= br.readLine();
//          String a="";
        int k = x.length();
       // char[] a = new char[I];
//       out.println("In case #"+ i +": "+k);
min = "";
max = "";
imin=0;
imax=0;
c=0;
           l=0;
            for (int j = 0; j < k; j++)
            {
                l = j+1;
//                if (x.substring(j,l)==" ")
//                    y = y+" ";
                 cmp = x.substring(j,l);
//out.println("Case #"+ i +": "+x.substring(j,l));         
                if (cmp.equals(" "))
                    c=1;
                    
                if (checkIfNumber(cmp))    
                {
                if (c==0)    
                    min = min + x.substring(j,l);
                else 
                    max = max + x.substring(j,l);
                }
            }
//            out.println("Case #"+ i +": "+min +" " + max);
            if (checkIfNumber(min))  
            {            
            imin = Integer.parseInt( min );
            }
            if (checkIfNumber(max))  
            {            
                imax = Integer.parseInt( max );
 
            }
          int n=0,m=0,ireord=0,tmp=0;
          int dig=0,d=0;
          String tmp1 = "";
          String reord = "0";
          int comb = 0;
            for ( n = imin; n <= imax; n++)
            {
                dig = min.length();
//                out.println("In case RUNNING#       "+ i +": "+n);
                
                if (dig>1)
                {
//                    reord = Integer.toString(n);                          
                        tmp1=Integer.toString(n);
                for (d =1;d<dig;d++)
                 {
                     
                     
//                     if (dig!=1)
                      reord = Rev(tmp1);
//                      out.println("In case # REORD"+ i +": "+ reord+ "tmp " + tmp);
                    tmp1=reord;
//                     if (checkIfNumber(reord))  
//                    {            
//                        tmp = Integer.parseInt( reord );
//                    }        


                      if (!chklead(reord))
                      {
//                       out.println("In case chklead#    "+ i +": "+reord);
                       continue;      
                      }
//                     else reord = m;
//                      out.println("In case #"+ i +": "+reord);

                     for (m=n+1;m<=imax;m++)
                     {
                       if (checkIfNumber(reord))
                         ireord=Integer.parseInt( reord );
                       if (ireord==m)  
                       {
                         comb=comb+1;
//                         out.println("Case # RIGHT"+ i +": Comb "+ comb + "Reord" + reord+ " REV " +n);
                        }
                    }
                 }       
                }
                else comb=0;
            }
//            out.println("Case #"+ i + comb);
                       out.println("Case #"+ i +": "+comb);

        }
        out.close();
    }
    public static boolean checkIfNumber(String in) {
        
        try {

            Integer.parseInt(in);
        
        } catch (NumberFormatException ex) {
            return false;
        }
        
        return true;
    }
    public static boolean chklead(String in) {
        int l=0,d=0;
        String cmp="";
        try {

//            for (d =0;d<in.length();d++)
//                 {   
                     l = 1;
//                     if (in.length()>0)
                     cmp = in.substring(d,l);
                     
                     if (cmp.equals("0"))
                      return false;
                     else
                      return true;
//                 }
//                 return true;
        
        } catch (NumberFormatException ex) {
            return false;
        }
        
    }
    public static String Rev (String n)
        {
            int r,t=0;
            String rev="";
//            while (n>0)
//            {
           if (checkIfNumber(n))  
            {            
                t = Integer.parseInt( n );
 
            }

                    r=t%10;
                    rev=rev+r;
                    t/=10;
                   if (n.length()>1) 
                    rev=rev+n.substring(0,n.length()-1);
                   else
                    rev=rev+t;
                    
//                }
                return rev;
        }
        
    public static void main(String[] args) throws Exception
    {
        solve();
    }
    
}
