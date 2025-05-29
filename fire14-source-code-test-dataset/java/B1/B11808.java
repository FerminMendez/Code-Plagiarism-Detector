import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Recycled {

	
	public static boolean isRecycled(int a, int b) {
		String left = a+"";
		String right = b+"";
		if(left.length()!=right.length()) return false;
		int l = left.length();
		for(int i=0;i<l;i++) {
			boolean o = true;
			for(int j=0;j<l;j++) {
				if(left.charAt((i+j)%l) == right.charAt(j)) continue;
				else o=false;
			}
			if(o) return true;
		}
		return false;
	}
	
	public static int next(int in) {
		int p = (int) (Math.log(in)/Math.log(10));
		int last = in - Math.abs(in/10)*10;
		if(last==0) return 0;
		return (int) (last*Math.pow(10, p) + in/10);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println(isRecycled(12345, 234521));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(in.readLine());
		for (int i = 1; i <= cases; i++) {
			String[]e = in.readLine().trim().split(" ");
			int A = Integer.parseInt(e[0]);
			int B = Integer.parseInt(e[1]);
			
			int count = 0;
			
			for(int x=A;x<B;x++) for(int y=x+1;y<=B;y++) if(isRecycled(x, y)) count ++;
			
			System.out.println("Case #"+i+": "+count);
		}
	}
	
}
