import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class triplets {

	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in)); //copy test data into standard input
		int num=Integer.parseInt(reader.readLine());
		for(int i=1;i<=num;i++){
			StringTokenizer st=new StringTokenizer(reader.readLine());
			System.out.print("Case #"+i+": ");
			int n=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int p=Integer.parseInt(st.nextToken());
			int over=0;//number automatically over
			int surp=0; //number over if surprising
			for(int j=0;j<n;j++){
				int score=Integer.parseInt(st.nextToken());
				int share=score/3;
				if(score==0){
					if(p==0){
						over++;
					}
				}else if(score%3==0){
					if(share>=p){
						over++;
					}else if(share+1>=p){
						surp++;
					}
				}else if(score%3==1){
					if(share+1>=p){
						over++;
					}
				}else if(score%3==2){
					if(share+1>=p){
						over++;
					}else if(share+2>=p){
						surp++;
					}
				}
			}
			if(surp>s){
				over+=s;
			}else{
				over+=surp;
			}
			System.out.println(over);
		}

	}

}
