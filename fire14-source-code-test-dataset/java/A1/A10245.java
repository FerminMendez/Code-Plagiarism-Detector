package qualification;
import java.io.*;
import java.util.*;
import java.math.*;

public class B
{
	//static String PROBLEM_NAME = "b-practice";
	static String PROBLEM_NAME = "b-small-0";
	//static String PROBLEM_NAME = "b-small-1";
	//static String PROBLEM_NAME = "b-small-2";
	//static String PROBLEM_NAME = "b-small-3";
	//static String PROBLEM_NAME = "b-small-4";
	//static String PROBLEM_NAME = "b-large-0";	

	public int[] max = {-1,-1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10,-1,-1};
	public int[] min = {0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10};

	public void solveCase() throws Exception 
	{
		int N = INT();
		int S = INT();
		int P = INT();
		
		int b = 0;
		for(int i=0; i<N; i++ )
		{
			int t = INT();
			if( min[t] >= P )
				b++;
			else if( S > 0 && max[t] >= P )
			{
				b++;
				S--;
			}
		}
		
		println( b );
	}

	
	
	// *************************************************************************************
	// ****************** FRAMEWORK (borrowed from eireksten and modified) *****************
	// *************************************************************************************
	
	public static File input;
	public static FileReader inputreader;
	public static BufferedReader in;
	
	public static File output;
	public static FileWriter outputwriter;
	public static BufferedWriter out;
	
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		setInput("problems/"+ PROBLEM_NAME +".in");
		setOutput("problems/"+ PROBLEM_NAME +".out");
		B b = new B();
		int cases = INT();
		for(int cc = 1;cc<=cases;cc++) {
						
			print("Case #"+cc+": ");
			b.solveCase();
		}
		
