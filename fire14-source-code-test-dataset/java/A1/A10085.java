import java.lang.*;
import java.util.*;
import java.io.*;
class codejam2
{
	public static boolean check(int[] ar){
		if(ar[2]-ar[1]<3 && ar[2]-ar[0]<3 && ar[0]>=0) return true;
		else return false;
	}

	public static boolean sur(int[] ar){
		if(ar[2]-ar[0]==2) return true;
		else return false;
	}

	public static int mainHelper(int n1,int s1,int p1,int[] p2){
		int n=n1;
		int s=s1;
		int p=p1;
		int ans=0;
		int[] points=p2;
		int[][] a =new int[n+1][3];
		for(int i=1;i<=n;i++){
			for(int j=0;j<3;j++){
				a[i][j]=points[i]/3;
			}
			if(points[i]%3==1) a[i][2]+=1;
			else if(points[i]%3==2){
				a[i][2]+=1;
				a[i][1]+=1;
			}
			
		}
		java.util.Arrays.sort(a[1]);
		for(int i=1;i<=n;i++){
			while(check(a[i])){
				if(a[i][2]>= p){
					if(sur(a[i])){
						if(s>0){ s-=1; ans+=1;}
						}
					else ans+=1;
					break;
				}
				else{
					int[] temp=a[i];
					temp[2]+=1;
					temp[1]-=1;
					java.util.Arrays.sort(temp);
					if(check(temp)) a[i]=temp;
					else break;

				}
			}
		}
		return ans;

	}

	public static void main(String[] args) 
	{
		//N S p .......3 1 5 15 13 11
		try{
			BufferedReader in=new BufferedReader(new FileReader("input2.txt"));
			BufferedWriter out=new BufferedWriter(new FileWriter("output2.txt"));
			int z=Integer.parseInt(in.readLine());
			for(int j=0;j<z;j++){
				String str=in.readLine();
				StringTokenizer st=new StringTokenizer(str);
				int n=Integer.parseInt(st.nextToken());
				int s=Integer.parseInt(st.nextToken());
				int p=Integer.parseInt(st.nextToken());
				int[] p2=new int[n+1];
				for(int i=1;i<=n;i++){
					p2[i]=Integer.parseInt(st.nextToken());
				}
				out.write("Case #"+(j+1)+": "+mainHelper(n,s,p,p2)+"\n");
			}
			out.close();
			in.close();
		}
		catch(IOException e){}


	}
}
