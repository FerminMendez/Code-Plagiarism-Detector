import java.util.*;
import java.io.*;

class gcj2{
	public static void main(String[] args) throws IOException{
		BufferedReader inp = new BufferedReader(new FileReader("inp.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
		int test = Integer.parseInt(inp.readLine());
		int p = 1;
		while(test>0){
			String d[] = inp.readLine().split(" ");
			int a = Integer.parseInt(d[0]);
			int b = Integer.parseInt(d[1]);
			int i = a;
			int count = 0;
			while(i<=b){
				String s = new Integer(i).toString();
				int j = 1;
				HashSet<Integer> se = new HashSet<Integer>();
				while(j<s.length()){
					String temp = s.substring(j,s.length())+s.substring(0,j);
					if(temp.charAt(0)=='0') {
						j++;
						continue;
					}
					else {
						int t = Integer.parseInt(temp);
						se.add(t);
					}
					j++;
				}
				Iterator<Integer> it = se.iterator();
				while(it.hasNext()){
					int gg = it.next();
					if(gg>i&&gg<=b){
				//		System.out.println(gg +" "+i);
						count++;
					}
				}
			//	System.out.println("------------------");
				i++;
			}
			out.write("Case #"+p+": "+count+"\n");
			System.out.println(count);
			test--;
			p++;
		}
		out.close();
	}
}