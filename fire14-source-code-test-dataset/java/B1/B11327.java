package recycledNumbers;


public class OutputData {

	private int[] Steps;


	public int[] getSteps() {
		return Steps;
	}


	public OutputData(int [] Steps){
		this.Steps = Steps;
		
		for(int i=0;i<this.Steps.length;i++){
			System.out.println("Test "+(i+1)+": "+Steps[i]);
		}
	}
	
}
