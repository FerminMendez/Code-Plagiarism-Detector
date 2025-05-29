import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class main2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader m = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter ou = new PrintWriter("file.txt");
		int n = Integer.parseInt(m.readLine());
	
		for (int i = 0; i < n; i++) {
			String cas = m.readLine();
			String [] a = cas.split(" ");
			int base = Integer.parseInt(a[0]);
			int count = 0;
			int count1=0;
			if(a[0].length()==1){
				System.out.print("Case #"+(i+1)+": "+count);

				System.out.print("\n");
			}else{
				Boolean con = false;;
				int cass = Integer.parseInt(a[0]);
				do {
//					 con = false;;
//				String newcase = a[0].charAt(0)+"";
//				for(int j=0  ;j<a[0].length()-1;j++ ){
//					newcase +=a[0].charAt(0)+"";;
//				}
		
				do{
					
					count1 = count;
					
					String newcase = cass+"";
					if (cass <Integer.parseInt(a[1])){
						con = true;
						for (int j = 0; j < newcase.length()-1; j++) {
							newcase = (newcase+newcase.charAt(0));
							newcase = newcase.substring(1,newcase.length());
							int cassM = Integer.parseInt(newcase);
							if (base <= cass && cass < cassM && cassM<=Integer.parseInt(a[1]))
								count++;
						}
					}
					cass++;
				}while(count1 <count);
				
//					String tmp = cass+"";
//					int first = Integer.parseInt(tmp.charAt(0)+"");
//					first++;
//					tmp = first+""+tmp.substring(1,tmp.length());
//					a[0]=tmp;
				
				}while(cass <= Integer.parseInt(a[1]));
				System.out.print("Case #"+(i+1)+": "+count);

				System.out.print("\n");
			}
		}
	}

}
