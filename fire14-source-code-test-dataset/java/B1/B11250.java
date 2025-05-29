import java.io.*;
import java.util.*;
public class C {
	public static int a;
	public static int b;
	public static void main(String[] args) throws Exception{
		File f = new File("C-small-attempt0.in");
		Scanner sc = new Scanner(f);
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
		int n = sc.nextInt();
		for(int i = 0;i<n;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			bw.write("Case #"+(i+1)+": "+count(a,b));
			bw.write("\r\n");			
		}
		bw.close();
		sc.close();
	}
	public static int count(int a,int b) {
		int k = 0;
		int temp = a;
		int total = 0;
		int temp2;
		while(temp>0) {
			k++;
			temp /=10;
		}
		int [] v = new int[k+1];
		for(int i = a;i<=b;i++) {
			temp = 0;
			temp2 = i;
			for(int j = 0;j<k;j++) {				
				temp2 =  (temp2%10)*((int)Math.pow(10,k-1)) + temp2/10;
				if(temp2>i&&temp2<=b) {
					v[temp] = temp2;
					temp++;
					for(int t = 0;t<temp-1;t++) {
						if(v[t]==temp2){
							temp--;
							break;
						}
					}					
				}
			}
			total +=temp;			
		}	
		return total;
	}
}