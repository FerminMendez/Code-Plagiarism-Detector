import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author Bageshwar
 *
 */
public class Dance {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		

		
		BufferedReader fr = new BufferedReader(new FileReader(new File(args[0])));
		String str =fr.readLine();
		System.out.println(str);
		int lines = Integer.parseInt(str);
		FileWriter writer = new FileWriter(new File(args[1]));
		StringTokenizer stk ;
		for(int i=0;i<lines;i++){
		
			str = fr.readLine();
			stk = new StringTokenizer(str," ");
			int c = Integer.parseInt((String) stk.nextElement());
			int surprize = Integer.parseInt((String) stk.nextElement());
			int high = Integer.parseInt((String) stk.nextElement());
			int data[] = new int[c];
			int triplets[][] = new int[c][3];
			boolean surprizeFlag=(surprize==0);
			int surprizeCount=0;
			int countHigh=0;
			System.out.print("Case #("+surprize+")"+(i+1));
			writer.write("Case #"+(i+1)+": ");
			System.out.print(" "+high+": ");
			for(int j=0;j<c;j++){
				data[j]=Integer.parseInt((String) stk.nextElement());
				triplets[j]=getTriplets(data[j],surprizeFlag,high);
				if(isSurprize(triplets[j]) && (++surprizeCount)>=surprize)
					surprizeFlag=true;
			
				System.out.print(data[j]+"="+Arrays.toString(triplets[j])+" ");
				if(isHigh(triplets[j],high))
					countHigh++;
			}
			System.out.println(countHigh+"");
			writer.write(countHigh+"\r\n");
		}
		writer.close();
		fr.close();
		
	}
	
	private static boolean isHigh(int[] is,int h) {
		if(is[0]>=h || is[1]>=h || is[2]>=h)
			return true;
		return false;
	}

	static boolean isSurprize(int[] a ){
		if(Math.abs(a[0]-a[1])>1)
			return true;
		
		if(Math.abs(a[0]-a[2])>1)
			return true;
		
		if(Math.abs(a[1]-a[2])>1)
			return true;
		
		return false;
			
	}

	
	private static int[] getTriplets(int x,boolean surprizeFlag,int high){
		
		if(x==0)
		return new int[]{0,0,0};
		//int x=20;
		int a,b,c;
		a=x/3;
		int t=3*a-x;
		if(t%2==0){
			//adjusting for highest
			if( (a>=high || (a-t/2) >=high) ||  
					((a-t/2)+1)<high ||
					surprizeFlag){
				b=(a-t/2);
				c=b;
			}else{
				System.out.print("(!)");
			b=(a-t/2)+1;
			c=b-2;
			}
			//b=b+1;
			//c=c-1;
		}else {
			//remainder is 1 ! 
			b=a;
			c=b-t;
		}
		//System.out.printf("%d %d %d",a,b,c);
		return new int[]{a,b,c};
		
	}
}
