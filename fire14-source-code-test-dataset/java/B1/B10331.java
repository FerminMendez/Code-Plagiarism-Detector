package ProblemC;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Common {
	static String filename="C:\\eclipse-jee-indigo-SR2-win32\\eclipse\\projects\\goole codejam 2012\\Qualification\\src\\ProblemC\\C-small-attempt0.in";
	static BufferedReader br;
	
	static String output;
	public static void main (String[] args) throws NumberFormatException, IOException{
		br = new BufferedReader(new FileReader(filename));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\eclipse-jee-indigo-SR2-win32\\eclipse\\projects\\goole codejam 2012\\Qualification\\src\\ProblemC\\output.txt"));
		int N, n, m;
		N = Integer.parseInt(br.readLine());
		String[] splitArr;
		for (int i=1;i<=N;++i){
			splitArr = br.readLine().split(" ");
			n = Integer.parseInt(splitArr[0]);
			m = Integer.parseInt(splitArr[1]);
			bw.append("Case #"+i+": "+process1(n, m)+"\n");
			bw.flush();
		}
		bw.close();
	}

	static int process1 (int n, int m){
		//System.out.println("\n\n\nn: "+n+"\tm: "+m);
		int result=0, num2;
		List<Pair> numbers = new ArrayList<Pair>();
		String inp1, inp2;
		for (int i=n;i<=m;++i){
			inp1 = String.valueOf(i);
				for (int j=inp1.length()-1; j>0;--j){
					if('0' != inp1.charAt(j) ){
						inp2=inp1.substring(j)+inp1.substring(0, j);
						num2= Integer.parseInt(inp2);
						if (m >=num2 && n<=num2&& i != num2 && !numbers.contains(new Pair(i, num2))){
							numbers.add(new Pair(i, num2));
							//System.out.println(new Pair(i, num2));
							++result;
						}
					}
				}				
		}
		/*Pair p1, p2;
		List <Pair> list = new ArrayList<Pair>();
		boolean found=false;
		for (int i=0 ; i< numbers.size();++i){
			p1 = numbers.get(i);
			found=false;
			for (int j=0; j< list.size();++j){
				p2=list.get(j);
				if (p1.n== p2.n && p1.m == p2.m){
					found=true;
					break;
				}
			}
			if(!found){
				list.add(p1);
			}
		}
		System.out.println(list);
		System.out.println(list.size());*/
		
		//System.out.println(numbers);
		//System.out.println(numbers.size());
		//for (int i=0; i< )
		return result;
	}
	
	static int process (int n, int m){
		System.out.println("\n\n\nn: "+n+"\tm: "+m);
		int result=0, num2;
		List<Pair> numbers = new ArrayList<Pair>();
		List<Integer> pos;
		List <String> nums = new ArrayList<String>();
		List <String>temp = new ArrayList<String>();
		char firstChar;
		String inp1, inp2;
		for (int i=n;i<=m;++i){
			inp1 = String.valueOf(i);
			if ( ! nums.contains(inp1)){
				firstChar=inp1.charAt(0);
				temp = new ArrayList<String>();
				for (int j=inp1.length()-1; j>0;--j){
					if('0' != inp1.charAt(j) && inp1.charAt(j)>=firstChar){
						inp2=inp1.substring(j)+inp1.substring(0, j);
						num2= Integer.parseInt(inp2);
						if (m > num2 && n< num2 && i != num2 && !numbers.contains(new Pair(i, num2))){
							nums.add(inp2);
							temp.add(inp2);
							System.out.print(new Pair(i, num2));
							++result;
						}
					}
				}
				
				if(2<= temp.size()){
					result+=((temp.size()-1)*(temp.size()))/2;
					System.out.println("Added : "+((temp.size()-1)*(temp.size()))/2);
				}
				
			}else{
				nums.remove(inp1);
			}
						
			
			/*pos = getTheLeastPosition(inp1);
			for ( int j=0;j< pos.size();++j){
				inp2 = inp1.substring(pos.get(j))+inp1.substring(0, pos.get(j));
				num2= Integer.parseInt(inp2);
				if(i != num2 && m >= num2){
					numbers.add(new Pair(i, num2));
					System.out.println(new Pair(i, num2));
					++result;
				}	
			}*/
			
		}
		return result;
	}
	
	static List<Integer> getTheLeastPosition(String inp){
		List<Integer> pos= new ArrayList<Integer>();
		int ps=0;
		char base = inp.charAt(0);
		boolean passedBase=false;
		for (int i=base-48;i<=9;++i, ++base){
			if ( -1 != (ps = inp.indexOf(base))){
				if (passedBase){
					pos.add(ps);
					break;
				}
					
				pos.add(ps);
				while (0 != ps &&-1 != (ps = inp.indexOf(base, ps+1))){
					passedBase=true;
					pos.add(ps);
				}
			}
		}
		if (-1 != ps){
			while (-1 != (ps = inp.indexOf(base, ps+1))){
				pos.add(ps);
			}
		}
		return pos;
	}
	
	static class Pair implements Comparable<Pair>{
		int n, m;

		public Pair() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Pair(int n, int m) {
			super();
			if ( n < m){
				this.n = n;
				this.m = m;	
			}else{
				this.n = m;
				this.m = n;
			}
			
		}

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public int getM() {
			return m;
		}

		public void setM(int m) {
			this.m = m;
		}

		@Override
		public String toString() {
			return "\nPair [n=" + n + ", m=" + m + "]";
		}

		@Override
		public boolean equals(Object arg0) {
			Pair p = (Pair)arg0;
			if ((n == p.n && m == p.m ) || (n == p.m && m== p.n)){
				//System.out.println("Equals");
				return true;
			}
			return false;
		}

		@Override
		public int compareTo(Pair o) {
			if ((n == o.n && m == o.m ) || (n == o.m && m== o.n)){
				return 0;
			}else if(n < o.n ){
				return -1;
			}else {
				return 1;
			}
		}

		
		
	}
}
