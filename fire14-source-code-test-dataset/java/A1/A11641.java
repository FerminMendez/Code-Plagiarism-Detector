import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: marcus
 * Date: 4/13/12
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class DancingGooglers {
    public static void main(String a[]) throws IOException {

        int T = 0;
        FileInputStream fInputstream = null;
        try {
            fInputstream = new FileInputStream("B-small.in");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        DataInputStream in = new DataInputStream(fInputstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;

        FileWriter fstream = new FileWriter("B-small.out");
        BufferedWriter out = new BufferedWriter(fstream);

        String strT = null;
        strT = br.readLine();

        T =  Integer.parseInt(strT);



        for(int i = 1; i <= T; i++)  {
            String testCase =  br.readLine();
            StringTokenizer st = new StringTokenizer(testCase, " ");

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            //System.out.println("Number of Googlers: " + N);
            //System.out.println("Number of Surprises: " + S);
            //System.out.println("Great to have: " + p);

            int result = 0;

            int []  markSheet = new int[N];
            for(int j = 0; j < N; j++){
                markSheet[j] = Integer.parseInt(st.nextToken());
            }

            for (int k = 0; k < N; k++){
                int minValue =  p > 1 ? ((p -1) * 3): p;
                //System.out.println("Min Value : " + minValue);

                if(markSheet[k] >= p ){
                    if(p == 0 && markSheet[k] >= 0){    // m = 0
                        result++;

                    } else if(markSheet[k] > p && p <= 1){  // m = 1, 2

                        result++;

                    }else if(markSheet[k] > ((p -1) * 3)){
                        result++;
                    } else if(S > 0){
                        if(markSheet[k] == ((p -1) * 3)){
                            result++;
                            S--;
                        } else {
                            int rem = markSheet[k] % 3;
                            int val =  markSheet[k] / 3;
                            if(rem > 1){
                                if((val + 2) >= p){
                                    result++;
                                    S--;
                                }
                            } else {
                                if((val + 1) >= p){
                                    result++;
                                    S--;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + i +  ": " + result);
            System.out.println("S: " + S);

            out.write("Case #" + i + ": " + result + "\n");
        }

        in.close();
        out.close();
    }


}
