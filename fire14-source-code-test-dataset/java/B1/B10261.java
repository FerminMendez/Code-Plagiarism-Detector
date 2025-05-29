package qualification;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import core.ExtendedBufferedReader;
import core.Template;

public class ProblemC extends Template {

	int _numberOfCases;
	Vector<List<Integer>> _cases = new Vector<List<Integer>>();

	@Override
	public void feedData(ExtendedBufferedReader iR) {
		// TODO Auto-generated method stub

		_numberOfCases = iR.getIntFL();

		for (int i=0; i<_numberOfCases; i++){

			_cases.add(iR.getIntListFL());

		}

	}

	public String rotRight(String iData){
		return iData.charAt(iData.length()-1)+iData.substring(0,iData.length()-1);
	}

	@Override
	public StringBuffer applyMethods() {
		// TODO Auto-generated method stub

		StringBuffer aBF = new StringBuffer();

		for (int i=0; i<_cases.size(); i++){

			List<Integer> aCase = _cases.elementAt(i);

			int A = aCase.get(0);
			int B = aCase.get(1);
			int count = 0;
			
			for (int n=A; n<=B; n++){



				String repN = (new Integer(n)).toString();
				String repM = repN;
				int aSize = repN.length();

				if (aSize>1) {

					List<Integer> aMExists = new ArrayList<Integer>();
					
					for (int j=0;j<aSize;j++) {

						repM = rotRight(repM);

						int rN = new Integer(repN).intValue();
						int rM = new Integer(repM).intValue();
						
						if ((rN<rM) && (rM<=B) && (!aMExists.contains(new Integer(rM)))) {
							count++;
							aMExists.add(new Integer(rM));
							System.out.println("n="+repN+",m="+repM);
						} 
						
					}

				}
			}
			aBF.append("Case #"+(i+1)+": "+count+"\n");

		}

		return aBF;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ProblemC().play(args);

	}

}
