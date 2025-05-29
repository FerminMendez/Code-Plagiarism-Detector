import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class BSmall {
	private int[] result;

	public BSmall() throws NumberFormatException, IOException {
		readFile();
		writeOutFile();
	}

	private int[] getNum(int num, int s) {
		int[] result = new int[4];
		int sur = s;
		int c = 10;
		result[3] = sur;
		while (c != 0) {
			if (num != 0) {
				int i = num / c;
				int r = num % c;
				if (i == 3) {
					if (r == 0) {
						result[0] = c;
						result[1] = c;
						result[2] = c;
						result[3] = sur;
						break;
					}
				}
				if (i == 2) {
					if (c - r == 1) {
						result[0] = c;
						result[1] = c;
						result[2] = r;
						result[3] = sur;
						break;
					} else if (c - r == 2) {
						c--;
						if (c != 0) {
							i = num / c;
							r = num % c;
							if (i == 3) {
								c++;
								r = num % c;
								result[0] = c;
								result[1] = c;
								result[2] = r;
								// result[3] = sur - 1;
								break;
							}
						}
					}
				}

				c--;
			} else {
				break;
			}
		}
		return result;
	}

	private boolean containsMax(int max, int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] >= max) {
				return true;
			}
		}
		return false;
	}

	private int getIndex(int Max, int[] nums) {
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (Math.abs(nums[i] - Max) == 1) {
				return i;
			}
		}
		return index;
	}

	private boolean check(int[] nums, int num) {
		boolean flag = true;
		int result = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			result += nums[i];
			boolean f = true;
			int index = -1;
			for (int j = i; j < nums.length - 1; j++) {
				if (!(Math.abs(nums[j] - nums[i]) < 3)) {
					return false;
				} else {
					if ((Math.abs(nums[j] - nums[i]) == 2)) {
						if (!f) {
							if (index != 0) {
								if (nums[index] != nums[j]) {
									return false;
								}
							}
						} else {
							f = false;
							index = j;
						}
					}
				}
			}
		}
		if (result != num) {
			return false;
		}
		return flag;
	}

	private int getResult(int S, int Max, int[] numbers) {
		int result = 0;
		int s = S;
		for (int i = 0; i < numbers.length; i++) {
			int[] nums = getNum(numbers[i], s);
			s = nums[3];
			boolean contain = containsMax(Max, nums);
			if (!contain) {
				int index = getIndex(Max, nums);
				if (index != -1 && s != 0) {
					int num = nums[index];
					for (int j = 0; j < nums.length; j++) {
						if (index != j) {
							if (num == nums[j]) {
								nums[index] = num + 1;
								nums[j] = nums[j] - 1;
								if (nums[j] >= 0) {
									boolean flag = check(nums, numbers[i]);
									if (flag) {
										s--;
										result++;
										break;
									}
								}
							}
						}
					}
				}
			} else {
				result++;
			}
		}
		return result;
	}

	private void readFile() throws NumberFormatException, IOException {
		FileInputStream fis = new FileInputStream("Input.txt");
		DataInputStream dis = new DataInputStream(fis);
		result = new int[Integer.parseInt(dis.readLine())];
		int c = 0;
		while (dis.available() > 0) {
			String line = dis.readLine();
			String[] numbers = line.split(" ");
			int[] nums = new int[Integer.parseInt(numbers[0])];
			int s = Integer.parseInt(numbers[1]);
			int Max = Integer.parseInt(numbers[2]);
			for (int i = 3; i < numbers.length; i++) {
				nums[i - 3] = Integer.parseInt(numbers[i]);
			}
			result[c] = getResult(s, Max, nums);
			c++;
		}
	}

	private void writeOutFile() throws IOException {
		FileWriter fw = new FileWriter("Output.txt");
		for (int i = 0; i < result.length; i++) {
			if (i < result.length - 1) {
				fw.write("Case #" + (i + 1) + ": " + result[i] + "\n");
			} else {
				fw.write("Case #" + (i + 1) + ": " + result[i]);
			}
		}
		fw.close();
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BSmall bs = new BSmall();

	}
}
