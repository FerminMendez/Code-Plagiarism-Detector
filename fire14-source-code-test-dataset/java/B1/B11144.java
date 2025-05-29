import java.io.BufferedReader;
import java.io.FileReader;


public class RecycledNumbers {

	public static void main(String[] args) {
		RecycledNumbers temp = new RecycledNumbers();
		temp.findPairs();
	}
	
	void findPairs(){
		String myFileName = "D:\\testcase.txt";
		try {
			BufferedReader myReader = new BufferedReader(new FileReader(myFileName));
			int myTestCases = 0;
			myTestCases = Integer.parseInt(myReader.readLine());
			
			for(int i=0; i<myTestCases; i++){
				String[] temp = myReader.readLine().split(" ");
				int A = Integer.parseInt(temp[0]);
				int B = Integer.parseInt(temp[1]);
				int j = A;
				int count = 0;
				int size = (j+"").length();
				
				while(j <= B){
					
					int[] myNumbers = new int[size];
					int myNumIndex = 0;
					String newNumber = "";
					
					for(int k=0; k < size-1; k++){
						
						if(size < 2)
							break;
						String number = new String(""+j);
						
						if(k == 0){
							if(number.charAt(size - 1) == '0'){
								newNumber = ""+number.charAt(size - 1)+number.substring(0, size - 1);
								continue;
							}
							newNumber = ""+number.charAt(size - 1)+number.substring(0, size - 1);
						}else{
							if(newNumber.charAt(size - 1) == '0'){
								newNumber = ""+newNumber.charAt(size - 1)+newNumber.substring(0, size - 1);
								continue;
							}
							newNumber = ""+newNumber.charAt(size - 1)+newNumber.substring(0, size - 1);
						}
						
						int check = Integer.parseInt(newNumber);
						if(check <= B && check > j && check >= A){
							boolean found = false;
							for(int z=0; z < size; z++){
								if(myNumbers[z] == check)
									found = true;
							}
							if(!found){
								count++;
								myNumbers[myNumIndex]=check;
								myNumIndex = myNumIndex+1;
								//System.out.println("("+j+", "+newNumber+")");
							}
						}
					}
					j++;
				}
				System.out.println("Case #"+(i+1)+": "+count);
			}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
