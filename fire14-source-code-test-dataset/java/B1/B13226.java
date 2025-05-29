import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class A {
	public static void main(String[] args){
			
		
		Scanner in;
		try{
			in=new Scanner(new FileReader("A.in"));
			int T=in.nextInt();
			for(int tt=1;tt<=T;++tt){
				int A=in.nextInt();
				int B=in.nextInt();
				int result=0;
				for (int i=A; i<=B;i++){
					int num=i; //we dont want to loose i!
					int[] dig=new int[7]; //the numbers at a maximum have 7 digits
					ArrayList res=new ArrayList();
					int d=0; //number of digits
					for (int j=0; j<7; j++){
						if (num<=0) dig[j]=-1;
						else {
							dig[j]=num%10;
							d++;
						}
						num/=10;
					}
					for (int j=0; j<d; j++){ // we have a maximum of 7 possible numbers
						num=0;
						int pow=0;
						for (int t=0; t<7;t++){ //generates number with stating point j
							if (dig[(t+j)%7]>=0){
								num+=dig[(t+j)%7]*Math.pow(10, pow);
								pow++;
							}
						}
						if (num>=A && num<=B && num!=i)
							for (int t=0; t<7; t++)
								if (res.contains(num)==false){
									result++; res.add(num);
								}
							
					}
				}
				System.out.println("Case #"+tt+": "+result/2);
			}
		}catch(FileNotFoundException e){
			
		}
		
	}
}
