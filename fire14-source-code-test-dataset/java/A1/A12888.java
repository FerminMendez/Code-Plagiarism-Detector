package second;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DanceSolver {
	private ArrayList<GooglerResult> googlers;
	int p;
	int numberOfStranges;
	int [] googlersSum;
	int max=0;
	public DanceSolver(int [] g,int value,int str){

		googlersSum=g;
		p=value;
		numberOfStranges=str;

		System.out.println("Number of googler "+g.length);
		System.out.println("Stranges "+str);
		System.out.println("Max value "+value);
		for(int i=0;i<g.length;i++)
			System.out.print(g[i]+" ");
		System.out.println("\n");

		googlers=new ArrayList<GooglerResult>();
		for(int i=0;i<googlersSum.length;i++)
			googlers.add(new GooglerResult(i, googlersSum[i]));

		sortGooglerTriples();

		LinkedList<Triples> t=new LinkedList<Triples>();
		selectFromGooglers(t,0,0);



	}

	public int getMax() {
		return max;
	}
	private void selectFromGooglers(LinkedList<Triples> list,int depth,int Stranges) {
		if(depth==googlers.size()){
			int cont=0;
			for(Triples t:list)
				if(t.getMaxValue()>=p)
					cont++;
			if(cont>max && Stranges==numberOfStranges){
				max=cont;
				for(Triples tt:list)
					System.out.println(tt);
				System.out.println();
			}
			return;
		}

		GooglerResult g=googlers.get(depth);
		for(Triples t:g){
			boolean added=false;
			if(t.isSurprise() && Stranges<numberOfStranges){
				added=true;
				list.addLast(t);
				selectFromGooglers(list,depth+1 , Stranges+1);
			}
			else{
				if(!t.isSurprise()){
					added=true;
					list.add(t);
					selectFromGooglers(list,depth+1 , Stranges);
				}
			}
			if(added)
				list.removeLast();

		}

	}
	private void sortGooglerTriples() {
		for(GooglerResult g:googlers)
			Collections.sort(g.getPossibleTriples(),new MyComparator());

	}
	class MyComparator implements Comparator<Triples>{

		@Override
		public int compare(Triples o1, Triples o2) {
			return o1.getMaxValue()-o2.getMaxValue();
		}

	}
	public static void main(String[] args) throws Exception {
		File input=new File("input2"+File.separatorChar+"input3.in");
		File output=new File("output2"+File.separatorChar+"output2.txt");
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(output)));

		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(input)));
		br.readLine();
		String current=br.readLine();
		int cont=1;
		while(current!=null && current.trim().length()!=0){
			StringTokenizer st=new StringTokenizer(current," ");
			int gnumber=Integer.parseInt(st.nextToken());
			int surprise=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			int [] g=new int [gnumber];
			for(int i=0;i<gnumber;i++)
				g[i]=Integer.parseInt(st.nextToken());
			int max=new DanceSolver(g, value, surprise).getMax();
			pw.append("Case #"+cont+": "+max);
			current=br.readLine();
			if(current!=null)
				pw.append("\n");
			pw.flush();
			cont++;
		}
		pw.flush();
		System.out.println("Finished");
	}
}
