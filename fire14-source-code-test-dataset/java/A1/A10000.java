import java.io.*;

class goodance
{

static int wc;
static int best;

public static void main(String args[])
throws IOException
{

FileReader fin=new FileReader("B-small-attempt2.in");
BufferedReader bin=new BufferedReader(fin);

FileWriter fout=new FileWriter("Output.txt");
BufferedWriter bout=new BufferedWriter(fout);
PrintWriter pout=new PrintWriter(bout);


int T=Integer.parseInt(bin.readLine());
String s[]=new String[T];

int omk1,omk2=3,parsm=4;
int i=0,dummy=10,r=0,test=0;
boolean flag,count;

while(i<T)
{ 
s[i]=bin.readLine();

    int l=s[i].length();
    int sp1=s[i].indexOf(' ');
    int N=Integer.parseInt(s[i].substring(0,sp1));
    int arr[]=new int[N];
    s[i]=s[i].substring(sp1+1);
   
    
    int sp2=s[i].indexOf(' ');
    int S=Integer.parseInt(s[i].substring(0,sp2));
    wc=S;
    s[i]=s[i].substring(sp2+1);
    
    
    
    int sp3=s[i].indexOf(' ');
    int P=Integer.parseInt(s[i].substring(0,sp3));
    best=P;
    s[i]=s[i].substring(sp3+1);
    
    
   
    
    for(int h=0;h<N;h++)
    {   int sp=s[i].indexOf(' ');
        if(sp==-1)
        arr[h]=Integer.parseInt(s[i].substring(0));
        else
        arr[h]=Integer.parseInt(s[i].substring(0,sp));
        
    s[i]=s[i].substring(sp+1);
    }
    
    for(int k=0;k<N;k++)
    {
        for(int a=0;a<=10;a++)
        {
            for(int b=0;b<=10;b++)
            {
                for(int c=0;c<=10;c++)
                {   
       
                    if(arr[k]==a+b+c)
                   {
                       if(flag=minmax(a,b,c))
                       { 
                           if(count=f(a,b,c))
                           {
                               int d=def(a,b,c);
                               omk1=d;
                               if(omk1<omk2)
                               {
                                parsm=omk1;
                                
                                }
                                if(omk2>omk1)
                                omk2=omk1;
                               
                            }
                        }
                    }
                }
            }
        }
        
        r+=pav(parsm);
        
        omk2=3;
        parsm=-1;
        }
        
    pout.println("Case #"+(i+1)+": "+r); 
    r=0;
   i++;
   omk2=3;
 
}    

bin.close();
pout.close();
bout.close();
fout.close();

}
    

    static boolean minmax(int n1,int n3,int n2)
    {   
       
        int max,min;
        max=(n1>n2?(n1>n3?n1:n3):(n2>n3?n2:n3));
        min=(n1<n2?(n1<n3?n1:n3):(n2<n3?n2:n3));
        
        if(max-min>2)
        return false;
        else
        return true;
    }
    
    static boolean f(int z,int m,int o)
    {   
        if(z>=best||m>=best||o>=best)
        return true;
        else 
        return false;
    }
    
    static int def(int n1,int n2,int n3)
    {
        int max,min;
        max=(n1>n2?(n1>n3?n1:n3):(n2>n3?n2:n3));
        min=(n1<n2?(n1<n3?n1:n3):(n2<n3?n2:n3));
        
        int diff=max-min;
        return diff;
    }
    
    
    static int pav(int t)
    {   int royal=0;
        if(t==2)
        {  if(wc>0)
            {royal=1;
                wc--;
            }
        }
    
        else if(t==1||t==0)
        royal=1;
        
        else
        {royal=0;
        
         }
        
         return royal;
        }
    }