import java.util.Scanner;

/*
4
3 1 5 15 13 11
3 0 8 23 22 21
2 1 1 8 0
6 2 8 29 20 8 18 18 21
 */
public class Problem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int test = 1,
			numberOfTests,
			dancarinos,
			erros,
			notaCorte,
			notaAtual,
			resposta;
		
		numberOfTests = scanner.nextInt();
		for( int i = 0; i < numberOfTests; i++ ){
			resposta = 0;
			
			dancarinos = scanner.nextInt();
			erros = scanner.nextInt();
			notaCorte = scanner.nextInt();
			
			int[] notas = new int[dancarinos];
			
			for( int j = 0; j < dancarinos; j++){
				notas[j] = scanner.nextInt();
			}
			
			int div, resto;
			
			for( int j = 0; j < dancarinos; j++ ){
				notaAtual = notas[j];
				div = notaAtual / 3;
				resto = notaAtual % 3;
			
				switch( resto ){
				case 0:
					if( div >= notaCorte){
						resposta++;
					}else{
						if( erros > 0 && div > 0 && div +1 >= notaCorte){
							resposta++;
							erros--;
						}
					}
					
					break;
				case 1:
			          if (div >= notaCorte || div + 1 >= notaCorte){
			              resposta++;
			          }else{
			        	  if (erros > 0 && div + 1 >= notaCorte){
			        		  resposta++;
			        		  erros--;
			        	  }
			          }
					break;
				case 2:
			          if (div + 1 >= notaCorte || div >= notaCorte){
			        	  resposta++;
			          }else{
			        	  if (erros > 0 && div + 2 >= notaCorte){
			        		  resposta++;
			        		  erros--;
			        	  }
			          }

					break;
				}
			}
			
			System.out.println("Case #"+test+": "+resposta);
			test++;
			
		}
	}
}

