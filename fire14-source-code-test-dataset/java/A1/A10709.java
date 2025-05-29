import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class DancingWithGooglers {

	private static String[] linhas;
	private static String[] linhasRespostas;
	private static String stringDoArquivo = "";
	private static Integer numeroDeTestes = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			FileInputStream fs = new FileInputStream("/home/gustavo/Downloads/B-small-attempt1.in");
			DataInputStream di = new DataInputStream(fs);
			BufferedReader br = new BufferedReader(new InputStreamReader(di));
			
			linhas = new String[101];
			
			int i = 0;
			String linha;
			while((linha = br.readLine()) != null && (i <= 100)){
				if(i== 0 && numeroDeTestes == null){
					numeroDeTestes = Integer.valueOf(linha);
					if(numeroDeTestes > 100 || numeroDeTestes < 1){
						System.out.println("Erro: Número de casos de teste fora dos padrões!");
					}
				}else{
					linhas[i] = linha;
					i++;
				}
			}
			
			
			di.close();
			if(i == 0 || i > 100 || i > numeroDeTestes){
				System.out.println("Número de linhas fora dos padrões.");
				System.exit(0);
			}
			
			linhasRespostas = new String[i];
			
			for(int j = 0; j < i; j++){
				linhasRespostas[j] = "Case #" + (j + 1) + ": " + Converterlinha(linhas[j]);
			}
			
			
			for (int k = 0; k < linhasRespostas.length; k++) {
	            if (k + 1 == linhasRespostas.length) {
	                stringDoArquivo = stringDoArquivo + linhasRespostas[k];
	                break;
	            }
	            stringDoArquivo = stringDoArquivo + linhasRespostas[k] + "\n";
	        }
			
			escreverNoArquivo(stringDoArquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("Numero de casos de teste errado!");
		}
		
	}

	private static String Converterlinha(String string) {
		        
        String[] stringComNumero = string.split(" ");
        Integer numeroVariaveis = stringComNumero.length;
        Integer googlers;
        Integer surpresa = 0;
        Integer pontoMinimo = 0;
        Integer jogadores = 0;
        
        if(numeroVariaveis > 0){
        	googlers = Integer.valueOf(stringComNumero[0]);
        	if(numeroVariaveis > 1){
        		surpresa = Integer.valueOf(stringComNumero[1]);
        	}
        	if(numeroVariaveis > 2){
        		pontoMinimo = Integer.valueOf(stringComNumero[2]);
        	}
        	try{
        		for(int i = 3; i < 3 + googlers; i++){
        			Integer base = Integer.valueOf(Integer.valueOf(stringComNumero[i])/3);
        			switch(Integer.valueOf(stringComNumero[i]) % 3){
        				case 0:
        					if (base >= pontoMinimo){
        						jogadores++;
        					}else{
        						if(surpresa > 0 && base > 0 && base + 1 >= pontoMinimo){
        							surpresa--;
        							jogadores++;
        						}
        					}
        					break;
        				case 1:
        					if(base >= pontoMinimo || base + 1 >= pontoMinimo){
        						jogadores++;
        					}else{
        						if(surpresa > 0 && base > 0 && base + 1 >= pontoMinimo){
        							jogadores++;
        							surpresa--;
        						}
        					}
        					break;
        				case 2:
        					if(base >= pontoMinimo || base + 1 >= pontoMinimo){
        						jogadores++;
        					}else{
        						if(surpresa > 0 && base > 0 && base + 2 >= pontoMinimo){
        							jogadores++;
        							surpresa--;
        						}
        					}
        					break;
        			}
        		}
        	} catch(ArrayIndexOutOfBoundsException e){
        		System.out.println("Erro! Número de jogadores errado.");
        		System.exit(0);
        	}
        }else{
        	System.out.println("Erro: Número argumentos inválido.");
        }
        
        return String.valueOf(jogadores);
	}
	
	public static char criarMapa(char x) {
        switch (x) {
            case 'a':
                return 'y';
            case 'b':
                return 'h';
            case 'c':
                return 'e';
            case 'd':
                return 's';
            case 'e':
                return 'o';
            case 'f':
                return 'c';
            case 'g':
                return 'v';
            case 'h':
                return 'x';
            case 'i':
                return 'd';
            case 'j':
                return 'u';
            case 'k':
                return 'i';
            case 'l':
                return 'g';
            case 'm':
                return 'l';
            case 'n':
                return 'b';
            case 'o':
                return 'k';
            case 'p':
                return 'r';
            case 'q':
                return 'z';
            case 'r':
                return 't';
            case 's':
                return 'n';
            case 't':
                return 'w';
            case 'u':
                return 'j';
            case 'v':
                return 'p';
            case 'w':
                return 'f';
            case 'x':
                return 'm';
            case 'y':
                return 'a';
            case 'z':
                return 'q';
        }
        return x;
    }
	
	public static void escreverNoArquivo(String texto) {
        try {
            String file_name = "A-small.out";
            FileWriter fstream = new FileWriter(file_name);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(texto);
            out.close();
            System.out.println("Saída criada!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
