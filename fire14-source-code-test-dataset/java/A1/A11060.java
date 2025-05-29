import java.util.*;

public class DancingGoogler{

    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	scanner.nextLine();
	int count = 1;
	while(scanner.hasNextLine()){
	    String[] tokens = scanner.nextLine().split(" ");
	    int numContestants = Integer.parseInt(tokens[0]);
	    int numSuprises = Integer.parseInt(tokens[1]);
	    int minScore = Integer.parseInt(tokens[2]);
	    int[] scores = new int[numContestants];
	    for(int i = 0; i < scores.length; ++i){
		scores[i] = Integer.parseInt(tokens[i + 3]);
	    }
	    DancingGoogler d = new DancingGoogler(numSuprises, minScore, scores);
	    System.out.println("Case #" + count + ": " + d.getNumGooglersWithMinScore());
	    ++count;
	}
    }

    public DancingGoogler(int numSuprises, int minScore, int[] scores){
	this.numSuprises = numSuprises;
	this.minScore = minScore;
	this.scores = scores;
    }

    public int getNumGooglersWithMinScore(){
	int count = 0;
	for(int score : scores){
	    if(score == 0){
		if(minScore == 0){
		    ++count;
		}
		continue;
	    }
	    if(score == 29){
		++count;
		continue;
	    }
	    if(score % 3 == 0){
		int av = score / 3;
		if(av >= minScore){
		    ++count;
		}else{
		    if(numSuprises > 0 && av >= minScore -1){
			++count;
			--numSuprises;
		    }
		}
		continue;
	    }
	    int av = score / 3;
	    int av1 = (score / 3) + 1;
	    int diffav = score - av * 3;
	    int diffav1 = av1 * 3 - score;
	    if(numSuprises > 0){
		if(diffav == 2){
		    if(av1 >= minScore){
			++count;
			continue;
		    }else{
			if(av >= minScore ||  score - av*2 >= minScore){
			    ++count;
			    --numSuprises;
			    continue;
			}
		    }
		}else{
		    if(av >= minScore || score -av * 2 >= minScore){
			++count;
			continue;
		    }
		    if(av1 >= minScore){
			++count;
			--numSuprises;
			continue;
		    }
		}
	    }else{
		if(diffav == 2){
		    if(av1 >= minScore){
			++count;
			continue;
		    }
		}else{
		    if(av >= minScore || score - av*2 >= minScore){
			++count;
			continue;
		    }
		}
	    }
	}
	return count;
    }

    private int numContestants;
    private int numSuprises;
    private int minScore;
    private int[] scores;
}