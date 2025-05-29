package package02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DancingWithTheGooglers {
	
	private static void checkInputFile(String filePath) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(new File(filePath)));
		PrintWriter output=new PrintWriter(filePath.concat(".out"));
		
		String str=new String();
		int row=0;
		
		while((str=br.readLine())!=null){
			if(row!=0){
				int as=checkOneline(str);
				output.println("Case #"+row+": "+as);
			}
			row=row+1;
		}
		output.close();
		br.close();
	}
	
	private static int checkOneline(String str) {
		int as=0;
		int s=0;
		int p=0;
		int tst1=0;
		int tst2=0;
		
		//将一行数字的字符串转为整型List;
		List<Integer> iLst=new ArrayList<Integer>();
		int j=0;
		for(int i=0;i<str.length();i++){
			if(str.substring(i, i+1).equals(" ")){
				iLst.add(Integer.valueOf(str.substring(j, i)));
				j=i+1;
			}
		}
		iLst.add(Integer.valueOf(str.substring(j, str.length())));
		
		s=iLst.get(1);
		p=3*iLst.get(2);
		for(int i=3;i<iLst.size();i++){
			if(iLst.get(i)>p-3){
				tst1=tst1+1;
			}
			if((iLst.get(i)<p-2)&&(iLst.get(i)>p-5)&&(iLst.get(i)!=0)){
				tst2=tst2+1;
			}
		}
		//如果tst2比意外分多的话,就等于意外数
		if(tst2>s){
			tst2=s;
		}
		
		as=tst1+tst2;
		return as;
	}

	public static void main(String args[]) throws IOException{
		Scanner scanner=new Scanner(System.in);
		String inputFilePath=scanner.nextLine();
		checkInputFile(inputFilePath);
	}
}
