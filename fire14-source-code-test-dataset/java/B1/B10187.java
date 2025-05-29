import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class recycle {

	public static int factorial(int num){
		if(num==0){
			return 1;
		}
		int n = 1;
		for(int i = 1; i<=num;i++){
			n*=i;
		}
		return n;
		
	}
	
	static int[] jt=new int[8];
	
	public static void main(String args[]) throws IOException{

		String[] ss = new String[2];
		int num;
		

		FileInputStream fstream = new FileInputStream("p:/C-small-attempt3.in");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String readLine;
		readLine = br.readLine();

		num = Integer.valueOf(readLine);
		//System.out.println(num);
		
		FileWriter fstreamw = new FileWriter("p:/C-small-attempt3.out");
		BufferedWriter out = new BufferedWriter(fstreamw);
		// Read File Line By Line
		int number = 1;
		
		
		
		while ((readLine = br.readLine()) != null) {


			ss = readLine.split(" ");
			////System.out.println(ss[0]);
			////System.out.println(ss[1]);
			int[] A = new int[ss[0].length()];
			int[] B = new int[ss[0].length()];
			int numA = Integer.valueOf(ss[0]);
			int numB = Integer.valueOf(ss[1]);
			int[] count=new int[8];
			int counttemp = 1;
			int sum =0;
			
			
			
			int l=ss[0].length();
			////System.out.println("l=="+l);
			int l2=(int)Math.pow(10, l-1);
			////System.out.println(numA+"   "+numB);
			// //System.out.print(ss[0].length());
			for (int i = 0; i < l; i++) {
				A[i] = Integer.valueOf(ss[0].charAt(i));
				// //System.out.print(ss[0].charAt(i));
			}
			////System.out.println();
			for (int i = 0; i < l; i++) {
				B[i] = Integer.valueOf(ss[1].charAt(i));
			}
			
			for (int j = numA; j <= numB; j++) {
				int jtemp = j;
				jt[0]=j;
				for (int i = 1; i < l; i++) {
					jtemp=(jtemp-(jtemp/(l2))*l2)*10+jtemp/l2;
					////System.out.println(j+"   "+jtemp);
					if((jtemp>=numA)&&(jtemp<=numB)&&(j!=jtemp)){
						
						if(notequal(jtemp)){
							counttemp = counttemp + 1;
							jt[i]=jtemp;
							//System.out.println(j+"   "+jtemp);
						}
					
						////System.out.println(j+"   "+jtemp);
					
					}
					
					////System.out.println(j);
					
				}
				
				for(int i=1;i<8;i++){
					jt[i]=0;
				}
				if(counttemp!=1){
					////System.out.println("counttemp="+Math.ceil(counttemp));
					////System.out.println(counttemp);
					switch(counttemp){
						case 1:
							count[1]=count[1]+factorial(counttemp)/(2*factorial(counttemp-2));
						    break;
						case 2:
							count[2]=count[2]+factorial(counttemp)/(2*factorial(counttemp-2));
							break;
						case 3:
							count[3]=count[3]+factorial(counttemp)/(2*factorial(counttemp-2));
							break;
						case 4:
							count[4]=count[4]+factorial(counttemp)/(2*factorial(counttemp-2));
							break;
						case 5:
							count[5]=count[5]+factorial(counttemp)/(2*factorial(counttemp-2));
							break;
						case 6:
							count[6]=count[6]+factorial(counttemp)/(2*factorial(counttemp-2));
							break;
						case 7:
							count[1]=count[1]+factorial(counttemp)/(2*factorial(counttemp-2));
							break;
					}
					////System.out.println("count="+Math.ceil(count));
				}
				counttemp=1;
			}
			
			sum = count[1]/1+count[2]/2+count[3]/3+count[4]/4+count[5]/5+count[6]/6+count[7]/7;
			//sum = count[1]+count[2]+count[3]+count[4]+count[5]+count[6]+count[7];
			
			out.write("Case #");
			out.write(String.valueOf(number));
			out.write(": ");
			out.write(String.valueOf(sum));
			if(number!=num){
				
			
			out.write("\r\n");
			}
			number++;
			
			if(sum!=0){
				//System.out.println("sum="+sum);
				////System.out.println(factorial(count)/(2*factorial(count-2)));
			}
			for(int i =0;i<8;i++){
				count[i]=0;
			}
			
			
			
			
			
		}
		
		
		out.close();
	}

	private static boolean notequal(int i) {
		for(int i1=0;i1<7;i1++){
			if(i==jt[i1]){
				return false;
			}
		}
		return true;
	}
}
