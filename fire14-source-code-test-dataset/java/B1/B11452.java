
public class ProbQ3 {
	public static void main(String[] args) {

		String fileContent = CodeJamTools.readFileAsString("c:\\temp\\inputQ3.txt");
		String[] rows = fileContent.split("\\n");
		int T = new Integer(rows[0]);
		String output = "";

		int counter = 1;

		for (int i=0; i<T; i++) {
			System.out.println(rows[counter]);
                        long[] data = CodeJamTools.readLongsFromRow(rows[counter]);
			counter++;

                        long A = data[0];
                        long B = data[1];

                        long c = 0;

                        for (long j=A; j<B; j++) {
                            for (long k=j+1; k<=B; k++) {
                                c += isValid(j,k);
                            }
                        }

			output += "Case #"+(i+1)+": ";
			output += c;
                        output += "\n";
		}

		System.out.print(output);
		CodeJamTools.writeStringToFile("C:\\Users\\Conny\\Documents\\conny\\own files\\java_workspace\\codejam2\\src\\outputQ3.txt", output);
	}


        private static long isValid(long n, long m) {
            String ns = ""+n;
            String ms = ""+m;
            for (int i=1; i<ns.length(); i++) {
                if (ns.equals(ms.substring(i)+ms.substring(0,i))) {
                    return 1;
                }
            }
            return 0;
        }
}
