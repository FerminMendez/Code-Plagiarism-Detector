import java.io.* ; 
import java.util.* ; 

public class FileReaderWriter {
	
	public static final int WRITE_MODE = 1 ; 
	public static final int READ_MODE = 2 ;
	
	private File file ; 
	
	private BufferedReader br ;
	private PrintWriter pw ; 
	private int mode ; 
	
	FileReaderWriter(String fileName , int mode) throws Exception
	{
		this.file = new File(fileName) ;
		this.mode = mode ;
		
		if(mode == FileReaderWriter.READ_MODE) 
		{
			if(!(file.isFile() && file.exists()))
			{
				throw new Exception(" File "+file.getPath()+" is not available for reading !") ;
			}
			else
			{
				br = new BufferedReader(new FileReader(this.file)) ;
			}
		}
		else if(mode == FileReaderWriter.WRITE_MODE)
		{
		  	pw = new PrintWriter(new FileWriter(this.file)) ; 
		}
		else 
		{
			throw new Exception("Unsupported File mode") ;
		}
	}
	
	public String readLine() throws Exception
	{
		return br.readLine() ; 
	}
	
	public Integer readInt() throws Exception
	{
		return Integer.parseInt(br.readLine()) ; 
	}
	
	public ArrayList<String> readStrList() throws Exception
	{
		String readStr = readLine() ;
		
		StringTokenizer stTokenizer = new StringTokenizer(readStr) ;
		
		ArrayList<String> readStrList = new ArrayList<String>(stTokenizer.countTokens()) ; 
		
		while(stTokenizer.hasMoreTokens())
		{
			readStrList.add(stTokenizer.nextToken()) ;
		}
		
		return readStrList ; 
		
	}
	
	public ArrayList<Integer> readIntList() throws Exception
	{
		String readStr = readLine() ;
		
		StringTokenizer stTokenizer = new StringTokenizer(readStr) ;
		
		ArrayList<Integer> readIntList = new ArrayList<Integer>(stTokenizer.countTokens()) ; 
		
		while(stTokenizer.hasMoreTokens())
		{
			readIntList.add(Integer.parseInt(stTokenizer.nextToken())) ;
		}
		
		return readIntList ; 
		
	}
	
	public ArrayList<Long> readLongList() throws Exception
	{
		String readStr = readLine() ;
		
		StringTokenizer stTokenizer = new StringTokenizer(readStr) ;
		
		ArrayList<Long> readLongList = new ArrayList<Long>(stTokenizer.countTokens()) ; 
		
		while(stTokenizer.hasMoreTokens())
		{
			readLongList.add(Long.parseLong(stTokenizer.nextToken())) ;
		}
		
		return readLongList ; 
		
	}
	
	public void write(String str) throws Exception
	{
		pw.print(str) ;
		pw.flush() ;
		
	}
	
	public void writeLine(String str) throws Exception
	{
		pw.println(str) ; 
		pw.flush() ;
		
	}
	
	public void writeListLine(ArrayList list, String seperator) throws Exception
	{
		ListIterator iterator = list.listIterator() ;
		
		while(iterator.hasNext())
		{
			pw.print(iterator.next()) ;
			if(iterator.hasNext()) pw.print(seperator) ;
			
		}
		
		pw.print("\n"); 
		pw.flush();
		
	}
	
	
	public void close() throws Exception
	{
		if(mode == FileReaderWriter.READ_MODE)
		{
			br.close() ; 
		}
		else if(mode == FileReaderWriter.WRITE_MODE) 
		{
			pw.flush() ;
			pw.close() ;
		}
	}
	
	
}
