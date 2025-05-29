import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Google Code Jam 2012. Qualification. Problem C.
 * 
 * @author Ivan Pryvalov (ivan.pryvalov@gmail.com)
 * 
 */
public class GCJ_2012_Q_C implements Runnable{
	
	static class Data{
		int i;
		int next;
		int prev;
	}
	
	private void solve() throws IOException {
		
		int MAX = 2000000 + 1;
		Data[] d = new Data[MAX];
		for (int i = 0; i < d.length; i++) {
			Data dat = new Data();
			dat.i = i;
			dat.next = -1;
			dat.prev = -1;
			d[i] = dat;
		}
		
		for (int i = 0; i < d.length; i++) {
			
			if (d[i].prev != -1)
				continue;
			
			String cur = ""+i;
			Set<String> set = new HashSet<String>();
			while (!set.contains(cur)){
				set.add(cur);						
				cur = next(cur);
			}
			
			List<Integer> list = new ArrayList<Integer>();
			for (String s : set) {
				if (s.charAt(0)!='0'){
					int num = Integer.parseInt(s);
					if (num < MAX)
						list.add(num);
				}
			}
			Collections.sort(list);
			for (int j = 0; j < list.size(); j++) {
				if (j>0){
					d[list.get(j)].prev = list.get(j-1);
					d[list.get(j-1)].next = list.get(j);
				}
				if (j<list.size()-1){
					d[list.get(j)].next = list.get(j+1);
					d[list.get(j+1)].prev = list.get(j);
				}
			}
		}
		
		int T = scanner.nextInt();
		for (int test = 0; test < T; test++) {
			int A = scanner.nextInt(); //10^3 or 2*10^6			
			int B = scanner.nextInt();
			
			long answer = 0;
			
			boolean[] used = new boolean[B+1];
			for(int x = A; x <=B; x++){
				if (used[x]) 
					continue;
				if (d[x].next != -1){
					int cur = x;
					int n = 0;
					while (cur<=B){
						used[cur] = true;
						n++;	
						if (d[cur].next==-1)
							break;
						cur = d[cur].next;						
					}
					answer += n*(n-1)/2;
				}
			}
			out.println("Case #"+(test+1)+": "+answer);
			
		}
	}

	private String next(String curS) {
		if (curS.length() > 1){
			char firstCh = curS.charAt(0);
			curS = curS.substring(1) + new String(new char[]{firstCh});
		}
		return curS;
	}
	
	//////////////////////////////////////////////////
	
	static class ArrayWrapper<T>{
		T[] ar;
		Comparator<T> comparator;
		
		public ArrayWrapper(Set<T> set) {
			ar = (T[]) set.toArray();
		} 

		public ArrayWrapper(T[] ar) {
			this.ar = ar;
		}
		
		public ArrayWrapper(T[] ar, Comparator<T> comparator) {
			this.ar = ar;
			this.comparator = comparator;
		}

		public ArrayWrapper<T> sort(){
			if (comparator==null){
				Arrays.sort(ar);		
			}else{
				Arrays.sort(ar, comparator);
			}
			return this;
		}
		
		public T getFirst(){
			return ar[0];
		}
		
		public T getLast(){
			return ar[ar.length-1];
		}
	}
	
	

	/////////////////////////////////////////////////
	final int BUF_SIZE = 1024 * 1024 * 8;//important to read long-string tokens properly
	final int INPUT_BUFFER_SIZE = 1024 * 1024 * 8 ;
	final int BUF_SIZE_INPUT = 1024;
	
	final int BUF_SIZE_OUT = 1024;
	
	boolean inputFromFile = true;
	String filenamePrefix = "C-small-attempt0";
	String inSuffix = ".in";
	String outSuffix = ".out";
	
	//InputStream bis;
	//OutputStream bos;
	PrintStream out;
	ByteScanner scanner;
	ByteWriter writer;
	
