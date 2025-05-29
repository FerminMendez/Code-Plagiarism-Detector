import java.io.*;
import java.util.*;
public class B {
	public static int a [];
	public static void main(String[] args) throws Exception{
		int N = 100;
		a = new int[N];
		File f = new File("B-small-attempt0.in");
		Scanner sc = new Scanner(f);
		int t = sc.nextInt();
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
		for(int i = 0;i<t;i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			for(int j = 0;j<n;j++) {
				a[j] = sc.nextInt();
			}
			bw.write("Case #"+(i+1)+": "+maxResult(n,s,p));
			bw.write("\r\n");
		}
		bw.close();
		sc.close();
	}
	public static int maxResult(int n,int s,int p) {
		int t = 0;
		int temp;
		for(int i = 0;i<n;i++){
			if(a[i]<0||a[i]>30) continue;
			if((a[i]>= 3*p)||((a[i]+1 == 3*p||a[i]+2 == 3*p)&&p>=1))
				t ++;
			else {
				if(s>0)
				if((a[i]+3 == 3*p||a[i]+4 == 3*p)&&p>=2){
					s--;
					t++;
				}				
			}
		}
		return t;
	}
}