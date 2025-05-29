import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GCIResult {

	public GCIResult() {
		mResultList = new LinkedList<String>();
		mCaseCounter = 1;
	}
	
	public void addString(String res)
	{
		mResultList.add(res);
	}
	
	public void addCase(String res) {
		mResultList.add("Case #" + mCaseCounter + ": " + res);
		mCaseCounter++;
	}
	
	public void clear() {
		mResultList.clear();
		mCaseCounter = 1;
	}
	
	public Iterator<String> iterator() {
		return mResultList.iterator();
	}
		
	private long             mCaseCounter;
	private List<String>	 mResultList;
}
