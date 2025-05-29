import java.io.*;
import java.util.*;
public class C

{
     BufferedReader read;
     BufferedWriter write;
    public static void main(String args[])
    {
        try {
            new C().init("C-small-attempt2");
        } catch (Exception ex) {
               System.out.println("error occured  "+ex);
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
                 System.out.println("error occured  "+ex);

               System.exit(0);
            }


      }
     TreeSet<Integer>tree;

void result(String x,int j) throws Exception
{
             tree=new TreeSet<Integer>();
             String ss[]=x.split(" ");
                int a=Integer.parseInt(ss[0].trim());
                int b=Integer.parseInt(ss[1].trim());
                System.out.println(a+"   "+b);
                int count=0;
                for(int i=a;i<=b;i++)
                {

                        tree.add(i);
                        count+=count(i,a,b);
                     
                   
                }
                System.out.println("Case #"+(j+1)+": "+count);
               write.write("Case #"+(j+1)+": "+count+"\n");
}

int count(int p,int a,int b)
    {
    TreeSet<Integer>t=new TreeSet<Integer>();
    
   
    String s=""+p;
    s=s.trim();
    int l=s.length();
    for(int i=1;i<l;i++)
    {
        if(s.charAt(i)=='0')continue;
        int p1=Integer.parseInt(s.substring(i)+s.substring(0, i));
        if(p!=p1&&p1<=b&&p1>=a&&!tree.contains(p1))
        {
        //    System.out.print("\t"+p+"  "+p1);
            t.add(p1);
        }
    }
    return t.size();
}

}
