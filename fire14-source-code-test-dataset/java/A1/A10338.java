import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class dancing {
	public static void main(String args[]) throws Exception{
		FileInputStream fs = new FileInputStream("in2.txt");
	    DataInputStream in = new DataInputStream(fs);
	    BufferedReader br=new BufferedReader(new InputStreamReader(in));
	    FileWriter fstream = new FileWriter("out3.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++){
			String line=br.readLine();
			String str[]=line.split(" ",-1);
			int N=Integer.parseInt(str[0]);
			int S=Integer.parseInt(str[1]);
			int P=Integer.parseInt(str[2]);
			int test=(3*P-2);
			int test2=(3*P-4);
			int count=0;
			int count2=0;
			for(int j=0;j<N;j++){
				int id=Integer.parseInt(str[3+j]);
				if(id>=test){
					count++;
				}
				else if((id>=test2)&& id>0){
					count2++;
				}
			}
			if(S>=count2){
				count=count+count2;
			}
			else{
				count=count+S;
			}
			out.write("Case #"+(i+1)+": "+count);
			out.newLine();
		}
		out.close();
		br.close();
	}
}
