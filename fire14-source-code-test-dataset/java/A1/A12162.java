package clasificacion.dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dancing 
{

	public static void main(String[] args) 
	{					
		FileReader 		fr = null;
		BufferedReader	br = null;
		FileWriter 		fw = null;
		BufferedWriter	bw = null;
		
		try 
		{
			//fr = new FileReader("C:/JAVA/Workspaces/CodeJam/googleCodeJam/src/clasificacion/dancing/prueba.in");
			fr = new FileReader("C:/JAVA/Workspaces/CodeJam/googleCodeJam/src/clasificacion/dancing/prueba_corta.in");
			//fr = new FileReader("C:/JAVA/Workspaces/CodeJam/googleCodeJam/src/clasificacion/dancing/prueba_larga.in");			
			br = new BufferedReader(fr);
			fw = new FileWriter("C:/CODEJAM/clasificacion/dancing.out");
			bw = new BufferedWriter(fw);
			
			int cantidad = Integer.parseInt(br.readLine());			
			for(int i = 0; i< cantidad ; i ++)
			{
				String linea = br.readLine();							
				String[] datos = linea.split(" ");
				int surprise 	= Integer.parseInt(datos[1]);
				int score		= Integer.parseInt(datos[2]);
				System.out.println(" // surprise: " + surprise + " // score " + score);
				int resultado = 0;
				for(int j = 3; j < datos.length; j ++)
				{
					System.out.println("puntuacion = " + datos [j]);
					int puntuacion = Integer.parseInt(datos[j]);					
					boolean salir = false;
					
					for(int a = 0; a <= 10 && !salir; a++)
					{ 
						for(int b = 0; b <= 10 && !salir; b++)
						{
							for(int c = 0; c <=10 && !salir; c++)
							{
								if( (a + b + c) == puntuacion)
								{
									if( (Math.abs(a -b) <= 1) && (Math.abs(a - c) <= 1) && (Math.abs(b - c) <= 1) )
									{
										if(( a >= score || b >= score || c >= score))
										{
											salir = true;
											resultado ++;
											System.out.println("a: " + a + " / b: " + b + " /c: " + c);
										}
									}																																													
								}
							}
						}
					}
					
					
					for(int a = 0; a <= 10 && !salir; a++)
					{ 
						for(int b = 0; b <= 10 && !salir; b++)
						{
							for(int c = 0; c <=10 && !salir; c++)
							{
								if( (a + b + c) == puntuacion)
								{
									if( (Math.abs(a -b) <= 1) && (Math.abs(a - c) <= 1) && (Math.abs(b - c) <= 1) )
									{
										if(( a >= score || b >= score || c >= score))
										{
											salir = true;
											resultado ++;
											System.out.println("a: " + a + " / b: " + b + " /c: " + c);
										}
									}
									if(( a >= score || b >= score || c >= score) && surprise > 0 &&  
											(Math.abs(a -b) <= 2) && (Math.abs(a - c) <= 2) && (Math.abs(b - c) <= 2) )
									{										
										salir = true;
										resultado ++;
										surprise --;
										System.out.println("a: " + a + " / b: " + b + " /c: " + c + "(*)");										
									}																																					
								}
							}
						}
					}										
				}	
				System.out.println("Case #" + (i +1) + ": " + resultado);
				bw.write("Case #" + (i + 1) + ": " + resultado);
				bw.newLine();
			}
					
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				br.close();
				bw.flush();
				bw.close();
				fr.close();
				fw.close();
			} 
			catch (IOException e) 
			{			
				e.printStackTrace();
			}			
		}
		
	}

}
