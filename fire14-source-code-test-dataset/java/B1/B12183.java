import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Run3 {
	public ArrayList<String> read(String name){
		ArrayList<String> data=new ArrayList<String>();

        try{
           BufferedReader br = new BufferedReader(new FileReader("C://codejam/"+name));

           String line = br.readLine();
          
           while(line != null){
                   data.add(line);
                   line = br.readLine();
           }

           br.close();

          
        }catch(Exception e){}
        return data;
	}
	
	public void write(ArrayList<String> data,String name){
		try{
	           BufferedWriter bw = new BufferedWriter(new FileWriter("C://codejam/"+name));
	           
	           for(int i = 0; i < data.size(); i++){
	               bw.write(data.get(i));
	               bw.newLine();
	           }

	           bw.close();
		}catch(Exception e){}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Run3 x= new Run3();
		ArrayList<String >data =new ArrayList<String>();
		ArrayList<String >out =new ArrayList<String>();
		data=x.read("input3.txt");
		for(int i=1;i<=Integer.parseInt(data.get(0));i++){
			String res=x.solve(data.get(i));
			System.out.println(res);
			out.add("Case #"+i+": "+res);
		}
		x.write(out, "output3.txt");
	}

	private String solve(String string) {
		String result="";
		int results=0;
		String[]x=string.split(" ");
		int a=Integer.parseInt(x[0]);
		int b=Integer.parseInt(x[1]);
		for(int i=a;i<b;i++){
			for(int j=i+1;j<=b;j++){
				String temp=""+i;
				for(int k=0;k<temp.length()-1;k++){
					temp+=temp.charAt(0);
					temp=temp.substring(1, temp.length());
					int num=Integer.parseInt(temp);
					if(num==j){
						if((""+num).length()==(""+j).length())
							results++;
					}
				}
				
				
				
			}
			
			
			
		}
		
		
		
		result+=results;
		return result;
	}

}
