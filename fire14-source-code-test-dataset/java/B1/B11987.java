import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RecycledPair{
	public static ArrayList<String> pairsList;
	public static void main(String[] args) throws Exception{
		System.setIn(new BufferedInputStream(new FileInputStream(".\\input\\C-small-attempt0.in")));
		System.setOut(new PrintStream(new File(".\\output\\C-small-attempt0.out")));
		Scanner in = new Scanner(System.in);
		pairsList=new ArrayList<String>();
		int caseNum=in.nextInt();
		for(int i=0;i<caseNum;i++){
			int a=in.nextInt();
			int b=in.nextInt();
			pairsList.removeAll(pairsList);
			if(b<=9){
				System.out.println("Case #"+(i+1)+": " +0);
			}else{
				int totalPair=getPairs(a,b);
				System.out.println("Case #"+(i+1)+": " +totalPair);
			}
//			if(i==1){
//				
//				System.out.println(a+"--"+b+" : "+pairsList.toString());
//			}
		}
	}
	private static int getPairs(int a, int b) {
		int totalPair=0;
		for(int k=a;k<=b;k++){
			//System.out.println("当前的值为："+k);
			int count=0;
				totalPair+=getPairOf(k, a, b,count);		
		}
		return totalPair;
	}
	public static int getPairOf(int target,int begin,int end,int count){
		//int pairs=0;
		int[] targetArray=parseIntToIntArray(target);
		int c=0;
		for(int i=1;i<targetArray.length;i++){
			int movedTargetArray[]=moveFront(targetArray, i);
			int movedTarget=calculateIntArray(movedTargetArray);
			//System.out.println("move target: "+movedTarget);
			if(compares(movedTarget, begin)!=-1 && compares(movedTarget, end)!=1
					&& target!=movedTarget){
				//System.out.println(++c +": "+target+"--"+movedTarget);
				String str1=target +" "+movedTarget;
				String str2=movedTarget +" "+target;
				if(!pairsList.contains(str1) && !pairsList.contains(str2)){
					pairsList.add(str1);
					pairsList.add(str2);	
					count++;
					//System.out.println( "-->pairs -->"+count);
				}
				
				//getPairOf(movedTarget, begin, end,count);
				
			}
		}
		return count;
	}
	
	public static int[] parseIntToIntArray(int param){
		int i=1;
		int target=param;
		while(target/10>=1){
			i++;
			target=target/10;
		}
		int[] result=new int[i];
		for(i=0;i<result.length;i++){
			int temp=(int)Math.pow(10, result.length-i-1);
			result[i]=param/temp;
			param=param-result[i]*temp;
		}
		return result;
	}
	public static  int calculateIntArray(int [] array){
		int sum=0;
		int i=0;
		for( i=0;i<array.length;i++){
			sum+=array[i]*(int)Math.pow(10, array.length-i-1);
		}
		//sum+=array[i];
		return sum;
		
	}
	private static int[] moveFront(int[] array,int len){
		int[] result=new int[array.length];
		for(int i=0;i<len;i++){
			result[i]=array[array.length-len+i];
		}
		for(int i=len;i<array.length;i++){
			result[i]=array[i-len];
		}
		return result;
	}
	public static int isSmallAt(int[] newArray,int[] begin,int len){
		for(int i=0;i<len;i++){
			if(newArray[i]<begin[i])return i;
		}
		return len;
	}
	public static int compares(int a,int b){
		if(a>b)return 1;
		if(a<b)return -1;
		return 0;
	}
}