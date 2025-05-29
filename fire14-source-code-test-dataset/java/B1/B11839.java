package info.m3o.gcj2012.recyclednumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileLoader {


	protected File infile;

	protected List<String> rawInputLines;

    public List<String> getRawInputLines() {
        if (rawInputLines == null) {
        	rawInputLines = new ArrayList<String>();
        }
        return this.rawInputLines;
    }



	InputFileLoader(String infilepath) {
		infile = new File(infilepath);
		assert infile.canRead() == true : "File " + infilepath
				+ " is not readable.";
	}


	public void readInputFile() {
		assert infile != null : "Infile is null.";
		assert infile.canRead() == true;
		
		FileReader fr;
		BufferedReader br;
		String str;
		if (infile.canRead()) {
			try {
				fr = new FileReader(infile);
				br = new BufferedReader(fr);
				str = br.readLine();
				while (str != null) {
					this.getRawInputLines().add(str);
					str = br.readLine();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
	}

}
