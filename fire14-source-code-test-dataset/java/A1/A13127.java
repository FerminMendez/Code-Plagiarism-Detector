import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class IOSystem {
	private String filePath;
	private List<String> inputList = new ArrayList<String>();
	private StringBuilder sb = new StringBuilder();
	private int readSize = 0;
	private int appendedSize = 0;
	public IOSystem(String filePath)
	{
		this(filePath," ");
	}
	public IOSystem(String filePath,String sep)
	{
		this.filePath = filePath;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath+".in"));
			String line = null;
			while((line=br.readLine())!=null)
			{
				inputList.addAll(Arrays.asList(line.split(sep)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int  size(){return inputList.size();}
	public boolean  hasNext(){return readSize < size();}
	public int  nextInt(){return Integer.parseInt(inputList.get(readSize++));}
	public long nextLong(){return Long.parseLong(inputList.get(readSize++));}
	public double nextDouble(){return Double.parseDouble(inputList.get(readSize++));}
	public String nextString(){return new String(inputList.get(readSize++));}
	public <T> void appendAnswer(T answer){sb.append("Case #"+(++appendedSize)+": "+answer.toString()+"\n");};
	public void output(){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath+".ou"));
			bw.write(sb.toString());
			bw.flush();
			System.out.println("output ->"+filePath+".ou");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
