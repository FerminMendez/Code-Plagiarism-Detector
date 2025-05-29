package third;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class ThirdProblem {
	private int a;
	private int b;
	private int number;
	private HashMap<Integer,HashMap<Integer, Boolean>> hash;


	public ThirdProblem(int a,int b){
		this.a=a;
		this.b=b;
		hash=new HashMap<Integer, HashMap<Integer,Boolean>>();
		for(int i=a;i<=b;i++){
			calculateCouples(i);
		}
	}


	private void calculateCouples(int n) {		
		String original=n+"";		
		for(int i=original.length()-1;i>0;i--){
			String pre=original.substring(i);
			String post=original.substring(0,i);
			int m=Integer.parseInt(pre+post);
			if(m>n && m<=b){
				HashMap<Integer, Boolean> mm=hash.get(m);
				if(mm==null)
					mm=new HashMap<Integer, Boolean>();
				if(mm.get(n)==null){
					mm.put(n, true);
					hash.put(m, mm);
					number++;
				}
			}
		}

	}
	public int getNumber() {
		return number;
	}

	public static void main(String[] args) throws Exception {
		File input=new File("input3"+File.separatorChar+"input2.in");
		File output=new File("output3"+File.separatorChar+"output2.txt");
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(output)));

		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(input)));
		br.readLine();
		String current=br.readLine();
		int cont=1;
		while(current!=null && current.trim().length()!=0){
			StringTokenizer st=new StringTokenizer(current," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int number=new ThirdProblem(a, b).getNumber();
			pw.append("Case #"+cont+": "+number);
			cont++;
			current=br.readLine();
			if(current!=null)
				pw.append("\n");
			pw.flush();
		}
		System.out.println("Finished");
	}


}
