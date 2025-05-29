import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sol {

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	public int AAA(int x,int p){
		if (x%3==0){
			if (x/3+1>=p){
				return(1);
			}
		}
		if (x%3==1){
			if (x/3+1>=p){
				return(1); 
			}
		}
		if (x%3==2){
			if (x/3+2>=p){
				return(1);
			}
		}
		return(0);
	}

	void run() throws IOException {
		br = new BufferedReader(new FileReader("input.txt"));
		out = new PrintWriter("output.txt");
		String s = br.readLine();
		int n = Integer.parseInt(s);
		for ( int i = 1; i <= n; i++){
			s = br.readLine();
			out.print("Case #"+i+": ");
			int ans = 0;
			st = new StringTokenizer(s);
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int[] a= new int[m+1];
			for ( int j=1; j<=m; j++){
				a[j] = Integer.parseInt(st.nextToken());
			}
			if (k == 0){
				for (int j = 1; j <=m ; j++){
					if ((a[j]/3+1>=p) && (a[j]%3>0)){
							ans++;
					}
					if ((a[j]/3>=p) && (a[j]%3==0)){
						ans++;
					}
				}
			} else {
				if (m == k){
					for (int j = 1; j<=m; j++){
						if (a[j]%3==0){
							if (a[j]/3+1>=p){
								ans++;
							}
						}
						if (a[j]%3==1){
							if (a[j]/3+1>=p){
									ans++; 
							}
						}
						if (a[j]%3==2){
							if (a[j]/3+2>=p){
									ans++;
							}
						}
					}
				}
					
				if ((m==2)&&(k==1)){
					
					int an1=0;
					if ((a[1]>=2)&&(a[1]<=28)){
					an1=AAA(a[1],p);
					if ((a[2]/3+1>=p) && (a[2]%3>0)){
						an1++;
				}
				if ((a[2]/3>=p) && (a[2]%3==0)){
					an1++;
				}
					}
					int an2=0;
					if ((a[2]>=2)&&(a[2]<=28)){
					an2=AAA(a[2],p);
					if ((a[1]/3+1>=p) && (a[1]%3>0)){
						an2++;
				}
				if ((a[1]/3>=p) && (a[1]%3==0)){
					an2++;
				}
					}
					ans=Math.max(an1, an2);
				}
					
					
					
				
				if ((m==3)&&(k==1)){
					int an1=0;
					if ((a[1]>=2)&&(a[1]<=28)){
					an1= AAA(a[1],p);
					if ((a[2]/3+1>=p) && (a[2]%3>0)){
						an1++;
				}
				if ((a[2]/3>=p) && (a[2]%3==0)){
					an1++;
				}
				if ((a[3]/3+1>=p) && (a[3]%3>0)){
					an1++;
			}
			if ((a[3]/3>=p) && (a[3]%3==0)){
				an1++;
			}
					}
					int an2=0;
					if ((a[2]>=2)&&(a[2]<=28)){
					an2= AAA(a[2],p);
					if ((a[1]/3+1>=p) && (a[1]%3>0)){
						an2++;
				}
				if ((a[1]/3>=p) && (a[1]%3==0)){
					an2++;
				}
				if ((a[3]/3+1>=p) && (a[3]%3>0)){
					an2++;
			}
			if ((a[3]/3>=p) && (a[3]%3==0)){
				an2++;
			}
					}
					int an3=0;
					if ((a[3]>=2)&&(a[3]<=28)){
					an3= AAA(a[3],p);
					if ((a[2]/3+1>=p) && (a[2]%3>0)){
						an3++;
				}
				if ((a[2]/3>=p) && (a[2]%3==0)){
					an3++;
				}
				if ((a[1]/3+1>=p) && (a[1]%3>0)){
					an3++;
			}
			if ((a[1]/3>=p) && (a[1]%3==0)){
				an3++;
			}		
					}
					ans=Math.max(an1, an2);
					ans=Math.max(ans, an3);
				}
				
				if ((m==3)&&(k==2)){
					int an1=0;
					if ((a[1]>=2)&&(a[1]<=28)&&(a[2]>=2)&&(a[2]<=28)){
					an1= AAA(a[1],p)+AAA(a[2],p);
					if ((a[3]/3+1>=p) && (a[3]%3>0)){
						an1++;
				}
				if ((a[3]/3>=p) && (a[3]%3==0)){
					an1++;
				}
					}
					int an2=0;
					if ((a[2]>=2)&&(a[2]<=28)&&(a[3]>=2)&&(a[3]<=28)){
					an2= AAA(a[2],p)+AAA(a[3],p);
					if ((a[1]/3+1>=p) && (a[1]%3>0)){
						an2++;
				}
				if ((a[1]/3>=p) && (a[1]%3==0)){
					an2++;
				}
					}
					int an3=0;
					if ((a[3]>=2)&&(a[3]<=28)&&(a[1]>=2)&&(a[1]<=28)){
					an3= AAA(a[3],p)+AAA(a[1],p);
					if ((a[2]/3+1>=p) && (a[2]%3>0)){
						an3++;
				}
				if ((a[2]/3>=p) && (a[2]%3==0)){
					an3++;
				}	
					}
					ans=Math.max(an1, an2);
					ans=Math.max(ans, an3);
				}
			}
			
			out.println(ans);
		}

		br.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new Sol().run();
	}

}