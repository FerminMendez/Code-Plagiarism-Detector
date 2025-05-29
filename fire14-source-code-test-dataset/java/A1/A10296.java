package B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class B {
	public static void main(String[] args) {
		B b = new B();
		b.run(args[0], "result");
	}
	
	public B() {
		
	}
	
	public void run(String inputFile, String outputFile) {
		String directory = this.getClass().getResource("").getPath() + "\\";
		inputFile = directory + inputFile;
		outputFile = directory + outputFile;
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(inputFile);
			bufferedReader = new BufferedReader(fileReader);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		if (bufferedReader != null) {
			int testCount = 0;
			try {
				testCount = Integer.parseInt(bufferedReader.readLine());
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
			StringBuilder builder = new StringBuilder(3400);
			
			for (int i = 1; i <= testCount; i++) {
				if (i > 1) {
					builder.append("\r\n");
				}
				builder.append("Case #");
				builder.append(i);
				builder.append(": ");
				
				String input = null;
				try {
					input = bufferedReader.readLine();
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
				
				String[] strs = input.split(" ");
				int length = strs.length;
				int[] ints = new int[length];
				
				for (int j = 0; j < length; j++) {
					try {
						ints[j] = Integer.parseInt(strs[j]);
					} catch (Exception e) {
					}
				}
				
				int case1 = 0;
				int case2 = 0;
				int case3 = 0;
				
				int s = ints[1];
				int p = ints[2];
				
				int a = 3 * p - 4;
				int b = a + 2;
				
				if (a < 2) {
					a = 2;
				}
				if (b < 2) {
					b = 2;
				}
				
				for (int j = 3; j < length; j++) {
					int test = ints[j];
					
					if (test >= a) {
						if (test > 28) {
							case3++;
						} else if (test >= b) {
							case1++;
						} else {
							case2++;
						}
					} else if (p == 1 && test >= 1) {
						case3++;
					} else if (p == 0) {
						case3++;
					}
				}
				
				if (case2 > s) {
					case2 = s;
				}
				
				builder.append(case1 + case2 + case3);
			}
			
			//System.out.println(builder.toString());
			try {
				FileWriter writer = new FileWriter(outputFile);
				writer.append(builder.toString());
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}