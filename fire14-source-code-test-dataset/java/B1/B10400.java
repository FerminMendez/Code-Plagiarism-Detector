import java.io.*;

class RecycledNumbers
{
  public static void main(String[] args)
  {
    try {
    //parse the input
    FileInputStream fstream = new FileInputStream(args[0]);
    DataInputStream dstream = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(dstream));
    String line = "";

    int numCases = Integer.parseInt(br.readLine());
//System.out.println("num cases: " + numCases);

    for(int lineIdx = 0; lineIdx < numCases; lineIdx++)
    {
      line = br.readLine();
      String[] words = line.split(" ");
      int n = Integer.parseInt(words[0]);
      int m = Integer.parseInt(words[1]);
//System.out.println(n + " " + m);
      int numRecycledNumbers = 0;
      for(int i = n; i <= m; i++)
      {
        for(int j = i+1; j <= m; j++)
          if(countRecycledNumbers(i, j))
            numRecycledNumbers++;
      }
//System.out.println(numRecycledNumbers);
      // write output
      BufferedWriter out = new BufferedWriter(new FileWriter("outfilename", true)); 
      out.write("Case #" + (lineIdx+1) + ": " + numRecycledNumbers + "\n");
      out.close(); 
    }
  }
  catch(FileNotFoundException ex)
  {
    System.out.println(ex);
  }
  catch(IOException ex)
  {
    System.out.println(ex);
  }
  }

  static boolean countRecycledNumbers(int n, int m)
  {
    String nStr = "" + n;
    String mStr = "" + m;
//System.out.println(nStr + " " + mStr);
    if(nStr.length() == mStr.length())
    {
//System.out.println("length condition hit");
      if( (nStr+nStr).indexOf(mStr) >= 0 )
      {
//        System.out.println("index condition hit");
        return true;
//System.out.println(numRecycledNumbers);
      }
    }
    return false;
  }
}


