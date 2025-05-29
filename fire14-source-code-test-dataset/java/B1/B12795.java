import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(input.readLine());

		for(int j=0;j<n;j++){
			char[] numbers;
			char[] newNumbers;
			int newNumber=-1;
			int count = 0;

			String AB[] = input.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);


			for(Integer original= B; original>A;original--){
				numbers = original.toString().toCharArray();
				perm:
					do{
						newNumbers = new char[numbers.length];
						newNumbers[0]=numbers[numbers.length-1];

						for(int i=1; i<numbers.length ;i++){
							newNumbers[i]=numbers[i-1];
						}
						numbers = newNumbers.clone();
//						if(numbers[0]=='0'){
//							continue perm;
//						}
						newNumber = charToInt(newNumbers);
						if (newNumber>B || newNumber<A){
							continue perm;
						}
						if(newNumber<=B && newNumber>=A && newNumber<original){
							count++;
							//System.out.print(newNumber+"\n");
						}
					}while(newNumber!=original);
			}
			System.out.print("Case #" +(j+1) + ": " + count +"\n");
		}
	}
	public static int charToInt(char[] number){
		int value=0;
		for(int i=0;i<number.length;i++){
			value+= (number[number.length-1-i]-48)*Math.pow(10, i);
		}
		return value;
	}

}
