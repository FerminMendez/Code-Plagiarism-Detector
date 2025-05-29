
/**
 * Write a description of class solver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class solver
{
    public int aise(int a[],int k,int j)
    {
        int i;
        int temp=0;
        for(i=0;i<j;i++)
        {
            temp=temp*10+a[(i+k)%j];
        }
        return temp;
    }

    public int[] reverse(int a[],int j)
    {
        int i,temp;
        for(i=0;i<j/2;i++)
        {
            temp=a[i];
            a[i]=a[j-i-1];
            a[j-i-1]=temp;
        }
        return a;
    }

  public boolean greater(int a[],int i,int n)
  {
      int j=0;
      for(j=0;j<n;j++)
      {
          if(a[(i+j)%n]<a[j])
          return false;
          else if(a[(i+j)%n]>a[j])
          return true;
        }
        return false;
    }
    public boolean lesser(int a[],int b[],int k,int j,int n1)
    {
        if(j<n1)
        return true;
        else
        {
            int i=0;
            for(i=0;i<n1;i++)
            {
                if(a[(k+i)%j]>b[i])
                return false;
                else if(a[(k+i)%j]<b[i])
                return true;
            }
            return true;
        }
    }


    public int solve(int a,int b)
  {
      int i,k,s;
      int n1=0,temp,temp1=b,j;
      int[] arr=new int[10];
      int count=0;
      int[] arr2=new int[10];
      int[] comp=new int[10];
      while(temp1>0)
          {
              arr2[n1++]=temp1%10;
              temp1=temp1/10;
           }
    
      arr2=reverse(arr2,n1);
      for(i=a;i<b;i++)
      { 
          temp=i;
          j=0;
          while(temp>0)
          {
              arr[j++]=temp%10;
              temp=temp/10;
           }
           arr=reverse(arr,j);
           s=0;
           for(k=j-1;k>0;k--)
           {
               if(arr[k]!=0)
               {
                   if(greater(arr,k,j) && lesser(arr,arr2,k,j,n1))
                   {
                   count++;
                   comp[s++]=aise(arr,k,j);
                }
                }
            }
            for(k=0;k<s;k++)
            {
                for(j=k+1;j<s;j++)
                    {
                           if(comp[k]==comp[j])
                           {
                               count--;
                            }
                        }
                    }
                
            }
          return count;
        }
      
      
    }
    

