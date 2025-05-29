import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

class Start{
	BufferedInputStream bis=new BufferedInputStream(System.in);
	PrintWriter out=new PrintWriter(System.out, true);
	int i,j,k,l,m,n,o,p,q,r,s,t,w,x,y,z,ry,rz,rs;
	long a,b,c;
	double d,e,f,g,h;
	char u,v;
	String st;
	int[] in,arr,res;
	final double pi=3.14159265;
	final double l2=0.69314718;

	char chr()throws IOException{
		while((ry=bis.read())==10 || ry==13 || ry==32){}
		return (char)ry;
	}

	int num()throws IOException{
		rz=0;rs=0;
		ry=bis.read(); if(ry=='-') rs=-1; else rz+=(ry-'0');
		while((ry=bis.read())>='0' && ry<='9') rz=rz*10+(ry-'0');
		if(rs==-1) rz=-rz;
		if(ry==13) bis.read();
		return rz;
	}

	String str()throws IOException{
		StringBuilder sb=new StringBuilder();
		while((ry=bis.read())!=10 & ry!=13 && ry!=32) sb.append((char)ry);
		if(ry==13) bis.read();
		return sb.toString();
	}

	String line()throws IOException{
		StringBuilder sb=new StringBuilder();
		while((ry=bis.read())!=10 && ry!=13) sb.append((char)ry);
		if(ry==13)bis.read();
		return sb.toString();
	}

	int log2(double par){return (int)(Math.log(par)/l2);}

	long perm(int p1,int p2){
		long ret=1; int it;
		it=p1; while(it>p2) ret*=it--;
		return ret;
	}

	long comb(int p1,int p2){
		long ret=1; int it;
		if(p2<p1-p2) k=p1-p2;
		it=p1; while(it>p2) ret*=it--;
		it=p1-p2; while(it>1) ret/=it--;
		return ret;
	}

	public void go()throws IOException{
		out =new PrintWriter(new FileWriter("out.txt"),true);
		t=num();
		w=t;
		while(--t>=0){
			a=0;
			y=num();
			z=num();
			if(y<10) y=10;
			p=(int)Math.log10((double)z);
			q=(int)Math.pow(10.0, (double)p);

			for(i=y; i<=z; i++)
			{
				k=i;
				r=p;
				while(r-->0){
					k = (k/10) + ((k%10)*q);
					if(k>i && k<=z) a++;
				}
			}
			out.println("Case #"+(w-t)+": "+a);
		}
		while(bis.available()>0)bis.read();
		out.close();
	}

	public static void main(String args[])throws IOException{new Start().go();}
}
