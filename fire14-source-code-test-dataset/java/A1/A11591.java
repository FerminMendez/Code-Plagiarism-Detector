import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dancers {

	/**
	 * @param args
	 */
	private static Hashtable<Integer, int[]> ns = new Hashtable<Integer, int[]>();
	private static Hashtable<Integer, int[]> s = new Hashtable<Integer, int[]>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tests;
		try{
			BufferedReader stdin = new BufferedReader(new FileReader(args[0]));
			tests = Integer.parseInt(stdin.readLine());
			for(int i = 0; i < tests; i++){
				System.out.print("Case #"+(i+1) + ": ");
				solve(stdin.readLine());
				System.out.println();
			} 
		}catch(IOException e){
			e.printStackTrace();
		}
		System.exit(0);

	}
	
	private static void solve(String in){
		String[] det = in.split(" ");
		int googlers = Integer.parseInt(det[0]);
		int surprises = Integer.parseInt(det[1]);
		int p = Integer.parseInt(det[2]);
		int max = 0;
		for(int i = 3; i < 3+googlers; i++){
			ns.clear();
			s.clear();
			analyze(i, Integer.parseInt(det[i]));
			switch(inclusion(i, p)){
			case 2: max +=1; break;
			case 1: if(surprises>=1) { max += 1; surprises -= 1;} break;
			default: break;
			}
		}
		System.out.print(max);
	}
	
	public static void analyze(int googler, int n){
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i = Math.max(0, n/3 - 1); i <= Math.min(n/3 + 1, 10); i++){
			for(int j = Math.max(0, (n-i)/2 - 1); j <= Math.min((n-i)/2 + 1, 10); j++){
				for(int k = Math.max(0, (n-i-j) - 1); k <= Math.min(n-i-j + 1, 10); k++){
					if(n == i + j + k && !h.contains(new Integer(i*100 + j*10 + k))){
					//System.out.println(i + "," + j + "," + k);
						if(categorize(googler,i,j,k))
						addPerms(i,j,k,h);
						
					}
				}
			}
		}
	}
	
	private static void addPerms(int i, int j, int k, HashSet<Integer> h){
		h.add(new Integer(100*i + 10*j + k));
		h.add(new Integer(100*i +10*k + j));
		h.add(new Integer(100*j + 10*i + k));
		h.add(new Integer(100*j + 10*k + i));
		h.add(new Integer(100*k + 10*i + j));
		h.add(new Integer(100*k + 10*j + i));
	}
	
	public static boolean categorize(int googler, int i, int j, int k){
		if(Math.abs(i-j)<2 && Math.abs(i-k)<2 && Math.abs(j-k)<2){
			int[] arr = {i,j,k};
			ns.put(new Integer(googler),arr);
			return true;
		} else if((Math.abs(i-j)==2 && Math.abs(i-k)<=2 && Math.abs(j-k)<=2) || (Math.abs(i-k)==2 && Math.abs(i-j)<=2 && Math.abs(j-k)<=2) || (Math.abs(j-k)==2 && Math.abs(i-j)<=2 && Math.abs(i-k)<=2)){
			int[] arr = {i,j,k};
			s.put(new Integer(googler), arr);
			return true;
		}
		return false;
	}
	
	private static byte inclusion(int googler, int p){
		int[] sur = s.get(new Integer(googler));
		int[] nsur = ns.get(new Integer(googler));
		
		boolean withSur = false;
		boolean withoutSur = false;
		
		for(int i = 0; i < 3; i++){
			if(sur != null && sur[i] >= p)
				withSur = true;
			if(nsur[i] >= p)
				withoutSur = true;
		}
		
		if(withoutSur)
			return 2;
		else if(withSur)
			return 1;
		else
			return 0;
	}
	
}
