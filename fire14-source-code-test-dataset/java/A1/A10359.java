import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(args[0])));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(args[1])));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			writer.write("Case #" + (i + 1) + ": " + process(reader));
			writer.newLine();
		}
		writer.flush();
		writer.close();
	}

	private static int process(BufferedReader reader) throws Exception {
		

		String s = reader.readLine();
		int end = s.indexOf(" ");
		int N = Integer.parseInt(s.substring(0, end));
		s = s.substring(end + 1);
		end = s.indexOf(" ");
		int S = Integer.parseInt(s.substring(0, end));
		s = s.substring(end + 1);
		end = s.indexOf(" ");
		int P = Integer.parseInt(s.substring(0, end));
		int count = 0;
		int score;
		for (int i = 0; i < N; i++) {
			if (i < N - 1) {
				s = s.substring(end + 1);
				end = s.indexOf(" ");
				score = Integer.parseInt(s.substring(0, end));
			} else {
				s = s.substring(end + 1);
				try {
					score = Integer.parseInt(s);
				} catch (Exception e) {
					score = 0;
				}
			}
			int base = score / 3;
			int left = score % 3;
			int max = base + (left + 1) / 2;
			if(max >= P){
				count++;
			}else if(S > 0 && base+left >= P){
				count++;
				S--;
			}else if(left == 0 && S > 0){
				if(score > P && max + 1 >= P){
					count++;
					S--;
				}
			}
			}
		return count;

		}

	}
		
	

