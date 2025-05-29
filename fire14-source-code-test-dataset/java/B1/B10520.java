import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
class gcj3
{
    public static void main(String args[])throws Exception
    {
        Scanner in=new Scanner(new File("C:/Users/Rakesh/Downloads/C-small-attempt0.in"));
       // Scanner in=new Scanner(System.in);
        FileWriter fstream = new FileWriter("c:/out.out");
        BufferedWriter out = new BufferedWriter(fstream);
        int t,i,j,k,temp,m=0,c=0,l=0,ok=1,p,r;
        t=in.nextInt();
        int res[][]=new int[1000][2],a[]=new int[t],b[]=new int[t];
        for(i=0;i<t;i++)
        {
            a[i]=in.nextInt();
            b[i]=in.nextInt();
        }
        for(i=0;i<t;i++)
        {
            for(j=a[i];j<=b[i];j++)
            {
                for(k=j+1;k<=b[i];k++)
                {
                    temp=k;
                    while(temp>0)
                    {
                        temp/=10;
                        l++;
                    }
                    r=l;
                    temp=k;
                    ok=1;
                    while(l-->1)
                    {
                            temp=(int) ((temp/(Math.pow(10,(r-1))))+((temp%(Math.pow(10,(r-1))))*10));
                            if(temp==j && temp>=a[i] && temp<=b[i])
                             {c++;
                                 for(p=0;p<m;p++)
                                  {
                                       if(res[p][0]==j)
                                       {
                                          ok=0;
                                          break;
                                       }
                                  }
                                  if(ok==1)
                                    {
                                      // c++;
                                        if(k>=j)
                                        {
                                             res[m][0]=j;
                                             res[m++][1]=k;
                                        }
                                        else
                                         {
                                             res[m][0]=k;
                                             res[m++][1]=j;
                                         }
                                       // break;
                                    }
                              }
                        }
                    }
                }
            try
            {
              out.write("Case #"+(i+1)+": "+c+"\n");
            }
            catch (Exception e)
            {//Catch exception if any
                 System.err.println("Error: " + e.getMessage());
            }
            //System.out.println(c);
            c=0;
            }
        out.close();
        }
    }

        