import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class Dancing {


	public static void main(String[] args) throws IOException {
		RandomAccessFile in = new RandomAccessFile(new File("B-small-attempt0.in"), "r");
		RandomAccessFile out = new RandomAccessFile(new File("DanceOut.out"),"rw");
		int num = Integer.parseInt(in.readLine());
		for (int j = 1; j <= num; j++){
			int count = 0;
			String[] numbers = in.readLine().split(" ");
			int gs = Integer.parseInt(numbers[0]);
			int special = Integer.parseInt(numbers[1]);
			int over = Integer.parseInt(numbers[2]);
			int[] arr = new int[gs];
			for (int i = 3; i < numbers.length; i++) {
				arr[i-3] = Integer.parseInt(numbers[i]);
			}
			Arrays.sort(arr);
			for (int i = 0; i < gs; i++) {
				int base = arr[i]/3;
				switch(arr[i] % 3) {
					case 0:
						if (special > 0 && base > 0 && (base+1) >= over) {
								count++;
								special--;
						}
						else if(base >= over) {
							count++;
						}
						
						break;
					case 1:
						if(base >= over || (base+1) >= over) {
							count++;
						}
						break;
						
					case 2:
						if (special > 0 && (base + 2) >= over) {
				        		count++;
				        		special--;
				        }
						else if ((base + 1) >= over || base >= over) count++;
				        
						break;
				}
			}
			out.writeBytes("Case #" + j + ": " + count + "\n");
		}
	}

}
