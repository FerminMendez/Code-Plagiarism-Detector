package br.com.google.codejam.one.small;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class RecNumber { 
	
	public static void main(String[] args)  {
		try {
			readFile("C-small-attempt0.in");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void readFile(String name) throws NumberFormatException, IOException{
		File file = new File(name);
        BufferedReader br;
        br = new BufferedReader(new FileReader(file));
        int cases = Integer.parseInt(br.readLine());       
        for (int i = 1; i <= cases; i++) {
        	String line = br.readLine();
        	StringTokenizer tokenizer = new StringTokenizer(line);
        	Integer intA = Integer.parseInt(tokenizer.nextToken());
        	Integer intB = Integer.parseInt(tokenizer.nextToken());
        	int count = 0;
    		for (int n = intA; n <= intB; n++) {
    			for (Integer m : shift(n)) {
    				if(intA <= n && n < m && m <= intB){
    					count++;
    				}
    			}
    			
    		}
			System.out.println("Case #"+ i + ": " + count);
		}
	}
	private static Set<Integer> shift(int value){
		Set<Integer> retorno = new HashSet<Integer>();
		
		// length = 1 have no possibilities
		if(value < 10 ){
			return retorno;
		}
		String strValue = Integer.toString(value);
		
		String nextToAnalyze = strValue;
		for (int i = 1; i <= strValue.length()-1 ; i++) {
			char[] shifted = new char[nextToAnalyze.length()];
			for (int j = 0; j < nextToAnalyze.length(); j++) {
				if(j == 0){
					shifted[nextToAnalyze.length()-1] = nextToAnalyze.charAt(j);
				} else {
					shifted[j-1] = nextToAnalyze.charAt(j);
				}
			}
			nextToAnalyze = new String(shifted);
			// check for leading zeros
			if(nextToAnalyze.charAt(0) != '0'){
				retorno.add(Integer.parseInt(nextToAnalyze));
			}
		}
		return retorno;
	}
}
