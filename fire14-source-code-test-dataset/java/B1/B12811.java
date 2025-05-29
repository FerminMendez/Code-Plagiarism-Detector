import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class RecycledNumbers {
	
	static ArrayList<Integer> perm(int j){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		String num = j+"";
		int aux;
		for(int i=0; i<num.length(); i++){
			num=num.substring(1)+num.charAt(0);
			aux=Integer.parseInt(num);
			if((aux+"").length()==num.length())
				ret.add(aux);
		}
		return ret; 
	}
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("C-small-attempt0.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileWriter("solution.out"));
		
		int cas= in.nextInt();
		in.nextLine();
		for(int i=1; i<=cas; i++){
			int a, b, res=0;
			HashSet<Map<Integer, Integer>>conj= new HashSet<Map<Integer, Integer>>();
			HashMap<Integer, Integer>aux;
			a= in.nextInt();
			b= in.nextInt();
			for(int j=a; j<=b; j++){
				ArrayList<Integer> arr=perm(j);
	            for(int h=0; h<arr.size(); h++){
	            	aux= new HashMap<Integer, Integer>();
	            	aux.put(Math.min(j, arr.get(h)), Math.max(j, arr.get(h)));
	            	if(arr.get(h)!=j && arr.get(h)<=b && arr.get(h)>=a && !conj.contains(aux)){
	            		res++;
	            		conj.add(aux);
	            	}
	            }
	        }

			out.println("Case #"+i+": "+res);
		}
		out.close();
		System.exit(0);


	}

}
