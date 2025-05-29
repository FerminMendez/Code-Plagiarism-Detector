import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class RecycledNumbers {
	HashSet<Pair> rnumsPairs = new 	HashSet<Pair>();
	PrintWriter out = null;
	BufferedReader in = null;

	public RecycledNumbers() {
		try {
			out = new PrintWriter(new FileWriter("B-small-practice.out"));
			in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getRecycleNumbers(int num,int A,int B) {
		String aux = num + "";
		int an=0;
		int len = aux.length();
		String rnum="";
		int rn=0;
		for (int i = 1; i < len; i++) {
			rnum=aux.substring(i) + aux.substring(0, i);
			rn=Integer.parseInt(rnum);
			an=Integer.parseInt(aux);
			if((rn>A)&&(rn<=B)&&(an<rn)){
				Pair p=new Pair(an,rn);
				rnumsPairs.add(p);
			}
		}
	}

	public void getCount(int A, int B) {
		for (int i = A; i <= B; i++) {
			getRecycleNumbers(i,A,B);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RecycledNumbers rn = new RecycledNumbers();
		try {
			int nt = Integer.parseInt(rn.in.readLine());
			String num[] = new String[2];
			for (int i = 1; i <= nt; i++) {
				num = rn.in.readLine().split(" ");
				 int A = Integer.parseInt(num[0]);
				  int B = Integer.parseInt(num[1]);
				rn.getCount(A, B);
				rn.out.println("Case #" + i + ": " + rn.rnumsPairs.size());
				rn.rnumsPairs.clear();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		rn.out.close();
	}

}

class Pair{
	int a=0;
	int b=0;
	public Pair(Integer a,Integer b){
		this.a=a;
		this.b=b;
	}
	public boolean equals(Object o){
		
		if(o==null){
			return false;
		}
		if(!(o instanceof Pair))return false;
		Pair p=(Pair)o;
		if(((p.a==a)&&(p.b==b))||((p.a==b)&&(p.b==a))){
			return true;
		}
		return false;
	}
	public int hashCode(){
		int hcode=a+"".hashCode()+b+"".hashCode();
		return  hcode;
	}
}
