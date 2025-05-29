

import java.util.Scanner;

/**
 *
 * @author krishna
 */
public class Dance {
    
    public static void main(String [] args)
    {
        Program();
    }
    public static void Program()
    {
        Scanner inp=new Scanner(System.in);
        String patt[];
        int count;
        String line;
       // System.out.println("Test Case ");
                
        int test=Integer.parseInt(inp.nextLine());
        int num=1;
        int S,N,P;
        int judge1,judge2,judge3,rem;
        int Score[]=new int[100];
        while(num<=test)
        {
           // System.out.println("pattern ");
            
            line=inp.nextLine();
            patt=line.split(" ");
            
                N=Integer.parseInt(patt[0]);
                S=Integer.parseInt(patt[1]);
                P=Integer.parseInt(patt[2]);
                count=0;
                for(int i=0;i<N;i++)
                {
                    Score[i]=Integer.parseInt(patt[i+3]);
                    judge1=judge2=judge3=Score[i]/3;
                    rem=Score[i]%3;
                    if(Score[i]==0 )
                    {
                        if(P==0)
                           count++;
                        
                      // System.out.println(judge1+" "+judge2+" "+ judge3);
                    }
                    else if( rem==0  )
                    {
                       if(judge1 >= P)
                           count++;
                       else if( S > 0 && (judge1 + 1)>=P )
                       { 
                           judge1++;
                           judge2--;
                           count++;
                           S--;
                       }
                       // System.out.println(judge1+" "+judge2+" "+ judge3);
                    }
                    else if(rem==1)
                    {
                        judge1++;
                        if(judge1 >= P)
                        {
                           count++;
                        }
                      
                      // System.out.println(judge1+" "+judge2+" "+ judge3);
                        
                    }
                    else if(rem==2)
                    {
                        judge1++;
                        judge2++;
                       if( (judge1 )>=P)
                       {
                           count++;
                       }
                       else if( S!=0  && ((judge1)+1)>=P)
                        {
                           S--;
                           judge1++;
                           judge2--;
                           count++;
                        }
                      
                    //  System.out.println(judge1+" "+judge2+" "+ judge3);
                    }
                } 
                System.out.println("Case #"+num+": "+count);
             num++;
        }
    }
}
