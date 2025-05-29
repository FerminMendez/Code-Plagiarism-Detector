import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;

public class D {
	public static void main(String[] args) throws IOException {
		int n;

		InputStreamReader reader = new InputStreamReader(new FileInputStream(
				args[0]));
		BufferedReader read = new BufferedReader(reader);
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(args[1])));

		// Scanner scan = new Scanner(System.in);
		n = Integer.parseInt(read.readLine());
		// n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			String p = read.readLine();
			write.write("Case #" + (i + 1) + ": " + holy(p, read));
			write.newLine();
		}
		write.flush();
		write.close();
	}

	static int holy(String r, BufferedReader read) throws IOException {
	    String p = r;
        String s, temp, m;
        int a = 0;
        int b = 0;
        int panjang = 0;
        int result = 0;

        a = Integer.parseInt(p.substring(0, p.indexOf(" ")));
        b = Integer.parseInt(p.substring(p.indexOf(" ") + 1, p.length()));

        for (int i = a; i <= b; i++) {
            s = Integer.toString(i);
            panjang = s.length();
            for (int j = 1; j < panjang; j++) {
                temp = s.substring(0, j);
                m = s.substring(j, panjang) + temp;
                if (Integer.parseInt(m) == i) {
                } else 
                if (Integer.parseInt(m) <= b && Integer.parseInt(m) >= a) {
                    result++;
                }
            }
        }
        
        if ((result % 2) == 0) {
            result = result/2;
        } else
        if (result % 2 == 1) {
            result = result/2+1;
        }
        
        return result;
	}
}