
/**
 * Write a description of class solver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class solver
{
   public int solve(int nog,int nos,int p,int t[])
   {
       int[] aux=new int[2*nog];
       int i=0,count=0;
       for(i=0;i<nog;i++)
       {   
               if(t[i]==0)
               {
                 aux[i]=0;
                 aux[nog+i]=-1;
                }
               else if(t[i]==1)
               {
                 aux[i]=1;
                 aux[nog+i]=-1;
                }
                
               else if(t[i]==29)
               {
                 aux[i]=10;
                 aux[nog+i]=-10;
                }
               else if(t[i]==30)
               {
                 aux[i]=10;
                 aux[nog+i]=-10;
                }
                else if(t[i]%3==0)
                {
                    aux[i]=t[i]/3;
                    aux[nog+i]=t[i]/3+1;
                }
                else if(t[i]%3==1)
                {
                    aux[i]=t[i]/3+1;
                    aux[nog+i]=-1;
                }
                else
                {
                    aux[i]=t[i]/3+1;
                    aux[nog+i]=t[i]/3+2;
                }
                
       }
       for(i=0;i<nog;i++)
       {
           if(aux[i]>=p)
           {
               count++;
               aux[nog+i]=-1;
            }
        }
        for(i=0;i<nog;i++)
        {
            if(nos==0)
            break;
            else if(aux[i+nog]>=p)
            {
                   nos-=1;
                   count++;
            }
        }
        return count;
       
    }
}