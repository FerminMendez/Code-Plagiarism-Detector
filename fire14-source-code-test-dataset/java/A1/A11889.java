import java.io.*;
import java.util.*;
import java.awt.Point;

class Case{
	long num1,Ngoogle,Special,p;
	int total;
	String result="";
	public Case(File aFile)
	{
		try{
			StringBuilder contents = new StringBuilder();
		  	BufferedReader input =  new BufferedReader(new FileReader(aFile));
			String line = input.readLine();
			num1 = Integer.valueOf(line).intValue();

			int i=1;
			total=0;

	System.out.println("nmber of ttal cases"+ num1 +"testing");

			while (i<=num1 && ( line = input.readLine()) != null)
			{

				StringTokenizer st = new StringTokenizer(line," ");

				Ngoogle=Integer.valueOf(st.nextToken());
 			//  System.out.println("ngooge #"+ Ngoogle);

				Special=Integer.valueOf(st.nextToken());
			//  System.out.println("Special #"+ Special);

				p=Integer.valueOf(st.nextToken());
			//  System.out.println("p #"+ p);

				// use this for testing
				long normalP=p*3-2;
				long specialP=p*3-4;
                int ii=1;

				while (ii<=Ngoogle)
				{
					long temp=Integer.valueOf(st.nextToken());
					// okay test the temp integer

					if(p==0)
					{
						total++;
					}
					else if(p==1)
					{
						if(temp>=1)
						total++;
					}
					else if(temp>=normalP)
					{
					  total++;
					}
					else if(Special>0 && temp>=specialP)
					{
					  total++;
					  Special--;
					}
					ii++;
				}


			//System.out.println(result);
			// output  total... or save to vector.
			// System.out.println("Case #"+ i +"total"+ total);
			oneCase(i, total);
			total=0;
			i++;

			}

		}
		catch (IOException ex){
		  ex.printStackTrace();
		}
	}

  public String getResult (){

	return result;

  }


  public void oneCase (int c, int total){

	// System out Case #c: total
	System.out.println("Case #"+ c +":" +total);
	result+="Case #"+c+": "+total+System.getProperty("line.separator");
  }


}


public class ReadWriteTextFile {
  static public String getContents(File aFile) {
    StringBuilder contents = new StringBuilder();
    try {
      BufferedReader input =  new BufferedReader(new FileReader(aFile));
      try {
        String line = null;
        while (( line = input.readLine()) != null){
          contents.append(line);
          contents.append(System.getProperty("line.separator"));
        }
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
    return contents.toString();
  }
  static public void setContents(File aFile, String aContents)
                                 throws FileNotFoundException, IOException {
    if (aFile == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!aFile.exists()) {
      throw new FileNotFoundException ("File does not exist: " + aFile);
    }
    if (!aFile.isFile()) {
      throw new IllegalArgumentException("Should not be a directory: " + aFile);
    }
    if (!aFile.canWrite()) {
      throw new IllegalArgumentException("File cannot be written: " + aFile);
    }
    Writer output = new BufferedWriter(new FileWriter(aFile));
    try {
      output.write( aContents );
    }
    finally {
      output.close();
    }
  }
  public static void main (String... aArguments) throws IOException {
    File testFile = new File("B-small-attempt0.in");
    File testFile2 = new File("result.txt");
	Case allcases = new Case(testFile);
    setContents(testFile2, allcases.getResult());
  }
}










