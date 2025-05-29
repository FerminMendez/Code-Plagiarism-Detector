package com.google.codejam.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeJamOutputFile extends File {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6971460798309687528L;
	private FileWriter writer;
	private Boolean caseZero = false;
	
	public CodeJamOutputFile(String pathname) {
		super(pathname);
		
		try {
			this.setWriter();
		} catch (IOException e) {
		}
	}

	private void setWriter() throws IOException {
		this.writer = new FileWriter(this);
		
	}

	public FileWriter getWriter() {
		return writer;
	}
	
	public void writeCase(int caseId, String result){
		if(caseId == 0){
			caseZero = true;
		}
		
		caseId = caseZero ? caseId + 1 : caseId;
		
		try {
			writer.write("Case #"+(caseId) +": " + result + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
