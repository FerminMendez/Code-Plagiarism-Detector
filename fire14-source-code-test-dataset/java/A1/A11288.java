public class Surprising {
    public static void main(String[] args) {
        
        int T = StdIn.readInt();
        for (int i = 1; i <= T; i++) {
            int N = StdIn.readInt();
            int S = StdIn.readInt();
            int P = StdIn.readInt();
            int count = 0;
            int sCount = 0;
            
            for (int j = 0; j < N; j++) {
                int googler = StdIn.readInt();
                if (googler > (3*P - 3))
                    count++;
                else if ((googler > (3*P - 5)) && sCount < S) {
                    if (googler != 0 && P != 1) {
                        count++;
                        sCount++;
                    }
                }               
            }
            StdOut.println("Case #" + i + ": " + count); 
        }        
    }
}