	@Override
	public void run() {
		try{
			InputStream bis = null;
			OutputStream bos = null;
			//PrintStream out = null;
			if (inputFromFile){
				File baseFile = new File(getClass().getResource("/").getFile());
				bis = new BufferedInputStream(
						new FileInputStream(new File(
								baseFile, filenamePrefix+inSuffix)),
								INPUT_BUFFER_SIZE);
				bos = new BufferedOutputStream(
						new FileOutputStream(
								new File(baseFile, filenamePrefix+outSuffix)));
				out = new PrintStream(bos);
			}else{
				bis = new BufferedInputStream(System.in, INPUT_BUFFER_SIZE);
				bos = new BufferedOutputStream(System.out);
				out = new PrintStream(bos);
			}
			scanner = new ByteScanner(bis, BUF_SIZE_INPUT, BUF_SIZE);
			writer = new ByteWriter(bos, BUF_SIZE_OUT);
			
			solve();
			out.flush();
		}catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public interface Constants{
		final static byte ZERO = '0';//48 or 0x30
		final static byte NINE = '9';
		final static byte SPACEBAR = ' '; //32 or 0x20
		final static byte MINUS = '-'; //45 or 0x2d	
		
		final static char FLOAT_POINT = '.';
	}
	
	public static class EofException extends IOException{
	}
	
	public static class ByteWriter implements Constants {
		
		int bufSize = 1024;
		byte[] byteBuf = new byte[bufSize];
		OutputStream os;
		
		public ByteWriter(OutputStream os, int bufSize){
			this.os = os;
			this.bufSize = bufSize;
		}
		
		public void writeInt(int num) throws IOException{
	         int byteWriteOffset = byteBuf.length;
	         if (num==0){
	        	 byteBuf[--byteWriteOffset] = ZERO;
	         }else{
	        	 int numAbs = Math.abs(num);
	        	 while (numAbs>0){
	        		 byteBuf[--byteWriteOffset] = (byte)((numAbs % 10) + ZERO);
	        		 numAbs /= 10;
	        	 }
	        	 if (num<0)
	        		 byteBuf[--byteWriteOffset] = MINUS;
	         }
	         os.write(byteBuf, byteWriteOffset, byteBuf.length - byteWriteOffset);
		}
		
		/**
		 * Please ensure ar.length <= byteBuf.length!
		 * 
		 * @param ar
		 * @throws IOException
		 */
		public void writeByteAr(byte[] ar) throws IOException{
			for (int i = 0; i < ar.length; i++) {
				byteBuf[i] = ar[i];
			}
			os.write(byteBuf,0,ar.length);
		}
		
		public void writeSpaceBar() throws IOException{
			byteBuf[0] = SPACEBAR;
			os.write(byteBuf,0,1);
		}
		
	}
	
	public static class ByteScanner implements Constants{
		
		InputStream is;
		
		public ByteScanner(InputStream is, int bufSizeInput, int bufSize){
			this.is = is;
			this.bufSizeInput = bufSizeInput;
			this.bufSize = bufSize;
			
			byteBufInput = new byte[this.bufSizeInput];
			byteBuf = new byte[this.bufSize];
		}
		
		public ByteScanner(byte[] data){
			byteBufInput = data;
			bufSizeInput = data.length;
			bufSize = data.length;
			byteBuf = new byte[bufSize];
			byteRead = data.length;
			bytePos = 0;
		}
		
		private int bufSizeInput;
		private int bufSize;
		
		byte[] byteBufInput;
		byte by=-1;
		int byteRead=-1;
		int bytePos=-1;

		byte[] byteBuf;
		int totalBytes;
		
		boolean eofMet = false;
		
		private byte nextByte() throws IOException{
			
			if (bytePos<0 || bytePos>=byteRead){
				byteRead = is==null? -1: is.read(byteBufInput);
				bytePos=0;
				if (byteRead<0){
					byteBufInput[bytePos]=-1;//!!!
					if (eofMet)
						throw new EofException();
					eofMet = true;
				}
			}
			return byteBufInput[bytePos++];
		}
		
		/**
		 * Returns next meaningful character as a byte.<br>
		 * 
		 * @return
		 * @throws IOException
		 */
		public byte nextChar() throws IOException{
			while ((by=nextByte())<=0x20);
			return by;
		}
		
		/**
		 * Returns next meaningful character OR space as a byte.<br>
		 * 
		 * @return
		 * @throws IOException
		 */
		public byte nextCharOrSpacebar() throws IOException{
			while ((by=nextByte())<0x20);
			return by;
		}
		
	    /**
	     * Reads line.
	     * 
	     * @return
	     * @throws IOException
	     */
	    public String nextLine() throws IOException {
            readToken((byte)0x20);
            return new String(byteBuf,0,totalBytes);
	    }
	    
	    public byte[] nextLineAsArray() throws IOException {
            readToken((byte)0x20);
            byte[] out = new byte[totalBytes];
            System.arraycopy(byteBuf, 0, out, 0, totalBytes);
            return out;
	    }
	    
		
	    /**
	     * Reads token. Spacebar is separator char.
	     * 
	     * @return
	     * @throws IOException
	     */
	    public String nextToken() throws IOException {
            readToken((byte)0x21);
            return new String(byteBuf,0,totalBytes);
	    }
	    
	    /**
	     * Spacebar is included as separator char
	     * 
	     * @throws IOException
	     */
	    private void readToken() throws IOException {	    	
            readToken((byte)0x21);
	    }
	    
	    private void readToken(byte acceptFrom) throws IOException {
            totalBytes = 0;
            while ((by=nextByte())<acceptFrom);
            byteBuf[totalBytes++] = by;
            while ((by=nextByte())>=acceptFrom){
                byteBuf[totalBytes++] = by;
            }
	    }
		
	    public int nextInt() throws IOException{
			readToken();
			int num=0, i=0;
			boolean sign=false;
			if (byteBuf[i]==MINUS){
				sign = true;
				i++;
			}
			for (; i<totalBytes; i++){
				num*=10;
				num+=byteBuf[i]-ZERO;
			}
			return sign?-num:num;
		}
		
		public long nextLong() throws IOException{
			readToken();
			long num=0;
			int i=0;
			boolean sign=false;
			if (byteBuf[i]==MINUS){
				sign = true;
				i++;
			}
			for (; i<totalBytes; i++){
				num*=10;
				num+=byteBuf[i]-ZERO;
			}
			return sign?-num:num;
		}
		
		/*
		//TODO test Unix/Windows formats
		public void toNextLine() throws IOException{
			while ((ch=nextChar())!='\n');
		}
		*/
		
		public double nextDouble() throws IOException{
			readToken();
			char[] token = new char[totalBytes];
			for (int i = 0; i < totalBytes; i++) {
				token[i] = (char)byteBuf[i];
			}
			return Double.parseDouble(new String(token));
		}
	    
	}
	
	public static void main(String[] args) {
		new GCJ_2012_Q_C().run();
	}
	
}
