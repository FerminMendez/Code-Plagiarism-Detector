package qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class b {

	public static void main(String[] args){
		if(args.length<1){
			System.out.println("Usage: <fnIn>");
		}
		String fn = args[0];
		String fnOut = toFnOut(fn);
		try{
			System.out.println("dir : "+System.getProperty("user.dir"));
			BufferedReader br = new BufferedReader(new FileReader(fn));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fnOut));
			int NCase = Integer.valueOf(br.readLine().trim());
			long stime = System.currentTimeMillis();
			for(int icase=0;icase<NCase;icase++){
				int[] a = toIntArray(br.readLine());
				int buf = process(a);
				String out = "Case #"+(icase+1)+": "+buf;
				bw.write(out,0,out.length());
				bw.newLine();
				long ctime = System.currentTimeMillis();
				System.out.println(String.format("--- Done: #%2d,%3.0fs, ends in:%2.1fm",(icase+1),(ctime-stime)*0.001,(ctime-stime)*0.001/60*NCase/(icase+1)));
			}
			br.close();
			bw.close();
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	static int process(int []a){
		int result = 0;
		int n = a[0]; // the number of Googlers
		int s = a[1]; // the number of surprising triplets of scores
		int p = a[2]; // threshold score	
			
		for(int i=3;i<=2+n;i++){
			int r = a[i]%3;
			int q = (a[i]-r)/3;
			if(a[i]>=(3*p)){ 
				result++;
			}else if( q>=p-2){
				if(q==p-1 && r!=0){
					result++;
				}
				else if(s>0 && canBeSurprising(a[i], p)){
					s--;
					result++;
				}
			}	
		}
		return result;
	}
	
	static boolean canBeSurprising(int n,int s){
		boolean result = false;
		int r = n%3;
		int q = (n-r)/3;
		if(q==s-2){
			if(r==2) return true;
		}
		if(q==s-1){
			if(r==0 && s>=2)return true;
		}
				
		return result;
	}
	
	static int[] toIntArray(String line){
		String[] p = line.trim().split("\\s+");
		int[] out = new int[p.length];
		for(int i=0;i<out.length;i++) out[i] = Integer.valueOf(p[i]);
		return out;
	}
	
	static String toFnOut(String fn){
		if(fn.lastIndexOf('.')!=-1){
			return fn.substring(0,fn.lastIndexOf('.'))+".out";
		}else return fn + ".out";
	}

}
