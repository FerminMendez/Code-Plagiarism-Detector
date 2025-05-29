import java.io.*;



public class DancingGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = 0;
		int N = 0;
		int S = 0;
		int p = 0;
		int ptr = 0;
		int maxCount = 0;
		int scoreSum = 0;
		int score1 = 0;
		int score2 = 0;
		int score3 = 0;
		String currentCase = null;
		String inputFilename = "B-small-attempt0.in";
		String outputFilename = "B-small-attempt0.out";
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(outputFilename));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		FileInputStream fStream = null;
		try {
			fStream = new FileInputStream(inputFilename);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataInputStream in = new DataInputStream(fStream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		
		try {
			T = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0;i<T;i++) {
			try {
				currentCase = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			maxCount = 0;
			ptr = currentCase.indexOf(' ');
			
			N = Integer.parseInt(currentCase.substring(0,ptr));
			S = Integer.parseInt(currentCase.substring(ptr,currentCase.indexOf(' ',ptr+1)).trim());
			
			ptr = currentCase.indexOf(' ',ptr+1);
			
			p = Integer.parseInt(currentCase.substring(ptr,currentCase.indexOf(' ',ptr+1)).trim());

			
			for(int j=0;j<N;j++) {
				ptr = currentCase.indexOf(' ',ptr+1);
				if (j == N-1) {
					scoreSum = Integer.parseInt(currentCase.substring(ptr).trim());
				}
				else {
					scoreSum = Integer.parseInt(currentCase.substring(ptr,currentCase.indexOf(' ',ptr+1)).trim());
				}

				score1 = scoreSum / 3;
				score2 = (scoreSum - score1) / 2;
				score3 = scoreSum - score1 - score2;
				if (score1 >= p || score2 >= p || score3 >= p) {
					maxCount++;
					continue;
				}
				else {
					if ((S > 0) && (scoreSum > 0)) {
						if (scoreSum < (3*p-4)) {
							//Minimum total points required for to get at least 1 "best result"
							continue;
						}
						
						while ((Math.abs(score1 - score2) < 3) && (Math.abs(score1 - score3) < 3) && (Math.abs(score2 - score3) < 3)) {
							if (score1 >= score2 && score1 >= score3) {
								if (score2 >= score3) {
									if ((score1 + 1) - (score2 - 1) < 3) {
										score1++;
										score2--;
									}
								}
								else {
									if ((score1 + 1) - (score3 - 1) < 3) {
										score1++;
										score3--;
									}
								}
							}
							else if (score2 >= score1 && score2 >= score3) {
								if (score1 >= score3) {
									if ((score2 + 1) - (score1 - 1) < 3) {
										score2++;
										score1--;
									}
								}
								else {
									if ((score2 + 1) - (score3 - 1) < 3) {
										score2++;
										score3--;
									}
								}
							}
							else if (score3 >= score1 && score3 >= score2) {
								if (score1 >= score2) {
									if ((score3 + 1) - (score1 - 1) < 3) {
										score3++;
										score1--;
									}
								}
								else {
									if ((score3 + 1) - (score2 - 1) < 3) {
										score3++;
										score2--;
									}
								}
							}
							
							if (score1 >= p || score2 >= p || score3 >= p) {
								maxCount++;
								S--;
								break;
							}
						}
						
					}
				}
				
			}
			
			try {
				out.write("Case #"+(i+1)+": "+maxCount+'\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
