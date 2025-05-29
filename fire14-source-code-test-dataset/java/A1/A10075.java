import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class q2 {
	public static int calc(int n, int s, int p,ArrayList<Integer> scores) {
		int count = 0;
		int aboveAve = 0;
		for(int i = 0;i < n;i++) {
			if(scores.get(i) >= 3*p) {
				aboveAve ++;
				continue;
			}
			if((scores.get(i) >= (3*p - 2))&&(3*p - 2 >= 0)) {
				aboveAve ++;
			} else {
				if((scores.get(i) >= (3*p - 4))&&(3*p - 4 >= 0)) {
					count ++;
				}
			}
		}
		if(count > s) {
			count = s;
		}
		count = count + aboveAve;
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		int p = 0;//at least p
		int s = 0;//surprise
		int n = 0;//n dancers
			try {
			FileReader fr = new FileReader("D:\\B-small-attempt1.in");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("D:\\y.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String str = br.readLine();
			int t = Integer.parseInt(str); 
			for(int i = 0;i < t;i++) {
				String data = br.readLine();
				String[] numbers = data.split(" ");
				n = Integer.parseInt(numbers[0]);
				s = Integer.parseInt(numbers[1]);
				p = Integer.parseInt(numbers[2]);
				for(int j = 0;j < n;j++) {
					scores.add(Integer.parseInt(numbers[j + 3]));
				}
				String prefix = "Case #" + (i+1) + ": ";
				System.out.print(prefix + calc(n, s, p, scores) + "\n");
				bw.write(prefix + calc(n, s, p, scores) + "\n");
				scores.clear();
			}
			br.close();
			fr.close();
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
