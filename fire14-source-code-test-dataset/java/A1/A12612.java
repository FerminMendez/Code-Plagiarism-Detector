import java.io.IOException;


public class DancingGooglers extends FileReaderWriter {

	/*//int[] GOOG = {29, 20, 8, 18, 18, 21};
	int[] GOOG = {23, 22, 21};*/
	
	DancingGooglers(String inPath, String outPath) throws IOException {
		super(inPath, outPath);
		reader();
		
	}
	
	@Override
	public void reader() throws IOException {
		super.writer();
		strLine = br.readLine();
		nTestCases = Integer.valueOf(strLine);
		
		int N, S, p;
		int nthCase = 0;
		
		int googlerCount = 0;
		
		String toWrite = new String();
		
		
		//While LOOP
		while( (strLine = br.readLine()) != null ) {
			googlerCount = 0;
			++nthCase;
			toWrite = toWrite + "Case #" + nthCase + ": ";
			String[] handler = strLine.split(" ");
			
			int[] GOOG = new int[handler.length];
			
			for(int i=0; i<handler.length; ++i) {
				GOOG[i] = Integer.valueOf(handler[i]);
			}
			
			N = GOOG[0];
			S = GOOG[1];
			p = GOOG[2];
			
			for(int i=3; i<GOOG.length; ++i) {
				int base = (int) GOOG[i] / 3;
				
				switch (GOOG[i] % 3) 
				{
					case 0:
					{
						if(base >= p)
							++googlerCount;
						else {
							if(S>0 && base>0 && base+1>=p) {
								++googlerCount;
								--S;
							}
						}
						break;
					}
					
					case 1:
					{
						if(base >= p || base+1 >= p) {
							++googlerCount;
						}
						else {
							if(S > 0 && base + 1 >= p) {
								++googlerCount;
								S--;
							}
						}
						break;
					}
					
					case 2:
					{
						if(base + 1 >= p || base >= p) {
							++googlerCount;
						}
						else {
							if(S > 0 && base + 2 >= p) {
								++googlerCount;
								--S;
							}
						}
						break;
					}
				}				
			}
			toWrite = toWrite + googlerCount + "\n";			
		}
		System.out.println(toWrite);
		bw.write(toWrite);
		bw.close();
	}

}
