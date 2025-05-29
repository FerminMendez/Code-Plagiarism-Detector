import java.io.*;
public class RecycledNumbers
{
    public void RecycledNumbers()throws IOException
    {        
          FileInputStream fstream = new FileInputStream("C:/Users/m.l/Desktop/C-small-attempt0.in"); 
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          int T=Integer.parseInt(br.readLine());
          String S[]=new String[T];int i,j,k,s,l,p,q,A=0,B=0;String a,temp1;
          for(i=0;i<T;i++)
          { 
              s=0;
              S[i]=br.readLine();l=S[i].length();
              for(j=0;j<l;j++)
              {
                  if(S[i].charAt(j)==' ')
                  {
                      A=Integer.parseInt(S[i].substring(0,j));
                      B=Integer.parseInt(S[i].substring(j+1));
                    }
                }
             for(j=A;j<=B;j++)
             {
                 a=Integer.toString(j);int temp2[]=new int[l];l=a.length();
                 for(k=0;k<l-1;k++)
                 {
                     temp1=a.substring(1)+a.charAt(0);temp2[k]=Integer.parseInt(temp1);
                     a=temp1;
                    }
              for(p=0;p<l;p++)
              {
                  q=0;
                  if(temp2[p]>j&&temp2[p]<=B&&temp2[p]>=A)
                  for(q=p+1;q<l;q++)
                  {
                      if(temp2[q]==temp2[p])
                      break;
                    }
                 if(q==l)
                 s+=1;
                }
            }
             System.out.println("Case #"+(i+1)+": "+s);   
            }
        }
    }