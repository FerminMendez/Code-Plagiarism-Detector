import java.io.BufferedReader;
import java.io.InputStreamReader;


public class C {

	boolean rec(int i, int j){
		String s1 = i+"";
		String s2 = j+"";
		if(s1.length() != s2.length())
			return false;
		
		String concat = s1+s1;
		if(!concat.contains(s2))
			return false;
		return true;
	}
	void run() {
		try {
			BufferedReader bfd = new BufferedReader(new InputStreamReader(
					System.in));
			int tc = Integer.parseInt(bfd.readLine()), i, j, k, a, b, cnt;
			String sp[];
			for(k=0; k<tc; ++k){
				sp = bfd.readLine().split(" +");
				a = Integer.parseInt(sp[0]);
				b = Integer.parseInt(sp[1]);
				cnt = 0;
				for(i=a; i<=b; ++i)
					for(j=i+1; j<=b; ++j)
						if(rec(i, j))
							cnt++;
				System.out.print("Case #"+(k+1)+": "); 
				System.out.print(cnt);
				System.out.println();
			}
			
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new C().run();
	}

}

