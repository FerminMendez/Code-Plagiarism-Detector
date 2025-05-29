package qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class c {

	public static void main(String[] args){
		if(args.length<1){
			System.out.println("Usage: <fnIn>");
		}
		String fn = args[0];
		String fnOut = toFnOut(fn);
		try{
			BufferedReader br = new BufferedReader(new FileReader(fn));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fnOut));
			int NCase = Integer.valueOf(br.readLine().trim());
			long stime = System.currentTimeMillis();
			for(int icase=0;icase<NCase;icase++){
				String[] a =  br.readLine().trim().split("\\s+");
				int result = process(a[0],a[1]);
				String out = "Case #"+(icase+1)+": "+result;
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
	static int process(String X, String Y){
		int xlenght = X.length();
		int ylength = Y.length();
		if( xlenght == 1 && ylength == 1 ) return 0;
		
		int x = Integer.valueOf(X);
		int y = Integer.valueOf(Y);
		String K = X;
		int k = x;
		int result = 0;
		while(k>=x && k<=y ){
			int klength = K.length();
			if(klength ==1) k++;
			else{ 
				for(int r = 1;r<klength;r++){
					int newk = Integer.valueOf(K.substring(r)+K.substring(0, r));
					if(newk==k) break;
					if(newk>=x && newk>k && newk<=y ){
						result++;
					}
				}
				k++;
			}
		
		K = Integer.toString(k);	
		}
		
		return result;
	}

	
	static String toFnOut(String fn){
		if(fn.lastIndexOf('.')!=-1){
			return fn.substring(0,fn.lastIndexOf('.'))+".out";
		}else return fn + ".out";
	}
}
