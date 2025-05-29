package ProblemC;

import java.io.*;
import java.util.StringTokenizer;

public class RecycledNums {

	/**
	 * @param args
	 */
	
	public RecycledNums(){
		
	}
	
	
	public static void recycledNums() throws IOException{
		BufferedReader rdr = new BufferedReader(new FileReader("C-small-attempt0.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("C.out"));
        int cases = Integer.parseInt(rdr.readLine());

        for (int i = 0; i < cases; i++) {
			String line = rdr.readLine();
            StringTokenizer st = new StringTokenizer(line);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int result = 0;
			
			for (int n=A; n<B; n++){
				for (int m=n+1; m<=B; m++){
					String ns = n+"";
					String ms = m+"";
					//System.out.println("n "+n+" m "+m);
					if(ns.length() == ms.length()){
						for(int j=ns.length()-1 ; j>0; j--){
							//System.out.println(ns+" "+ms.substring(j, ns.length())+" "+ms.substring(0, j));
							if(ms.equals(ns.substring(j, ms.length())+ns.substring(0, j))){
								result++;
								break;
								//System.out.println(n+" "+m);
							}
						}
					}
				}
			}
			
			
            pw.println("Case #"+(i+1)+": "+result);
        }
        

        pw.close();
        rdr.close();
	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		recycledNums();
	}

}
