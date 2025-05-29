import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecycledPairs {
	public static void main(String []args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new FileReader("input.in"));
		String hm="", line[];
		int n =Integer.valueOf(in.readLine()), m=1, a, b, c;
		for(m=1;m<=n;m++){
			System.out.print(m+" ");
			line=in.readLine().split(" ");
			a=Integer.valueOf(line[0]); b=Integer.valueOf(line[1]);
			c=0;
			for(int i=a;i<b;i++){
				for(int j=i+1;j<=b;j++){
					//System.out.println("ANA: "+i+" "+j);
					if(recycled(String.valueOf(i),String.valueOf(j))) c++;
				}
			}
			hm+="Case #"+m+": "+c+"\n";
		}
		System.out.println();
		System.out.println(hm);
	}

	private static boolean recycled(String n, String m) {
		String aux=""; int li=0;
		int leng=n.length();
		//System.out.println("Length: "+leng);
		if(leng==1) return false;
		for(int i=leng-1;i>0;i--){
			aux=String.valueOf(n.charAt(leng-1));
			aux+=n.substring(0, leng-1);
			n=aux;
			//System.out.println(aux+" "+m);
			if(n.equals(m))
				return true;
		}
		return false;
	}
}
