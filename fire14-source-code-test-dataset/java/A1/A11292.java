import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingGooglers
{
  public static void main(String[] args)
  {
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
      FileWriter fileWriter = new FileWriter(args[1]);

      String casesNo = reader.readLine();

      for (int t = 0; t < Integer.parseInt(casesNo); t++)
      {
        String[] params = reader.readLine().split(" ");

        int y = 0;
        int s = Integer.parseInt(params[1]);
        int p = Integer.parseInt(params[2]);

        int normalLimit = (3 * p) - 2;
        int suprisingLimit = normalLimit - 2;

        for (int n = 0; n < Integer.parseInt(params[0]); n++)
        {
          int ti = Integer.parseInt(params[n + 3]);

          if (ti >= normalLimit)
            y++;
          else if (suprisingLimit>0 && s>0 && ti >= suprisingLimit)
          {
            y++;
            s--;
          }


//          int pi = ti%3 > 0 ? (ti/3)+1 : ti/3;
//
//          if (pi >= p)
//            y++;
//          else if (ti > 1 && ti < 29 && s > 0 && pi + 1 == p)
//          {
//            y++;
//            s--;
//          }
        }
        fileWriter.write("Case #" + (t + 1) + ": " + Integer.toString(y) + "\n");
      }

      fileWriter.flush();
      fileWriter.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
