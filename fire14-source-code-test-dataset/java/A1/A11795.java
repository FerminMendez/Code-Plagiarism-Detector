import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class B {

	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("B-small-attempt5.in"));
		FileWriter f = new FileWriter("B.out");
		int N,S,p;
		int googler;
		int kol,ost;
		int br;
		int T=sc.nextInt();
		
		for(int t=1;t<=T;t++){
			br=0;
			sc.nextLine();
			N=sc.nextInt();
			S=sc.nextInt();
			p=sc.nextInt();
			for(int i=0;i<N;i++){
				googler=sc.nextInt();
				kol=googler/3;
				ost=googler%3;
				
				if(kol>=p){
					br++;
					continue;
				}
				
				if(ost==0){
					if(kol+1>=p&&S>0&&kol-1>=0){
						S--;
						br++;
						
					}
					continue;
				}
				
				if(ost==1){
					if(kol+1>=p){
						br++;
						
					}
					continue;
				}
				//ost==2
				if(kol+1>=p){
					br++;
					continue;
				}
				if(kol+2>=p&&S>0){
					S--;
					br++;
				}
			}
			f.write("Case #"+t+": "+br+"\n");
		}
		
		f.close();
	}

}
