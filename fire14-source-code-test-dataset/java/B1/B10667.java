import java.io.*;
import java.util.*;
public class recycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fstream = new FileInputStream("C:/input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int numOfLines = Integer.parseInt(br.readLine());	
		
			for(int i = 1; i <= numOfLines; i++){
				String str = br.readLine();
				String numbers[] = str.split(" ");
				int result = Recycle(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]));
				System.out.println("Case #" + i + ": " + result);
				
			}
		//int A = 1111, B = 2222;
			 
			
			
	}
		catch (Exception e) {
			// TODO: handle exception
		}
}

	private static int Recycle(int A, int B) {
		// TODO Auto-generated method stub

		int j = 0, count = 0;
		for (int i = A; i <= B ; i++)
		{
			String temp = Integer.toString(i);
			ArrayList<Integer> Number = new ArrayList<Integer>();
			for (int k = 0; k < temp.length(); k++){
				
					String rotated = temp.substring(temp.length()-k, temp.length());
					String other_half = temp.substring(0, temp.length()-k);
					String total = rotated+other_half;
					int rot_number = Integer.parseInt(total);
					if(rot_number <= B && rot_number >= A && rot_number < i)
					{
						if(contains(Number, rot_number))
						{}
							//do nothing
						else{
		//					System.out.println(i + "; "+rot_number);
							Number.add(rot_number);
							count++;
						}
						
						
					}
				
			}
			
		}
		
		return count;
	}

	private static boolean contains(ArrayList<Integer> number, int rot_number) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < number.size(); i++)
		{
			if (number.get(i) == rot_number)
			{
				return true;
			}
				
		}
		
		return false;
		
	}

}
