import java.io.IOException;

class Round1C {
	private int Case;

	public Round1C(int Case, int A, int B) {
		this.Case = Case;
		int result = this.Computer(A, B);
		this.outPut(result);
	}

	/*
	 * N從A到B
	 * 把每個數字N作旋轉後的結果，
	 * 判斷，是否大於N且小於等於B
	 * 是result++
	 * 
	 * */
	private int Computer(int A, int B){
		int result = 0;
		if(this.degree(A) == this.degree(B)){
			for(int N = A; N <= B; N++){
				for(int i = 1; i <= degree(N); i++){
					int r = Rotation(N, i);
//					System.out.println("\t" + r);
					if(N < r && r <= B){
						result++;
					}
				}
			}
		}
		return result;
	}
	
	private int Rotation(int temp, int order){
		int result = 0;
		String rotation = Integer.valueOf(temp).toString();
		rotation = rotation.substring(order) + rotation.substring(0, order);
		result = Integer.parseInt(rotation);
		return result;		
	}
	
	private int degree(int temp){
		for(int i = 1; ;i++){
			temp /= 10;
			if(temp == 0){
				return i;
			}			
		}
	}
	
	private void outPut(int result) {
		try {
			System.out.println("Case #" + Case + ": " + result);
			Main.bufWriter.write("Case #" + Case + ": " + result);
			Main.bufWriter.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
