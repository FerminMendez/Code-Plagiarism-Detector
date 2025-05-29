/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

/**
 *
 * @author Sriram
 */
//import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class RecycledNumbers_GCJ_2012{

    public static void main(String args[]) throws Exception
    {
      Scanner in = new Scanner(new java.io.FileInputStream("f:\\input.in"));
      PrintStream out = new PrintStream(new FileOutputStream("f:\\output.out"));
      int T = in.nextInt();
      for(int zz=0; zz<T;zz++)
      {
          int A,B;
          A = in.nextInt();
          B = in.nextInt();
          HashSet<Integer> s = new HashSet<Integer>();
          int count = 0;
          for(int i=A;i<(B+1);i++)
          {
              int[] perm = rotations(i);
              for(int e: perm)
              {
                  if((e>=A)&&(e<=B)&&(e>i))
                  {
                     s.add(e);
                     count++;
                  }
              }
          }
          out.printf("Case #%d: %d\n",(zz+1),count);
      }
    }

    static int[] rotations(int n) {
        // Max places for small set: 4
        // Max places for large set: 7
        int places = 1;
        if((n/1000>0))
        {
        if (n == 1000) {
            return new int[]{1000, 100, 10, 1};
        }
        int a,b,c,d;
        d = n%10;
        a = n/1000;
        b = (n-(a*1000))/100;
        c = ((n%100)-d)/10;
        return new int[]{(a*1000+b*100+c*10+d),(b*1000+c*100+d*10+a),(c*1000+d*100+a*10+b),(d*1000+a*100+b*10+c)};
        }
        if ((n / 100) > 0) {
            if (n == 100) {
                return new int[]{100, 10, 1};
            }
            int x, y, z;
            z = n%10;
            x = n/100;
            y = (n-(x*100)-z)/10;
            return new int[]{(x * 100) +(y * 10) + z, (y * 100 + z * 10 + x), (z * 100 + x * 10 + y)};
        }
        if((n/10)>0)
        {
            if(n == 10)
                return new int[]{10,1};
            int x,y;
            x = n/10;
            y = n%10;
            return new int[]{x*10+y,y*10+x};
        }
        return new int[]{n};

    }
}
