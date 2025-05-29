package Q2;


public class DancingSolver extends Solver {

	public static void main(String[] args) throws Exception{
		Main m;
		m = new Main("B-small-attempt0");
//		m = new Main("test");
		m.run(new DancingSolver(), false);
	}

	
	@Override
	public String solve() throws Exception {
		Integer[] spl = splitLine(readLine());
		int N = spl[0];
		int surprising = spl[1];
		int maxRes = spl[2];
		Integer $ = 0;
		for(int i=3;i<N+3;i++){
			int score = spl[i];
			if(getMaxVal(score) >= maxRes){
				$++;
				continue;
			}
			if(surprising > 0 && getMaxValSurprising(score) >= maxRes){
				$++;
				surprising--;
			}
		}
		return $.toString();
	}

	private int getMaxVal(int x){
		int mod = x % 3;
		int avg = x / 3;
		if(mod == 0)
			return avg;
		else
			return avg+1;
	}
	private int getMaxValSurprising(int x){
		if(x == 0)
			return 0;
		if(x == 1)
			return 1;
		if(x >= 26)
			return 10;
		int mod = x % 3;
		int avg = x / 3;
		if(mod <= 1)
			return avg+1;
		else
			return avg+2;
	}


}
