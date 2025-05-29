import java.io.FileWriter;
import java.io.IOException;


public class OutputPrinter {
	public OutputPrinter()
	{
		try {
			m_writer = new FileWriter("C:/AHK/output.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	FileWriter m_writer;
	
	int m_case = 1;
	public void print(String result)
	{
		try {
			m_writer.write("Case #"+ (m_case++)+": " + result + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
