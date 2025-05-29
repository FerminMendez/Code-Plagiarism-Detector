import java.util.ArrayList;
import java.util.HashSet;


public class ProbC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> in=Utils.readFile("C-small-attempt0.in.in");
		ArrayList<String> out =new ArrayList<String>();
		//int[][] matrix=new int[100000][100000];
		for (int i = 1; i < in.size(); i++) {
			String[] str=in.get(i).split(" ");
			int A= Integer.parseInt(str[0]);
			int B= Integer.parseInt(str[1]);
			int numA=numDigit(A);
			int count=0;
			HashSet<Integer> checkDup=new HashSet<Integer>();
			for(int j=A;j<=B;j++){
				for(int pos=1;pos<numA;pos++){
					int recycle=rotate(j,pos);
					//System.out.println(i+": "+j+ " vs "+recycle);
					if(recycle<=B&&j<recycle){
						if(!checkDup.contains(recycle)){
							count++;//System.out.println("**************"+j+"<=>"+recycle);
							checkDup.add(new Integer(recycle));
						}		
						//System.out.println(i+": "+j +" vs "+recycle+"**********");	
					}
				}
				checkDup.clear();
			}
			System.out.println("Case #"+i+": "+ count);
			
			
			
		}
//		for(int i=1000;i<1200;i++){
//			System.out.println(i+"=>"+rotate(i,4));
//		}

	}

	private static int myExp(int e){
		if(e==1)
			return 1;
		if(e==2)
			return 10;
		if(e==3)
			return 100;
		if(e==4)
			return 1000;
		if(e==5)
			return 10000;
		if(e==6)
			return 100000;
		//if(e==7)
		return 1000000;
		
	}
	private static int rotate(int A,int pos) {
		int num=numDigit(A);
		if(pos==1)
			return (A%10)*myExp(num-pos+1)+A/10;
		if(pos==2)
			return (A%100)*myExp(num-pos+1)+A/100;
		if(pos==3)
			return (A%1000)*myExp(num-pos+1)+A/1000;
		if(pos==4)
			return (A%10000)*myExp(num-pos+1)+A/10000;
		if(pos==5)
			return (A%100000)*myExp(num-pos+1)+A/100000;
		if(pos==6)
			return (A%1000000)*myExp(num-pos+1)+A/1000000;
		//if(pos==7)
		return (A%10000000)*myExp(num-pos+1)+A/10000000;
	}
	private static int numDigit(int A) {
		if(A/1000000>0)
		return 7;
		if(A/100000>0)
			return 6;
		if(A/10000>0)
			return 5;
		if(A/1000>0)
			return 4;
		if(A/100>0)
			return 3;
		if(A/10>0)
			return 2;
		return 1;
	}

}
