import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Recycle {
	public static void main(String args[]){
				
		Recycle t=new Recycle();
		Scanner sc;
		int T;
		int A, B;
		int temp, len;
		int div, rem, no, goo;
		
		int count = 0;
		try{
			sc = new Scanner(new FileReader("test.txt"));
			T = sc.nextInt();
			//in = new BufferedReader(new FileReader("test.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter("Ans.txt"));

			while(T>0)
			{
				goo=0;
				A = sc.nextInt();
				B = sc.nextInt();
				temp = A;	len=1;
				while(temp>=10)
				{
					temp = temp/10;
					len++;
				}
				System.out.println(A+ " " +B+ " " +len);
				for(int i=A; i<B; i++)
				{
					for(int j=1; j<len; j++){
						rem = i%(int)Math.pow(10,j);
						div = i/(int)Math.pow(10,j);
						no = rem*(int)Math.pow(10, len-j) + div;
						//pw.println(i+ " "+rem+ " " + div+" " +no);
						if(no>A && no<=B && no>i){ 
							//pw.println(i+","+no+","+j);
							goo++;
						}
					}
				}
				
				System.out.println(goo);
				pw.println("Case #"+ ++count +": "+ goo);
				pw.flush();
				
				T--;
			}
			pw.close();
		}catch(Exception e){}

	}
}
