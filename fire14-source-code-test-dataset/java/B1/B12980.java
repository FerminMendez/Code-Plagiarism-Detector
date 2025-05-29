import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;



public class TestCaseReader {
	public ArrayList<String> read(BufferedReader r) throws NumberFormatException, IOException
	{
		ArrayList<String> s  = new ArrayList<String>();
		int n = Integer.parseInt(r.readLine());
		for (int i = 0 ; i < n ; i ++ )
			s.add(r.readLine());
		return s;
	}
}
