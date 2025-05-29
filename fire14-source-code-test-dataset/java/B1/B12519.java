import java.util.*;
import java.io.*;
public class Rec{
	public static void rotateArray(char[] array, int amount) 
	{ 
		for( int j=0; j<amount; j++) {
			char a = array[0];
			int i;
			for(i = 0; i < array.length-1; i++){
				array[i] = array[i+1];
			}
			array[array.length-1]= a;
		}
	}
	public static boolean check(int a,int b,int c){
		return (c <=b && c>=a);
	}
	public static boolean sameElem(char[] c){
		for(int i=0;i<c.length-1;i++){
			if(c[i]!=c[i+1])
				return false;
		}
		return true;
	}
	public static boolean equal(char[] a,char[] b){
		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("c.out"));
		String num = br.readLine();
		String line = br.readLine();
		
		int casenum=1;
		while(line!=null){
			String[] nums = line.split(" ");
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			int digits = nums[0].length();
			int ctr=0;
			if(digits<=1){
				pw.println("Case #"+casenum+": "+0);
				casenum++;
				line = br.readLine();
				continue;
			}
			
			for(int i=a;i<=b;i++){
				String cmp = Integer.toString(i);
				LinkedHashSet<String> set = new LinkedHashSet<String>();
				char[] arr = cmp.toCharArray();
				int range=0;
				int equal=0;
				for(int j=0;j<digits-1;j++){
					rotateArray(arr,1);
					if(sameElem(arr))
						continue;
					String sss = new String(arr);
					if(sss.equals(cmp))
						continue;
					if(set.contains(sss))
						continue;
					if(check(a,b,Integer.parseInt(sss))){
						set.add(sss);
					}
				}
				ctr+=set.size();
			}
			pw.println("Case #"+casenum+": "+(ctr/2));
			casenum++;
			line = br.readLine();
		}
		pw.flush();
	}
}