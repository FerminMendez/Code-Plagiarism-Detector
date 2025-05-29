import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class RecycledNums {
	public static String rootDir = System.getProperty("user.dir") + File.separator;
	public static String filesDir = rootDir + "files" + File.separator;
	private FileWriter fw;
	
	private int tests;
	private int[] a;
	private int[] b;
	private int[] pow10 = {1,10,100,1000,10000,100000,1000000,10000000};
	
	
	public static void main(String[] args) {
		RecycledNums r = new RecycledNums();
		r.go();
	}
	
	public RecycledNums() {
		try {
			Scanner input = new Scanner(new File(filesDir + "recycled.txt"));
			Scanner line;
			tests = Integer.parseInt(input.nextLine());
			a = new int[tests];
			b = new int[tests];			
			
			for (int c  = 0; c < tests; c++) {
				line = new Scanner(input.nextLine());
				
				a[c] = line.nextInt();
				b[c] = line.nextInt();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i] + " " + b[i]);
//		}
	}
	
	public void go() {
		
		open();
		int[] r;
		int count;
		HashMap<Integer,Integer> h;
		for (int c = 0; c < tests; c++) {
			count = 0;
			h = new HashMap<Integer,Integer>();
			
			for (int n = a[c]; n <= b[c]; n++) {
				if (digits(n) < 2)
					continue;
				
				if (h.containsKey(n))
					continue;
				r = getRecycledNums(n);
				
				for (int i = 0; i < r.length; i++) {
					for (int j = i + 1; j < r.length; j++) {
						if (r[i] < a[c] || r[i] > b[c] || r[j] < a[c] || r[j] > b[c])
							continue;
						if (digits(r[i]) != digits(r[j]))
							continue;
						if (r[i] == r[j])
							continue;
						
						count++;
					}
				}
				add(r,h);
			}
			
			write("Case #" + (c+1) + ": " + count);
			if (c != tests-1)
				write("\n");
			System.out.println("Case #" + (c+1) + ": " + count);
		}
		close();
	}
	
	private void add(int[] r,HashMap<Integer,Integer> h) {
		for (int n : r)
			if (!h.containsKey(n))
				h.put(n, n);
	}
	
	private int digits(int n) {
		if (n == 0)
			return 0;
		return 1 + digits(n/10);
	}
	
	private int[] getRecycledNums(int n) {
		int[] digits = new int[digits(n)];
		int[] nums = new int[digits.length];
		int start;
		int num;
		
		for (int i = 0; i < digits.length; i++)
			digits[i] = (n/pow10[i])%10;
		
		for (int i = 0; i < digits.length; i++) {
			start = i;
			num = 0;
			
			for (int j = 0; j < digits.length; j++) {
				num += digits[start]*pow10[j];
				
				start = (start+1)%digits.length;
			}
			
			nums[i] = num;
		}
		return check(nums);
		
	}
	
	private int[] check(int[] n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i : n)
			if (!list.contains(i))
				list.add(i);
		
		return toIntArray(list);
	}
	
	private int[] toIntArray(ArrayList<Integer> list) {
		int[] temp = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++)
			temp[i] = list.get(i).intValue();
		return temp;
	}
	private void open() {
		try {
			fw = new FileWriter(new File(filesDir + "recycledAns.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void write(String s) {
		try {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
