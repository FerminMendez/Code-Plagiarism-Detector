import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class C {
    public static void main(String args[]){
    	String fn="C:\\codejam\\C.in";
        String fnOut="C:\\codejam\\C.out";
try{
	BufferedReader br = new BufferedReader(new FileReader(fn));
	BufferedWriter bw = new BufferedWriter(new FileWriter(fnOut));
	String line = null;
	int NCase = Integer.valueOf(br.readLine().trim());
	long stime = System.currentTimeMillis();
	for(int icase=0;icase<NCase;icase++){
		String[] a = toStringArray(br.readLine());
		int buf = procesar(a);
		String out = "Case #"+(icase+1)+": "+buf;
		bw.write(out,0,out.length());
		bw.newLine();
		long ctime = System.currentTimeMillis();
                        System.out.println(out);
		//System.out.println(String.format("--- Done: #%2d,%3.0fs, ends in:%2.1fm",(icase+1),(ctime-stime)*0.001,(ctime-stime)*0.001/60*NCase/(icase+1)));
	}
	br.close();
	bw.close();
}catch(IOException ex){
	System.out.println(ex);
}
    	
    }
    
    
    
    static String[] toStringArray(String line){
        String[] p = line.trim().split("\\s+");
        //int[] out = new int[p.length];
        //for(int i=0;i<out.length;i++) out[i] = Integer.valueOf(p[i]);
        return p;
}



	static public int procesar(String nums[]){
    	int x = 0;
    	long A = new Long(nums[0]);
    	long B = new Long(nums[1]);

    	for(long i = A; i<= B; i++){
    		
    		List<Long> num = new ArrayList<Long>();
    		
    		for(long j = 1; j<(new Long(A).toString()).length(); j++){
    			
    			long p1 = (long) (i/(Math.pow(10,j)));
    			long p2 = (long) (i%(Math.pow(10,j)));
    			long pn = new Long(p2+""+p1);
    			//System.out.println("Aca " + pn );
    			if(pn>i&&pn<=B){
    				if(!num.contains(pn)){
    					num.add(pn);
    					x++;
    				}
    				System.out.println(x + " - " + i +  ": " + pn);
    			}

    		}
    	}
    	return (x);
    }
}
