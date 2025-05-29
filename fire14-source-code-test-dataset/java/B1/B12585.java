

import java.util.Scanner;

/**
 *
 * @author krishna
 */
public class Recycled {
   

    public static void main(String[] args) {
        Program();
    }

    public static void Program() {
        Scanner inp = new Scanner(System.in);
        String line;
        String nor[];
        int num1, num2;
        int test = Integer.parseInt(inp.nextLine());
        int num = 1;
        while (num <= test) {
            line = inp.nextLine();
            nor = line.split(" ");
            num1 = Integer.parseInt(nor[0]);
            num2 = Integer.parseInt(nor[1]);
            System.out.println("Case #"+num+": "+CountNum(num1, num2));
            num++;
        }


    }

    public static int CountNum(int num1, int num2) {
        int count = 0;
        int goMax[]={9,99,999,9999,99999,999999};
        int goMin[]={0,10,100,1000,10000,100000};
        int length;
        for (int x = num1; (x < num2) && !leadingZeros(x); x++) {
            {
                 length=Integer.valueOf(x).toString().length();
                 count +=found(x,Math.max(num1,(int)goMin[length-1]),(int)Math.min(num2,goMax[length-1]));
                     
            }
        }

        return count;
    }

    private static int found(int num, int min, int max) {
     
        int part1;
        int part2;
        int zero=10;
        String join;
        int rem;
        int count=0;
          while(num/zero !=0)
          {
              rem=num%zero;
           
              part1=rem;
              part2=num/zero;
              
                
              join=part1+""+part2;
              zero =zero*10;
             if(Integer.parseInt(join)>=min && Integer.parseInt(join)<=max && Integer.parseInt(join) > num  && checkLength(num,join)  ){
                  
                  count++;
              }
             
              if(alternate(join,max))
                  count--;
          }
        return count;
    }
 public static boolean leadingZeros(int num)
{
  String str=num+"";
  if(str.charAt(0)=='0')
      return true;
  else
      return false;
      
}
 public static boolean checkLength(int num1,String str2)
 {
     String str1=num1+"";
     if(str1.length() == str2.length())
         return true;
     else
         return false;
 }
 public static boolean alternate(String str,int max)
 {
     String str2=str.substring(1);
     str2=str2+str.charAt(0);
     if(str==str2)
     {
         return true;
     }
     else
         return false;
 }
}

