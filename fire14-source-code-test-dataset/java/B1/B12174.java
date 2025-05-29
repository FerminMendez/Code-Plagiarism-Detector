import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class recycle {

    
    public static void rec() throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/test1")); 

        String line;
        StringBuilder bubs = new StringBuilder();


        int T = Integer.parseInt(""+in.readLine().charAt(0));

        int i=0;
        while ((line=in.readLine())!=null) {
            i++;
            String[] splitline = line.split("\\s+");
            
            int A = Integer.parseInt(splitline[0]);
            int B = Integer.parseInt(splitline[1]);
            int d = splitline[0].length();

            StringBuilder subs = new StringBuilder();
            subs.append("Case #" + i + ": ");
            int count = 0;

            for (int n=A;n<B;n++) {
                String sn = ""+n;
                HashMap<Integer, Integer> hm = new HashMap();

                for (int b=0;b<d-1;b++) {
                    String r = sn.substring(d-1-b);
                    String l = sn.substring(0, d-1-b);
                    String btry = (r+l);
                    if (!hm.containsKey(Integer.parseInt(btry)) && btry.charAt(0)!='0' && Integer.parseInt(btry) > n && Integer.parseInt(btry) <=B) {
                        hm.put(Integer.parseInt(btry), 1);
                        count++;
            
                    }
                    
                }

            }
            subs.append(count);
            bubs.append(subs.toString());
            System.out.println(subs.toString());
        }
        

    }
    
}
