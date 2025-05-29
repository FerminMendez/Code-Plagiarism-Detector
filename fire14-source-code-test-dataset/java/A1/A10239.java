/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package codejam.practice;

/**
 *
 * @author Saikat Roy
 */
import java.io.*;
public class Main1 {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public void input() throws IOException
    {
       int k=1;
       int n=Integer.parseInt(br.readLine());
       while(n--!=0)
       {
           String str1=br.readLine();
           String[] str2=new String[40];
           str2=str1.split("[ ]");
           
           int N=Integer.parseInt(str2[0]);
           int S=Integer.parseInt(str2[1]);
           int p=Integer.parseInt(str2[2]);
           int x=0;
           int[] arr=new int[N];
           while(x<N){
               arr[x]=Integer.parseInt(str2[x+3]);
               x++;
           }
           
           for(int k1=0;k1<N-1;k1++)
               for(int k2=k1+1;k2<N;k2++)
                   if(arr[k2]<arr[k1])
                   {
                       int hold=arr[k1];
                       arr[k1]=arr[k2];
                       arr[k2]=hold;
                   }
           
           
           
          // for(int m=0;m<N;m++)
          // System.out.print(arr[m]+" ");
               

           int flag=0;
           int[] check=new int[6];
           check[0]=(3*p)-4;
           check[1]=(3*p)-3;
           check[2]=(3*p)-2;
           check[3]=(3*p)+2;           
           check[4]=(3*p)+3;
           check[5]=(3*p)+4;
           
           String[] allocation=new String[N];
           
           for(int y=0;y<N;y++){
               allocation[y]="A";
               if(p>1)
               if(((arr[y]==check[0])||(arr[y]==check[1]||(arr[y]==check[2])))&&(S!=0))
               {
                   //System.out.println(y);
                   flag++;
                   S--;
                   //allocation[y]="";
                   allocation[y]="X";
               }
            }
           
           
          
           if(S!=0){
              for(int y=0;y<N;y++){
               if(((arr[y]==check[3])||(arr[y]==check[4]||(arr[y]==check[5])))&&(S!=0))
               {
                //   System.out.println("x");
                   flag++;
                   S--;
                   //allocation[y]="";
                   allocation[y]="X";
               }
            } 
           }
           
           int chk=(3*p)-2;
           if(p==0)
               chk=0;
           
           
           for(int y=0;y<N;y++){
             //  System.out.println(allocation[y]);
               if(arr[y]>=chk && allocation[y].equals("A"))
               {
                   //System.out.println("x");
                   flag++;
                  //allocation[y]="";
                   allocation[y]="X";
               }
           }
           //if(S!=0)
              // flag-=S;
           
          // for(int y=0;y<N;y++)
            //   System.out.println(allocation[y]);
           
           System.out.print("Case #"+k+": "+flag);
             if(n!=0)
           System.out.println();
           k++;
       }
    }
     
    public static void main(String[] args) throws IOException {
        Main1 ob=new Main1();
        ob.input();
    }
}
