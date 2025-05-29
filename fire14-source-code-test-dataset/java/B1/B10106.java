	import java.awt.Point;
	import java.io.*;
	import java.lang.reflect.Array;
	import java.math.BigInteger;
	import java.util.*;
	
import static java.lang.Math.*;
	
	public class Start {
	
	    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	    BufferedReader in;
	    PrintWriter out;
	    StringTokenizer tok = new StringTokenizer("");
	
	    void init() throws FileNotFoundException {
	        if (ONLINE_JUDGE) {
	            in = new BufferedReader(new InputStreamReader(System.in));
	            out = new PrintWriter(System.out);
	        } else {
	            in = new BufferedReader(new FileReader("input.txt"));
	            out = new PrintWriter("output.txt");
	        }
	    }
	
	    String readString() throws IOException {
	        while (!tok.hasMoreTokens()) {
	            tok = new StringTokenizer(in.readLine());
	        }
	        return tok.nextToken();
	    }
	
	    int readInt() throws IOException {
	        return Integer.parseInt(readString());
	    }
	
	    long readLong() throws IOException {
	        return Long.parseLong(readString());
	    }
	
	    double readDouble() throws IOException {
	        return Double.parseDouble(readString());
	    }
	
	    public static void main(String[] args) {
	        new Start().run();
	    }
	
	    public static void mergeSort(int[] a) {
	        mergeSort(a, 0, a.length - 1);
	    }
	    
	    private static void mergeSort(int[] a, int levtIndex, int rightIndex) {
	        final int MAGIC_VALUE = 50;
	        if (levtIndex < rightIndex) {
	            if (rightIndex - levtIndex <= MAGIC_VALUE) {
	                insertionSort(a, levtIndex, rightIndex);
	            } else {
	                int middleIndex = (levtIndex + rightIndex) / 2;
	                mergeSort(a, levtIndex, middleIndex);
	                mergeSort(a, middleIndex + 1, rightIndex);
	                merge(a, levtIndex, middleIndex, rightIndex);
	            }
	        }
	    }
	
	    private static void merge(int[] a, int levtIndex, int middleIndex,
	            int rightIndex) {
	        int length1 = middleIndex - levtIndex + 1;
	        int length2 = rightIndex - middleIndex;
	        int[] levtArray = new int[length1];
	        int[] rightArray = new int[length2];
	        System.arraycopy(a, levtIndex, levtArray, 0, length1);
	        System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
	        for (int k = levtIndex, i = 0, j = 0; k <= rightIndex; k++) {
	            if (i == length1) {
	                a[k] = rightArray[j++];
	            } else if (j == length2) {
	                a[k] = levtArray[i++];
	            } else {
	                a[k] = levtArray[i] <= rightArray[j] ? levtArray[i++]
	                        : rightArray[j++];
	            }
	        }
	    }
	
	    private static void insertionSort(int[] a, int levtIndex, int rightIndex) {
	        for (int i = levtIndex + 1; i <= rightIndex; i++) {
	            int current = a[i];
	            int j = i - 1;
	            while (j >= levtIndex && a[j] > current) {
	                a[j + 1] = a[j];
	                j--;
	            }
	            a[j + 1] = current;
	        }
	    }
	
	    public void run() {
	        try {
	            long t1 = System.currentTimeMillis();
	            init();
	            solve();
	            out.close();
	            long t2 = System.currentTimeMillis();
	            System.err.println("Time = " + (t2 - t1));
	        } catch (Exception e) {
	            e.printStackTrace(System.err);
	            System.exit(-1);
	        }
	    }
	
	    
	    class LOL {
	    	int x;
	    	int y;
	    	
	    		public LOL(int x, int k){
	    			this.x = x;
	    			y = k;
	    		}

	    	
	    }
	    
	    ArrayList<LOL> list;
	    int a,b;
	    
	    void PROC (int x){
	    	String s = Integer.toString(x);
	    	for (int i = 0; i<s.length()-1; i++){
	    		String temp = "";
	    		temp += s.substring(i+1,s.length());
	    		temp += s.substring(0,i+1);
	    		int k = Integer.parseInt(temp);
	    		if (k>=a && k<=b && x < k  ) {
	    			boolean b = false;
	    			for (int z = 0; z <list.size(); z++){
	    				if (list.get(z).x == x && list.get(z).y==k){
	    					b = true;
	    					break;
	    				}
	    			}
	    			if (!b) list.add(new LOL(x, k));
	    		}
	    	}
	    }
	    
	    public void solve() throws IOException {
	    	
	    		int n = readInt();
	    		
	    		for (int t = 1; t <= n; t++){
	    			
	    			a = readInt();
	    		    b = readInt();
	    		    list = new  ArrayList<LOL>();
	    			int ans = 0;
	    			for (int i = a; i<=b; i++){
	    				PROC(i);
	    			}
	    			out.print("Case #"+t+": ");
	    			out.print(list.size());
	    			if (t!=n) out.println();
	    			list.clear();
	    		}
	    }
	    

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	