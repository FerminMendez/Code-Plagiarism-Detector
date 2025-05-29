/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Conny
 */
public class ProbQ2 {
	public static void main(String[] args) {

		String fileContent = CodeJamTools.readFileAsString("c:\\temp\\inputQ2.txt");
		String[] rows = fileContent.split("\\n");
		int T = new Integer(rows[0]);
		String output = "";

		int counter = 1;

		for (int i=0; i<T; i++) {
			System.out.println(rows[counter]);
                        long[] data = CodeJamTools.readLongsFromRow(rows[counter]);
			counter++;

                        long Ni = data[0];
                        long p = data[2];
                        long S = data[1];

                        long limit1 = Math.max(1,3*p-4);
                        long limit2 = 3*p-2;

                        long overs = 0;
                        long borderlines = 0;
                        for (int j=3; j<data.length; j++) {
                            if (data[j] >= limit2)
                                overs++;
                            else if (data[j] >= limit1)
                                borderlines++;
                        }

			output += "Case #"+(i+1)+": ";
			output += (overs+Math.min(borderlines, S));
                        output += "\n";
		}

		System.out.print(output);
		CodeJamTools.writeStringToFile("C:\\Users\\Conny\\Documents\\conny\\own files\\java_workspace\\codejam2\\src\\outputQ2.txt", output);
	}

}
