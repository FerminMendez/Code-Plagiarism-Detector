import java.util.*;
import java.io.*;

class gcj1{
	public static void main(String[] args) throws IOException{
		BufferedReader inp = new BufferedReader(new FileReader("inp.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
		int i = 0;
		int[][] regular = new int[31][3];
		int[][] surprising = new int[31][3];
		while(i<=30){
			surprising[i][0]=-1;
			surprising[i][1]=-1;
			surprising[i][2]=-1;
			regular[i][0]=-1;
			regular[i][1]=-1;
			regular[i][2]=-1;
			i++;
		}
		i=0;
		while(i<=30){
			int j = 0;
			while(j<=10){
				int k = j;
				while(k<=10){
					int m = k;
					while(m<=10){
						int sum = j+k+m;
						if(sum==i){
							if(Math.abs(m-j)<=1 && Math.abs(j-k)<=1 && Math.abs(m-k)<=1) {
							//	System.out.println("For "+i+" triplet is : "+m+" "+j+" "+k);
								regular[i][0] = m;
								regular[i][1] = j;
								regular[i][2] = k;
							}
							else {
								if((Math.abs(m-j)==2 && Math.abs(j-k)<=2 && Math.abs(k-m)<=2)|| (Math.abs(m-j)<=2 && Math.abs(j-k)==2 && Math.abs(k-m)<=2) || (Math.abs(m-j)<=2 && Math.abs(j-k)<=2 && Math.abs(k-m)==2)){
							//		System.out.println("For "+i+" Surprising triplet is : "+m+" "+j+" "+k);
									surprising[i][0]=m;
									surprising[i][1]=j;
									surprising[i][2]=k;
								}
							}
						}
						m++;
					}
					k++;
				}
				j++;
			}
		//	System.out.println("-----------------------------");
			i++;
		}
		int test = Integer.parseInt(inp.readLine());
		int p = 1;
		while(test>0){
			String data[] = inp.readLine().split(" ");
			int d[] = new int[data.length];
			int pp=0;
			while(pp<data.length){
				d[pp] = Integer.parseInt(data[pp]);
				pp++;
			}
			int s = d[1];
			int t = d[2];
			i = 3;
			int count = 0;
			while(i<data.length){
				if(regular[d[i]][0]>=t || regular[d[i]][1]>=t || regular[d[i]][2]>=t){ 
					count++;
				}
				else {
					if(s>0) {
						if(surprising[d[i]][0]>=t || surprising[d[i]][1]>=t || surprising[d[i]][2]>=t){
							s--;
							count++;
						}
					}
				}
				i++;
			}
			i=0;
			if (s>0){
				while(i<data.length){
					if(s==0) break;
					if(regular[d[i]][0]>=t || regular[d[i]][1]>=t || regular[d[i]][2]>=t){
						if(surprising[d[i]][0]>=t || surprising[d[i]][1]>=t || surprising[d[i]][2]>=t){
							s--;
						}
						else {
							if(surprising[d[i]][0]!=-1){
								count--;
								s--;
							}
							else {
								i++;
								continue;
							}
						}
					}
					else {
						if(surprising[d[i]][0]>=t || surprising[d[i]][1]>=t || surprising[d[i]][2]>=t){
						
						}
						else {
							if(surprising[d[i]][0]!=-1){
								s--;
							}
							else {
								i++;
								continue;
							}
						}
					}
					i++;
				}
			}
		//	if(s>0) out.write("what the fuck!! \n");
			System.out.println(count);
			out.write("Case #"+p+": "+count+"\n");
			p++;
			test--;
		}
		out.close();		
	}
}
		