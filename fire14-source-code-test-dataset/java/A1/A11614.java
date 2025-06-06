import java.io.*;

public class ProbB 
{
	public static void main (String[] args) throws Exception
	{
		MyInputReader in = new MyInputReader(new FileInputStream("B-small-attempt2.in"));
		PrintWriter pw = new PrintWriter("output.txt");
		int T = in.nextInt();
		for(int q=0; q<T; q++)
		{
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int result = 0;
			int count = 0;
			for(int i=0; i<n; i++)
			{
				int temp = in.nextInt();
				if(temp==0 && p>0)
					continue;
				if(3*p<=temp || 3*p-2==temp || 3*p-1==temp)
					result++;
				else if(count<s && ((3*p-3)==temp || (3*p-4)==temp || (3*p+4)==temp || (3*p+3)==temp))
				{
					result++;
					count++;
				}	
			}
			pw.println("Case #"+(q+1)+": "+result);
			pw.flush();
		}
	}
	
	static class MyInputReader
    {
		final private int BUFFER_SIZE = 1 << 17;
	
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
		
		public MyInputReader(InputStream in)
		{
			din = new DataInputStream(in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
	        
	        public String nextString() throws Exception
		{
			StringBuffer sb=new StringBuffer("");
			byte c = read();
			while(c <= '\n') 
				c = read();
			do
			{
			   sb.append((char)c);
			   c=read();
			}
			while(c>'\n');
			
			return sb.toString();
		}
	        
		public String nextWord() throws Exception
		{
			StringBuffer sb=new StringBuffer("");
			byte c = read();
			while(c <= ' ') 
				c = read();
			do
			{
			   sb.append((char)c);
			   c=read();
			}
			while(c>' ');
			
			return sb.toString();
		}
		
		public char nextChar() throws Exception
		{
			byte c=read();
			while(c<=' ') 
				c= read();
			
			return (char)c;
		}
		
		public int nextInt() throws Exception
		{
			int ret = 0;
			byte c = read();
			while(c <= ' ') 
				c = read();
			boolean neg = c == '-';
			if(neg) 
				c = read();
			do
			{
			  	ret = ret * 10 + c - '0';
			 	c = read();
			} 
			while (c > ' ');
			
			if(neg) 
				return -ret;
			
			return ret;
		}
		
		public long nextLong() throws Exception
		{
			long ret = 0;
			byte c = read();
			
			while (c <= ' ') 
				c = read();
			boolean neg = c == '-';
			if(neg) 
				c = read();
			
			do
			{
			  	ret = ret * 10 + c - '0';
			 	c = read();
			} 
			while (c > ' ');
			
			if(neg) 
				return -ret;
			
			return ret;
		}
		
		private void fillBuffer() throws Exception
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if(bytesRead == -1) 
				buffer[0] = -1;
		}
		
		private byte read() throws Exception
		{
			if(bufferPointer == bytesRead) 
				fillBuffer();
			return buffer[bufferPointer++];
		}
    }
}