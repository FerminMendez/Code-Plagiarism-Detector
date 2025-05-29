//Kholofelo Moyaba
//Problem C codejam
//14 April 2012

import java.util.Scanner;

class RecycledNumbers
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i=1;i<=cases;i++)
        {
            int a = input.nextInt();
            int b = input.nextInt();
            int digits = (a+"").length()-1;//number of digits -1
            int factor = 1;//factor in order of a and b
            for(int j=0;j<digits;j++,factor*=10);//factor=10^digit
            int result = 0;
            for(int n=a;n<b;n++){
                int[] buffer = new int[digits];//current pairs
                int m = n;//rotation of n into m
                for(int j=0;j<digits;j++){
                    m = m/10 + (m%10)*factor;//rotate
                    if(m<=b && n<m)//recycled pair
                    {//check if duplicate
                        boolean distinct = true;
                        for(int k=0;k<j;k++)
                            if(buffer[k]==m)
                            {
                                distinct = false;
                                break;
                            }
                        if(distinct)
                        {
                            result++;
                            buffer[j] = m;
                        }
                    }
                }
            }
            System.out.println("Case #"+i+": "+result);
        }
    }
}