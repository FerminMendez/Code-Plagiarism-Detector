import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class DancingGogglers {
	static class Data{
		int n,surprise,max;
		int score [][];
		
		int getNumberofNonMax(){
			int max = 0;
			for(int i = 0 ; i < score.length; i++){
				if(score[i][1] ==0 && score[i][0] >=2)
					max++;
			}
			return max;
		}
		int getNumberOfMax(){
			int max = 0;
			for(int i = 0 ; i < score.length; i++){
				if(score[i][1] ==1)
					max++;
			}
			return max;
		}
		int getNumberofMaxWithOnlySurprise(){
			int max = 0;
			for(int i = 0 ; i < score.length; i++){
				if(score[i][2] ==1)
					max++;
			}
			return max;
		}
		int getSolution (){
			int initMax = getNumberOfMax();
			if(getNumberofMaxWithOnlySurprise() > surprise){
				return (initMax - (getNumberofMaxWithOnlySurprise() - surprise ));
			}
			if(getNumberofNonMax() >= surprise){
				return getNumberOfMax();
			}
			return initMax;
		}
	}
	
	public static void main(String[] args) {
		Data[] data = getData();
		for(int i = 0 ; i < data.length; i++){
			int index = i+1;
//			System.out.print("Case #" + index + ": " + data[i].n + " "+ data[i].surprise + " "  + data[i].max + " ");
//			for(int score[] : data[i].score){
//				System.out.print(score[0] + " ");
//			}
			System.out.println("Case #" + index + ": " + data[i].getSolution());
		}
			
		
	}

	private static Data[] getData() {
		try {
			String[] input = getInput("B-small-attempt1.in");
			Data [] data = new Data[input.length];
			
			for(int i = 0 ; i < input.length; i++){
				Data d = new Data();
				StringTokenizer token = new StringTokenizer(input[i], " ");
				d.n = Integer.parseInt((String) token.nextElement());
				d.surprise = Integer.parseInt((String) token.nextElement());
				d.max = Integer.parseInt((String) token.nextElement());
				d.score = new int[d.n][1+1+1];
				for(int j = 0 ; j < d.n; j++){
					d.score[j][0] = Integer.parseInt((String) token.nextElement());
					if(d.score[j][0] < d.max) continue;
					if((d.score[j][0] == 0 && d.max == 0)|| (d.score[j][0] >= (3*d.max -4) && (d.score[j][0]!=0)) ){
						d.score[j][1] = 1;
						if((d.score[j][0] == 3*d.max-4) ||
								(d.score[j][0] == 3*d.max-3)){
							d.score[j][2] =1;
						}
					}
				}
				data[i] = d;
			}
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	static String[] getInput(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		try {
			String message = reader.readLine();
			int numberOfTestCases = Integer.parseInt(message);
			String[] input = new String[numberOfTestCases];
			for (int i = 0; i < numberOfTestCases; i++) {
				message = reader.readLine();
				input[i] = message;
			}
			return input;
		} finally {
			reader.close();
		}
	}
}
