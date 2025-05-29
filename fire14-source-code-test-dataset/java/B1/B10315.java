package C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class C {
	private ArrayList<Integer> shift1 = new ArrayList<Integer>(2000000);
	private ArrayList<Integer> shift2 = new ArrayList<Integer>(2000000);
	private ArrayList<Integer> shift3 = new ArrayList<Integer>(2000000);
	private ArrayList<Integer> shift4 = new ArrayList<Integer>(2000000);
	private ArrayList<Integer> shift5 = new ArrayList<Integer>(2000000);
	private ArrayList<Integer> shift6 = new ArrayList<Integer>(2000000);
	
	public static void main(String[] args) {
		C c = new C();
		c.run(args[0], "result");
	}
	
	public C() {
		for (int i = 0; i < 2000000; i++) {
			if (i > 9) {
				if (i > 999999) {
					shift1.add(i % 1000000 * 10 + i / 1000000);
				} else if (i > 99999) {
					shift1.add(i % 100000 * 10 + i / 100000);
				} else if (i > 9999) {
					shift1.add(i % 10000 * 10 + i / 10000);
				} else if (i > 999) {
					shift1.add(i % 1000 * 10 + i / 1000);
				} else if (i > 99) {
					shift1.add(i % 100 * 10 + i / 100);
				} else {
					shift1.add(i % 10 * 10 + i / 10);
				}
			} else {
				shift1.add(9999999);
			}
		}
		for (int i = 0; i < 2000000; i++) {
			if (i > 99) {
				if (i > 999999) {
					shift2.add(i % 100000 * 100 + i / 100000);
				} else if (i > 99999) {
					shift2.add(i % 10000 * 100 + i / 10000);
				} else if (i > 9999) {
					shift2.add(i % 1000 * 100 + i / 1000);
				} else if (i > 999) {
					shift2.add(i % 100 * 100 + i / 100);
				} else {
					shift2.add(i % 10 * 100 + i / 10);
				}
			} else {
				shift2.add(9999999);
			}
		}
		for (int i = 0; i < 2000000; i++) {
			if (i > 999) {
				if (i > 999999) {
					shift3.add(i % 10000 * 1000 + i / 10000);
				} else if (i > 99999) {
					shift3.add(i % 1000 * 1000 + i / 1000);
				} else if (i > 9999) {
					shift3.add(i % 100 * 1000 + i / 100);
				} else {
					shift3.add(i % 10 * 1000 + i / 10);
				}
			} else {
				shift3.add(9999999);
			}
		}
		for (int i = 0; i < 2000000; i++) {
			if (i > 9999) {
				if (i > 999999) {
					shift4.add(i % 1000 * 10000 + i / 1000);
				} else if (i > 99999) {
					shift4.add(i % 100 * 10000 + i / 100);
				} else {
					shift4.add(i % 10 * 10000 + i / 10);
				}
			} else {
				shift4.add(9999999);
			}
		}
		for (int i = 0; i < 2000000; i++) {
			if (i > 99999) {
				if (i > 999999) {
					shift5.add(i % 100 * 100000 + i / 100);
				} else {
					shift5.add(i % 10 * 100000 + i / 10);
				}
			} else {
				shift5.add(9999999);
			}
		}
		for (int i = 0; i < 2000000; i++) {
			if (i > 999999) {
				shift6.add(i % 10 * 1000000 + i / 10);
			} else {
				shift6.add(9999999);
			}
		}
	}
	
	public void run(String inputFile, String outputFile) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String directory = this.getClass().getResource("").getPath() + "\\";
		inputFile = directory + inputFile;
		outputFile = directory + outputFile;
		
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
				
				int count = 0;
				if (input != null) {
					String[] strs = input.split(" ");
					int start = 0;
					int end = 0;
					
					try {
						start = Integer.parseInt(strs[0]);
						end = Integer.parseInt(strs[1]);
						System.out.print(start);
						System.out.print(' ');
						System.out.println(end);
					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
					
					for (int j = start; j < end; j++) {
						int test1 = shift1.get(j);
						int test2 = shift2.get(j);
						int test3 = shift3.get(j);
						int test4 = shift4.get(j);
						int test5 = shift5.get(j);
						int test6 = shift6.get(j);
						
						
						if (test1 > j && test1 <= end) {
							count++;
						} else {
							test1 = 0;
						}
						if (test2 > j && test2 <= end && test1 != test2) {
							count++;
						} else {
							test2 = 0;
						}
						if (test3 > j && test3 <= end && test1 != test3 && test2 != test3) {
							count++;
						} else {
							test3 = 0;
						}
						if (test4 > j && test4 <= end && test1 != test4 && test2 != test4 && test3 != test4) {
							count++;
						} else {
							test4 = 0;
						}
						if (test5 > j && test5 <= end && test1 != test5 && test2 != test5 && test3 != test5 && test4 != test5) {
							count++;
						} else {
							test5 = 0;
						}
						if (test6 > j && test6 <= end && test1 != test6 && test2 != test6 && test3 != test6 && test4 != test6 && test5 != test6) {
							count++;
						}
					}
				}
				builder.append(count);
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