import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class dancing {

	static int max(int a){
		if (a % 3 == 0)
		   return a/3;
		return a/3 + 1;
	}
	static int maxs(int a){
		if (a > 1 && a % 3 != 1)
		   return max(a)+1;
		else return max(a);
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(args[0]);
        //DataInputStream in = new DataInputStream(file);
        Scanner ins = new Scanner(file);
        BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
        int n = ins.nextInt();     
        for (int i = 0; i < n; i++){
        	int answ = 0;
        	int t,s,p;
        	t = ins.nextInt(); s = ins.nextInt(); p = ins.nextInt();
        	for (int j = 0; j < t; j++){
        		int tmp = ins.nextInt();
        		if(max(tmp) >= p){
        			answ++; 
        		}else if(maxs(tmp) >= p && s > 0){
        			s--; answ++;
        		}
            }
        	out.write("Case #"+ (i+1) +": "+answ);
        	out.newLine();
        }
        ins.close();
        out.close();
        file.close();
        
	}

}
