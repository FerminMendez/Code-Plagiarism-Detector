import java.io.*;
class Main1{
	public static void main(String[] ar) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\B-small-attempt2.in"));
		PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\User\\Desktop\\outputB2.out"));  
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++){
			String[] m = br.readLine().split(" ");
			int n = Integer.parseInt(m[0]);
			int s = Integer.parseInt(m[1]);
			int p = Integer.parseInt(m[2]);
			int[] r = new int[m.length-3];
			int res = 0;
			for (int j=3; j<m.length; j++){
				r[j-3] = Integer.parseInt(m[j]);
				if (p==0){
					res= m.length -3;
				} else {
					if (p==1){
						if (r[j-3] >=1){
							res++;
						}
					} else {
						if (r[j-3] >= 3*p-2){// x >= p+(p-1)+(p-1) pasti masuk
						res++;
						} else {
							if (s>0 && r[j-3]>= 3*p-4){ // x>= p+(p-2)+(p-2)
							s--;
							res++;
							}
						}
					}
				}
				
			}
			out.println("Case #"+(i+1)+": "+res);
			
			
		}
		out.close();
	}
}