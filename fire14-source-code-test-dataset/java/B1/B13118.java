package phase1.problemC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RecycledNumbers s = new RecycledNumbers();
		try {
			s.doIt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void doIt() throws Exception {
		Scanner s = new Scanner(new File("C:\\Andre\\GCJInputs\\fase1\\p3\\C-small-attempt0.in"));
		int T = Integer.valueOf(s.nextLine());
        int cont=1;
		
        Writer out = new OutputStreamWriter(new FileOutputStream("C:\\Andre\\GCJInputs\\fase1\\p3\\C-small-attempt0.out"));
        
        while (cont<=T) {
        	out.write("Case #"+cont+": ");
        	String[] values = s.nextLine().split(" ");
        	out.write(String.valueOf(calculate(values[0], values[1])));
        	out.write("\n");
        	cont++;
        }
        
        out.flush();
        out.close();
	}
	
	
	private int calculate(String A, String B) {
		int r = 0;
		
		String c = A;
		
		if (c.length()==1) {
			return r;
		}
		
		int cont = Integer.parseInt(c)-1;
		int fim = Integer.parseInt(B);
		
		while (cont++<fim) {
			String nc = String.valueOf(cont);
			
			if (numerosIguais(nc)) continue;
									
			r = r+gira(String.valueOf(cont), B);
		}
		
		return r;		 
	}
	
	private int gira(String n, String B) {
		int len = n.length()-1;
		int qd = 0;
		int d1 = Integer.parseInt(n.substring(0, 1));
		int resp = 0;
		
		String linha = "";
		Set<String> linhas = new HashSet<String>();
		
		while (qd++<len){
			int pd = Integer.parseInt(n.substring(qd, qd+1));
			String m = n.substring(qd)+n.substring(0,qd);
			if (m.length()!=len+1) continue;
			
			linha = linha+ n + ", " + m;
			if (pd<d1) continue;
						
			if (Integer.parseInt(m) > Integer.parseInt(B)) continue;
			if (Integer.parseInt(n) < Integer.parseInt(m)) {
				linhas.add(linha);
			}
			linha="";
		}
		
		resp=linhas.size();
		return resp;
	}
	
	private boolean numerosIguais(String s) {
		int cont=10;
		cont = cont + s.indexOf('0') + s.indexOf('1') + s.indexOf('2') + s.indexOf('3') + s.indexOf('4') + s.indexOf('5')
			+ s.indexOf('6') + s.indexOf('7') + s.indexOf('8') + s.indexOf('9');
				
		if (cont>2) return false;
		return true;
	}

}













