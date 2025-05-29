class CodeJam2012 {
    public static void main(String[] args) {
    	String[] input = "100 3 1 5 15 13 11 3 0 8 23 22 21 2 0 4 9 8 2 0 4 16 4 2 0 8 20 5 1 0 6 7 1 0 4 17 3 1 4 25 9 8 3 1 5 12 12 11 3 0 6 6 12 8 2 0 10 26 26 3 0 8 21 21 1 1 0 3 6 3 0 10 2 28 10 2 1 3 5 6 3 3 4 18 8 3 1 0 9 23 1 0 4 9 3 3 0 4 24 21 3 3 10 27 7 20 1 0 4 8 1 0 10 26 3 0 1 17 13 21 3 0 10 7 1 1 2 2 6 22 12 1 0 9 24 2 0 8 7 7 3 0 1 25 13 0 2 0 5 27 12 2 0 9 5 1 2 1 9 26 18 2 1 0 5 10 3 0 10 26 14 11 2 2 5 15 2 1 0 6 15 1 0 6 14 2 2 9 14 4 2 0 4 8 8 3 2 2 6 6 8 3 1 10 27 30 27 1 0 0 16 3 0 10 17 12 15 2 0 4 23 7 3 0 10 30 30 30 1 0 3 6 1 0 9 12 1 0 4 20 1 1 2 3 2 1 1 22 0 2 1 5 26 10 1 0 5 12 2 2 1 2 25 2 1 4 8 17 1 1 4 14 1 1 8 15 2 2 8 15 2 2 0 6 5 6 2 2 9 5 10 2 0 9 16 11 3 3 7 26 21 28 2 0 0 30 30 1 0 8 0 1 1 2 27 1 0 4 9 3 2 5 11 12 12 1 0 8 20 1 1 4 25 1 0 6 14 1 0 8 26 3 2 0 9 9 10 1 0 6 15 2 0 4 1 8 1 1 3 5 3 0 2 22 3 1 2 2 2 24 18 1 0 0 0 3 0 1 7 25 14 1 0 10 17 1 0 9 24 3 0 8 22 18 20 1 1 5 11 3 1 9 24 23 28 2 2 1 22 6 3 1 5 11 12 16 3 1 1 6 3 17 2 0 6 14 14 2 2 2 22 6 2 2 5 21 21 2 1 7 6 9 3 0 1 0 0 0 3 0 9 9 13 27 3 0 7 17 18 17 1 0 10 27 3 1 3 6 5 14 1 0 2 14 2 0 6 14 26 3 1 8 15 15 4 1 1 9 24 3 0 0 27 3 23 3 1 5 20 11 12 ".split(" ");
        QuestionA(input);
    }


	
	static void QuestionA(String[] input){
		int inputCounter = 0, T, N, S, p, nonSupprising, supprising, googlers, thresholdSmall, thresholdLarge;
		T=Integer.valueOf(input[inputCounter]);
		inputCounter++;
		
		for (int i=0; i<T; i++){
			N=Integer.valueOf(input[inputCounter]);
			inputCounter++;
			S=Integer.valueOf(input[inputCounter]);
			inputCounter++;
			p=Integer.valueOf(input[inputCounter]);
			inputCounter++;
			nonSupprising=0;
			supprising=0;
			thresholdSmall= Math.max(p,p*3-4);
			thresholdLarge= Math.max(p,p*3-2);
			for(int j=0; j<N;j++){
				googlers=Integer.valueOf(input[inputCounter]);
				inputCounter++;
				if(googlers>=thresholdLarge){
					nonSupprising++;
				}
				else if(googlers>=thresholdSmall){
					supprising++;
				}
			}
			System.out.print("Case #"+(i+1)+": "+(nonSupprising+Math.min(supprising, S))+"\n");
		}
		
	}
}