package jam2012.qround;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RPair {
	int n;
	int m;
	public RPair(int n,int m){
		this.n = n;
		this.m = m;
	}
	public static void main(String args[])
	{
		int line = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("C-small-attempt0.out"));
			//			BufferedReader br = new BufferedReader(new FileReader("input.in"));
			String str;
			String[] strIn;
			Integer.parseInt(br.readLine());
			while ((str = br.readLine()) != null)   {
				strIn = str.split(" ");
				int min = Integer.parseInt(strIn[0]);
				int max = Integer.parseInt(strIn[1]);
				int count = 0;
				List <RPair>used = new ArrayList<RPair>();
				for(int i=min;i<=max;i++){
					int[] mutList = play(i,min,max);
					for(int j=0;j<mutList.length;j++)
						if(!used.contains(new RPair(i,mutList[j]))){
							count++;
							used.add(new RPair(i,mutList[j]));
						}
				}
				line++;
				//				System.out.println("Case #"+line+": "+count/2);
				bw.write("Case #"+line+": "+count/2);
				bw.newLine();
			}
			br.close();
			bw.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	public static int[] play(int num, int min, int max){
		String c = Integer.toString(num);
		int len = c.length();
		List <Integer>mutList = new ArrayList<Integer>();
		for (int i=1;i<len;i++){
			c = Character.toString(c.charAt(len-1)).concat(c.substring(0, len - 1));
			int mut = Integer.parseInt(c);
			if (Integer.toString(mut).length()==len && mut != num && mut >= min && mut <= max)
				mutList.add(mut);
		}

		if (mutList.size() != 0){
			int[] intArray = new int[mutList.size()];
			for (int i = 0; i < mutList.size(); i++) {
				intArray[i] = mutList.get(i);
			}
			return intArray;
		}
		else return new int[0];
	}

}


