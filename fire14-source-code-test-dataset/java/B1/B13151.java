import java.io.*;
class RecycledNumbers
{
  void main()throws IOException
  {
      BufferedReader obj= new BufferedReader(new FileReader("C-small-attempt0.in"));
      PrintWriter p= new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
      
      int T=Integer.parseInt(obj.readLine());
      long a,b,n,m,q,order,i,count=0;String s;
      
      for(i=1;i<=T;i++)
      {
          s=obj.readLine();
          
          a=Integer.parseInt(s.substring(0,s.length()/2));
          b=Integer.parseInt(s.substring(s.length()/2+1,s.length()));
          order=s.length()/2;
          
          for(n=a;n<=b;n++)
          {
              for(q=1;q<order;q++)
              {
                  m=(long)(n%Math.pow(10,q)*Math.pow(10,order-q)+(n/Math.pow(10,q)));
                  if(m>n&&m<=b)
                   count++;
                }
         
            }
            
            p.println("Case #"+i+": "+count);
                count=0;
      }
      p.flush();
      p.close();
    }
}
