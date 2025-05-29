import java.io.*;

public class recycled {

	/**
	 * @param args
	 */
    public static int solve(BufferedReader reader) throws IOException {
    	
		int cpt = 0;
		
		String[] entiers = new String[2];
		
		entiers = reader.readLine().split(" ");
 		
		if(Integer.parseInt(entiers[0]) < 10) return 0;
		else {
			for(int i = Integer.parseInt(entiers[0]); i <= Integer.parseInt(entiers[1]); i++)
				cpt += NombreRecycle(entiers[0], entiers[1], Integer.toString(i));
		}
		
		return cpt;
    }
    
    public static int NombreRecycle(String a, String b, String n) throws IOException {
    	
    	int cpt = 0;
    	
    	for(int i = 1; i < n.length() ; i++)
    		if( Integer.parseInt(n) < Integer.parseInt(n.substring(i) + n.substring(0, i)) && Integer.parseInt(n.substring(i) + n.substring(0, i)) <= Integer.parseInt(b)) cpt++;
    	
    	return cpt;
    }
    
    
    public static void main(String[] args) {

    	
		try {
			InputStream ips = new FileInputStream("recycled.in"); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			
			int cases = Integer.valueOf(br.readLine());
			
			for (int i = 1; i <= cases; i++) {
				imprimer(i, solve(br));
			}
		} catch (IOException x) {
			System.err.println(x);
		} catch (NumberFormatException x) {
			System.err.println(x);
		}
    }

    static void imprimer(int numero, int resultat) {
		
		try {
			FileWriter fw = new FileWriter ("recycled.out",true);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				fichierSortie.println ("Case #" + numero + ": " + resultat); 
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		
	}
}
