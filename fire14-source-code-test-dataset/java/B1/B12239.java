import java.io.*;
import java.util.*;

public class QualiC_Naive
{
  static void sop(String str)
  {
    System.out.println(str);
  }
  
  static void sop1(String str)
  {
    System.out.print(str);
  }
  
  public static void main(String args[])
  {
    long tstart = System.currentTimeMillis();
    if(args.length < 1)
    {
      System.out.println("You have not given input file!");
      System.exit(0);
    }
    File f1 = null;
    Scanner sc = null;
    try
    {
      f1 = new File(args[0]);
      sc = new Scanner(f1);
    }
    catch(Exception e)
    {
      System.out.println("Error opening the input file " + e);
    }
    /*
      int nCases, i, j, k, m, n;
      sc.next();
      sc.nextInt();
      sc.nextLine();
      sc.nextDouble();
    */
    int nCases, i, j, k, m, n;
    nCases = sc.nextInt();
    // sc.nextLine();
    for(i=1; i<=nCases; ++i)
    {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int ans = 0;
      String strn = "" + a;
      // String strm = "" + b;
      int len = strn.length();
      int mult=0;
      switch(len)
      {
        case 2: mult = 10; break;
        case 3: mult = 100; break;
        case 4: mult = 1000; break;
        case 5: mult = 10000; break;
        case 6: mult = 100000; break;
        case 7: mult = 1000000; break;
      }
      if(len == 1)
        ans = 0;
      else
      { 
      /*
        try
	{
	  FileWriter tempf = new FileWriter("temp.dat");
	  BufferedWriter buff = new BufferedWriter(tempf);
	  buff.write("Case " + i + ":-------------------------------------------\n");
      */
        int c[] = new int[len];
        for(j=a; j<=b; j++)
	{ 
	  c[0] = j;
	  HashSet<Integer> x = new HashSet<Integer>();
	  for(k=1; k<len; k++)
	  {
	    c[k] = (c[k-1] % 10) * mult + c[k-1] / 10;
            if(j<c[k] && c[k]<=b)
	      {
	        if(x.add(c[k]))
	          ans++;
	   //   buff.write("" + j + " - " + c2 + "\n");
	      }
	  }

	}
	/*
	  buff.close();
	}
	catch(IOException e1)
	{
	  sop("Error: " + e1);
	}
	*/
      }
  
      sop("Case #" + i + ": " + ans);
    }
    long tend = System.currentTimeMillis();
    System.err.println("Time taken: " + (tend - tstart)/1000.0 + " seconds");
  } // end of main()
}

