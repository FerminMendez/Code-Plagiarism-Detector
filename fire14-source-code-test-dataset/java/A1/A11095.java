
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]){
		try{
		FileInputStream fin=new FileInputStream("C:\\Program lang\\Google Code Jam\\input00.txt");
		DataInputStream datain=new DataInputStream(fin);
		BufferedReader br=new BufferedReader(new InputStreamReader(datain));
		int T=Integer.parseInt(br.readLine());
		for(int j=0;j<T;j++){
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());// googlers
		int S=Integer.parseInt(st.nextToken());// surprising triplets
		int p=Integer.parseInt(st.nextToken());// least max of triplet
		int out=0;
		for(int i=0;i<N;i++){
			int num=Integer.parseInt(st.nextToken());
			if(num%3==0){
				if(num/3>=p){
					out++;
				}
				else if((num+3)/3==p && S>0 && num>=3)	{
					S--;
					out++;
				}
				
			}
			else if(num%3==1){
				if((num+2)/3>=p)	out++;
			}
			else{
				if((num+1)/3>=p && num>=2)	out++;
				else if((num+4)/3>=p && S>0 && num>=2) {
					out++;
					S--;
				}
			}
		}
		System.out.println("Case #"+(j+1)+": "+out);
		
		}
		
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}