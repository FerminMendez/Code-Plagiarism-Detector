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

	static int holy(String s, BufferedReader read) throws IOException {
	
            int [] value = new int [103];
            String p = s;
            int i = 0;
            int min_score = 0;
            int result = 0;
            
            
            while (p.indexOf(" ") != -1){
                int pemisah = p.indexOf(" ");
                int a = Integer.parseInt(p.substring(0 , pemisah));
                value [i] = a;
                i++;
                p = p.substring(pemisah+1);
            }
            
            value [i] = Integer.parseInt(p);
            i++;
            
            switch (value[2]) {
                case 0 :
                    min_score = 0 ;
                    break;
                case 1 :
                    min_score = 1 ;
                    break;
                case 2 :
                    min_score = 2 ;
                    break;
                case 3 :
                    min_score = 5 ;
                    break;
                case 4 :
                    min_score = 8 ;
                    break;
                case 5 :
                    min_score = 11 ;
                    break;
                case 6 :
                    min_score = 14 ;
                    break;
                case 7 :
                    min_score = 17 ;
                    break;
                case 8 :
                    min_score = 20 ;
                    break;
                case 9 :
                    min_score = 23 ;
                    break;
                case 10 :
                    min_score = 26 ;
                    break;
            }
            
            int surprising = value [1];
            
			if (value[2] == 0) {
				for (int j = 3; j < i; j++) {
					result++;
				}
			} else {
				for (int j = 3; j < i; j++) {

					if ((value[j] == min_score) || (value[j] == min_score + 1)) {
						if (surprising > 0) {
							result++;
							surprising--;
						}
					}	

					if (value[j] > min_score + 1) {
						result++;
					}
				}
			}
                        
            return result;

	}
}