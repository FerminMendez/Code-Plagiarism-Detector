import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RecycledNumbers2 {

	public static int analizar(String first, String second ){
		ArrayList<String> dupList=new ArrayList<String>();
		int contador=0;
		int primero=Integer.parseInt(first);
		int segundo=Integer.parseInt(second);
		for(int i=primero;i<=segundo;i++){
			for(int j=i+1;j<=segundo;j++){
				for(int k=1;k<first.length();k++){
					String uno=""+i;
					String dos=""+j;
					String fm=convertir(k, uno);
					if(fm.equals(dos)&&!dupList.contains(uno+"-"+dos))
					{
						if(uno.startsWith("0")||dos.startsWith("0")){						
							System.out.println(uno+"-"+dos);
						}
						contador++;
						dupList.add(uno+"-"+dos);
					}
				}
			}
		}
		return contador;
	}

	public static String convertir(int k, String primero){
		String acumulador="";
		for(int i=0;i<k;i++)	
		{
			acumulador=primero.charAt(primero.length()-1)+acumulador;
			primero=primero.substring(0, primero.length()-1);
		}
		primero=acumulador.concat(primero);

		return primero;
	}

	public static void main(String[] args) {
		try {
			FileOutputStream fos=new FileOutputStream(new File("data/outC.txt"));
			BufferedReader br=new BufferedReader(new FileReader("data/C-small-attempt0.in"));
			PrintWriter pw=new PrintWriter(fos);

			String a=br.readLine();
			System.out.println("Ignore"+a);
			int contador=0;
			while((a=br.readLine())!=null)
			{
				contador++;
				System.out.println("Case #"+contador+": "+a);
				String first=a.split(" ")[0];
				String second=a.split(" ")[1];
				int temp=analizar(first, second);
				System.out.println(temp);
				pw.println("Case #"+contador+": "+temp );
			}
			pw.close();
		} catch (Exception e){}	}
}