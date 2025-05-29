import java.io.*;
public class GoogleCodeJam3 
{
  public static void main(String[] args) throws IOException 
   {
        FileInputStream fstreami = new FileInputStream("input.txt");
        DataInputStream in = new DataInputStream(fstreami);
        FileWriter fstreamo = new FileWriter("output.txt");
        BufferedWriter out = new BufferedWriter(fstreamo);
        int testCases = Integer.parseInt(in.readLine());
        int i = 0;
        String [] input;
        while (i < testCases)
        {
            input = in.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int testNum = A;
            int pairs = 0;
            int len = Integer.toString(A).length();
            while(testNum <= B)
            {
				String st = Integer.toString(testNum);
				int [] testing = new int[len];
				int index = 0;
				for(int j = 0; j < len-1; j++)
				{
                    st = st.substring(len-1, len) + st.substring(0,len-1);
                    int newNum = Integer.parseInt(st);
 	//				System.out.println(newNum);
                  if ((newNum > testNum) && (newNum <= B))
                    {
                        boolean bool = false;
                        for (int k = 0; k < index; k++)
                        {
                            if (testing[k] == newNum)
                            {
	//							System.out.println("fuckfuckfuckfuckfuckfuckfuck");
                                bool = true; break;
                            }
                        }
                        if (bool == false)
                        {
                           pairs++;
                           testing[index] = newNum;
						   index++;
                        }
                    }
                }
                testNum++;
            }
            out.write("Case #" + (i+1) + ": " + pairs + "\n");
            i++;
        }
        in.close();
	out.close();
   }
}