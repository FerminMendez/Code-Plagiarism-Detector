import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
	private static Map<Character,Character> mapa;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream("B-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Erich\\Desktop\\B-small-attempt0.out"));
		int qtd = sc.nextInt();
		for(int j=0;j<qtd;j++){
			int googlers=sc.nextInt();
			int surprising = sc.nextInt();
			int limite = sc.nextInt();
			int total=0;
			for(int i=0;i<googlers;i++){
				int tripla = sc.nextInt();
				int divisao = tripla/3;
				if(divisao>=limite){
					total++;
				}else{
					switch(tripla%3){
						
						case 1:
							if(divisao+1>=limite){
								total++;
							}
							break;
						case 2:
							if(divisao+1>=limite){
								total++;
							}else{
								if(surprising>0 && divisao+2>=limite){
									surprising--;total++;
								}
							}
							break;
						case 0:
							if(divisao+1>=limite && surprising>0 && tripla>0){
								surprising--;total++;
							}
							break;
					}
				}
			}
			String saida = "Case #"+(j+1)+": "+total+"\n";
			bw.write(saida);
		}
		bw.flush();
		bw.close();
	}

}
