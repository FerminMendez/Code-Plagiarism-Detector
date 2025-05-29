package ProblemB;

import java.io.*;
import java.util.StringTokenizer;

public class Dancing {

	public Dancing() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void dancing()throws IOException{
		BufferedReader rdr = new BufferedReader(new FileReader("B-small-attempt0.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("B.out"));
        int cases = Integer.parseInt(rdr.readLine());

        for (int i = 0; i < cases; i++) {
			String line = rdr.readLine();
            StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int result = 0;
			
			for(int j=0; j<n; j++){
				int x = Integer.parseInt(st.nextToken());
				if(!(x==0 && p!=0)){
					if(x >= p*3 || x == p*2 + (p-1) || x == p + (p-1)*2){
						result++;
					}
					else{
						if((s>0) && (x == p*2 + (p-2) || x == p + (p-1) +(p-2) || x == p + (p-2)*2 )){
							result++;
							s--;
						}
					}
				}
				
			}
			
			
            pw.println("Case #"+(i+1)+": "+result);
        }
        

        pw.close();
        rdr.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		dancing();
	}

}
