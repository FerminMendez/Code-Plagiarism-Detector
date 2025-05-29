
public class Pair 
{
	int N, M;
	
	Pair(int n, int m)
	{
		N = n;
		M = m;
	}
	
	@Override
	public boolean equals(Object otherPair) 
	{
		Pair right = (Pair)otherPair;
		return (N == right.N && M == right.M);
	}
}
