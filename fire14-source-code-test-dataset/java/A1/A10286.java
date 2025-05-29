package Problem2;


	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileInputStream;
	import java.io.FileWriter;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.util.ArrayList;



		class FileReader{
				
			public static ArrayList<String> Parsefile(String filename){
				String chaine="";
				String fichier =filename; 

				try{
					InputStream ips=new FileInputStream(fichier); 
					InputStreamReader ipsr=new InputStreamReader(ips);
					BufferedReader br=new BufferedReader(ipsr);
					String ligne;
					int j=0;
					ArrayList<String> ArS_lines = new ArrayList<String>();
					
					while ((ligne=br.readLine())!=null){
						System.out.println(ligne);
						if (j>=1)
						ArS_lines.add(ligne);
						j++;
					}		
					br.close(); 
					
					return ArS_lines;
					
				}		
				catch (Exception e){
					return null;
				}
				
			}
			
			public static void writeconfig(String destinationfilename , ArrayList<String> ArS) {
				try {
					
					FileWriter fw = new FileWriter (destinationfilename);
					BufferedWriter bw = new BufferedWriter (fw);
					PrintWriter fichierSortie = new PrintWriter (bw); 
					int i;
					int n = ArS.size();
					
					for (i=0;i<n;i++){	
					fichierSortie.println("Case #"+(i+1)+":" + " "+ ArS.get(i)); 
					}
					
					fichierSortie.close();
					
				}
				
				catch (Exception e){
					System.out.println(e.toString());

				}	
			}
			
			public static void writeconfig(String destinationfilename , int[] ArS) {
				try {
					
					FileWriter fw = new FileWriter (destinationfilename);
					BufferedWriter bw = new BufferedWriter (fw);
					PrintWriter fichierSortie = new PrintWriter (bw); 
					int i;
					int n = ArS.length;
					
					for (i=0;i<n;i++){	
					fichierSortie.println("Case #"+(i+1)+":" + " "+ ArS[i]); 
					}
					
					fichierSortie.close();
					
				}
				
				catch (Exception e){
					System.out.println(e.toString());

				}	
			}
			

		}

