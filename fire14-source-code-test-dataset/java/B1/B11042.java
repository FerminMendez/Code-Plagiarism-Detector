   import java.util.*;
   import java.io.*;

    class recycled_numbers
   {
       public static void main(String[] args) throws Exception
      {
         BufferedReader in = new BufferedReader(new FileReader("recnum.in"));
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recnum.out")));
      
         int n = Integer.parseInt(in.readLine());
         int ans = 0;
         for(int x = 0; x<n; x++)
         {
            out.print("Case #" + (x+1) + ": ");
            ans = 0;
            String input = in.readLine();
            StringTokenizer token = new StringTokenizer(input, " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            for(int y = a; y<=b; y++)
            {
               for(int z = y+1; z<=b; z++)
               {
                  if(recycled("" +y,""+z))
                     ans++;
               }
            }
            out.println(ans);
         }
         out.close();
      }
       public static boolean recycled(String a, String b)
      {
         if(a.length() != b.length() || hash(a)!=hash(b))
				return false;
         //if(a.length() < b.length())
         //   return recycled("0"+a, b);
			//else if(b.length() < a.length())
			//	return recycled(a,"0"+b);
     
	   	
         for(int x = 0; x<a.length(); x++)
         {
            if(a.equals(b))
               return true;
            a = a.substring(1,a.length())+a.substring(0,1);
         }
         if(a.equals(b))
            return true;
         return false;
      }
		
		public static int hash(String a)
		{
			int sum = 0;
			for(int x = 0; x<a.length(); x++)
			{
				int b = (int)(a.charAt(x));
				sum+=b;
			}
			return sum;
		}
   }