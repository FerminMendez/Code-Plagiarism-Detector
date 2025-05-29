import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class googlers {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("B-small-attempt1.in"));
		 // input file name goes above
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("googlers.out")));
		 int x=Integer.parseInt(f.readLine());
		 for (int i = 0; i < x; i++) {
			 int output=0;
			 StringTokenizer base=new StringTokenizer(f.readLine());
			 int no=Integer.parseInt(base.nextToken());
			 int sur=Integer.parseInt(base.nextToken());
			 int max=Integer.parseInt(base.nextToken());
			 
			 int [] sum=new int [no];
			 for (int j = 0; j < no; j++) {
				sum[j]=Integer.parseInt(base.nextToken());
			}
			int[][] calc = new int[no][3];
			for (int j = 0; j < no; j++) {
				if(sum[j]%3!=2)
				{
					calc[j][0]=sum[j]/3;
					calc[j][1]=sum[j]/3;
					calc[j][2]=sum[j]-2*sum[j]/3;
				}
				else{
					calc[j][0] = sum[j] / 3+1;
					calc[j][1] = sum[j] / 3;
					calc[j][2] = sum[j] -(sum[j] / 3 +sum[j]/3+1);	
				}
			}
			for (int j = 0; j < no; j++) {
				boolean found = false;
				for (int j2 = 0; j2 < 3 && !found; j2++) {
					if (calc[j][j2] >= max) {
						output++;
						found = true;
					}
				}
				if (!found) {
					for (int j2 = 0; j2 < 3 && !found && sur > 0; j2++) {
						if (calc[j][j2] + 1 >= max) {
							if(sum[j]>2&& sum[j]%3!=1)
							{
								output++;
								sur--;
								found = true;	
							}
						}
					}
				}
			}
			out.println("Case #"+(i+1)+": "+output);
		}
		 out.close();
		 f.close();
	}
	
}