		close();
	}
	
	// **************** HELPERS ****************************

	public static double[] converDoubleArray(ArrayList<Double> n){double[] ret=new double[n.size()];for(int i=0;i<ret.length;i++){if(n.get(i)!=null)ret[i]=n.get(i).doubleValue();else ret[i] = 0;} return ret;}
	public static ArrayList<Double> convertDoubleArray(double[] n){ArrayList<Double> arr = new ArrayList<Double>();for(int i=0; i<n.length; i++)arr.add( new Double( n[i] ) );return arr;}
	public static long[] convertLongArray(ArrayList<Long> n){long[] ret=new long[n.size()];for(int i=0;i<ret.length;i++){if(n.get(i)!=null)ret[i]=n.get(i).longValue();else ret[i] = 0;} return ret;}
	public static ArrayList<Long> convertLongArray(long[] n){ArrayList<Long> arr = new ArrayList<Long>();for(int i=0; i<n.length; i++)arr.add( new Long( n[i] ) );return arr;}
	public static int[] convertIntArray(ArrayList<Integer> n){int[] ret=new int[n.size()];for(int i=0;i<ret.length;i++){if(n.get(i)!=null)ret[i]=n.get(i).intValue();else ret[i] = 0;} return ret;}
	public static ArrayList<Integer> convertIntArray(int[] n){ArrayList<Integer> arr = new ArrayList<Integer>();for(int i=0; i<n.length; i++)arr.add( new Integer( n[i] ) );return arr;}

	public static double[] createDoubleArray(int elements, double start){return createDoubleArray(elements,start,0);}
	public static double[] createDoubleArray(int elements, double start, double inc ){double[] arr = new double[elements];for(int i=0; i<elements; i++) arr[i] = start + i * inc;return arr;}
	public static long[] createLongArray(int elements, long start){return createLongArray(elements,start,0);}
	public static long[] createLongArray(int elements, long start, long inc ){long[] arr = new long[elements];for(int i=0; i<elements; i++) arr[i] = start + i * inc;return arr;}
	public static int[] createIntArray(int elements, int start){return createIntArray(elements,start,0);}
	public static int[] createIntArray(int elements, int start, int inc ){int[] arr = new int[elements];for(int i=0; i<elements; i++) arr[i] = start + i * inc;return arr;}

	public static int[] mapArray( int[] array, int[] map ){int[] mapped=new int[map.length];int l=map.length;for(int i=0;i<l;i++)mapped[i]=array[ map[i]];return mapped;}
	public static long[] mapArray( long[] array, int[] map ){long[] mapped=new long[map.length];int l=map.length;for(int i=0;i<l;i++)mapped[i]=array[ map[i]];return mapped;}
	public static double[] mapArray( double[] array, int[] map ){double[] mapped=new double[map.length];int l=map.length;for(int i=0;i<l;i++)mapped[i]=array[ map[i]];return mapped;}
	public static String[] mapArray( String[] array, int[] map ){String[] mapped=new String[map.length];int l=map.length;for(int i=0;i<l;i++)mapped[i]=array[ map[i]];return mapped;}
	//public static _C_[] mapArray( _C_[] array, int[] map ){_C_[] mapped=new _C_[map.length];int l=map.length;for(int i=0;i<l;i++)mapped[i]=array[ map[i]];return mapped;}

	// **************** PRINT METHODS **********************
	public static void printException(Exception e ){ e.printStackTrace(); }
	public static void println(){try{out.write("\n");System.out.println();}catch(Exception e){printException(e);}}
	public static void println(Object obj){try{out.write(obj.toString());out.write("\n");System.out.println(obj.toString());}catch(Exception e){printException(e);}}
	public static void print(Object obj){try{out.write(obj.toString());System.out.print(obj.toString());}catch(Exception e){printException(e);}}
	public static void println(long number){try{out.write(Long.toString(number));out.write("\n");System.out.println(number);}catch(Exception e){printException(e);}}
	public static void print(long number){try{out.write(Long.toString(number));System.out.print(number);}catch(Exception e){printException(e);}}
	public static void println(char c){try{out.write(Character.toString(c));out.write("\n");System.out.println(c);}catch(Exception e){printException(e);}}
	public static void print(char c){try{out.write(Character.toString(c));System.out.print(c);}catch(Exception e){printException(e);}}
	public static void println(String line){try{out.write(line);out.write("\n");System.out.println(line);}catch(Exception e){printException(e);}}
	public static void print(String line){try{out.write(line);System.out.print(line);}catch(Exception e){printException(e);}}

	public static void print( long[] array, String spacer){print( convertLongArray(array), spacer );}
	public static void print( double[] array, String spacer){print( convertDoubleArray(array), spacer );}
	public static void print( int[] array, String spacer){print( convertIntArray(array), spacer );}

	public static void println( long[] array, String spacer){print(array, spacer );println("");}
	public static void println( double[] array, String spacer){print( array, spacer );println("");}
	public static void println( int[] array, String spacer){print("");print( array, spacer );println("");}
	
	public static <T> void print( T[] array, String spacer){for(int i=0; i<array.length; i++){if( i!=0 )print(spacer);print(array[i]);}}
	public static <T> void println( T[] array, String spacer){print(array,spacer);println("");}
	
	@SuppressWarnings("unchecked")
	public static void print( List list ){print(list, " ");}
	@SuppressWarnings("unchecked")
	public static void print( List list, String spacer ){int doSpace=0;for( Object obj : list ){	if( doSpace != 0 )print(spacer);print( obj );doSpace++;}}
	
	@SuppressWarnings("unchecked")
	public static void println( List list ){println(list, " ");}
	@SuppressWarnings("unchecked")
	public static void println( List list, String spacer ){int doSpace=0;for( Object obj : list ){	if( doSpace != 0 )print(spacer);print( obj );doSpace++;} println("");}
	
	

	// ******************** INPUT DECLARATION ******************
	public static void setInput(String filename) throws IOException {input = new File(filename);inputreader = new FileReader(input);in = new BufferedReader(inputreader);}
	public static void setOutput(String filename) throws IOException {output = new File(filename);outputwriter = new FileWriter(output);out = new BufferedWriter(outputwriter);}
	public static void close() throws IOException {if(in!=null)in.close();if(inputreader!=null)inputreader.close();if(out!=null)out.flush();if(out!=null)out.close();if(outputwriter!=null)outputwriter.close();}
	
	// ************************** INPUT READING *****************
	static String LINE() throws IOException { return in.readLine(); }
	static String TOKEN() throws IOException {while (st == null || !st.hasMoreTokens())st = new StringTokenizer(LINE());return st.nextToken();}
	static int INT() throws IOException {return Integer.parseInt(TOKEN());}
	static long LONG() throws IOException {return Long.parseLong(TOKEN());}
	static double DOUBLE() throws IOException {return Double.parseDouble(TOKEN());}
	static BigInteger BIGINT() throws IOException {return new BigInteger(TOKEN());}
	

	//**************** PERMUTATIONS  **********************
