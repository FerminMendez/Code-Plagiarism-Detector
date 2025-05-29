import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class RecycledNumbers {
	public static int calcRecycled(int A, int B) {
		int total = 0;
		for(int i = 0; i < B-A+1; i++) {
			int[] temp = getCycles(i+A);
			for(int x: temp) {
				if(x == -1)
					continue;
				if(x <= i+A)
					continue;
				if(x <= B && x >= A) {
					total++;
				}
			}
		}
		return total;
	}
	public static int[] getCycles(int init) {
		String s = init+"";
		int[] array = new int[s.length()-1];
		for(int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i+1) == '0')
				array[i] = -1;
			else {
				int temp = Integer.parseInt(s.substring(i+1) + s.substring(0, i+1));
				for(int j = 0; j < i; j++) {
					if(array[j] == temp) {
						temp = -1;
						break;
					}
				}
				array[i] = temp;
			}
		}
		return array;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader("C-small-attempt0.in.txt"));
		int T = Integer.parseInt(read.readLine());
		for(int i = 1; i <= T; i++){
			StringTokenizer st = new StringTokenizer(read.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println("Case #" + i + ": " + calcRecycled(A, B));
		}
	}
}
