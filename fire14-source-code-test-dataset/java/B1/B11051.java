import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;


public class RecycledNumbers {
	
	public static void main(String[] args) {
		RecycledNumbers rec = new RecycledNumbers();
		File file  = new File("C:\\Users\\aadi\\Desktop\\RecycledNumbers\\C-small-attempt0.in");
		
		Numbers[] numbers = new Numbers[2000001];
		for(int i =1 ;i<2000001 ;i++){
			int length = (int) (Math.log10(i)+1);
			numbers[i] = new Numbers(i, length);
			int temp = i;
			for(int j =0 ;j<length-1; j++){
				temp = numbers[i].circularPermutes(temp, length);
				if(numbers[i].isUnique(i)){
					numbers[i].arr[(numbers[i].count)]=temp;
					numbers[i].count++;
				}
			}
		}
		try{
			FileWriter fstream = new FileWriter("C:\\Users\\aadi\\Desktop\\RecycledNumbers\\out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			Scanner scanner = new Scanner(file);
			int numOfCases = Integer.parseInt(scanner.nextLine());
			for(int i = 0; i<numOfCases ;i++){
				int pairs = 0;
				String line = scanner.nextLine();
				Scanner scanner2 = new Scanner(line);
				scanner2.useDelimiter(" ");
				String s = scanner2.next();
				int length =s.length();
				int min = Integer.parseInt(s);
				int max = scanner2.nextInt();
				System.out.println("max"+max);
				for(int j = min ; j<=max ; j++){
					for(int k =0 ;k<numbers[j].count ;k++){
						if(numbers[j].arr[k]<=max && numbers[j].arr[k]>j){
							pairs++;
						}
					}
				}
				out.write("Case #"+(i+1)+": ");
				out.write(""+pairs);
				out.write(System.getProperty("line.separator"));
				System.out.println(pairs);
				System.out.println("");
			}
			out.close();
		}catch(FileNotFoundException f){
			f.getStackTrace();
		}catch(Exception e){
			e.getStackTrace();
		}
	}	
}

class Numbers{
	int num;
	int length;
	int count;
	int[] arr = new int[6];
	
	public Numbers(int number, int length){
		this.length =length;
		this.num = number;
	}
	
	public int circularPermutes(int number,int length){
		int divider = (int) Math.pow(10,length-1);
		int temp = (number%divider)*10+number/divider;
		return temp;
	}
	
	public boolean isUnique(int number){
		for(int i =0; i<count ;i++){
			if(arr[i]==number){
				return false;
			}
		}
		return true;
	}
}
