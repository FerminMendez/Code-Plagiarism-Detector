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
		testCase TC = io1.readInput("a1.txt", numberOfLines);
		String result="";int _i=1;
		for(String case1:TC.cases){
			int[] a1 = intAfromString(case1.substring(case1.indexOf('\n') +1));
			
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


	private int numberOfG(int[] a) {
		// what if a[2] == 0 ??
		if(a[2]==0) return a[0];
		
		int minScoreSur = a[2] + 2*max(0,a[2]-2);
		int minScore = a[2]+ 2*max(0,a[2]-1);
		int numberWithSur = a[1];
		
		
		int googlers=0;
		for(int i=3; i<a.length ; i++){
			if(a[i] >= minScore){
				googlers++;
			}else if(numberWithSur > 0 && a[i] >= minScoreSur){
				googlers++;
				numberWithSur--;
			}
		}
		
		return googlers;
	}

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
