package package03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {
	
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
		int minNumb=0;
		int maxNumb=0;
		
		//将一行数字的字符串转为整型List;
		List<Integer> iLst=getIntLstFromString(str);
		
		minNumb=iLst.get(0);
		maxNumb=iLst.get(1)+1;
		
		for(int a=minNumb;a<maxNumb+1;a++){
			String tst=String.valueOf(a);
			Set<Integer> is=new HashSet<Integer>();
			for(int i=1;i<tst.length();i++){
				String str1=tst.substring(0, i);
				String str2=tst.substring(i);
				int a1=Integer.valueOf(str2.concat(str1));
				is.add(a1);
			}
			for(Iterator<Integer> it=is.iterator();it.hasNext();){
				int a1=it.next();
				if(a1>a && a1<maxNumb){
					as=as+1;
				}
			}
		}
		
		return as;
	}

	private static List<Integer> getIntLstFromString(String str){
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
			return iLst;
	}
	public static void main(String args[]) throws IOException{
		Scanner scanner=new Scanner(System.in);
		String inputFilePath=scanner.nextLine();
		checkInputFile(inputFilePath);
	}
}
