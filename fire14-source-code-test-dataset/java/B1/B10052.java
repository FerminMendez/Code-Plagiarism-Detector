import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


	public class Main_c_new {
		public static void main(String[] args) throws Exception{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int cases=Integer.parseInt(in.readLine());
			for(int i=1;i<=cases;i++)
			{
				int count = 0;
				String line = in.readLine();
				String parts[] = line.split(" ");
				int a = Integer.parseInt(parts[0]);
				int b = Integer.parseInt(parts[1]);
				for(int j=a;j<b;j++){
					int temp = j;
					int length = 0;
					for(int k=0;k<8;k++){
						length++;
						temp/=10;
						if(temp<=0){
							break;
						}
					}
					ArrayList<Integer> list = new ArrayList<Integer>();
					for(int k=1;k<length;k++){
						 
						int div = (int)Math.pow(10,k);
						int part1 = j/div;
						int part2 = j%div;
						if(part2 >= (int)(Math.pow(10, k-1))){
							int num = (part2*((int)Math.pow(10, length-k)))+part1;
							if(num>j && num<=b){
								int flag = 0;
								for(int l=0; l<list.size();l++){
									if(list.get(l) == num){
										flag = 1;
									}
								}
								
								if(flag == 0){
								count++;
								list.add(num);
								}
							}
						}
					}
						
					}

				System.out.println("Case #"+i+": "+count);
			}
		}
	}
