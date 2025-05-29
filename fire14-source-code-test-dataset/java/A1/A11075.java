/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package b;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mrzk
 */
public class Main
{
    /**
     * @param args the command line arguments
     */
    private static  int numberOfSurprises,max,res;
    private static ArrayList<Integer> resultList=new ArrayList<Integer>();
    public static void main(String[] args)
    {
        try 
        {
            Scanner inp = new Scanner(new File("mm.in"));
            FileWriter fw=new FileWriter(new File("mm.out"));
            int cnt=Integer.valueOf(inp.nextLine());
            for (int i = 0; i < cnt; i++)
            {
                res = calcMax(inp.nextLine());
                fw.write("Case #"+String.valueOf(i+1)+": "+String.valueOf(res)+"\n");
            }
            fw.close();
            inp.close();
        } catch (Exception ex)
        {
        }
    }

    private static int calcMax(String line)
    {
        resultList.clear();
        int result=-1;
        ArrayList arr=new ArrayList();
        int posSpace=line.indexOf(' ');
        int numberOfGooglers=Integer.valueOf(line.substring(0, posSpace));
        line=line.substring(posSpace+1);

        posSpace=line.indexOf(' ');
        numberOfSurprises=Integer.valueOf(line.substring(0, posSpace));
        line=line.substring(posSpace+1);

        posSpace=line.indexOf(' ');
        max=Integer.valueOf(line.substring(0, posSpace));
        line=line.substring(posSpace+1);


        for(int i=0;i<numberOfGooglers;i++)
        {
            posSpace=line.indexOf(' ');
            int t=0;
            if(posSpace!=-1)
                t=Integer.valueOf(line.substring(0, posSpace));
            else
                t=Integer.valueOf(line);
            arr.add(makeSet(t));
            line=line.substring(posSpace+1);
        }

        res=0;

        mmmmm(arr, 0, 0);
        //esult=calc(arr, 0, max, numberOfSurprises,0,0);
        for(int i=0;i<resultList.size();i++)
        {
            int tempul=resultList.get(i);
            result=Math.max(result,tempul);
        }

        return result;
    }

    private static void mmmmm(ArrayList arr,int index,int srps)
    {
        int temp=res;
        int temp2=srps;
        Set[] sets=(Set[])arr.get(index);
        for(Set st:sets)
        {
            temp=res;
            temp2=srps;
            if(st.max()>=max)
                res++;
            if(st.isSurprising())
                srps++;
            if(srps>numberOfSurprises)
            {
                res=temp;
                srps=temp2;
                continue;
            }
            else
            {
                if((index+1)<arr.size())
                {
                    mmmmm(arr, index+1, srps);
                    res=temp;
                    srps=temp2;
                }
                else
                {
                    if(srps==numberOfSurprises)
                        resultList.add(res);
                    return;
                }
            }
        }
        return;
    }

    private static int calc(ArrayList arr,int index,int max, int srp, int res,int csrp)
    {
        index++;
        int cnt=res;
        Set[] sets=(Set[])arr.get(index);
        for(Set st:sets)
        {
            cnt=res;
            if(st.max()>=max)
                cnt++;
            if(st.isSurprising())
                csrp++;
            calc(arr, index, max, srp, res, csrp);
        }
        return cnt;
    }

    private static Set[] makeSet(int sum)
    {
        Set[] mySets=new Set[0];
        int mean=sum/3;
        for(int a=mean-2;a<=(mean+2);a++)
        {
            for(int b=mean-2;b<=(mean+2);b++)
            {
                for(int c=mean-2;c<=(mean+2);c++)
                {
                    if((a+b+c==sum)&&(checkNums(a, b, c)))
                    {
                        boolean cnd=false;
                        Set tmp=new Set(a, b, c);
                        for(int z=0;z<mySets.length;z++)
                        {
                            if(mySets[z].equals(tmp))
                            {
                                cnd=true;
                                break;
                            }
                        }
                        if(cnd)
                            continue;
                        mySets=resizeArray(mySets, mySets.length+1);
                        mySets[mySets.length-1]=tmp;
                    }
                }
            }
        }
        return mySets;
    }

    private static boolean checkNums(int a,int b,int c)
    {
        if((a<0)||(b<0)||(c<0))
            return false;
        int minim=Math.min(a, Math.min(b, c));
        int maxim=Math.max(a, Math.max(b, c));
        if((maxim-minim)<=2)
            return true;
        else
            return false;
    }

    private static Set[] resizeArray(Set array[], int newSize)
    {
        Set[] newArray = new Set[newSize];
        for(int i = 0 ; i < array.length ; i++)
            newArray[i] = array[i];
        return newArray;
    }

}


class Set
{
    private int a,b,c;
    public Set(int a,int b,int c)
    {
        if((a<=b)&&(b<=c))
        {
            this.a=a;
            this.b=b;
            this.c=c;
        }
        else if((b<=a)&&(a<=c))
        {
            this.a=b;
            this.b=a;
            this.c=c;
        }
        else if((b<=c)&&(c<=a))
        {
            this.a=b;
            this.b=c;
            this.c=a;
        }
        else if((a<=c)&&(c<=b))
        {
            this.a=a;
            this.b=c;
            this.c=b;
        }
        else if((c<=a)&&(a<=b))
        {
            this.a=c;
            this.b=a;
            this.c=b;
        }
    }

    public int max()
    {
        return (Math.max(a, Math.max(b, c)));
    }

    public boolean equals(Set st)
    {
        if((a==st.a)&&(b==st.b)&&(c==st.c))
            return true;
        else
            return false;
    }

    public boolean isSurprising()
    {
        if((c-a)==2)
            return true;
        else
            return false;
    }
}
