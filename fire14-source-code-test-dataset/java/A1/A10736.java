package test;
import java.io.*;

public class Test {
	
	static public void magic(String tmp, int Result [],int index ){
		int N=0,S=0,P=0,size;
		char Carr []= new char[300];
		size=tmp.length();
		tmp.getChars(0, size, Carr, 0);
		
		int i=0,j=0,spc=0;
		String bom;
		while (spc<3){
			
			if(Carr[j]!=' '){
				j++;
			}else{
				bom=tmp.substring(i, j);
				if(spc==0)
					N=Integer.parseInt(bom);
				if(spc==1)
					S=Integer.parseInt(bom);
				if(spc==2)
					P=Integer.parseInt(bom);
				spc++;
				j++;
				i=j;
			}
		}
		
		int counter=N;
		int bomnum,nosur,sur,ans=0;
		nosur=((P-1)*2)+P;
		sur=((P-2)*2)+P;
		if(sur<0)
			sur=1;
		while (counter>0){
			if(Carr[j]!=' '&&j<size){
				j++;
			}else{
				bom=tmp.substring(i, j);
				bomnum=Integer.parseInt(bom);
				if(bomnum>=nosur){
					ans++;
				}else if(bomnum>=sur && S>0){
					ans++;
					S--;
				}
				j++;
				i=j;
				counter--;
			}
		}
		
		Result[index]=ans;
		
	}
	
	public static void main(String[] args) {
		
		////////
		int index=0,T,casenum=1,j;
		String tmp;
		
		int Result[]=new int [101];
		
		////////
		
		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			tmp = reader.readLine();
			T=Integer.parseInt(tmp);
			
			j=T;
			while(j!=0){
				tmp = reader.readLine();
				magic (tmp,Result,index);
				
				index++;
				j--;
			}
			
			j=T;
			while(j!=0){
				System.out.println("Case #"+casenum+": "+Result[casenum-1]);
				casenum++;
				j--;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}