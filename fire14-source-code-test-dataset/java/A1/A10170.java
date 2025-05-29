import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CodeJam {
	public static void main(String a[]){
		try {
			FileReader f = new FileReader("B-small-attempt1.in");
			BufferedReader in = new BufferedReader(f);
			FileWriter fwrite = new FileWriter("output");
			BufferedWriter out = new BufferedWriter(fwrite);
			int n = Integer.parseInt(in.readLine().toString());
			int i = 0;
			int j=0;
			int numOfGooglers = 0;
			int numOfSurprise = 0;
			int bestResult = 0;
			String line = null;
			int[] sums = new int[100];
			triplet [] goo = new triplet[100];
			int surpDone=0;
			boolean curSurp = false;
			int count = 0;
			while(i<n){
				count = 0;
				line = in.readLine();
				out.write("Case #"+(i+1)+": ");
				numOfGooglers = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line =line.substring(line.indexOf(" ")+1);
				numOfSurprise = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line =line.substring(line.indexOf(" ")+1);
				bestResult = Integer.parseInt(line.substring(0,line.indexOf(" ")));
//				System.out.print(numOfGooglers+"  "+numOfSurprise+" "+bestResult+"|");
				line =line.substring(line.indexOf(" ")+1);
				j=0;
				surpDone =0;
				curSurp=false;
				while(j<numOfGooglers){
					curSurp = false;
					if(j<numOfGooglers-1){
						sums[j]=Integer.parseInt(line.substring(0,line.indexOf(" ")));
						line = line.substring(line.indexOf(" ")+1);
//						System.out.println(sums[j]);
					}
					else
						sums[j] = Integer.parseInt(line);
					if(sums[j] <=28 && sums[j]>=2 && surpDone < numOfSurprise){
						if(test(setScore(sums[j],false,bestResult), bestResult)==true)
							curSurp = false;
						else if(test(setScore(sums[j], true, bestResult),bestResult)==true){
							surpDone+=1;
							curSurp = true;
						}
						else if(test(setScore(sums[j], true, bestResult),bestResult)==false){
							curSurp = false;
						}
						else	{
							curSurp = true;
						
//						System.out.print("here");
						surpDone++;}
					}
					goo[j] = setScore(sums[j], curSurp,bestResult);
					if(goo[j].one >= bestResult || goo[j].two >= bestResult|| goo[j].three >= bestResult)
						count++;
//					System.out.print(sums[j]+" "+goo[j].one+"  "+goo[j].two+"  "+goo[j].three+"  "+goo[j].surprise+"  ");
					j++;
				}
				
//				System.out.println(count);
				out.write(String.valueOf(count));
				out.newLine();
				i++;
			}
				in.close();
				out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static boolean test(triplet t,int best){
		if(t.one>=best||t.two>=best||t.three>=best){
//			System.out.print("positive");
			return true;
		}
//		System.out.print("negative");
		return false;
		
	}
	public static triplet setScore(int sum, boolean surp, int best){
		triplet score = new triplet();
		int a,b,c;
		
		int div = sum/3;
		int mod = sum%3;
		a=b=c=div;
		if(mod==1){
			if(surp ==false)
				a=a+1;
			else{
				a=a+1 ; 
				b=b+1;
				c=c-1;
				if(a>=best||b>=best||c>=best){
					score.flag=true;
//				System.out.println("here"+a+b+c+best);
				}
				
			}
		}else if(mod==2){
			if(surp ==false ){
				a=a+1;
				b=b+1;
			}
			else{
				a=a+2;
				if(a>=best||b>=best||c>=best){
					score.flag=true;
//				System.out.println("here");
				}
				
			}
		}else {
			if(surp==true){
				a=a+1;
				b=b-1;
				if(a>=best||b>=best||c>=best){
					score.flag=true;
//				System.out.println("here");
				}
			}
		}
		score.one=a;
		score.two=b;
		score.three=c;
		score.surprise=surp;
		return score;
		
	}
}