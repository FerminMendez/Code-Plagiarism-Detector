import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class dancing {

    
    public static void dancers(String input) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/test1")); 
        String newline;
        String line;
        StringBuilder bubs = new StringBuilder();

        
        //String[] lines = input.split("\\r?\\n");
        int T = Integer.parseInt(""+in.readLine().charAt(0));

        int i=0;
        while ((line=in.readLine())!=null) {
            i++;
            String[] splitline = line.split("\\s+");
            int count = 0;
            int N = Integer.parseInt(splitline[0]);
            int S = Integer.parseInt(splitline[1]);
            int p = Integer.parseInt(splitline[2]);
            
            StringBuilder subs = new StringBuilder();
            subs.append("Case #" + i + ": ");
            
            for (int j=3;j<splitline.length;j++) {
                int t = Integer.parseInt(splitline[j]);
                if (t >= 3*p) {
                    count++;
                } else if (t >= 3*p-2 && t>0){
                    count++;
                } else if ( t>= 3*p-4 && S>0 && t>1) {
                    count++;
                    S--;
                }
            }
            subs.append(count);
            bubs.append(subs.toString());
            System.out.println(subs.toString());
        }
        
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("output"));
            out.write(bubs.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
