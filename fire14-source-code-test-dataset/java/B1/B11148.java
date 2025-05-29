import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String args[]){
		try{
		FileInputStream fin=new FileInputStream("C:\\Program lang\\Google Code Jam\\input01.txt");
		DataInputStream datain=new DataInputStream(fin);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(datain));
		File file = new File("C:\\Program lang\\Google Code Jam\\output01.txt");
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
		
		int T=Integer.parseInt(br.readLine());
		for(int j=0;j<T;j++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			String sA=st.nextToken();
			String sB=st.nextToken();
			int A=Integer.parseInt(sA);
			int B=Integer.parseInt(sB);
			int l[]=new int[sA.length()];
			int u[]=new int[sB.length()];
			int count=0;
			for(int i=0;i<sA.length()-1;i++){
				l[i]=Integer.parseInt(sA.substring(i,i+1));
				u[i]=Integer.parseInt(sB.substring(i,i+1));
			}
			l[sA.length()-1]=Integer.parseInt(sA.substring(sA.length()-1));
			u[sB.length()-1]=Integer.parseInt(sB.substring(sB.length()-1));
			
			if(l.length==2){
				ArrayList<Integer> num=new ArrayList<Integer>();
				//ab
				for(int i=A;i<B+1;i++){
					if(!num.contains(i)){
						int unit=i%10;
						int tens=i/10;
						if(unit!=tens){
							int swap=unit*10+tens;
							if(A<=swap && swap<=B)	{
								num.add(swap);
								count++;	
							}
						}
					}
				}
				
			}
			else if(l.length==3){
					// abc
				ArrayList<Integer> num=new ArrayList<Integer>();
				// A is at 0th position
				// r is at r-A
				for(int i=A;i<B+1;i++){
					if(!num.contains(i)){
					String s1=Integer.toString(i);
					int p=Integer.parseInt(s1.substring(1)+s1.substring(0,1));  //bca
					int q=Integer.parseInt(s1.substring(2)+s1.substring(0,2));  //cab
					if(p==q){}
					else if(p>=A && p<=B){
						count++;
						num.add(p);
						if(q>=A && q<=B){
							count=count+2;
							num.add(q);
						}
					}
					else if(q>=A && q<=B)	{
						count++;
						num.add(q);
					}
				}
				}
			}
			bw.write("Case #"+(j+1)+": "+count);
			bw.newLine();
		}
		bw.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}

