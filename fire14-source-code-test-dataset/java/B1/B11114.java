import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class recycledNumbers{
	public static void main(String args[]){
		try{
			PrintWriter out = new PrintWriter(new FileWriter("output.txt")); 
			Scanner sc = new Scanner(new File(args[0]));
			Integer min, max, d, n, recy;
			Vector<Integer> v;
			Vector<Integer> recV;

			int t = sc.nextInt();
			
			for(int i=1;i<=t;i++){
				n=0;
				min = sc.nextInt();
				max = sc.nextInt();
				d = min.toString().length();
				v = new Vector<Integer>();
				for(int j=min;j<=max;j++){
					recV = new Vector<Integer>();
					for(int k=1;k<d;k++){
						recy = (int) ((j%Math.pow(10,k))*(Math.pow(10,d-k)) + j/Math.pow(10,k));
						if(recy<=max && recy >=min && recy!=j && !recV.contains(recy)){
							if(!v.contains(recy)){
								n++;
								recV.add(recy);
								v.add(j);
								}
						}
					}
				}
				out.println("Case #"+i+": "+n);
			}
			

			out.close();
		}catch (Exception e){
        }
	}
}