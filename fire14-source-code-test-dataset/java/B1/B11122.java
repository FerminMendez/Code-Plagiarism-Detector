
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Recycled {
    private String strLine;
    private BufferedReader f;
    private PrintWriter out;
    private ArrayList<Integer> hasil;
    
    public Recycled() {
        strLine = new String();
	try {
		f = new BufferedReader(new FileReader("c0.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("recycled.out")));
	} catch(IOException i) {
	}
	hasil = new ArrayList<Integer>();
    }
    
    public void find(int A, int B) {
        byte[] n;
        byte[] m;
        boolean isFind = false;
        int count = 0;
        for (int i = A; i < B; i++) {
            for (int j = i+1; j <= B; j++) {
                n = Integer.toString(i).getBytes();
                m = Integer.toString(j).getBytes();
                if (n.length == m.length) {
                    for (int k = 1; k < m.length && !isFind; k++) {
                        m = cls(m,8);
                        if (Arrays.equals(n, m)) {
                            isFind = true;
                        }
                    }
                    if (isFind) {
                        count++;
                        isFind = false;
                    }
                }
                
            }
        }
        hasil.add(count);
    }
    
    int byteArrayToInt(byte [] b) {
        return (b[0] << 24)
                + ((b[1] & 0xFF) << 16)
                + ((b[2] & 0xFF) << 8)
                + (b[3] & 0xFF);
    }

    byte[] intToByteArray(int value) {
        return new byte[] {
                (byte)(value >>> 24),
                (byte)(value >>> 16),
                (byte)(value >>> 8),
                (byte)value};
    }
    
    public byte[] cls(byte[] b, int k){
    
        byte[] hasil1 = b;
        byte temp = hasil1[0];
        System.arraycopy(b, 1, hasil1, 0, b.length-1);
        hasil1[b.length-1] = temp;
        return hasil1;
    }
    
    public static void main(String[] args) throws IOException {
        Recycled rec = new Recycled();
        int T;
	int A;
        int B;
	StringTokenizer st;
	
	T = Integer.parseInt(rec.f.readLine());
        System.out.println("T = " + T);
	if (T > 50 || T < 1) {
            System.out.println("Error");
	} else {
            for (int i = 0; i < T; i++) {
                if ((rec.strLine = rec.f.readLine()) != null) {
                    st = new StringTokenizer(rec.strLine);
                    A = Integer.parseInt(st.nextToken());
                    B = Integer.parseInt(st.nextToken());
                    rec.find(A,B);
                }
            }
                for (int x = 0; x < rec.hasil.size(); x++) {
                        rec.out.println("Case #" + (x + 1)+ ": " +rec.hasil.get(x));
                }
		rec.out.close();                                  // close the output file
		System.exit(0);
	}
    }
}
