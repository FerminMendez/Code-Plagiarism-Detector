import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("codejamb.in"));
		BufferedWriter brout=new BufferedWriter(new FileWriter("codejamb.out"));
		StringTokenizer sb=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(sb.nextToken());
		int n;
		int p;
		int surprising;
		int[] values;
		for(int l=1;l<=t;l++) {
			sb=new StringTokenizer(br.readLine());
			n=Integer.parseInt(sb.nextToken());
			surprising=Integer.parseInt(sb.nextToken());
			p=Integer.parseInt(sb.nextToken());
			values=new int[n];
			for(int i=0;i<n;i++) {
				values[i]=Integer.parseInt(sb.nextToken());
			}
		   int  resultMax=getAnswer(values,p,surprising,0);
		
			brout.write("Case #"+l+": "+resultMax+"\n");
		}
		brout.close();
		return;
	}
	public static int getAnswer(int[] x,int p,int surprisingleft,int start) {
		if(x.length-start<surprisingleft) {
			return Integer.MIN_VALUE;
		}
		if(start>=x.length && surprisingleft!=0) {
			return Integer.MIN_VALUE;
		}
		if(start==x.length && surprisingleft==0) {
			return 0;
		}
		boolean flag=false;
		if(surprisingleft==0) {
			flag=true;
		}
		int ifsurprising=0;
		int ifnotsurprising=0;
		int k=x[start]%3;
		int num1s=0;
		int num2s=0;
		int num3s=0;
		int num1not=0;
		int num2not=0;
		int num3not=0;
		switch(k) {
		case 0:
			if(x[start]==30 || x[start]==0) {
				num1not=x[start]/3;
				num2not=x[start]/3;
				num3not=x[start]/3;
				num1s=x[start]/3;
				num2s=x[start]/3;
				num3s=x[start]/3;
			} else {
				num1s=x[start]/3-1;
				num2s=x[start]/3;
				num3s=x[start]/3+1;
				num1not=x[start]/3;
				num2not=x[start]/3;
				num3not=x[start]/3;	
			}
			
			break;
		case 1:
			if(x[start]==1) {
				num1s=x[start]/3;
				num2s=x[start]/3;
				num3s=x[start]/3+1;
				num1not=x[start]/3;
				num2not=x[start]/3;
				num3not=x[start]/3+1;
			} else {
				num1s=x[start]/3-1;
				num2s=x[start]/3+1;
				num3s=x[start]/3+1;
				num1not=x[start]/3;
				num2not=x[start]/3;
				num3not=x[start]/3+1;
			}
		
			break;
		case 2:
			num1s=x[start]/3;
			num2s=x[start]/3;
			num3s=x[start]/3+2;
			num1not=x[start]/3;
			num2not=x[start]/3+1;
			num3not=x[start]/3+1;
			break;
		}
		if(num1s>=p) {
			ifsurprising++;
		}
		if(num2s>=p) {
			ifsurprising++;
		}
		if(num3s>=p) {
			ifsurprising++;
		}
		if(num1not>=p) {
			ifnotsurprising++;
		}
		if(num2not>=p) {
			ifnotsurprising++;
		}
		if(num3not>=p) {
			ifnotsurprising++;
		}
		if(flag) {
			if(ifnotsurprising>0)
			return getAnswer(x,p,surprisingleft,start+1)+1;
			else 
				return getAnswer(x,p,surprisingleft,start+1);
		}
		else {
			int acc21=0;
			int acc22=0;
			if(ifsurprising>0) {
				acc21=1;
			}
			if(ifnotsurprising>0) {
				acc22=1;
			}
		    
		if(getAnswer(x,p,surprisingleft-1,start+1)+acc21> getAnswer(x, p, surprisingleft, start+1)+acc22)
			return getAnswer(x,p,surprisingleft-1,start+1)+acc21;
		else 
			return getAnswer(x, p, surprisingleft, start+1)+acc22;
	   }
		
	}
}

