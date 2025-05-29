import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;




public class Dancing {
	
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
				int nn = sc.nextInt();
				int s = sc.nextInt();
				int p = sc.nextInt();
				int num = 0;
				int snum = 0;
				for (int j = 0;j<nn;j++){
					int val = sc.nextInt();
					if (val/3 >=p)
						num++;
					else if (val/3 == p-1 && val/3 >= 0){
						if (val % 3 ==0){
							if (val/3-1 >= 0)
								snum++;
						}
						else 
							num++;
					}
					else if (val/3 == p-2 && val/3 >= 0){
						if (val % 3 ==2)
							snum++;
					}
				}
				num = num + (snum>s?s:snum);
				System.out.println("Case #"+(i+1)+": "+num);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
