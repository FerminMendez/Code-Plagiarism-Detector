import java.io.*;
import java.util.*;

/**
 *
 * @author kronenthaler
 */
public class C {
	public static void main(String arg[]){
		try{
			Scanner in = new Scanner(new FileInputStream("c-small.in"));
			System.setOut(new PrintStream("c.out"));
			int T = in.nextInt();
			for(int cases=1;cases<=T;cases++){
				int A = in.nextInt();
				int B = in.nextInt();
				int count = 0;
				for(int i=A;i<B;i++){
					//numero de digitos de i;
					int aux = i;
					int d = 0;
					while(aux!=0){ aux/=10; d++; }
					Set<ArrayList<Integer>> map = new HashSet<ArrayList<Integer>>();
					for(int j=1;j<d;j++){
						aux = i;
						int buf = 0;
						int offset = 1;
						for(int k=0; k<j; k++, offset*=10){
							buf += (aux % 10)*offset;
							aux /= 10;
						}
						offset=1;
						for(int k=j;k<d;k++,offset*=10);
						
						int m = (buf*offset) + aux;
						if(i < m && m <= B){
							ArrayList<Integer> a = new ArrayList<Integer>();
							a.add(i);
							a.add(m);
							if(!map.contains(a)){
								count++;
								map.add(a);
							}
						}
					}
				}
				System.out.printf("Case #%d: %d\n", cases, count);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
