public class Result {
	
	public String output;
	public int i;
	
	public Result(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "Case #"+i+": " + output;
	}

	
}
