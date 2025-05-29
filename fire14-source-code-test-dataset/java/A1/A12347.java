import java.util.*;
import java.io.*;
class Caso{
	int n;
	int s;
	int p;
	int[]t;	
	public void leer(Scanner s){
		n=s.nextInt();
		this.s=s.nextInt();
		p=s.nextInt();
		t=new int[n];
		for(int i=0;i<t.length;i++){
			t[i]=s.nextInt();
		}
	}
	public Caso(){
	}
	public String obtenerRespuesta(){
		int ps=0;
		int mx=0;
		int c=s;
		for(int i=0;i<t.length;i++){
			ps=(int)Math.ceil(t[i]/3.);
			if(ps>=p){
				mx++;
			}else{
				if(t[i]<=28&&t[i]>1&&c>0){
					if(ps+1>=p&&t[i]%3!=1){
						mx++;
						c--;
					}
				}
			}
		}
		return mx+"";
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