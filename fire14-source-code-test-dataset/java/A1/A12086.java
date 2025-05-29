import java.io.File;
import java.util.Scanner;


public class DancingGooglers {

	public static void calculate(File file){
		
		String output="";
		int cases = 0;
		String singleLine = "";
		try{
			Scanner scanner = new Scanner(file);
			cases = Integer.parseInt(scanner.nextLine());
			int []result = new int[cases];	
			int counter=0;
			for(int i=0; i<cases;i++){
				singleLine=scanner.nextLine();
				String [] words = singleLine.split(" ");
				int [] numbers = new int [words.length];
				int player=0;
				int surprise=0;
				int best=0;
				for(int j=0;j<words.length;j++){
					numbers[j]=Integer.parseInt(words[j]);
				}
				player=numbers[0];
				surprise=numbers[1];
				best=numbers[2];
				int[]scores= new int[player];
				for(int k=0;k<player;k++){
					scores[k]=numbers[k+3];
				}
				for(int l=0;l<scores.length;l++){
					if(scores[l]>=3*best-2){
						counter++;
					}
					if((3*best-4>=0)&&(surprise!=0)&&(scores[l]>=3*best-4)&&(scores[l]<3*best-2)){
						counter++;
						surprise--;
					}
					
				}
				result[i]=counter;
				
				output+="Case #"+(i+1)+": ";
				output+=result[i]+" ";
				output+="\n";
				counter=0;
			}
		}catch(Exception e){
			System.out.println("Please debug this program to find the exception.");
		}
		
		System.out.println(output);	
	}
	public static void main(String[] args) {
		File file = new File("./src/B-small-attempt0.in");
		calculate(file);
	}

}
