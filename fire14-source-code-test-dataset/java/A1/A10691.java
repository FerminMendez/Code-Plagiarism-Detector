import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class SolutionJamB {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			FileInputStream fisEntrada = new FileInputStream("src/entrada1.in");
			FileWriter fwSalida = new FileWriter("src/salida4.out");
			BufferedWriter bwSalida = new BufferedWriter(fwSalida);
			DataInputStream disEntrada = new DataInputStream(fisEntrada);
			String sEntrada;
			String arrsEntrada[];
			String sSalida;
			int participantes;
			int sorpresas;
			int pMinimo;
			int resultado;
			int resultadoIndividual;
			int cocienteResultado;
			int residuoResultado;
			StringBuilder sbParteSalida;
			BufferedReader brEntrada = new BufferedReader(new InputStreamReader(disEntrada));
			int contador;
			
			try
			{
				contador = Integer.parseInt(brEntrada.readLine());
				for(int i = 1; i<=contador; i++)
				{
				    sEntrada = brEntrada.readLine();
				    arrsEntrada = sEntrada.split(" ");
				    participantes = Integer.parseInt(arrsEntrada[0]);
				    sorpresas = Integer.parseInt(arrsEntrada[1]);
				    pMinimo = Integer.parseInt(arrsEntrada[2]);
				    resultado = 0;
					for(int j = 1; j <= participantes; j++)
					{
						resultadoIndividual = Integer.parseInt(arrsEntrada[2+j]);
						cocienteResultado = (int)Math.floor(resultadoIndividual / 3 );
						residuoResultado = (pMinimo * 3) - resultadoIndividual;
						
						if(cocienteResultado >= pMinimo)
						{
							resultado++;
						}
						else if( residuoResultado <= 2 && resultadoIndividual != 0)
						{
							resultado++;
						}
						else if( sorpresas > 0 )
						{
							if(residuoResultado <= 4 && resultadoIndividual != 0)
							{
								resultado++;
								sorpresas--;
							}
						}
						
					}
					sSalida = "Case #" + i + ": " + resultado + "\n";
					bwSalida.write(sSalida);
				}
				bwSalida.close();
			}
			catch(Exception e)
			{
				e.getMessage();
				bwSalida.close();
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

}
