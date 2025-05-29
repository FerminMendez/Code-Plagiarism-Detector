
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Principal {
	
	public static void main (String Args[]){
		boolean numeros[]= new boolean[2000000];
		Scanner input = new Scanner(System.in);
		File saida = new File("c:/saida.txt");
		BufferedWriter bw;
		
		int A, B, T;
		String entrada;
		String a,b;
		String search;
		int tamanho_string, teste;
		int resposta=0, temp=0;
		String texto="";
		
		
		entrada=input.nextLine();
		T= Integer.parseInt(entrada);

		
		for(int i=1;i<=T;i++){
			
			
			
			a = input.next();
			b = input.next();
			
			A = Integer.parseInt(a);
			B = Integer.parseInt(b);
			for(int j=A; j<=B; j++){
				if(numeros[j]){
					continue;
				}
				
				numeros[j]=true;
				search = ""+j+j;
				tamanho_string= a.length();
				
				for (int k=0;k<tamanho_string-1;k++){
					teste = Integer.parseInt(search.substring(k+1, k+tamanho_string+1));
					if(teste >j && teste <=B && !numeros[teste]){
						numeros[teste]=true;
						temp++;
					}
					
					
				}
				for(;temp>0;temp--)
					resposta+=temp;
				temp=0;
				
			}
			
			
			texto="Case #"+i+": "+resposta+"\n";
			
			try {
				bw=new BufferedWriter(new FileWriter(saida, true));
				bw.write(texto);
				bw.newLine();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			

			
			
			for(int asd=0;asd<2000000;asd++)
				numeros[asd]=false;
			temp=0;
			resposta=0;
			
		}

		
	}

}
