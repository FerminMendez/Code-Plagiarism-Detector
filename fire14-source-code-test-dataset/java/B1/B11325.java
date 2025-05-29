package recycledNumbers;



public class InputData {

	private int Test_Number;
	public int getTest_Number() {
		return Test_Number;
	}

	public int[] getA() {
		return A;
	}

	public int[] getB() {
		return B;
	}

	private int [] A;
	private int [] B;


	public InputData(int Test_Number, int [] A, int [] B){

		this.Test_Number = Test_Number;
		this.A = A;
		this.B = B;
	}
	
}
