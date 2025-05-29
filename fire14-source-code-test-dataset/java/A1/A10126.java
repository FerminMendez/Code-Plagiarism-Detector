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
		j=t;
		while(--t>=0){
			n=num();
			s=num();
			p=num();
			x=0;
			for(i=0;i<n;i++)
			{
				y=num();
				z=y/3;
				if((z>=p) ||
				((z+1 + z*2 == y) && z+1>=p) ||
				(((z+1)*2 + z == y) && z+1>=p)) x++;
				else if(s>0 &&
				((z-1>0 && (z*3 == y) && z+1>=p)||
				(z-2>0 && (z*3+2 == y) && z+2>=p)||
				(z-2>0 && (z*3-2 == y) && z>=p))||
				(z+2<10 && (z*3+4 == y) && z+2>=p)||
				(z-2>0 && (z*3-4 == y) && z>=p))
				{ x++; s--;}
			}
			out.println("Case #"+(j-t)+": "+x);
		}
		while(bis.available()>0)bis.read();
		out.close();
	}

	public static void main(String args[])throws IOException{new Start().go();}
}
