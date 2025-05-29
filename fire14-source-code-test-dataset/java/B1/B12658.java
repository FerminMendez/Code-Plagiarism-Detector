import java.util.Scanner;
public class plain
{
    static int A[],B[],n[];
public static void main(String args[])
{
    int t=0;
    Scanner in=new Scanner(System.in);
    t=in.nextInt();
    in.nextLine();
    A=new int[t];
    B=new int[t];
    n=new int[t];
    for(int i=0;i<t;i++)
    {
        String a=in.nextLine();
        int q=Integer.parseInt(a.substring(0,a.indexOf(" ")));
        int c=Integer.parseInt(a.substring(a.indexOf(" ")+1));
        A[i]=q;
        B[i]=c;        
    }
    int num=A[0];
    for(int i=0;i<t;i++)
    {
        n[i]=getTot(i);
        System.out.println("Case #1:"+n[i]);
    }    
}


public static int getTot(int i)
{
    int n=A[i];
    int   g=0,l=(Math.abs(B[i]-A[i]))-2,tot=0;       
    
    for(int j=0;j<l;j++)
    {           
        int n1=getNo(n,i);                
        tot+=n1;        
        n++;
    }
 
    return tot;
}
public static int getNo(int no,int i)
{
    int num=no,a=0,b=0,len=0;
    while(num!=0)        
    {
        a=num%10;        
        num=num/10;
        len++;
    }  
    num=no;
    int arr[]=new int[len];
    a=0;
    int l=0;
    while(num!=0)
    {
       a=num%10;
       arr[l++]=a;       
       num/=10;
    }
    num=no;       
    int no2[]=new int[Math.abs(A[i]-B[i])],g=0;
    int ln=-1,tot=0;
    for(int o=arr.length-1;o>=0;o--)
    {       
     b=arr[0]; 
    for(int p=0;p<(len-1);p++)
    {
        arr[p]=arr[p+1];  
    }
    arr[len-1]=b;        
    int rev=0;
    a=0;
    for(int p=0;p<len;p++)
    {
      rev+=arr[p]*Math.pow(10,p);
    }      
    if(rev>=A[i] && rev<=B[i] && rev>num )
        {            
          for(int k=0;k<(A[i]-B[i]);k++)  
          {  
              if(rev==no2[i])
              {
                  g=1;
                  break;
              }
          }
          if(g==0)
          {
            ln++;
            no2[ln]=rev;
            tot++;      
          }          
          g=0;          
        }             
    }
    return tot;
}

}
