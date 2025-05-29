import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dancing {
	static int surprising;

	/**
	 * @param args
	 */
	 public static final int regexOccur(String text, String regex) {
		    Matcher matcher = Pattern.compile(regex).matcher(text);
		    int occur = 0;
		    while(matcher.find()) {
		        occur ++;
		    }
		    return occur;
	}
	 
    public static int solve(BufferedReader reader) throws IOException {
    	
		int cpt = 0;
		String ligne = reader.readLine();
		int taille = regexOccur(ligne, Pattern.quote(" ")) + 1;
		
		String[] entiers = new String[taille];
		
		entiers = ligne.split(" ");
		
		int N = Integer.parseInt(entiers[0]);
		int S = Integer.parseInt(entiers[1]);
		int p = Integer.parseInt(entiers[2]);
		surprising = 0;
 		
		for(int i = 0; i < N; i++) {
			cpt += best_result(p, Integer.parseInt(entiers[i + 3]));
		}
		
		if(S - surprising > 0) return cpt;
		else return cpt + S - surprising;
    }
    
    public static int best_result(int p, int note) throws IOException {
    	
    	int a;
    	
    	a = note/3;
    	
    	if(a >= p) return 1;
    	else {
    		if(note - a > 0) {
    			if(note%3 == 0 && a + 1 >= p) {
        			surprising++;
        			return 1;
        		}
        		if(note%3 == 1 && a + 1 >= p) return 1;
        		if(note%3 == 2) {
        			if(a + 1 >= p) return 1;
        			if(a + 2 >= p) {
        				surprising++;
        				return 1;
        			}
        		}
    		}
    	}
    	
    	return 0;
    }
    
    
    public static void main(String[] args) {

    	
		try {
			InputStream ips = new FileInputStream("dancing.in"); 
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
			FileWriter fw = new FileWriter ("dancing.out",true);
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
