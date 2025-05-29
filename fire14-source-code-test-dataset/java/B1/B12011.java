
import java.util.*;


public class C
{
   public static void main(String[] args)
   {
      new C(new Scanner(System.in));
   }

   ArrayList<Integer> makeNice(int v)
   {
      ArrayList<Integer> vs = new ArrayList<Integer>();
      while (v > 0)
      {
         vs.add(v%10);
         v = v/10;
      }
      return vs;
   }

   int changeBack(ArrayList<Integer> val)
   {
      int res = 0;
      int u=1;
      for (int v : val)
      {
         res += v*u;
         u = u*10;
      }
      return res;
   }

   public C(Scanner in)
   {
      int tc = 1;
      int T = in.nextInt();
      while (T-->0)
      {
         int A = in.nextInt();
         int B = in.nextInt();
         int res = 0;
         for (int val=A; val<=B; val++)
         {
            TreeSet<Integer> ts = new TreeSet<Integer>();
            //System.out.println(val);
	//System.out.print(val+":");
	    ArrayList<Integer> vs = makeNice(val);
            for (int u=0; u<vs.size(); u++)
            {
               //System.out.println(vs);
	       if (vs.get(vs.size()-1) != 0)
               {
                  int nv = changeBack(vs);
                  if (nv > val && nv <= B)
                     ts.add(nv);
               }
               Collections.rotate(vs,1);
            }
	    //System.out.println(ts);
            res += ts.size();
	//	System.out.println(ts);
         }
         System.out.printf("Case #%d: %d%n", tc++, res);
      }
   }
}
