
public class Case {
	
	//Atrib
	public int ind;
	public double a;
	public double b;

	public String resolver() {
		StringBuilder s_out = new StringBuilder("Case #" + ind + ": ");
		
		int cont = 0;
		
		for(int n = (int) a;n<b+1;n++)
			for(int m = n+1;m<=b;m++){
				
				String nn = String.valueOf(n);
				String mm = String.valueOf(m);
//				nn = nn.replace("0", "");
//				mm = mm.replace("0", "");
				if(nn.length() == mm.length() 
						&& Double.parseDouble(nn) < Double.parseDouble(mm)){
					
//					System.out.println("---" + nn + " " + mm);
					
					for(int i=1;i<nn.length();i++){
						
						String aux = nn.substring(i, nn.length()) + nn.substring(0, i);
						if(aux.equals(mm)){
//							System.out.println("---" + nn + " " + mm);
//							System.out.println( aux);
							cont++;
							i = nn.length();
						}
					}
					
				}
			}
		
//		System.out.println(cont);
		s_out.append(cont);
		
		s_out.append("\n");
		return s_out.toString();
	}

}//endClass
