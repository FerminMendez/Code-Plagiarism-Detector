import java.io.*;

public class RecycledNumbers {

	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Need a filename.");
		}
		else {
			File file = new File(args[0]);
			try {
				BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				int numCases = Integer.parseInt(fin.readLine());
				for(int i=0; i<numCases; i++) {
					String line = fin.readLine();
					int min = Integer.parseInt(line.substring(0, line.indexOf(" ")).trim());
					int max = Integer.parseInt(line.substring(line.indexOf(" ")).trim());
					int count = 0;
					for(int a=min; a<max; a++) {
						for(int b = a+1; b<=max; b++) {
							if(isRecycled(a, b))
								count++;
						}
					}
					System.out.println("Case #" + (i+1) + ": " + count);
				}
			} catch(FileNotFoundException e) {
				System.err.println("File not found!");
			} catch(IOException e) {
				System.err.println("Could not read file!");
			}
		}
	}
	
	private static boolean isRecycled(int a, int b) {
		String aStr = "" + a;
		String bStr = "" + b;
		for(int i=1; i<aStr.length(); i++) {
			if((aStr.substring(i) + aStr.substring(0, i)).equals(bStr))
				return true;
		}
		return false;
	}
}
