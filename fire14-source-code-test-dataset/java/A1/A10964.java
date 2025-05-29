import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestB {
	private final static String DAT_PATH = "/Users/ttsurumi/Downloads/";

//	private final static String dat = "A-sample-practice.in";
//	private final static String dat = "A-small-practice.in";
	private final static String dat = "B-small-attempt0.in";

	public static String datPath = DAT_PATH + dat;
	public static String ansPath = DAT_PATH + dat + ".ans";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(datPath));
			BufferedWriter bw = new BufferedWriter(new FileWriter(ansPath));
            String[] movCounts = br.readLine().split(" ");
            String tmp_str;
            int count = 1;
            while((tmp_str = br.readLine()) != null){
            	String[] row = tmp_str.split(" ");
            	long N = Long.parseLong(row[0]);
            	long s = Long.parseLong(row[1]);
            	long p = Long.parseLong(row[2]);
            	int ans = 0;
//            	p("N=" + N + ", s="+s+", p="+p);
            	for(int i = 0; i < N; i++){
            		long elm = Long.parseLong(row[i + 3]);
                	if(check(elm, p)){
 //               		p("c"+i);
                		ans++;
                	}else if(0 < s && scheck(elm, p)){
   //             		p("s"+i);
                		ans++;
                		s--;
                	}
            	}
//            	p("ans"+ans);
            	bw.write("Case #" + count + ": " + ans );
            	bw.newLine();
            	count++;
            }
            bw.flush();
		}catch(IOException e){
			System.err.println(e);
		}
	}
	private static boolean check(long elm, long max){
		if(max <= elm / 3)return true;
		if(elm % 3 == 0)return false;
		if(max <= elm / 3 + 1)return true;
		return false;
	}
	private static boolean scheck(long elm, long max){
		if(elm % 3 == 0){
			if(elm != 0 && max <= elm / 3 + 1){
				return true;
			}
		}else if(elm %3 == 2){
			if(max <= elm / 3 + 2)return true;
		}
		return false;
	}
	private static void p(String s){
		System.out.println(s);
	}
}

