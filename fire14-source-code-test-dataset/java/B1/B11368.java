import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class recycled {
	
	static HashMap<Long, HashMap<Long, Integer>> found;
	static Set<Long> touched;
	
	public static int calc(long a, long b){
		int compteur = 0;
		int nbchiffres = 1;
		long pow = 10;
		while(pow<a){
			pow=pow*10;
			nbchiffres++;
		}
		for(long n=a; n<=b; n++){
			if(n>pow){
				pow=pow*10;
				nbchiffres++;
			}
			//System.out.println(n+" "+a+" "+b);
			compteur+= nbpossibleM(a,b,n, nbchiffres, pow);
		}
		return compteur;
	}

	private static int nbpossibleM(long a, long b, long n, int nbchiffre, long pow) {
		long smallpow = 10;
		long bigpow = pow/10;
		//System.out.println("-------- "+nbchiffre+" "+smallpow+" "+bigpow+"\n\n\n");
		long m=0;
		int possibilities =0;
		touched.clear();
		for(int k=1; k<nbchiffre; k++){
			m= n/smallpow + (n%smallpow)*bigpow;
			if(m<n && m>=a && !touched.contains(m)){
				/*if(found.containsKey(m)){
					HashMap<Long, Integer> map = found.get(m);
					if(map.containsKey(n)){
						map.put(n, map.get(n)+1);
					}
					else{
						map.put(n, 1);
					}
				}
				else{
					HashMap<Long,Integer> map = new HashMap<Long, Integer>();
					map.put(n, 1);
					found.put(m, map);
				}*/
				possibilities++;
				touched.add(m);
			}
			smallpow=smallpow*10;
			bigpow=bigpow/10;
		}
		return possibilities;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		//found = new HashMap<Long	, HashMap<Long, Integer>>();
		touched = new HashSet<Long>();
		Scanner s = new Scanner(new File("input.txt"));
		int nbcas = s.nextInt();
		
		for(int i=0; i<nbcas; i++){
			long a = s.nextLong();
			long b = s.nextLong();
			System.out.println("Case #"+(i+1)+": "+calc(a,b));
		}
		
		/*
		for(long m: found.keySet()){
			HashMap<Long, Integer> map = found.get(m);
			for(long n: map.keySet()){
				if(map.get(n)==2){
					System.out .println(m+" "+n);
				}
			}
		}*/
	}
}
