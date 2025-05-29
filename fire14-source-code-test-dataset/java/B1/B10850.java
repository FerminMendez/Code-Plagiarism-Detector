import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class C {
    
    private static boolean isRecyledPair(String n, String m) {
        int l = n.length();
        String s = "";
        
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < l; j++) {
                s += n.charAt((j+i) % (l));
            }
            if (s.equals(m)) {
                return true;
            }
            s = "";
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File(args[0]));
            int T = Integer.parseInt(file.nextLine());
            
            BufferedWriter out = new BufferedWriter(new FileWriter(args[0].substring(0, args[0].length()-2) +"out"));
            for (int i = 0; i < T; i++) {
                int A = file.nextInt();
                int B = file.nextInt();
                
                int ans = 0;
                for (int j = A; j < B; j++) {
                    for (int k = j+1; k <= B; k++) {
                        if (isRecyledPair(String.valueOf(j), String.valueOf(k))) {
                            ans++;
                        }
                    }
                }
                
                out.write(new StringBuilder().append("Case #").append(i+1).append(": ").append(ans).append("\n").toString());
            }
            out.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}