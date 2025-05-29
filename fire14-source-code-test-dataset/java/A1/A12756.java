import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class B {

		 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		
		
		int t = Integer.parseInt(input.readLine());
		for(int i=0;i<t;i++){
			int staticCount=0;
			int count=0;
			int max=0;
			ArrayList<String> hasSup = new ArrayList<String>();
			ArrayList<String> hasNoSup = new ArrayList<String>();
			ArrayList<char[]> combos = new ArrayList<char[]>();
			String[] line = input.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int s = Integer.parseInt(line[1]);
			int p = Integer.parseInt(line[2]);
			
			// Sort into 2 groups
			for(int j=3;j<line.length;j++){
				if((Integer.parseInt(line[j])>28) ||(Integer.parseInt(line[j])<2)){
					hasNoSup.add(line[j]);
				} else {
					hasSup.add(line[j]);
				}
			}
			
			// Add the count those greater than p in the non surprising
			for(String score: hasNoSup){
				if (bestScoreNon(score)>=p){
					staticCount++;
				}
			}
			
			permute("",seed(hasSup.size()),combos);
			
			for(char[] combo:combos){
				for(int k =0;k<s;k++){
					if (bestScoreSup(hasSup.get(combo[k]-48))>=p){
						count++;
					}
				}
				for(int k=s;k<combo.length;k++){
					if (bestScoreNon(hasSup.get(combo[k]-48))>=p){
						count++;
					}
				}
				if(max<(count+staticCount)){
					max = (count+staticCount);
				}
				count =0;
			}
			System.out.printf("Case #%d: %d\n",i+1, max);
		}
	}
	
	public static String seed(int n){
		String seed = "";
		for(Integer i=0; i<n;i++){
			seed = seed.concat(i.toString());
		}
		return seed;
	}
	
	public static void permute(String beginningString, String endingString,ArrayList<char[]> all) {
		    if (endingString.length() <= 1)
		    	all.add((beginningString + endingString).toCharArray());
		    else
		      for (int i = 0; i < endingString.length(); i++) {
		        try {
		          String newString = endingString.substring(0, i) + endingString.substring(i + 1);
		          permute(beginningString + endingString.charAt(i), newString,all);
		        } catch (StringIndexOutOfBoundsException exception) {
		          exception.printStackTrace();
		        }
		      }
	}
	
	public static int bestScoreNon(String number){
		int score = Integer.parseInt(number);
		int bestScore;
		if (score==0){
			bestScore = 0;
		} else if(score>=1 && score<=3){
			bestScore = 1;
		} else if(score>=4 && score<=6){
			bestScore = 2;
		}  else if(score>=7 && score<=9){
			bestScore = 3;
		}  else if(score>=10 && score<=12){
			bestScore =4;
		}  else if(score>=13 && score<=15){
			bestScore = 5;
		}  else if(score>=16 && score<=18){
			bestScore = 6;
		}  else if(score>=19 && score<=21){
			bestScore = 7;
		}  else if(score>=22 && score<=24){
			bestScore = 8;
		}  else if(score>=25 && score<=27){
			bestScore = 9;
		}  else {
			bestScore = 10;
		}
		return bestScore;
	}
	
	public static int bestScoreSup(String number){
		int score = Integer.parseInt(number);
		int bestScore;
		if(score>=2 && score<=4){
			bestScore = 2;
		} else if(score>=5 && score<=7){
			bestScore = 3;
		}  else if(score>=8 && score<=10){
			bestScore = 4;
		}  else if(score>=11 && score<=13){
			bestScore =5;
		}  else if(score>=14 && score<=16){
			bestScore = 6;
		}  else if(score>=17 && score<=19){
			bestScore = 7;
		}  else if(score>=20 && score<=22){
			bestScore = 8;
		}  else if(score>=23 && score<=25){
			bestScore = 9;
		}  else {
			bestScore = 10;
		}
		return bestScore;
	}

}
