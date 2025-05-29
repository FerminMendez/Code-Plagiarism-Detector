import java.io.*;

public class QualB {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int z = Integer.parseInt(br.readLine());
		int[] u = {0, 0, 3, 6, 9, 12, 15, 18, 21, 24, 27};
		int[] ul = {0, 0, 1, 4, 7, 10, 13, 16, 19, 22, 25};
		
		
		for(int i=0; i<z; i++){
			String[] s = br.readLine().split("\\s+");
			
			int n = Integer.parseInt(s[0]);
			int ss = Integer.parseInt(s[1]);
			int p = Integer.parseInt(s[2]);
			
			int l = 3 + n;
			int index = 0;
			
			int[] arr = new int[n];
			
			for(int j=3; j<l; j++){
				arr[index] = Integer.parseInt(s[j]);
				index++;
			}
			
			if(p == 0){
				System.out.println("Case #" + (i+1) + ": " + n);
			}else{
				int ctr = 0;
				
				for(int j=0; j<n; j++){
					int t = arr[j];
					
					if(t > u[p]){
						ctr++;
						
					}else if(t > ul[p] && ss > 0){
						ss--;
						ctr++;
					}
				}
				
				System.out.println("Case #" + (i+1) + ": " + ctr);
			}
		}
	}
}
