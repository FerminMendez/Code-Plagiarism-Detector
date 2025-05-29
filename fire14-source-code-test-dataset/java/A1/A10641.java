/**
 * 
 */

/**
 * @author Ambar
 * Apr 14, 2012
 * 10:34:18 PM
 */
public class QB {

	 int canBeatReqd(int total, int reqdPoints) {
         int result = 0;
         int max;
         if (total % 3 == 2) max = total / 3 + 2;
         else if (total % 3 == 0) max = total / 3 + 1;
         else max = total / 3 + 1;
         if (max >= reqdPoints) result += 2;
         if (total % 3 == 0) max = total / 3;
         else if (total % 3 == 1) max = total / 3 + 1;
         else max = total / 3 + 1;
         if (max >= reqdPoints) result += 1;
         return result;
     }
	 
     static void program() {
         //test(); return;
         int n = Utility.getNoOfTestCases("E:\\Temp\\GCJ2012\\Q2\\B-small-attempt0.in");
         String[] inputss = Utility.getContents("E:\\Temp\\GCJ2012\\Q2\\B-small-attempt0.in");
         for (int i = 1; i <= n; ++i) {
//             var inputs = Console.ReadLine().Split().Select(kk => int.Parse(kk)).ToArray();
             String[] inputs2 = inputss[i].split(" ");
             int N = Integer.parseInt(inputs2[0]);
             int S = Integer.parseInt(inputs2[1]);
             int p = Integer.parseInt(inputs2[2]);
//             int N = inputs[0], S=inputs[1], p=inputs[2];
             int beats = 0, beatsIfApart=0;
             for (int j = 3; j < 3 + N; ++j) {
                 int total = Integer.parseInt(inputs2[j]);
                 // only total of 2 onwards can be apart
                 if (total > (p - 1) * 3) beats++;
                 else if (total>1 && total >= (p - 1) * 3 - 1) beatsIfApart++;
             }
             int totalBeats = beats + Math.min(beatsIfApart, S);
             System.out.println("Case #"+(i)+": "+totalBeats);
//             Console.WriteLine("Case #{0}: {1}", i + 1, totalBeats);
         }
     }
     
	public static void main(String[] args) {
		program();
	}

}
