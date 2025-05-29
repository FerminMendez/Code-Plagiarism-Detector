import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;


public class DancingWiththeGooglers {
	
	private static tripletOfScore[] triples;
	
	private static void iniciarEscenario() {
		triples=new tripletOfScore[31];
		triples[0]=new tripletOfScore(0, 0, 0);
		triples[1]=new tripletOfScore(1, 0, 0);
		triples[2]=new tripletOfScore(1,1,0,2,0,0);
		triples[3]=new tripletOfScore(1,1,1,2,1,0);
		triples[4]=new tripletOfScore(2,1,1,2,2,0);
		triples[5]=new tripletOfScore(2,2,1,3,1,1);
		triples[6]=new tripletOfScore(2,2,2,3,2,1);
		triples[7]=new tripletOfScore(3,2,2,3,3,1);
		triples[8]=new tripletOfScore(3,3,2,4,2,2);
		triples[9]=new tripletOfScore(3,3,3,4,3,2);
		triples[10]=new tripletOfScore(4,3,3,4,4,2);
		triples[11]=new tripletOfScore(4,4,3,5,3,3);
		triples[12]=new tripletOfScore(4,4,4,5,4,3);
		triples[13]=new tripletOfScore(5,4,4,5,5,3);
		triples[14]=new tripletOfScore(5,5,4,6,4,4);
		triples[15]=new tripletOfScore(5,5,5,6,5,4);
		triples[16]=new tripletOfScore(6,5,5,6,6,4);
		triples[17]=new tripletOfScore(6,6,5,7,5,5);
		triples[18]=new tripletOfScore(6,6,6,7,6,5);
		triples[19]=new tripletOfScore(7,6,6,7,7,5);
		triples[20]=new tripletOfScore(7,7,6,8,6,6);
		triples[21]=new tripletOfScore(7,7,7,8,7,6);
		triples[22]=new tripletOfScore(8,7,7,8,8,6);
		triples[23]=new tripletOfScore(8,8,7,9,7,7);
		triples[24]=new tripletOfScore(8,8,8,9,8,7);
		triples[25]=new tripletOfScore(9,8,8,9,9,7);
		triples[26]=new tripletOfScore(9,9,8,10,8,8);
		triples[27]=new tripletOfScore(9,9,9,10,9,8);
		triples[28]=new tripletOfScore(10,9,9,10,10,8);
		triples[29]=new tripletOfScore(10,10,9);
		triples[30]=new tripletOfScore(10,10,10);
		
	}
	public static void main(String[] args) {

		iniciarEscenario();
		try {
			FileOutputStream fos=new FileOutputStream(new File("data/outB.txt"));
			BufferedReader br=new BufferedReader(new FileReader("data/B-small-attempt0.in"));
			PrintWriter pw=new PrintWriter(fos);
			
			String a=br.readLine();
			System.out.println("Ignore"+a);
			int contadorCasos=1;
			
			while((a=br.readLine())!=null)
			{
				String parte[]=a.split(" ");
				int googlers=Integer.parseInt(parte[0]);
				int sps=Integer.parseInt(parte[1]);
				int numeroMayor=Integer.parseInt(parte[2]);
				int contador=0;
				
				for(int i=0;i<googlers;i++){
					int puntajeActual=Integer.parseInt(parte[3+i]);
					tripletOfScore temporal=triples[puntajeActual];
					
					if(temporal.existeAlgunValorMayorPrimero(numeroMayor)){
						contador++;
					}
					else{
						if(sps>0)
						{
							if(temporal.existeAlgunValorMayorSegundo(numeroMayor))
							{
								contador++;
								sps--;
							}
						}
					}
				}
				pw.println("Case #"+contadorCasos+": "+contador);
				contadorCasos++;
			}
			pw.close();
		} catch (Exception e) {e.printStackTrace();}
		}
}

class tripletOfScore{
	private int puntajeUno;
	private int puntajeDos;
	private int puntajeTres;
	private int segundoPuntajeUno;
	private int segundoPuntajeDos;
	private int segundoPuntajeTres;
	private int TIPO;
	
	public tripletOfScore(int a, int b, int c){
		puntajeUno=a;
		puntajeDos=b;
		puntajeTres=c;
		TIPO=1;
	}
	
	public tripletOfScore(int a, int b, int c, int a2, int b2, int c2){
		puntajeUno=a;
		puntajeDos=b;
		puntajeTres=c;
		segundoPuntajeUno=a2;
		segundoPuntajeDos=b2;
		segundoPuntajeTres=c2;
		TIPO=2;
	}

	public int getPuntajeUno() {
		return puntajeUno;
	}

	public int getPuntajeDos() {
		return puntajeDos;
	}

	public int getPuntajeTres() {
		return puntajeTres;
	}

	public int getSegundoPuntajeUno() {
		return segundoPuntajeUno;
	}

	public int getSegundoPuntajeDos() {
		return segundoPuntajeDos;
	}

	public int getSegundoPuntajeTres() {
		return segundoPuntajeTres;
	}
	
	public int getTipo() {
		return TIPO;
	}
	
	public boolean existeAlgunValorMayorPrimero(int num){
		if(puntajeUno>=num||puntajeDos>=num||puntajeTres>=num){
			return true;
		}
		else return false;
	}
	
	public boolean existeAlgunValorMayorSegundo(int num){
		if(TIPO==1){
			return false;
		}
		else{
			if(segundoPuntajeUno>=num||segundoPuntajeDos>=num||segundoPuntajeTres>=num){
				return true;
			}
			else return false;
		}
	}
}
