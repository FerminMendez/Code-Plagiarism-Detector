/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam;

/**
 *
 * @author PRATIK
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int test=args.length/2;
      

        int len=0,i,m,tem,val=0,l=0,count=0,count1=0,j=1,k;
        char arr[];
        String sec;
        int secnd;
        char temp;
        int f=1;
        int[] array=new int[500];
        int[][] array1=new int[1000][2];
        while(test!=0)
        {
            int start=Integer.parseInt(args[f]);
            int end=Integer.parseInt(args[f+1]);
            while(start<end)
            {
            String st=String.valueOf(start);
            len=st.length();
            char arr1[]=new char[len];
            if(len>1)
            {
            for(i=0;i<len;i++)
            {
                arr=st.toCharArray();

                temp=arr[len-1];
                for(k=1;k<len;k++)
                    arr1[k]=arr[k-1];
                arr1[0]=temp;
                st=String.valueOf(arr1);
                val=Integer.parseInt(st);
                if(val<=end && val>start)
                {
                    array1[l][0]=start;
                    array1[l][1]=Integer.parseInt(st);
                    l++;
                    count1++;
                }

            }
            }
            start++;
            }
            for(i=0;i<l;i++)
            {
                for(k=i+1;k<l;k++)
                {
                    if(array1[k][0]==array1[i][0] && array1[k][1]==array1[i][1])
                    {
                        if(count1>0)
                     count1--;
                    }
                }
            }


            System.out.println("Case #"+j+ ": "+count1);
            j++;
            test--;
            count1=0;
            f=f+2;
            l=0;
        }
    }

}
