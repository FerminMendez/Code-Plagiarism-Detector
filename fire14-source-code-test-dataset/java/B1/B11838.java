
import java.util.*;
import java.io.*;

public class RecycledNumbers {
	public void doMain() throws Exception {
		Scanner sc = new Scanner(new FileReader("input.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		int T = sc.nextInt();
		for (int t=0; t<T; t++) {
			System.out.println("Now case " + (t+1));
			int A = sc.nextInt();
			int B = sc.nextInt();
			boolean[] flag = new boolean[B-A+1];
			for(int f=0; f<B-A; f++){
				flag[f] = false;
			}
			int ans = 0;
			for(int i=A; i<B; i++){
				if(flag[i-A]==false){
					String str = String.valueOf(i);
					String curstr = str;
					int NofR = 0;
					int NofRdN = 0;
					for(int j=0; j<str.length()-1;j++){
						String recycled = recycle(str);
						System.out.println(str + " " + recycled);
						int recycledInt = Integer.parseInt(recycled);
						if(recycledInt>Integer.parseInt(curstr) && recycledInt<=B) {
							System.out.println("found!");
							NofRdN++;
							flag[recycledInt-A] = true;
						}
						str = recycled;
					}
					System.out.println("NofRdN = " + NofRdN);
					ans = ans + ((NofRdN+1) * NofRdN)/2;
				}
			}
			System.out.println("Case #" + (t+1) + ": " + ans);
			pw.print("Case #" + (t+1) + ": " + ans);
			pw.println();
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	public static String recycle(String str){
		String last = str.substring(str.length()-1);
		String substr = str.substring(0,str.length()-1);
		String recycled = last + substr;
		return recycled;
	}


	public static void main(String[] args) throws Exception {
		(new RecycledNumbers()).doMain();
	}
}

