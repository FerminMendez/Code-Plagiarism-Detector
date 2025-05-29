import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;


public class RecycledNumbers {
	
	public static void main(String []args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File("C-small-attempt0.in")));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("out")));
		int T = Integer.parseInt(reader.readLine());
		
		for(int i = 0;i<T;i++){
			HashSet<ValuePairs> set = new HashSet<ValuePairs>();
			
			String[] limits = reader.readLine().split(" ");
			int A = Integer.parseInt(limits[0]);
			int B = Integer.parseInt(limits[1]);
	
			for(int j = A;j<B;j++){
				LinkedList<Character> list = new LinkedList<Character>();
				String num = ""+j;
				for(int k = 0;k<num.length();k++){
					list.add(num.charAt(k));
				}
				for(int k = 1;k<num.length();k++){
					Collections.rotate(list, 1);
					String temp = "";
					for(int m = 0; m < num.length(); m++){
						temp += list.get(m);
					}
					int result = Integer.parseInt(temp);
					if(result>j&&result<=B){
						set.add(new ValuePairs(j,result));
						System.out.println(j+" "+result+"\n");
					}
				}
			}
			
			writer.write("Case #"+(i+1)+": "+set.size()+"\n");
			writer.flush();
		}
	}

}
