import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;

public class qualifycodejamC{

	public static int checkNum(int num, int m, int n){
			String snum = Integer.toString(num);
			int[] array = new int[snum.length()];
			int min = num;
			int count = 0;

			for(int i=0;i<array.length;i++){
				boolean dupe = false;
				char[] temp = new char[snum.length()];
				for(int j=0;j<array.length;j++){
					temp[j] = snum.charAt((j + i) % snum.length());


				}
				array[i] = Integer.parseInt(new String(temp));
				//do a dupe check
				for(int k=0;k<i;k++){
					if(array[k] == array[i]){
						dupe = true;
					}
				}
				//System.out.print(";"+array[i]+";");

				if (m <= array[i] && array[i] <= n && array[i] != num && !dupe){
					count++;

				}
				if(Math.min(min,array[i]) >= m){
					min = (int)Math.min(min,array[i]);
				}
				//System.out.println("length: "+array.length+" current: "+num+"; min: "+ min);
			}

			if(min != num){
				//System.out.println();
				return 0;
			}
			//System.out.println("!X count: "+ count);
			if(count == 2){
				return 3;
			}else if(count == 3){
				return 6;
			}else if(count == 4){
				return 10;
			}else if(count == 5){
				return 16;
			}else if(count == 6){
				return 21;
			}else if(count == 7){
				return 28;
			}else if(count == 8){
				return 36;
			}

			return count;
	}

	public static void main(String[] args){

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		   String x = null;
		   String linein = null;
		   int totalcases = 0;
		   int result = 0;
		   int n = 0;
		   int m = 0;
		   int counter = 1;


		   try{
		    x = br.readLine();
		    totalcases = Integer.parseInt(x);

		    while( (linein = br.readLine()) != null){
					result = 0;

					StringTokenizer st = new StringTokenizer(linein);
					n = Integer.parseInt(st.nextToken());
					m = Integer.parseInt(st.nextToken());

					for (int i=n;i<m+1;i++){
						result = result + checkNum(i,n,m);
					}

					System.out.print("Case #" + (counter) + ": "+ result);
					//System.out.println(" debug: return val: "+process_return+"; used surprises: " + surprise_count + "/"+ttl_surprises);
					System.out.println();

					counter++;
				}

		   }
		   catch (IOException e) {
			   e.printStackTrace();
		   }

	}

}