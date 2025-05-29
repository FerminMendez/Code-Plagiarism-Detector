package cycles;

import java.io.File;

import io.Reader;

public class CycloMatic {
	public static void main(String[] args){
		new CycloMatic();
	}
	
	public CycloMatic(){
		String[] lines = Reader.getInput(new File("C-small-attempt0.in"));
		
		
		for(int i = 0; i < lines.length; i++){
			String line = lines[i];
			String[] lineParts = line.split(" ");
			int bottom = Integer.parseInt(lineParts[0]);
			int top = Integer.parseInt(lineParts[1]);
			int sum = 0;
			for(int j = bottom; j<top; j++){
				int q = numCycles(j,top);
				if (q!=0){
					sum+=q;
				}
			}
			System.out.println("Case #"+(i+1)+": "+sum);
		}
			
		
	}
	
	public int numCycles(int original, int max){
		int counter = 0;
		String newIntS = cycle(original);
		int newInt = Integer.parseInt(newIntS);
		for (int i = 0; i < (original+"").length();i++){
			if(newInt>original && newInt<=max){
				counter++;
			}
			newIntS = cycle(newIntS);
			newInt = Integer.parseInt(newIntS);
		}
		return counter;
	}
	
	
	public String cycle(int j){
		return cycle(j+"");
	}
	
	public String cycle(String j){
		String s = j+"";
		char ss=s.charAt(s.length()-1);
		s = s.substring(0,s.length()-1);
		return ss+s;
	}
}
