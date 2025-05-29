import java.io.*;

public class Numbers{
	
	public static void main(String args[]){
		
		try{
			
			FileInputStream fstream = new FileInputStream(args[0]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			PrintWriter out = new PrintWriter(args[0] + "_out");
			
			String strLine = br.readLine();
			int cases = Integer.parseInt(strLine);
				
			for (int i = 0; i < cases; i++){
				//System.out.println("			i " + i);
				
				strLine = br.readLine();
				String[] a_and_b = strLine.split(" ");
				int a = Integer.parseInt(a_and_b[0]);
				int b = Integer.parseInt(a_and_b[1]);
				
				int length = String.valueOf(a).length();
				
				int[] found_as = new int[(int)java.lang.Math.pow(10,length+1)];
				
				int solutions = 0;
				
				for (double j = java.lang.Math.pow(10,length-1); j < java.lang.Math.pow(10,length); j++){
					//System.out.println("	j " + j);
					
					String this_number = String.valueOf(j);
					//System.out.println("this_number = " + this_number);
					char[] this_numbers_ciphers = this_number.toCharArray();
					//for (int k = 0; k < this_numbers_ciphers.length; k++) System.out.println("this_numbers_ciphers = " + this_numbers_ciphers[k]);
					
					for (int k = 0; k < length; k++){
						
						//System.out.println("		k " + k);
						
						char[] this_recycles_ciphers = new char[length];
						for (int l = 0; l < length; l++) {
							//System.out.println("				l " + l);
							//System.out.println("vor mod");
							int new_pos = (l + k) % length;
							//System.out.println("new pos = " + new_pos);
							//System.out.println("length = " + length);
							//System.out.println("this_numbers_ciphers[new_pos] = " + this_numbers_ciphers[new_pos]);
							//System.out.println("this_recycles_ciphers[l] = " + this_recycles_ciphers[l]);
							this_recycles_ciphers[l] = this_numbers_ciphers[new_pos];
							//System.out.println("nach mod" + l);
							}
						
						//System.out.println("-- vor new String");
						int m = Integer.parseInt(new String(this_recycles_ciphers));
						//System.out.println("-- nach new String");
						
						//System.out.println("--- vor if-Block");
						if ( a <= m && m < j && j <= b){
							boolean double_flag = false;
							//System.out.println("---- vor double_flag schleife");
							for (int l = 0; l < 2*solutions; l++) {
								//System.out.println("---- vor if-block in double_flag schleife");
								//System.out.println("found_as[2*l] = " + found_as[2*l]);
								//System.out.println("(int)j = " + (int)j);
								//System.out.println("found_as[2*l+1] = " + found_as[2*l+1]);
								//System.out.println("(int)m) = " + (int)m);
								if (found_as[2*l] == (int)j && found_as[2*l+1] == (int)m) {
									//System.out.println("----- vor anweisung");
									double_flag = true;
									//System.out.println("----- nach anweisung");
								}
								//System.out.println("---- nach if-block in double_flag schleife");
							}
							//System.out.println("---- nach double_flag schleife");
							found_as[2*solutions] = (int)j;
							found_as[2*solutions+1] = (int)m;
							if (double_flag != true) solutions++;
							double_flag = false;
							//System.out.println("case " + i + " solution " + solutions + " a " + a + " b " + b + " j " + j + " m " +  m);
						}
						//System.out.println("--- nach if-Block");
						
					}
					
				}
				
				out.println("Case #" + (i+1) + ": " + solutions);
				
			}
			
			in.close();
			out.close();
			
		}
		
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		
	}
		
}
	
