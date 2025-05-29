
public class Code3DataStructure {
	private int a;
	private int b;
	private int result;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	private static int denomination(int baseDenomination, int amount) {
		int denomination = 1;
		for (int i = 0; i < amount; i++) {
			denomination*=baseDenomination;
		}
		return denomination;
	}
	private static int rotateNumber(int m,int chunkSize) {
		int chunk = m%(denomination(10,chunkSize));
		int leftover = m/(denomination(10,chunkSize));
		int leftoverSize = (leftover+"").length();
		int output = chunk*(denomination(10,leftoverSize))+leftover;
		return output;
	}
	public static void main(String[] args) {
		int x = rotateNumber(12345, 3);
		System.out.println(x);
	}
}
