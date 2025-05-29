import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class jam {

	public static void main(String args[])
	{
		ArrayList<String> inp=read_fil("D:\\google_Jam\\B-small-attempt1.in");
		//		ArrayList<String> inp=read_fil("D:\\google_Jam\\A-large-practice.in");
		int lin_num=0;
		int T=Integer.valueOf(inp.get(lin_num));
		lin_num++;

		for(int kk=0;kk<T;kk++){

			String lin=inp.get(lin_num);
			lin_num++;
			String[] lins=lin.split(" ");
			int N=Integer.valueOf(lins[0]);
			int S=Integer.valueOf(lins[1]);
			int p=Integer.valueOf(lins[2]);
			int[] t=new int[N];
			int y=0;
			
			for(int i=0;i<N;i++){
				t[i]=Integer.valueOf(lins[i+3]);
			}
			for(int i=0;i<N;i++){
				int s1=0;int s2=0;int s3=0;
				while((s1+s2+s3)<t[i] && s1<=10 && s2<=10 && s3<=10){
					if(s3<10) s3++;
					if((s1+s2+s3)==t[i]) break;
					if(s2<10) s2++;
					if((s1+s2+s3)==t[i]) break;
					if(s1<10) s1++;
					if((s1+s2+s3)==t[i]) break;
				}
				if(s1+s2+s3!=t[i]) continue;
				int max=getmax(s1,s2,s3);
				if(max>=p){
					y++;
					continue;
				}else if(S>0 && s2==s3){
					s3++;
					s2--;
					if(s1+s2+s3==t[i] && s3>=p && s3>=p && s1>=0 && s2>=0 && s3>=0){
						S--;
						y++;
						continue;
					}
				}
				
			}
			if(S>0){
				y=0;
				for(int i=0;i<N;i++){
					int s1=0;int s2=0;int s3=0;
					while((s1+s2+s3)<t[i] && s1<=10 && s2<=10 && s3<=10){
						if(s3<10) s3++;
						if((s1+s2+s3)==t[i]) break;
						if(s2<10) s2++;
						if((s1+s2+s3)==t[i]) break;
						if(s1<10) s1++;
						if((s1+s2+s3)==t[i]) break;
					}
					if(s1+s2+s3!=t[i]) continue;
					
					if(S>0 && s2==s3){
						s3++;
						s2--;
						if(s1+s2+s3==t[i] && s3>=p && s1>=0 && s2>=0 && s3>=0){
							S--;
							y++;
							continue;
						}
					}else{
						int max=getmax(s1,s2,s3);
						if(max>=p){
							y++;
							continue;
						}
					}
					
				}
			}
			
			writeFile("Case #"+(kk+1)+": "+y);


		}


	}


	private static int getmax(int s1, int s2, int s3) {
		int max=0;
		if(max<s1) max=s1;
		if(max<s2) max=s2;
		if(max<s3) max=s3;
		return max;
	}


	public static ArrayList<String> read_fil(String file){  
		ArrayList<String> arr=new ArrayList<String>(); 
		try{

			FileInputStream fstream = new FileInputStream(file);

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null)   {
				arr.add(strLine);
			}

			in.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		return arr;
	}

	public static void writeFile(String ss) {
		String fileName = "D:\\google_Jam\\Output.txt";

		try {
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(ss);
			writer.write('\n');
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}