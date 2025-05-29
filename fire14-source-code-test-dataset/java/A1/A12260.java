import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class B {

	public static int convert(String input) {
		int output = 0;
		String[] pairs = input.split(" ");
//		int N = Integer.parseInt(pairs[0]);
		int S = Integer.parseInt(pairs[1]);
		int P = Integer.parseInt(pairs[2]);
		int[] numbers = new int[pairs.length - 3];
		for (int i = 3; i < pairs.length; i++) {
			numbers[i - 3] = Integer.parseInt(pairs[i]);
		}
		boolean[] done = new boolean[numbers.length];
		boolean[] five = new boolean[numbers.length];
		boolean[] sur = new boolean[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			for (int j = P; j <= num; j++) {
				if ((3 * j) == num 
						|| ((j + (j - 1) + (j - 1)) == num && ((j-1)>=0))
						|| ((j + j + (j - 1)) == num && ((j-1)>=0))
						|| (j + (j + 1) + (j + 1)) == num
						|| (j + j + (j + 1)) == num
						
				) {
//					System.out.println("1 : "+num);
					done[i] = true;
					five[i] = true;
					sur[i] = false;
					break;
				}
			}
		}
		int surprised = 0;
		for (int i = 0; i < numbers.length && surprised < S; i++) {
			if (!done[i]) {
				int num = numbers[i];
				for (int j = P; j <= num; j++) {
					if (       (((j - 2) + (j - 1) + (j)) == num&& ((j-1)>=0)&& ((j-2)>=0))
							|| (((j - 2) + (j) + (j)) == num &&  ((j-2)>=0))
							|| (((j - 2) + (j - 2) + (j)) == num && ((j-2)>=0))
							|| ((j + 2) + (j + 1) + (j)) == num
							|| ((j + 2) + (j) + (j)) == num
							|| ((j + 2) + (j + 2) + (j)) == num
					) {
//						System.out.println("2 : "+num);
						done[i] = true;
						five[i] = true;
						sur[i] = true;
						surprised ++;
						break;
					}
				}
			}
		}
		if(surprised < S){
			for (int i = 0; i < numbers.length && surprised < S; i++) {
				if (!done[i]) {
					int num = numbers[i];
					for (int j = 0; j <= num; j++) {
						if (       (((j - 2) + (j - 1) + (j)) == num&& ((j-1)>=0)&& ((j-2)>=0)&& ((j-1)!=P)&& ((j-2)!=P)&& ((j)!=P))
								|| (((j - 2) + (j) + (j)) == num &&  ((j-2)>=0)&& ((j-2)!=P)&& ((j)!=P))
								|| (((j - 2) + (j - 2) + (j)) == num && ((j-2)>=0)&&((j-2)!=P)&& ((j)!=P))
						) {
//							System.out.println("3 : "+num);
							done[i] = true;
							five[i] = false;
							sur[i] = true;
							surprised ++;
							break;
						}
					}
				}
			}
		}
		if(surprised < S){
			for (int i = 0; i < numbers.length && surprised < S; i++) {
				if (!sur[i]&&five[i]) {
					int num = numbers[i];
					for (int j = P; j <= num; j++) {
						if (       (((j - 2) + (j - 1) + (j)) == num&& ((j-1)>=0)&& ((j-2)>=0))
								|| (((j - 2) + (j) + (j)) == num &&  ((j-2)>=0))
								|| (((j - 2) + (j - 2) + (j)) == num && ((j-2)>=0))
								|| ((j + 2) + (j + 1) + (j)) == num
								|| ((j + 2) + (j) + (j)) == num
								|| ((j + 2) + (j + 2) + (j)) == num
						) {
//							System.out.println("4 : "+num);
							done[i] = true;
							five[i] = true;
							sur[i] = true;
							surprised ++;
							break;
						}
					}
				}
			}
		}
		if(surprised < S){
			for (int i = 0; i < numbers.length && surprised < S; i++) {
				if (!sur[i]&&five[i]) {
					int num = numbers[i];
					for (int j = 0; j <= num; j++) {
						if (       (((j - 2) + (j - 1) + (j)) == num&& ((j-1)>=0)&& ((j-2)>=0)&& ((j-1)!=P)&& ((j-2)!=P)&& ((j)!=P))
								|| (((j - 2) + (j) + (j)) == num &&  ((j-2)>=0)&& ((j-2)!=P)&& ((j)!=P))
								|| (((j - 2) + (j - 2) + (j)) == num && ((j-2)>=0)&&((j-2)!=P)&& ((j)!=P))
						) {
//							System.out.println("5 : "+num);
							done[i] = true;
							five[i] = false;
							sur[i] = true;
							surprised ++;
							break;
						}
					}
				}
			}
		}
		
//		if(surprised < S)
//			System.out.println("lesaa");
//		System.out.println(surprised + "----"+S);
		
		for (int i = 0; i < sur.length; i++) {
			if(five[i])
				output++;
		}
		return output;
	}

	public static void main(String[] args) {
		String inputFile = "B-small-attempt4.in";
		String outPutFile = "B-small4.out";
		try {
			FileInputStream fstream = new FileInputStream(inputFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			FileWriter fstream2 = new FileWriter(outPutFile);
			BufferedWriter out = new BufferedWriter(fstream2);
			String strLine;
			strLine = br.readLine();
			int casesNum = Integer.parseInt(strLine);
			for (int i = 0; i < casesNum; i++) {
				strLine = br.readLine();
				String parse = "Case #" + (i + 1) + ": " + convert(strLine);
				System.out.println(parse);
				if (i < casesNum - 1)
					parse += "\n";
				out.write(parse);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
