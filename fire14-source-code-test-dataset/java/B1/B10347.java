import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class ProblemB {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("C-small-attempt0.in"));
		System.setOut(new PrintStream("salida"));

//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea = bf.readLine();
		int casos = Integer.parseInt(linea);
		int cont = 1;
		while(casos>0){
			linea = bf.readLine();
			String[] nums = linea.split(" ");
			int result = 0;
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			
			for (int i = a; i <=b; i++) {
				int actual = i;
				ArrayList<Integer> transpuestos = trasponer(actual);
				result+=generarParejas(actual, b,transpuestos);
			}
			System.out.println("Case #"+cont+": "+result);
			cont++;
			casos--;
		}
	}


	private static int generarParejas(int actual, int b, ArrayList<Integer> lista) {
		int cont = 0;
		for (int i = actual+1; i <=b; i++) {
			if(lista.contains(i))
				cont++;
		}
		return cont;
	}


	private static ArrayList<Integer> trasponer(int actual) {
		String ini = actual+"";
		ArrayList<Integer> resp = new ArrayList<Integer>();
		for (int i = 0; i < ini.length()-1; i++) {
			String s = ini.substring(ini.length()-1-i)+ini.substring(0,ini.length()-1-i);
			resp.add(Integer.parseInt(s));
		}
		return resp;
	}
}