

	import java.util.Comparator;
	import java.io.OutputStream;
	import java.io.PrintWriter;
	import java.io.Writer;
	import java.util.Collection;
	import java.util.List;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.InputMismatchException;
	import java.util.ArrayList;
	import java.math.BigInteger;
	import java.util.Collections;
	import java.io.InputStream;
	import java.util.*;
	import java.io.*;


class Main{
		public static void main(String...s) {
			InputStream inputStream = System.in;
			OutputStream outputStream = System.out;
			InputReader in = new InputReader(inputStream);
			OutputWriter out = new OutputWriter(outputStream);
			int Test=in.readInt();
			new Solver(Test,in,out);
			out.close();
		}
	}
	class Solver
	{
		static int T;
		static InputReader in;
		static OutputWriter out;
		static IOUtils utils;
		
		Solver(int T,InputReader in,OutputWriter out)
		{
			this.T=T;
			this.in=in;
			this.out=out;
			solve();
		}
		static int findDigit(int num)
		{
			int count=0,cnt=0;
			int tmp=num%10;
			while(num > 0)
			{
				count++;
				if(tmp == (num %10)) { cnt++;}
				num/=10;
			
			}
			return (cnt == count ? 0:count);
		
		}
		static void solve()
		{
			int itr=1;
			//preprocess();
			for(int f = 0 ; f < T ; f++)
			{
				int A=in.readInt();
				int B=in.readInt();
				int sum=0;
				for(int i=A;i<=B;i++)
				{
					int tmp=i,newNum=tmp,x=0,ans=0;
					int howManyDigit=findDigit(tmp);if(howManyDigit == 0) { ans=0;continue;}
					if(howManyDigit == 2) x=10;
					if(howManyDigit == 3) x=100;
					if(howManyDigit == 4) x=1000;
					for(int f1 = 1 ; f1 < howManyDigit ; f1++)
					{
						int tmp1=newNum;
						newNum=( tmp1%10 ) * x ;int y=1;tmp1=tmp1/10;
						while(tmp1 > 0)
						{
							newNum+=(tmp1%10)*y;
							tmp1/=10;
							y*=10;
					
						}
						if(newNum >= A && newNum <= B ) { ans++;}
					}
					sum+=ans;
				}
				out.printLine("Case #"+itr+":"+" "+sum/2);
				itr++;
			}		
		}
	}
	/*class MoreUtils
	{
		static char mark[];
		static int prime[]=new int[1000000];
		static int pcount=-1;
		static int Tree[];
		static int Brr[];
		static InputReader in;
		static OutputWriter out;
		MoreUtils(int Arr[],int UPPER_LIMIT,InputReader in,OutputWriter out)
		{
			Brr=new int[UPPER_LIMIT+1];Brr[0]=0;
			for(int i=1;i<=UPPER_LIMIT;i++) {Brr[i]=Arr[i];}
			Tree=new int[ UPPER_LIMIT * 3];
	        buildTree(1,1,UPPER_LIMIT);
			//for(int i=1;i<=2*UPPER_LIMIT;i++) out.print(Tree[i]+" ");
			
		}
		public static int[] prime(int UPPER_LIMIT)
		{
			mark=new char[UPPER_LIMIT/2/8+1];
		    for (int i = 3; i*i <=UPPER_LIMIT; i += 2)
		        if ( (mark[i>>4] & (1<<((i>>1)&7))) == 0 )
		           for (int j = i*i; j <=UPPER_LIMIT; j += i<<1) mark[j>>4] |= (1<<((j>>1)&7));
		    prime[++pcount] = 2;
		    for (int i = 3; i <=UPPER_LIMIT; i += 2)
				if ( (mark[i>>4]&(1<<((i>>1)&7))) == 0) {prime[++pcount] = i;}
			return prime;
		}
		static void buildTree(int N,int LOWER_LIMIT,int UPPER_LIMIT)
		{
			
			if(LOWER_LIMIT == UPPER_LIMIT)
			{
				Tree[N]=Brr[ LOWER_LIMIT];
				return ;
			}
			int mid=( LOWER_LIMIT + UPPER_LIMIT) >> 1;
			buildTree(2*N ,  LOWER_LIMIT , mid);
			buildTree(2*N+1 , mid+1 , UPPER_LIMIT);
			Tree[N]=Math.max(Tree[2*N], Tree[2*N+1]);
		}
		static long query(int N, int l , int r , int x , int y)
		{
			
			if(y < l || x > r) {return 0;}
			if( l >=x && r <= y){return Tree[N];}
			int mid = (l + r) >> 1;
			long L=query( 2*N , l , mid , x , y);
			long R=query(2*N+1 ,mid+1 , r , x , y);
			return Math.max(L, R);
		}
	}*/
	class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public long readLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			long sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuffer res = new StringBuffer();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}
	}
	class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(outputStream);
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}
	}

	class IOUtils 
	{

		public static int[] readIntArray(InputReader in, int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = in.readInt();
			return array;
		}
		public static long[] readLongArray(InputReader in, int size) {
			long[] array = new long[size];
			for (int i = 0; i < size; i++)
				array[i] = in.readInt();
			return array;
		}
	}

	class IntegerUtils {

		public static int compare(long a, long b) {
			if (a < b)
				return -1;
			if (a > b)
				return 1;
			return 0;
		}
	}


