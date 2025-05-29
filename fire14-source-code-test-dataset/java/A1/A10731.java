import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class GoogleJamQ2 {

	  static int[] triplets = new int[100];
	  static int number_googlers = 0;
	  static int number_surprising = 0;
	  static int least_number = 0;
	
	    
	  
	/**
	 * @param args
	 * @throws IOException 
	 */
	private static void get_numbers(String toCalculate)
	{
		char[] number_to_convert = new char[4];
		int number_got = 0;
		int number_triplets = 0;
		int number_length = 0;
		int str_length = toCalculate.length();
		for(int k = 0; k < str_length; k++)
		{
			number_to_convert[0] = toCalculate.charAt(k);
			number_length ++;
			if(k + 1 < str_length)
			{
				number_to_convert[1] = toCalculate.charAt(k+1);
				k++;
				if(number_to_convert[1] != ' ')
				{
					number_length ++;
					if(k + 1 < str_length)
					{
						number_to_convert[2] = toCalculate.charAt(k+1);
						k++;
						if(number_to_convert[2] != ' ')
						{
							number_length ++;
							k++;
						}
					}

				}
			}

			switch(number_got)
			{
				case 0:
					number_googlers = new Integer(new String(number_to_convert,0,number_length));
					number_got ++;
					break;
				case 1:
					number_surprising = Integer.parseInt(new String(number_to_convert,0,number_length));
					number_got ++;
					break;
				case 2:
					least_number = Integer.parseInt(new String(number_to_convert,0,number_length));
					number_got ++;
					break;
				default:
					triplets[number_triplets] = Integer.parseInt(new String(number_to_convert,0,number_length));
					number_got ++;
					number_triplets ++;
					break;
			}
			number_length = 0;
		}
	}
	
	private static boolean canGreater(int total, int least)
	{
		int single = total / 3;
		int remainer = total % 3;
		if (single >= least)
		{
			return true;
		}
		else
		{

			switch(remainer)
			{
				case 0:
					if(number_surprising > 0)
					{
						if(single == 0)
						{
							//System.out.println(single+", "+single+", "+single);
							return false;
						}
						else if((single + 1) >= least)
						{
							//System.out.println((single-1)+", "+single+", "+(single+1));
							number_surprising --;
							return true;
						}
						else
						{
							return false;
						}
					}
					else
					{
						//System.out.println(single+", "+single+", "+single);
						return false;
					}
					
				case 1:
					if((single + 1) >= least)
					{
						return true;
					}
					else
						return false;
					
				case 2:
					if((single + 1) >= least)
					{
						return true;
					}
					else 
					{
						if((number_surprising > 0))
						{
							if((single + 2) >= least)
							{
								number_surprising --;
								return true;
							}
						}
						else
						{
							return false;
						}

					}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		//System.out.println("Begin cacluating");
		 FileInputStream fstream = new FileInputStream("rec/input.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  strLine = br.readLine();
		  int x = Integer.parseInt(strLine);
		  
		  int output_result = 0;

		  for(int i = 0; i < x; i++)
		  {
			  strLine = br.readLine();
			  get_numbers(strLine);
			  //System.out.println("googlers: "+number_googlers+" surprising: "+number_surprising+" least: "+least_number);

			  for(int k = 0; k < number_googlers; k++)
			  {
				  //System.out.println((k+1)+": "+triplets[k]);
				  if(canGreater(triplets[k], least_number))
				  {
					  output_result ++;  
				  }
			  }
			  System.out.println("Case #"+(i+1)+": "+output_result);
			  output_result = 0;
		  }
		  

	}

}

