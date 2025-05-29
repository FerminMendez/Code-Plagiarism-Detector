import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestB {
	private final static String DAT_PATH = "/Users/ttsurumi/Downloads/";

//	private final static String dat = "A-sample-practice.in";
//	private final static String dat = "A-small-practice.in";
//	private final static String dat = "B-sample.in";
	private final static String dat = "C-small-attempt0.in";
	 
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
            	long min = Long.parseLong(row[0]);
            	long max = Long.parseLong(row[1]);
            	int width = row[0].length();
            	bw.write("Case #" + count + ": " );
            	long ans = 0;
            	System.out.println("min = " + min + ", max = " + max + ", width" + width);
               	for(long i = min; i < max; i++){
            		long t= check(i,min,max,width);
            		ans += t;
            		if(t != 0)System.out.println("ans = " + ans + ", t = " + t);
               	}
            	bw.write(ans+"");
            	bw.newLine();
            	count++;
            }
            bw.flush();
		}catch(IOException e){
			System.err.println(e);
		}
	}
	private static long check(long l,long min, long max, int width){
		long count = 0;
		long next = (long)Math.pow(10, width-1);
		long t = l % 10;
		long h = l / 10;
		long shift = h + t * next;
		if(shift == l )return 0;
		shift=l;
		for(int i = 0; i < width - 1; i++){
			t = shift % 10;
			h = shift / 10;
			shift = h + t * next;
			if(min < shift && l < shift && shift <= max ){
				System.out.println("l = " + l + ", ans" + shift);
				count++;
			}
		}
		return count;
	}
}
