import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;

public class qualifycodejamB{

	public static int surprisePVal(int score){
		if(score < 4){
			if(score == 0){
				return 0;
			}else if(score == 1){
				return 1;
			}else{
				return 2;
			}
		}

		double dscore = (double) score;

		if((dscore % 3) == 1){
			return (int)Math.ceil(dscore/3);
		}
		else{
			return ((int)Math.ceil(dscore/3) + 1);
		}

	}

	public static int bestVal(int score){
		if(score < 4){
			if(score == 0){
				return 0;
			}else{
				return 1;
			}
		}
		double dscore = (double)score;
		return (int)Math.ceil(dscore/3);
	}

	public static int process_score(int cscore, int ttl_surp, int surp, int pval){
		int returnval = 0;
		int currentp = bestVal(cscore);


		if(currentp >= pval){
			return 1;
		}

		int bestp = surprisePVal(cscore);

		if (bestp >= pval && ttl_surp > surp){
			return 3;
		}

		return returnval;
	}

	public static void main(String[] args){

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		   String x = null;
		   String linein = null;
		   int totalcases = 0;
		   int ttl_scores = 0;
		   int ttl_surprises = 0;
		   int surprise_count = 0;
		   int pval = 0;
		   int pcount = 0;
		   int currentscore = 0;
		   int scorecount = 0;
		   int counter = 1;
		   int process_return = 0;

		   try{
		    x = br.readLine();
		    totalcases = Integer.parseInt(x);

		    while( (linein = br.readLine()) != null){
					surprise_count = 0;
					pcount = 0;
					scorecount = 0;

					StringTokenizer st = new StringTokenizer(linein);
					ttl_scores = Integer.parseInt(st.nextToken());
					ttl_surprises = Integer.parseInt(st.nextToken());
					pval = Integer.parseInt(st.nextToken());

					while(scorecount < ttl_scores){
						currentscore = Integer.parseInt(st.nextToken());
						process_return = process_score(currentscore,ttl_surprises,surprise_count,pval);
						if ((process_return & 1) == 1){
							pcount++;
						}
						if (process_return == 3){
							surprise_count++;
						}

						scorecount++;
					}

					System.out.print("Case #" + (counter) + ": "+ pcount);
					//System.out.println(" debug: return val: "+process_return+"; used surprises: " + surprise_count + "/"+ttl_surprises);
					System.out.println();

					counter++;
				}

		   }
		   catch (IOException e) {
			   e.printStackTrace();
		   }

	}

}