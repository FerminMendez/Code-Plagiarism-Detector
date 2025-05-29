import java.io.*;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= T; i++) {
			String[] input = reader.readLine().split(" ");
            int result = 0;
			int A=Integer.parseInt(input[0]);
			int B=Integer.parseInt(input[1]);
			if(A<10){
				result=0;
			} else if(A<100){
				for(int j=A;j<=B;j++){
					String temp1 = j+"";
					int temp = ( (Integer.parseInt(temp1.charAt(0)+"") + Integer.parseInt(temp1.charAt(1)+"")) * 11 ) - j;
					if(temp > j && temp <=B ){
						++result;
					}
				}
				
			} else if(A<1000){ 
				for(int j=A;j<=B;j++){
					String temp = j+"";
					String temp1 = Character.toString(temp.charAt(2))+Character.toString(temp.charAt(0))+Character.toString(temp.charAt(1));
					String temp2 = Character.toString(temp.charAt(1))+Character.toString(temp.charAt(2))+Character.toString(temp.charAt(0));
					int temp3 = Integer.parseInt(temp1);
					int temp4 = Integer.parseInt(temp2);
					if(j<temp3 && temp3<=B){
						++result;
					}
					if(j<temp4 && temp4<=B){
						++result;
					}
				}
			}
			if (i < T) {
            System.out.println("Case #" + i + ": " + result);
			} else {
            System.out.print("Case #" + i + ": " + result);
			}
		}
		
	}
}