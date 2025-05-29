
public class Dance {
	JamInputReader ir;
	
	public Dance(String fileName) {
		ir = new JamInputReader(fileName);
		int t = ir.getNumItems();
		
		for(int i = 0; i < t; i++) {
			int n = ir.getNextInt();
			int s = ir.getNextInt();
			int p = ir.getNextInt();
			
			int c = 0;
			int l = p * 3 - 4;
			
			for(int j = 0; j < n; j++) {
				int q = ir.getNextInt();
				
				if(p < 2) {
					if(q >= p)
						c++;
				} else {
					if(q > l + 1)
						c++;
					else if(s > 0 && (q == l || q == l + 1)) {
						s--;
						c++;
					}
				}
			}
			
			System.out.println("Case #" + (i + 1) + ": " + c);
		}
	}
	
	public static void main(String[] args) {
		new Dance(args[0]);
	}
}
