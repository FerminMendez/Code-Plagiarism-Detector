import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(in.readLine());
		for(int i=1;i<=cases;i++)
		{
			String line = in.readLine();
			String parts[] = line.split(" ");
			int out = 0;
			int n = Integer.parseInt(parts[0]);
			int s = Integer.parseInt(parts[1]);
			int p = Integer.parseInt(parts[2]);
			int count = 0;
			int marks[] = new int[n];
			for(int j=0;j<n; j++){
				marks[j] = Integer.parseInt(parts[3+j]);
			}
			if(p == 0){
				count = n;
				System.out.println("Case #"+i+": "+count);
				continue;
			}
			else{
				for(int j = 0 ; j < n ; j++){
					if(marks[j] != 0){
						if(marks[j] >= 3*p){
							count++;
							continue;
						}
						else if(marks[j] == ((3*p)-2)){
							count++;
							continue;
						}
						else if(marks[j] == ((3*p)-1)){
							count++;
							continue;
						}
						else if((marks[j] == ((3*p)-3) )||(marks[j] == ((3*p)-4))){
							if(s>0){
								s--;
								count++;
							}
						
						}
						}
					}
					System.out.println("Case #"+i+": "+count);
				}
			}
			
		}

	}


