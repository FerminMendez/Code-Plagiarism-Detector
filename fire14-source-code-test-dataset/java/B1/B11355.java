import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;


public class RecycledNumbers {
	long totalCases = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new RecycledNumbers().solve();
	}
	
	public void solve() throws Exception {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader("smallinput2.txt"));
			pw = new PrintWriter(new FileWriter("smalloutput2.txt"));
			String str = "";
			if ((str = br.readLine()) != null) {
				System.out.println(str);
				totalCases = Integer.parseInt(str);
				System.out.println("Total cases:" + totalCases);
			}

			for (int ctr=1;ctr<=totalCases;ctr++) {
				str = br.readLine();
				System.out.println("Input string:" + str);
				String[] strArr = str.split(" ");
				String str1 = strArr[0];
				String str2 = strArr[1];
				long num1 = Long.parseLong(str1);
				long num2 = Long.parseLong(str2);
				int len = str1.length();
				int totalCount = 0;
				Set numSet = new HashSet();
				for (long l1 = num1; l1 < num2; l1++) {
					String str3 = new Long(l1).toString();
					for (long l2 = l1+1; l2 <= num2; l2++) {
						String str4 = new Long(l2).toString();
						//System.out.println("Matching " + str3 + "," + str4);
						if (len == 2) {
							String originalString = str3.substring(0,1)+str3.substring(1,2);
							String recycledString = str4.substring(1,2)+str4.substring(0,1);
							//System.out.println("recycledString:" + recycledString);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4);
							}
						}
						if (len == 3) {
							String originalString = str3.substring(0,1)+str3.substring(1,2)+str3.substring(2,3);
							String recycledString = str4.substring(2,3)+str4.substring(0,1)+str4.substring(1,2);
							//System.out.println("recycledString:" + recycledString);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(1,2)+str4.substring(2,3)+str4.substring(0,1);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4);
							}
						}
						if (len == 4) {
							String originalString = str3.substring(0,1)+str3.substring(1,2)+str3.substring(2,3)+str3.substring(3,4);
							String recycledString = str4.substring(3,4)+str4.substring(0,1)+str4.substring(1,2)+str4.substring(2,3);
							//System.out.println("recycledString:" + recycledString);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(2,3)+str4.substring(3,4)+str4.substring(0,1)+str4.substring(1,2);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(1,2)+str4.substring(2,3)+str4.substring(3,4)+str4.substring(0,1);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
						}
						if (len == 5) {
							String originalString = str3.substring(0,1)+str3.substring(1,2)+str3.substring(2,3)+str3.substring(3,4)+
									str3.substring(4,5);
							String recycledString = str4.substring(4,5)+str4.substring(0,1)+str4.substring(1,2)+str4.substring(2,3)+
									str4.substring(3,4);
							//System.out.println("recycledString:" + recycledString);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(3,4)+str4.substring(4,5)+str4.substring(0,1)+str4.substring(1,2)+
									str4.substring(2,3);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(2,3)+str4.substring(3,4)+str4.substring(4,5)+str4.substring(0,1)+
									str4.substring(1,2);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(1,2)+str4.substring(2,3)+str4.substring(3,4)+str4.substring(4,5)+
									str4.substring(0,1);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
						}
						if (len == 6) {
							String originalString = str3.substring(0,1)+str3.substring(1,2)+str3.substring(2,3)+str3.substring(3,4)+
									str3.substring(4,5)+str3.substring(5,6);
							String recycledString = str4.substring(5,6)+str4.substring(0,1)+str4.substring(1,2)+str4.substring(2,3)+
									str4.substring(3,4)+str4.substring(4,5);
							//System.out.println("recycledString:" + recycledString);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(4,5)+str4.substring(5,6)+str4.substring(0,1)+str4.substring(1,2)+
									str4.substring(2,3)+str4.substring(3,4);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(3,4)+str4.substring(4,5)+str4.substring(5,6)+str4.substring(0,1)+
									str4.substring(1,2)+str4.substring(2,3);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(2,3)+str4.substring(3,4)+str4.substring(4,5)+str4.substring(5,6)+
									str4.substring(0,1)+str4.substring(1,2);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(1,2)+str4.substring(2,3)+str4.substring(3,4)+str4.substring(4,5)+
									str4.substring(5,6)+str4.substring(0,1);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
						}						
						if (len == 7) {
							String originalString = str3.substring(0,1)+str3.substring(1,2)+str3.substring(2,3)+str3.substring(3,4)+
									str3.substring(4,5)+str3.substring(5,6)+str3.substring(6,7);
							String recycledString = str4.substring(6,7)+str4.substring(0,1)+str4.substring(1,2)+str4.substring(2,3)+
									str4.substring(3,4)+str4.substring(4,5)+str4.substring(5,6);
							//System.out.println("recycledString:" + recycledString);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(5,6)+str4.substring(6,7)+str4.substring(0,1)+str4.substring(1,2)+
									str4.substring(2,3)+str4.substring(3,4)+str4.substring(4,5);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(4,5)+str4.substring(5,6)+str4.substring(6,7)+str4.substring(0,1)+
									str4.substring(1,2)+str4.substring(2,3)+str4.substring(3,4);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(3,4)+str4.substring(4,5)+str4.substring(5,6)+str4.substring(6,7)+
									str4.substring(0,1)+str4.substring(1,2)+str4.substring(2,3);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(2,3)+str4.substring(3,4)+str4.substring(4,5)+str4.substring(5,6)+
									str4.substring(6,7)+str4.substring(0,1)+str4.substring(1,2);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
							recycledString = str4.substring(1,2)+str4.substring(2,3)+str4.substring(3,4)+str4.substring(4,5)+
									str4.substring(5,6)+str4.substring(6,7)+str4.substring(0,1);
							if (recycledString.equals(originalString)) { 
								//System.out.println("OriginalString:" + str3 + ",MatchingString:" + str4);
								numSet.add(str3+str4); 
							}
						}						

					}
				}
				System.out.println("TotalCount:" + numSet.size());
				pw.print("Case #" + (ctr) + ": " + numSet.size() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
			pw.close();
		}
	}
	
}
