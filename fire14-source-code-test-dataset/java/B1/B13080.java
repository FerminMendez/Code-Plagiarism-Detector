import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Recycled {
	
	public static boolean isRot(String a, String b){
		if(a.length()!=b.length())
			return false;
		if(!a.equals(b)){
			String c = b;
				for(int i=0;i<a.length();i++){
					c = c.charAt(c.length()-1) + "" + c.substring(0,c.length()-1);
					if(a.equals(c))
						return true;
				}
		}else return true;
		return false;
	}
	
	//public static boolean noEsta(Arra)
	
	public static void rots(String a, int in, int f, HashMap<Integer, HashSet<Integer>> mapa) {
		int num = Integer.parseInt(a);
		if(num<10)return;
		if(num>f || num<in)return;
		String c=a;
		for (int i = 0; i < a.length(); i++) {
			c = c.charAt(c.length() - 1) + "" + c.substring(0, c.length() - 1);
			//System.out.println(c);
			int cc= Integer.parseInt(c);
			if(cc>=in && cc<=f&& String.valueOf(cc).length()==a.length() && cc!=num){
//				if(mapa.containsKey(num) && !mapa.get(num).contains(cc)){
//					mapa.put(num,cc);
//					if(!mapa.containsKey(cc))
//						mapa.put(cc, new ArrayList<Integer>());
//					mapa.get(cc).add(num);
//				}
//				else{
//					mapa.put(num, new ArrayList<Integer>());
//					mapa.get(num).add(cc);
//					if(!mapa.containsKey(cc))
//						mapa.put(cc, new ArrayList<Integer>());
//					mapa.get(cc).add(num);
//				}
				if(!mapa.containsKey(num)){
					mapa.put(num, new HashSet<Integer>());
				}
				mapa.get(num).add(cc);
				if(!mapa.containsKey(cc))
					mapa.put(cc, new HashSet<Integer>());
				mapa.get(cc).add(num);
			}else{
				//System.out.println(cc);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/debian/Descargas/C-small-attempt0.in"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int f = Integer.parseInt(input);
		for (int i = 0; i < f; i++) {
			HashMap<Integer,HashSet<Integer>> mapa = new HashMap<Integer, HashSet<Integer>>();
			input = br.readLine();
			int a = Integer.parseInt(input.split(" ")[0]);
			int b = Integer.parseInt(input.split(" ")[1]);
			for (int k = a; k <=b; k++) {
					//System.out.println("k " + k);
					//System.out.println("l " + l);
					rots("" + k, a,b,mapa);
			}
			int cont =0;
			for(int key: mapa.keySet()){
				cont+=mapa.get(key).size();
			}
			System.out.println("Case #" + (i + 1) + ": " + (cont>>1));
		}
	}

}
