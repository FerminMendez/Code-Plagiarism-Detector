import java.io.*;

public class B

{
     BufferedReader read;
     BufferedWriter write;
    public static void main(String args[])
    {
        try {
           new B().init("B-small-attempt0");
           // new B().init1();
        } catch (Exception ex) {
          //  Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     void init(String name) throws Exception
    {


        read=new BufferedReader(new FileReader(new File(name+".in")));
        write=new BufferedWriter(new FileWriter(new File(name+".out")));


          String x="";


            try {
                x = read.readLine();
               int n = Integer.parseInt(x);
              for(int i=0;i<n;i++)
                 {
                   x = read.readLine();
                   result(x, i);
                }
                write.flush();
                write.close();
                read.close();

               // System.out.println(a+"    "+b);
                }

             catch (Exception ex) {

               System.exit(0);
            }


      }

     int l=0;
void result(String x,int i) throws Exception
{
             String ss[]=x.split(" ");
                int l1=ss.length;
                int n=Integer.parseInt(ss[0].trim());
                int surprise=Integer.parseInt(ss[1].trim());
                int min=Integer.parseInt(ss[2].trim());
             //   System.out.println("\n n  "+n+" surprise   "+surprise+" min   "+min);
                int count=0;
               // int t[]=new int[n];
                for(int j=3;j<l1;j++)
                {
                   int p=Integer.parseInt(ss[j].trim());
                   int res[][]=generateTriplet(p);
                   boolean b=false;
                   for(int k=0;k<l;k++)
                   {
                       if(!surprise(res[k][0],res[k][1],res[k][2])&&(res[k][0]>=min||res[k][1]>=min||res[k][2]>=min))
                       {
                           count++;
                           b=true;
                           break;
                       }
                   }

                   if(!b&&surprise>0)
                   {
                   for(int k=0;k<l;k++)
                   {
                       if((res[k][0]>=min||res[k][1]>=min||res[k][2]>=min))
                       {
                           count++;
                           surprise--;
                           b=true;
                           break;
                       }
                   }
                   }
                }
                
                
            
                System.out.println("Case #"+(i+1)+": "+count);
              write.write("Case #"+(i+1)+": "+count+"\n");
}

boolean surprise(int i,int j,int k)
  {
    if(Math.abs(i-j)==2||Math.abs(j-k)==2||Math.abs(i-k)==2)return true;
    return false;
}
int [][] generateTriplet(int p)
    {
    l=0;
    int res[][]=new int[100][3];
    int i=Math.max(0, p/3-3);
    for(;i<=p/3+3;i++)
        for(int j=i-2;j<=i+2;j++)
            for(int k=i-2;k<=i+2;k++)
            {
                if(i+j+k!=p||i>10||j>10||k>10||i<0||j<0||k<0)continue;
                if(Math.abs(i-j)<=2&&Math.abs(k-j)<=2&&Math.abs(i-k)<=2)
                {
                    res[l][0]=i;
                    res[l][1]=j;
                    res[l][2]=k;
                    l++;
                }
            }
    return res;
}

}
