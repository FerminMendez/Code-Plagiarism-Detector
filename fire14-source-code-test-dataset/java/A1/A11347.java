package codejam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 从文本读取输入
 * @author Administrator
 *
 */
public class InOutTool extends ArrayList<String> {
	private String inPath ;
	private String outPath;
	public String outText(String path){
		this.outPath = path;
		return outText();
	}
	public String outText(){
		StringBuffer sb = new StringBuffer();
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(outPath).getAbsoluteFile());
			for(String s:this){
				out.println(s);
				sb.append(s);sb.append("\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=out){
				out.close();
			}
		}
		return sb.toString();
	}
	public String readText(String inPath){
		StringBuffer sb = new StringBuffer();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(new File(inPath).getAbsoluteFile()));
			String s;
			while((s = in.readLine()) != null){
				s = s.trim();
				add(s);//每一行作为ArrayList的一个元素
				sb.append(s);sb.append("\n");
			}
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=in){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	public InOutTool(String inPath,String outPath){
		this.inPath = inPath;this.outPath = outPath;
		readText(inPath);
		if((size()!=0)&&get(0).equals("")) remove(0);
	}
}
