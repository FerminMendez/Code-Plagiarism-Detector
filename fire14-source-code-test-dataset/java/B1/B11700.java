import java.text.*;
import java.util.*;
import java.lang.*;


public class solutionRunner {

	public solutionRunner(){
		run();
	}
	
	private void run(){

		int numberOfLines = 1;
		inpOutHandler io1 = new inpOutHandler();
		testCase TC = io1.readInput("a.txt", numberOfLines);
		String result="";int _i=1;
		for(String case1:TC.cases){
			//int[] a1 = intAfromString(case1.substring(case1.indexOf('\n') +1));
			pairs = new HashSet<Long>();
			long[] a1 = longAfromString(case1.substring(case1.indexOf('\n') +1));
			if(_i==TC.cases.length){
				 result +="Case #" + (_i++) +": " + numberOfG(a1);
			}else{
				 result +="Case #" + (_i++) +": " + numberOfG(a1) + "\n";
			}
		}
		io1.createOutput("OUTPUT.txt", result);
		//System.out.println(result);
		 
		/*
		double xx = 1231212.9;
		DecimalFormat threeDec = new DecimalFormat(".0000000");
		String shortString = (threeDec.format(xx));
		*/
		
	}


	private long numberOfG(long[] a) {
		long min = a[0];long max = a[1];
		//System.out.println("<" + min + " , " + max + ">");
		for(long n=min; n<max ; n++){
			long[] rs = largerRecycles(n);
			if(rs!=null){
				for(long r:rs){
					if(r>=min && r<=max){
						long temp = encodePair(n,r, max+1);
						if(!pairs.contains(temp))
							pairs.add(temp);
					}
				}
			}
		}
		/*
		for(long _x:pairs){
			long[] _tem = decodePair(_x, max+1);
			System.out.println("<" + _tem[0] + " , " + _tem[1] + ">");
		}
		*/
		return pairs.size();
	}
	// returns numbers r : r_i > n and r_i can be recycled from n
	private long[] largerRecycles(long n) {
		if(n<10) return null;
		String _sN = ""+n;int len = _sN.length();
		ArrayList<Long> recycles = new ArrayList<Long>();
		long r = leftRotate(n,len);
		while(r!=n){
			if(r>n)
				recycles.add(r);
			r = leftRotate(r,len);
		}
		if(recycles.size()<1) return null;
		long[] rs = new long[recycles.size()];
		for(int i=0; i<recycles.size();i++)
			rs[i] = recycles.get(i);
		
		return rs;
	}
	private long leftRotate(long r, int len) {
		long base = (long)Math.pow(10, len-1);
		return ((r%base)*10 + r/base);
	}
	// x < y < STEP
	private long encodePair(long x, long y, long STEP){
		return (x + y*STEP) ;
	}
	// a[0] < a[1] < STEP
	private long[] decodePair(long x, long STEP){
		long[] a = new long[2];
		a[0] = x%STEP; a[1] = x/STEP;
		return a;
	}
	HashSet<Long> pairs;// = new HashSet<Long>();

	
	private int[] intAfromString(String s) {
		String[] words = s.split(" ");
		int[] a = new int[words.length];
		for(int i=0;i<a.length;i++)
			a[i] = Integer.parseInt(words[i]);
		
		return a;
	}
	private double[] doubleAfromString(String s) {
		String[] words = s.split(" ");
		double[] a = new double[words.length];
		for(int i=0;i<a.length;i++)
			a[i] = Double.parseDouble(words[i]);
		
		return a;
	}
	private long[] longAfromString(String s) {
		String[] words = s.split(" ");
		long[] a = new long[words.length];
		for(int i=0;i<a.length;i++)
			a[i] = Long.parseLong(words[i]);
		
		return a;
	}
	private void swap(int[] a, int i, int j) {
		if(i==j || a.length<2) return;
		int temp = a[i];
		a[i]=a[j];a[j]=temp;
	}
	private int max(int x, int y){
		if(x>y){
			return x;
		}else{
			return y;
		}
	}
}
