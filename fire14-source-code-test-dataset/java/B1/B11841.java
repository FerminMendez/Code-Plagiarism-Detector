package info.m3o.gcj2012.recyclednumber;

public class ResultUtil {
	MyNumberStringSet testedNumberSet;
	MyNumberStringPairSet recycledNumberSet;

	public ResultUtil() {
		testedNumberSet = new MyNumberStringSet();
		recycledNumberSet = new MyNumberStringPairSet();
		assert (testedNumberSet.isEmpty() == true) : "ResultUtil Constructor Error.";
		assert (recycledNumberSet.isEmpty() == true) : "ResultUtil Constructor Error.";
	}

	public void clearSets() {
		this.testedNumberSet.clear();
		this.recycledNumberSet.clear();
	}

	public boolean isTested(String s) {
		return (this.testedNumberSet.contains(s));
	}

	public boolean isInRecycledNumberSet(String s) {
		return (this.recycledNumberSet.contains(s));
	}

}
