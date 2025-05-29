import java.io.*;
import java.util.*;

public class QualiB 
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
      int nDancers = sc.nextInt();
      int nSurprising = sc.nextInt();
      int best = sc.nextInt();
      int totpts[] = new int[nDancers];
      for(j=0; j<nDancers; j++)
        totpts[j] = sc.nextInt();
      int ans = 0;
      if(best == 0)
        ans = nDancers;
      else if(best == 1)
           {
	     for(j=0; j<nDancers; j++)
	       if(totpts[j] > 0)
	         ans++;
	   }
      else
      {
	for(j=0; j<nDancers; j++)
	{
	  if(nSurprising <= 0)
	    break;
	  if(totpts[j] == 3*best-4 || totpts[j] == 3*best-3)
	  {
	    totpts[j] = 3*best-2;
	    nSurprising--;
	  }
	}
	for(j=0; j<nDancers; j++)
	  if(totpts[j] >= 3*best-2 )
	    ans++;
      }

      sop("Case #" + i + ": " + ans);
    }
    long tend = System.currentTimeMillis();
    System.err.println("Time taken: " + (tend - tstart)/1000.0 + " seconds");
  } // end of main()
}

