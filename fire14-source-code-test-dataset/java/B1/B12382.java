import java.util.*;
import java.io.*;
class Caso{
	int a;
	int b;
	public void leer(Scanner s){
		a=s.nextInt();
		b=s.nextInt();
	}
	public Caso(){
	}
	public String obtenerRespuesta(){
		long resultado=0;
		for(int i=a;i<=b;i++){
			int j=1;
			int nd=(int)Math.log10(i)+1;
			HashMap<Integer,Integer>h=new HashMap<Integer,Integer>();
			while(j<nd){
				int d=(int)Math.pow(10,j);
				int r=i%d;
				int sg=(i-r)/d;
				int mt=(int)(r*Math.pow(10,nd-j))+sg;
				if(h.get(mt)==null&&i<mt&&mt<=b){
					h.put(mt,1);
					resultado++;
				}
				j++;
			}
		}
		return resultado+"";
	}
}
public class Caso1{
	public void iniciar(){
		Scanner s=null;
		PrintStream ps=null;
		try{
			ps=new PrintStream(new FileOutputStream(new File("output.txt")));
			s=new Scanner(new FileReader("input.txt"));
			StringBuffer entrada=new StringBuffer();
			while(s.hasNextLine()){
				entrada.append(s.nextLine()+"\n");
			}
			s=new Scanner(entrada+"");
		}catch(Exception e){
			e.printStackTrace();
		}
		int numeroCasos=s.nextInt();
		Caso[]casos=new Caso[numeroCasos];
		for(int i=0;i<numeroCasos;i++){
			casos[i]=new Caso();
		}
		for(int k=0;k<numeroCasos;k++){
			casos[k].leer(s);
		}
		for(int i=0;i<casos.length;i++){
			ps.println("Case #"+(i+1)+": "+casos[i].obtenerRespuesta());
		}
	}
	public static void main(String[]args){
		(new Caso1()).iniciar();
	}
}