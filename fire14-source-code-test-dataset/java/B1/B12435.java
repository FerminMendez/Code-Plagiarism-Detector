import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecycledNumbers {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("resource/input.in"));
		int T = sc.nextInt(); 
		int i = 1;
		while (i<=T) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println("Case #"+i+": "+process(A, B));
			i++;
		}
	}
	private static int process(int A, int B) {
		List<String> added = new ArrayList<String>();
		int counter = 0;
		for(int i=A; i<=B; i++){
			String s = i+"";
			for(int j=0; j<s.length()-1; j++){
				char ch = s.charAt(0);
				s = s.concat(ch+"");
				s = s.substring(1, s.length());
				int nx = Integer.valueOf(s);
				if(nx>=A && nx<=B && nx!=i && !added.contains(i+"|"+nx) && !added.contains(nx+"|"+i)){
					counter++;
					added.add(i+"|"+nx);
					added.add(nx+"|"+i);
				}
			}
		}
		return counter;
	}
}
