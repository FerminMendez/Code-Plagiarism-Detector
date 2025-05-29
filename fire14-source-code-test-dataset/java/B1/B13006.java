import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;




public class Recycled_Numbers {

	
	public static int recycle(int a,int b){
		if (b == 1){
			return (a % 10)*(a>99?100:10)+a/10;
		}
		else
			return (a % 100)*10+a/100;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D://1.txt");
		Scanner sc;
		try {
			sc = new Scanner(f);
			int n = sc.nextInt();
			//System.out.println(n);
			for (int i = 0;i<n;i++){
				int num = 0;
				int a = sc.nextInt();
				//System.out.println(a);
				int b = sc.nextInt();
				//System.out.println(b);
				for(int j = a;j<b;j++){
					if (j<10)
						continue;
					else{
						if (recycle(j,1)>j && recycle(j,1)<=b){
							//System.out.println(j);
							//System.out.println(recycle(j,1));
							num++;
						}
						if (j>99 && recycle(j,2)>j && recycle(j,2)<=b)
						{
							//System.out.println(j);
							//System.out.println(recycle(j,2));
							num++;
						}
					}
						
				}
				System.out.println("Case #"+(i+1)+": "+num);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
