import java.util.*;
import java.io.*;
class DancingWithTheGooglers{
	Scanner input;
	PrintWriter output;
	StringBuilder answer = new StringBuilder();

	public static void main(String[] args){
		DancingWithTheGooglers app = new DancingWithTheGooglers();
		app.openInput(args[0]+".in");
		app.setOutput(args[0]+".out");
		app.solve();
		app.saveAndCloseOutput();
	}

	public void openInput(String filename){
		try{
			input = new Scanner(new File(filename));
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void setOutput(String filename){
		try{
			output = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void solve(){
		int nCase = input.nextInt();
		input.nextLine();
		int n,s,p;
		int count = 0;
		for(int i=1;i<=nCase;i++){
			n = input.nextInt();
			s = input.nextInt();
			p = input.nextInt();

			count = 0;
			for(int j=0;j<n;j++){
				int score = input.nextInt();
				switch(score%3){
					case 0:
						if(score/3>=p){count++;}
						else if(s>0 && score != 0 && score/3+1 == p){count++;s--;}
						break;
					case 1:
						if(score/3 + 1 >= p){count++;}
						break;
					case 2:
						if(score/3 + 1 >= p){count++;}
						else if(s>0 && score/3 + 2 == p){count++;s--;}
						break;
				}
			}
			output.println("Case #"+i+": "+count);
		}
	}

	public void saveAndCloseOutput(){
		output.close();
	}
}
