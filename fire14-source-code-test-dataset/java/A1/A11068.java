import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class dancing{
	public static void main(String args[]){
		try{
			PrintWriter out = new PrintWriter(new FileWriter("output.txt")); 
			Scanner sc = new Scanner(new File(args[0]));
			int n, s, p, y;

			int t = sc.nextInt();
			sc.nextLine();
			
			for(int i=1;i<=t;i++){
				y=0;
				n = sc.nextInt();
				s = sc.nextInt();
				p = sc.nextInt();
				int score;
				for(int j=0;j<n;j++){
					score=sc.nextInt();
					if(score%3==0){
						if(score/3>=p){
							y++;
						}
						else if(score/3+1>=p && s>0 && score!=0){
							y++;
							s--;
						}
					}else if(score%3==1){
						if(score/3+1>=p){
							y++;
						}
					}else { 
						if(score/3+1>=p){
							y++;
						}
						else if(score/3+2>=p && s>0){
							y++;
							s--;
						}
					}
				}
				out.println("Case #"+i+": "+y);
			}
			out.close();
		}catch (Exception e){
        }
	}
}