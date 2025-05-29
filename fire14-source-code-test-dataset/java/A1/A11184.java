public class DataModel extends Thread {
		
		private int googlersNo;
		private int suprScore;
		private int minScore;
		private int[] googScore;
		private int caseNo;
		private int output;
		private boolean stateCalc;
		
		public DataModel(String input, int caseNo) {
			this.caseNo = caseNo;
			String[] temp = input.split(" ");
			stateCalc = false;
			try {
				googlersNo = Integer.parseInt(temp[0]);
				suprScore = Integer.parseInt(temp[1]);
				minScore = Integer.parseInt(temp[2]);
				googScore = new int[googlersNo];
				for(int i = 0;i<googlersNo;i++) {
					googScore[i] = Integer.parseInt(temp[3+i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		private boolean isOverReqScore(int i) {
			int[] temp = {i/3,i/3,i/3};
			int diff = (i-(temp[0]+temp[1]+temp[2]));
			int minDiff = minScore-temp[0];
			if(diff > 0) {
				temp[0] += 1;
				if(diff > 1 && minDiff < 3 && minDiff > 0 && suprScore > 0) {
					temp[0] += 1;
					suprScore--;
				} else if(diff > 1) {
					temp[1] += 1;
				} 
			} else if (minDiff == 1 && temp[0]!=0 && suprScore > 0) {
				temp[0] += 1;
				temp[2] -= 1;
				suprScore--;
			}
			return (temp[0]>=minScore||temp[1]>=minScore||temp[2]>=minScore);
		}
		
		@Override
		public void run() {
			for(int i = 0;i<googlersNo;i++) {
				if(isOverReqScore(googScore[i])) {
					output++;
				}
			}
			stateCalc = true;
		}
		
		public boolean isDone() { 
			return stateCalc;
		}
		
		public void getOutput() {
			System.out.println("Case #"+caseNo+": "+output);
		}
	}