import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Recycle {
	
	int low, high;
	ArrayList<NumPair> instances;
	
	public Recycle(int low, int high) {
		this.low = low;
		this.high = high;
		this.instances = new ArrayList<NumPair>();
	}
	
	public void reset(int low, int high) {
		this.low = low;
		this.high = high;
		this.instances.clear();
	}
	
	NumPair moveDigits(int num, int digits) {
		String numStr = Integer.toString(num);
		int startIndex = numStr.length() - digits;
		String sub = numStr.substring(startIndex);
		String ret = sub.concat(numStr.substring(0,startIndex));	
		return new NumPair(num, Integer.parseInt(ret));
	}
	
	boolean checkRecycled(NumPair num) {
		if (num.orig == num.modded || num.modded > num.orig)
			return false;
		if (num.modded >= low && num.modded <= high) {
			return true;
		} 
		return false;
	}
	
	public void compute() {
		int length = Integer.toString(low).length();
		for (int i=low; i<=high; i++) {
			for (int j=1; j<length; j++) {
				NumPair shifted = moveDigits(i, j);
				if (checkRecycled(shifted)) {
					if (!instances.contains(shifted)) {
						instances.add(shifted);
					}
				}
			}
		}
	}
	
	public int getLow() {
		return low;
	}
	
	public int getInstances() {
		return instances.size();
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public static void main(String[] args) {
		File input = new File("C-small-attempt0.in");
		Recycle driver = new Recycle(1111,2222);
		if (!input.canRead())
			System.out.println("Can't read file!");
		int count=1;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(input));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null && !line.isEmpty()) {
				StringTokenizer tokenizer = new StringTokenizer(line, " ");
				String low = tokenizer.nextToken();
				String high = tokenizer.nextToken();
				driver.reset(Integer.parseInt(low), Integer.parseInt(high));
				driver.compute();
				System.out.println("Case #" + count +": " + driver.getInstances());
				count++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public class NumPair {
		int orig, modded;
		
		public NumPair(int orig, int modded) {
			this.orig = orig;
			this.modded = modded;
		}
		
		@Override public boolean equals(Object o) {
			NumPair n = (NumPair)o;
			if ((n.orig == orig && n.modded == modded) || (n.orig == modded && n.modded == orig)) {
				return true;
			}  
				return false;
		}
		
		public String toString() {
			return orig + ", " + modded;
		}
	}
	
}
