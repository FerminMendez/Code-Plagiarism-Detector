import java.util.*;
import java.io.*;
public class GoogleB {
	
	public static int doit(int s, int p, ArrayList<Integer> arr){
		int count =0 ;
		for (int i = 0; i < arr.size(); i++){
			if ((p-1>=0 && arr.get(i) >= 2*(p-1) + p) || (arr.get(i) >= 3*p)){
				count++;
				arr.remove(i);
				i--;
			}
			else if ((p-2 >= 0 && arr.get(i) >= 2*(p-2) + p && s > 0)){
				arr.remove(i);
				s--;
				i--;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(new File("B-small.txt"));
		int lines = scan.nextInt();
		for (int i = 0; i < lines; i++){
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < n; j++){
				arr.add(scan.nextInt());
			}
			System.out.println("Case #" + (i+1) + ": " + doit(s, p, arr));
		}
	}
}
