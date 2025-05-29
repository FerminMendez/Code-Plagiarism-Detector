import java.io.*;

public class qua1 {
	public static int[] factorize(int i) {
		int[] re = new int[3];
		if(i==0)
			for(int ind=0; ind<3; ind++) {
				re[ind] = 0;
			}
		else {
			int temp = i / 3;
			temp++;
			for(int ind=0; ind<3; ind++) {
				re[ind] = temp;
			}
			int diff = temp * 3 - i;
			for(int ind=0; ind<diff; ind++) {
				re[ind] = re[ind] - 1;
			}
		}
		return re;
	}
	public static int[] surp(int[] arr, int l) {
		int[] re = new int[3];
		int id = 0;
		int judge = 0;
		int judge2 = 0;
		for(int ind=0; ind<3; ind++) {
			if(arr[ind]==l-1 && judge==0) {
				re[id] = l;
				judge = 1;
				id++;
			}
			else if(arr[ind]!=l-2 && judge2==0) {
				re[id] = arr[ind] - 1;
				judge2 = 1;
				id++;
			}
			else {
				re[id] = arr[ind];
				id++;
			}
		}
		return re;
	}
	public static void main(String[] args) throws IOException {
		File f = new File(".");
		File path = new File(f.getCanonicalPath()+"/src/"+"B-small-attempt2.in");
		try {
			BufferedReader buf = new BufferedReader(new FileReader(path));
			int T = Integer.parseInt(buf.readLine());
			int[] arr = new int[100];
			String str = null;
			for(int i=0;i<T;i++) {
				int[] info = new int[3];
				str = buf.readLine();
				String[] dat = str.split(" ");
				for(int ii=0;ii<3;ii++) {
					info[ii] = Integer.parseInt(dat[ii]);
				}
				int res = 0;
				int iter = info[1];
				for(int ii=0;ii<info[0];ii++) {
					int sign = 0;
					int diff2 = 0;
					arr[ii] = Integer.parseInt(dat[ii+3]);
					int[] t = factorize(arr[ii]);
					for(int iind=0;iind<3;iind++) {
						//System.out.println(t[iind]);
						if(t[iind]==info[2]-2)
							diff2++;
					}
					for(int ind=0;ind<3;ind++) {
						if(t[ind]>=info[2])
							sign = 1;
					}
					for(int ind=0;ind<3;ind++) {
						if(sign==0 && t[ind]==info[2]-1 && iter!=0 && t[ind]!=0 && diff2!=2) {
							sign = 1;
							iter--;
						}
					}
					//System.out.println(sign);
					if(sign==1)
						res++;
				}
				int line = i+1;
				System.out.println("Case #" + line + ": " + res);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
	}
}
