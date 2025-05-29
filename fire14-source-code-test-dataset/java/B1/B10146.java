import java.util.Scanner;


public class RecycledNumbers {

	public static int Recycled(int k,int begin,int end){
		int length =String.valueOf(k).length();
		int inc=0;
		int con=(int) Math.pow(10,length);
		int div=1;
		int temp;
		for(int i=1;i<length;i++){
			div*=10;
			con/=10;
			temp=(k%div)*con+(k/div);
			if(temp>k){
			if(temp>=begin&&temp<=end){
				inc++;
			}
			}
		}
		return inc;
	}
	public static int testcase(int begin,int end){
		int inc=0;
		for(int i=begin;i<=end;i++){
			inc+=Recycled(i,begin,end);
		}
		return inc;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++){
			System.out.println("Case #"+(i+1)+": "+testcase(scan.nextInt(),scan.nextInt()));
		}
	}

}
