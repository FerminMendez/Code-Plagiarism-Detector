import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;


public class RecycledNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("codejamc.in"));
		BufferedWriter brout=new BufferedWriter(new FileWriter("codejamc.out"));
		StringTokenizer sb=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(sb.nextToken());
		for(int l=1;l<=t;l++) {
			sb=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(sb.nextToken());
			int B=Integer.parseInt(sb.nextToken());
			HashSet<String> set=new HashSet<String>();
			for(int i=A;i<=B;i++) {
				String inp=i+"";
				String result="";
				for(int j=1;j<inp.length();j++) {
				     result=inp.substring(j)+inp.substring(0,j);
				     if(!inp.equals(result) && Integer.parseInt(result)<=B && Integer.parseInt(result)>=A && (Integer.parseInt(inp)+"").length()==(Integer.parseInt(result)+"").length()) {
				    		set.add(inp+" "+result);
							set.add(result+" "+inp);
				     }
				}
			
				
			}
			brout.write("Case #"+l+": "+set.size()/2+"\n");
		}
		brout.close();
		return;
	}
}
