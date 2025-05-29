package main;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.io.Files;

public class Recycle2 {
	public static void main(String[] args) throws IOException{
		final JFileChooser fc = new JFileChooser(new File("C:\\Users\\munsey\\Documents\\jam"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			List<String> lines = Files.readLines(file, Charsets.UTF_8);
			Iterator<String> itr = lines.iterator();
			itr.next();
			int caseNum = 0;
			while(itr.hasNext()) {
				caseNum++;
				Iterator<String> minMax = Splitter.on(" ").split(itr.next()).iterator();

				int min = Integer.parseInt(minMax.next());
				int max = Integer.parseInt(minMax.next());
				
				int size = 0;
				for(int k = min; k <= max ; k++){
					size += recycle(k, min, max);
				}
				System.out.println("Case #" + caseNum + ": " + (size/2));
			}
		}
	}
	
	public static int recycle(int input, int min, int max){
		Set<Integer> output = new HashSet<Integer>();
		String sInput = Integer.valueOf(input).toString();
		StringBuffer build;
		for(int i = 0; i < sInput.length(); i++){
			build = new StringBuffer();
			for(int j = 0; j < sInput.length(); j++){
				build.append(sInput.charAt((i + j) % sInput.length()));
			}
			if(build.charAt(0) != 0 && !build.toString().equals(sInput)){
				int x = Integer.parseInt(build.toString());
				if(x >= min && x <= max){
					output.add(x);
				}
			}
		}
		return output.size();
	}
}
