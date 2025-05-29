import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		final long MAX = 2000000;
		try {
			Scanner in = new Scanner(new FileReader("input.in"));
			PrintWriter out = new PrintWriter("output.out");
			int N=in.nextInt();
			int[][] count=new int[10][(int)MAX];
			List<String> input = new ArrayList<String>();
			long A, B;
			String tmp, compA, compB, subA1, subA2, subA, prevK="", prevL="";
			char check;
			int index=0, same=0, strlength;
			for(int i=0;i<N;i++){
				A=in.nextLong();
				B=in.nextLong();
				count=new int[10][(int) MAX];
				for(long j=A; j<=B; j++){
					tmp=String.valueOf(j);
					input.add(tmp);
					for(long k=0;k<tmp.length();k++){
						check=tmp.charAt((int)k);
						switch (check) {
						case '1': count[1][index]++; break;
						case '2': count[2][index]++; break;
						case '3': count[3][index]++; break;
						case '4': count[4][index]++; break;
						case '5': count[5][index]++; break;
						case '6': count[6][index]++; break;
						case '7': count[7][index]++; break;
						case '8': count[8][index]++; break;
						case '9': count[9][index]++; break;
						case '0': count[0][index]++; break;
						}
					}
					index++;
				}
				for(int k=0;k<(B-A+1);k++){
					for(int l=0;l<k;l++){
						if(count[0][l]==count[0][k])
						if(count[1][l]==count[1][k])
						if(count[2][l]==count[2][k])
						if(count[3][l]==count[3][k])
						if(count[4][l]==count[4][k])
						if(count[5][l]==count[5][k])
						if(count[6][l]==count[6][k])
						if(count[7][l]==count[7][k])
						if(count[8][l]==count[8][k])
						if(count[9][l]==count[9][k]){
							compA=input.get(l);
							compB=input.get(k);
							strlength=compA.length();
							if(strlength<=1)
								continue;
//							System.out.println("K:"+count[0][k]+count[1][k]+count[2][k]+count[3][k]+count[4][k]+count[5][k]+count[6][k]+count[7][k]+count[8][k]+count[9][k]+"L:"+count[0][l]+count[1][l]+count[2][l]+count[3][l]+count[4][l]+count[5][l]+count[6][l]+count[7][l]+count[8][l]+count[9][l]);
//							System.out.println(compA + " , " + compB);
							for(int m=1;m<strlength;m++){
								subA1=compA.substring(0, m);
								subA2=compA.substring(m);
								subA=subA2+subA1;
								if(subA.charAt(0)=='0'||compB.charAt(0)=='0');
								else if(subA.equals(compB)){
									if(prevK!=""&&prevL!=""&&prevK==input.get(k)&&prevL==input.get(l)){
										break;
									}
//									System.out.println("["+k+"]"+input.get(k) + " , " +"["+l+"]"+ input.get(l)+ " , " + prevK + " , " + prevL);
//									out.println("["+k+"]"+input.get(k) + " \t " +"["+l+"]"+ input.get(l));
									out.flush();
									same++;
									prevK=input.get(k);
									prevL=input.get(l);
								}
							}
							subA1="";
							subA2="";
						}
					}
				}
				System.out.println("Case #"+(i+1)+": "+same);
				out.println("Case #"+(i+1)+": "+same);
				index=0;input.clear();same=0;
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
