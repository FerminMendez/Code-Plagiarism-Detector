import java.io.*;
public class B{
	
	public static void main(String args[]){
		int C = 1;
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("B.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			br.readLine();
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
			// Print the content on the console
				System.out.println("Case #" + C + ": " + passes(strLine));
				C++;
			}
			//Close the input stream
				in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	private static int passes(String s){
		int fails=0;
		String[] in = s.split(" ");
		int T = Integer.parseInt(in[0]);
		int S = Integer.parseInt(in[1]);
		int p = Integer.parseInt(in[2]);
		int[] scores = new int[T];
		int base;
		boolean one;
		int two;
		
		for(int i = 3; i<in.length; i++){
			scores[i-3] = Integer.parseInt(in[i]);
		}
		for(int score: scores){
		base = (int) (score/3);
        if(score%3 == 0){
			
          int[][] result = {
            {base, base, base},
            {base - 1, base, base + 1}
          };
		  

          // regular case:
          if (base >= p)
          {
              one= true;
              fails++;
          }
          else
          {
            // check for surprise case:
            if (S > 0 && base > 0 && base + 1 >= p)
            {            
              fails++;
              S--;
              one= true;
            }            
          }         

          two = S;
        }

        if(score%3==1)
        {
          int[][] result = {
		  {base, base, base+1},
            {base-1, base+1, base+1},
          };

          // regular case:
          if (base >= p||base + 1 >= p)
          {
              fails++;
              one= true;
          }
          else
          {
            // surprise case:
            if (S > 0 && base + 1 >= p)
            {
              one= true;
              fails++;
              S--;
            }
          }

          two = S;
        }

        if(score%3==2)
        {          
          int[][] result = {
            {base, base, base + 2},
            {base, base + 1, base + 1}
          };

          // regular case:
          if (base + 1 >= p||base >= p)
          {
            one= true;
            fails++;
          }
          else
          {
            if (S > 0 && base + 2 >= p)
            {
              one= true;
              fails++;
              S--;
            }
          }

          two = S;
        }
      }
	      return fails;
    }

  }

		
		
		/*
		for(int t: scores){
			//System.out.println(t + " " + p + " " + fails);
			if(t<(3*p-2)){
				fails++;
				//System.out.println(fails);
				if(t>=p&&S>0){
					S--;
					fails--;
					//System.out.println(fails);
				}
			}
		}
		//System.out.println(fails);
		return T-fails;
		*/