//	    new Permutation(20) will create 20 objects
//	    and steps through the different orderings
	//
//	    .hasMore()  .getTotal()     .getNumLeft()
//	    .getNext()  .reset()
	//---------------------------------
	class Permutation {
		  private int[] a; private long numLeft; private long total;
		  public Permutation(int n) { a = new int[n]; total = getFactorial (n);  reset (); }
		  public void reset () {for (int i = 0; i < a.length; i++) { a[i] = i; } numLeft = total; }
		  public long getNumLeft () { return numLeft; }  public long getTotal () {  return total; }  public boolean hasMore () { return numLeft > 0; }
		  private long getFactorial (int n) { long fact = 1;for (int i = n; i > 1; i--) {fact *= i; } return fact; }
		  public int[] getNext () {  if ( numLeft == total) {  numLeft--;  return a;  }    int temp;
		    int j = a.length - 2;  while (a[j] > a[j+1]) {  j--;  }   int k = a.length - 1;  while (a[j] > a[k]) {  k--;  }
		    temp = a[k];  a[k] = a[j];  a[j] = temp;  int r = a.length - 1;  int s = j + 1;  while (r > s) {  temp = a[s]; a[s] = a[r];  a[r] = temp;   r--;   s++;  }
		    numLeft--;   return a;  }	
	}

	//**************** COMBINATIONS  **********************
	//new Combination(24,5) will create 24 objects 
	//and chooses 5 at a time
	//
	//.hasMore()  .getTotal()     .getNumLeft()
	//.getNext()  .reset()
	//---------------------------------
	class Combination {
		private int[] a; private int n; private int r;private long numLeft;private long total;
		public Combination (int n, int r) {
			this.n = n;this.r = r;a = new int[r];
			BigInteger nFact = getFactorial (n);BigInteger rFact = getFactorial (r);BigInteger nminusrFact = getFactorial (n - r);total = nFact.divide (rFact.multiply (nminusrFact)).longValue();reset ();}

		public void reset () {for (int i = 0; i < a.length; i++) {a[i] = i;}numLeft=total;}
		public long getNumLeft () {return numLeft;}	public boolean hasMore () {return numLeft > 0;} public long getTotal () {return total;}
		private BigInteger getFactorial (int n) {BigInteger fact = BigInteger.ONE;for (int i = n; i > 1; i--) {fact = fact.multiply (new BigInteger (Integer.toString (i)));}return fact;}
		public int[] getNext () {if (numLeft == total) {numLeft--; return a;}int i = r - 1;while (a[i] == n - r + i) {i--;}a[i] = a[i] + 1;
		for (int j = i + 1; j < r; j++) { a[j] = a[i] + j - i;} numLeft--; return a;}
	}

	//**************** Coloring  **********************
	//new Coloring(24,5) will create 24 objects 
	//and color each up to 5 different ways.
	//
	//.hasMore()  .getTotal()     .getNumLeft()
	//.getNext()  .reset()
	//---------------------------------
	class Coloring {
		private int[] a;private int r;private long numLeft;	private long total;
		public Coloring (int n, int r){this.r = r;a = new int[n];total = (long) Math.pow(r, n); reset();}
		public void reset(){for(int i=0;i<a.length;i++) {a[i]=0;}numLeft=total;a[0]=-1;}
		public long getNumLeft () {return numLeft;}	public boolean hasMore (){return numLeft > 0;}
		public long getTotal () {return total;}
		public int[] getNext () {numLeft--;a[0]++;int j=0;while(a[j]==r){a[j]=0;a[j+1]++;j++;}return a;}
	}

}