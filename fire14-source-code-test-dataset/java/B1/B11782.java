import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
public class Problem extends Template {
	public static void main(String[] args) throws Exception {
		_iFILE = "sample";
		_oFILE = "output";

//		Base ProblemA = new Base(new int[] {0, 1}) {
//			String lhs = " abcdefghijklmnopqrstuvwxyz";
//			String rhs = " yhesocvxduiglbkrztnwjpfmaq";
//			
//			@Override
//			protected String implementation(String[][] params) {
//				String trans = "";
//				String input = ArrayUtil.join(params[0], " ");
//				for (int i = 0; i < input.length(); i++) {
//					trans += rhs.charAt(lhs.indexOf(input.charAt(i)));
//				}
//				
//				return trans;
//			}
//		};
//		Base ProblemB = new Base(new int[] {0, 1}) {
//			@Override
//			protected String implementation(String[][] params) {
//				int count = 0;
//				
//				int n = new Integer(params[0][0]).intValue();
//				int s = new Integer(params[0][1]).intValue();
//				int p = new Integer(params[0][2]).intValue();
//				
//				boolean[][] match = new boolean[n][2];
//				
//				int[] t = new int[n];
//				for (int i = 0; i < n; i++) {
//					t[i] = new Integer(params[0][3 + i]).intValue();
//					
//					//Assuming x <= y <= z
//					boolean s_match = false;
//					boolean n_match = false;
//
//					for (int x = 0; x <= 10; x++) {
//						{
//							int z = x + 2;
//							int y = t[i] - x - z;
//
//							if(x <= y && y <= z && z >= p) {
//								//System.out.println("\t(" + x + "," + y +  "," + z + ") " + p);
//								s_match = true;
//							}
//						}
//						{
//							int z = x + 1;
//							int y = t[i] - x - z;
//
//							if(x <= y && y <= z && z >= p) {
//								//System.out.println("\t(" + x + "," + y +  "," + z + ") " + p);
//								n_match = true;
//							}
//						}
//						{
//							int z = x;
//							int y = t[i] - x - z;
//
//							if(x <= y && y <= z && z >= p) {
//								//System.out.println("\t(" + x + "," + y +  "," + z + ") " + p);
//								n_match = true;
//							}
//						}
//					}
//					match[i][0] = s_match;
//					match[i][1] = n_match;
//					
//					/*System.out.print(t[i]);
//					if(s_match) System.out.print(" *");
//					if(n_match) System.out.print(" +");
//					System.out.println();*/
//					
//					if(n_match)
//						count++;
//					else if(s > 0 && s_match) {
//						s--;
//						count++;
//					}
//				}
//				return Integer.toString(count);
//			}
//		};
		Base ProblemC = new Base(new int[] {0, 1}) {
			@Override
			protected String implementation(String[][] params) {
				int count = 0;
				try {
					int len = params[0][0].length();
					Integer[] p = ArrayUtil.convert(params[0], Integer.class);
					for (int n = p[0]; n <= p[1]; n++) {
						int m = n;
						while(true) {
							m = (int) ((m%10)*Math.pow(10, len - 1)) + m/10;
							if(n < m && m <= p[1]) count++;

							if(n == m) break;
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}

				return Integer.toString(count);
			}
		};
//		Base ProblemD = new Base(new int[] {1, 0}) {
//			@Override
//			protected String implementation(String[][] params) {
//				int r = new Integer(params[0][0]).intValue();
//				int c = new Integer(params[0][1]).intValue();
//				int d = new Integer(params[0][2]).intValue();
//
//				
//				
//				
//				return "";
//			}
//		};
		
		ProblemC.run();
	}
}

class Template {
	public static String _oFILE;
	public static String _iFILE;

	public static abstract class Base {
		static { System.out.println("--- GOOGLE CODE JAM 2012 ---------------------------------------"); }

		private int[] inputType;
		private String columnSeperator = " ";
		private Template.Base.iCollection input;
		abstract protected String implementation(String[][] params) throws Exception;

		public Base(int[] inputType) throws Exception {
			this.inputType = inputType;
			if (new File(_iFILE).exists()) {
				input = new Template.Base.iCollection();

				String strLine;
				BufferedReader buffReader = new BufferedReader(new FileReader(_iFILE));
				while ((strLine = buffReader.readLine()) != null)
					input.add(strLine.split(columnSeperator));
				buffReader.close();

				input.index();
			}else { throw new Exception("Input File Missing"); }
		}

		public void run() throws Exception {
			int inputSize = new Integer(input.get(0)[0]).intValue();
			BufferedWriter buffWriter = new BufferedWriter(new FileWriter(new File(_oFILE)));
			for (int i = 1; i <= inputSize; i++) {
				String result = implementation(Template.ArrayUtil.convert(input.item(i)));
				printResult(input.item(i), result);

				buffWriter.write("Case #" + i + ": " + result + "\n");
				buffWriter.flush();
			}
			buffWriter.close();

			System.out.println("----------------------------------------- GOOGLE INPUT TYPES ---");
			System.out.println("{0,n} : EACH CASE WITH n (n > 0) ROWS");
			System.out.println("{1,0} : EACH CASE WITH DYNAMIC (DEFINED @ FIRST ROW) SET OF ROWS");
			System.out.println("--------------------------------------------- Subodh Gairola ---");
		}

		private void printResult(ArrayList<String[]> params, String result) {
			for (int i = 0; i < params.size(); i++) {
				for (int j = 0; j < params.get(i).length; j++) {
					System.out.print(params.get(i)[j] + " ");
				}
				System.out.println();
			}
			System.out.println("\t\t|" + result + "|");
		}
		class iCollection extends ArrayList<String[]> {
			private static final long serialVersionUID = 1L;
			int[][] _index;

			public void index() {
				_index = new int[new Integer(this.get(0)[0]).intValue() + 1][2];
				_index[0][0] = inputType[0];
				_index[0][1] = inputType[1];
				for (int i = 1; i < _index.length; i++) {
					if (_index[0][0] == 0) {
						int len = inputType[1];

						_index[i][0] = 1 + (i - 1) * len;
						_index[i][1] = len;
					} else if (_index[0][0] == 1) {
						int lastPos = _index[i - 1][0];
						int lastLen = _index[i - 1][1];

						_index[i][0] = lastPos + lastLen;
						_index[i][1] = new Integer(this.get(_index[i][0])[0]).intValue() + 1;
					}
				}
			}
			public Template.Base.iCollection item(int index) {
				int pos = _index[index][0];
				int len = _index[index][1];
				Template.Base.iCollection params = new Template.Base.iCollection();
				for (int i = pos; i < pos + len; i++) {
					params.add(this.get(i));
				}
				return params;
			}
		}
	}
	public static class Generator {
		public int[] a;
		public BigInteger numLeft;
		public BigInteger total;
		public void reset() {
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			numLeft = new BigInteger(total.toString());
		}
		public BigInteger getNumLeft() {
			return numLeft;
		}
		public BigInteger getTotal() {
			return total;
		}
		public boolean hasMore() {
			return numLeft.compareTo(BigInteger.ZERO) == 1;
		}
		public static BigInteger getFactorial(int n) {
			BigInteger fact = BigInteger.ONE;
			for (int i = n; i > 1; i--) {
				fact = fact.multiply(new BigInteger(Integer.toString(i)));
			}
			return fact;
		}
		public static class Permutation extends Template.Generator {
			public Permutation(int n) {
				if (n < 1) {
					throw new IllegalArgumentException("Minimum 1");
				}
				a = new int[n];
				total = Template.Generator.getFactorial(n);
				reset();
			}
			public int[] getNext() {
				if (numLeft.equals(total)) {
					numLeft = numLeft.subtract(BigInteger.ONE);
					return a;
				}
				int temp;
				int j = a.length - 2;
				while (a[j] > a[j + 1]) {
					j--;
				}
				int k = a.length - 1;
				while (a[j] > a[k]) {
					k--;
				}
				temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				int r = a.length - 1;
				int s = j + 1;
				while (r > s) {
					temp = a[s];
					a[s] = a[r];
					a[r] = temp;
					r--;
					s++;
				}
				numLeft = numLeft.subtract(BigInteger.ONE);
				return a;
			}
		}
		public static class Combination extends Template.Generator {
			private int n;
			private int r;

			public Combination(int n, int r) {
				if (r > n) {
					throw new IllegalArgumentException();
				}
				if (n < 1) {
					throw new IllegalArgumentException();
				}
				this.n = n;
				this.r = r;
				a = new int[r];
				BigInteger nFact = Template.Generator.getFactorial(n);
				BigInteger rFact = Template.Generator.getFactorial(r);
				BigInteger nminusrFact = Template.Generator.getFactorial(n - r);
				total = nFact.divide(rFact.multiply(nminusrFact));
				reset();
			}
			public int[] getNext() {
				if (numLeft.equals(total)) {
					numLeft = numLeft.subtract(BigInteger.ONE);
					return a;
				}
				int i = r - 1;
				while (a[i] == n - r + i) {
					i--;
				}
				a[i] = a[i] + 1;
				for (int j = i + 1; j < r; j++) {
					a[j] = a[i] + j - i;
				}
				numLeft = numLeft.subtract(BigInteger.ONE);
				return a;
			}
		}
	}
	public static class ArrayUtil {
		@SuppressWarnings("unchecked")
		public static <T> T[][] permutations(T[] array) {
			Template.Generator.Permutation x = new Template.Generator.Permutation(array.length);
			ArrayList<T[]> permutations = new ArrayList<T[]>();
			while (x.hasMore()) {
				int[] indices = x.getNext();
				T[] permutation = (T[]) Array.newInstance(array[0].getClass(), indices.length);
				for (int i = 0; i < indices.length; i++) {
					permutation[i] = array[indices[i]];
				}
				permutations.add(permutation);
			}
			return convert(permutations);
		}
		@SuppressWarnings("unchecked")
		public static <T> T[][] combinations(T[] array, int n) {
			Template.Generator.Combination x = new Template.Generator.Combination(array.length, n);
			ArrayList<T[]> combinations = new ArrayList<T[]>();
			while (x.hasMore()) {
				int[] indices = x.getNext();
				T[] combination = (T[]) Array.newInstance(array[0].getClass(), indices.length);
				for (int i = 0; i < indices.length; i++) {
					combination[i] = array[indices[i]];
				}
				combinations.add(combination);
			}
			return convert(combinations);
		}
		@SuppressWarnings("unchecked")
		public static <T> T[] convert(String[] array, Class<T> cl) throws Exception {
			T[] n = (T[]) Array.newInstance(cl, array.length);
			for (int i = 0; i < array.length; i++) {
				n[i] = cl.getConstructor(String.class).newInstance(array[i]);
			};
			return n;
		}
		public static <T> String[] convert(T[] array) throws Exception {
			String[] n = new String[array.length];
			for (int i = 0; i < array.length; i++) {
				n[i] = array[i].toString();
			}
			return n;
		}
		@SuppressWarnings("unchecked")
		public static <T> T[] convert(ArrayList<T> arrayList) {
			if (arrayList.size() == 0) {
				return null;
			}
			T[] array = (T[]) Array.newInstance(arrayList.get(0).getClass(), arrayList.size());
			for (int i = 0; i < array.length; i++) {
				array[i] = arrayList.get(i);
			}
			return array;
		}
		public static <T> String join(T[] array, String seperator) {
			String string = "";
			for (int i = 0; i < array.length; i++) {
				string += array[i].toString();
				if (i < array.length - 1) {
					string += seperator;
				}
			}
			return string;
		}
		public static <T> T[] remove(T[] array, int index) {
			ArrayList<T> arrayList = new ArrayList<T>();
			for (int i = 0; i < array.length; i++) {
				if (i != index) {
					arrayList.add(array[i]);
				}
			}
			return convert(arrayList);
		}
		public static <T> T[] unique(T[] array) {
			ArrayList<T> arrayList = new ArrayList<T>();
			for (int i = 0; i < array.length; i++) {
				if (!arrayList.contains(array[i])) {
					arrayList.add(array[i]);
				}
			}
			return convert(arrayList);
		}
	}
}
