import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Pl_C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"C:\\Users\\Administrator\\Desktop\\CodeJam\\C-small-attempt0.in"));
			String[] line = new String[Integer.parseInt(bf.readLine())];
			String [] answer =new String [line.length];
			int numberOutput=0;
			for (int i = 0; i < line.length; i++) {
				line[i] = bf.readLine();
				answer[i]="Case #"+(i+1)+":";
				
			}
			for(int i=0;i<line.length;i++){				
				String []data =line[i].split(" ");
				int start=Integer.parseInt(data[0]);				
				int end=Integer.parseInt(data[1]);
				
				ArrayList<String> blackList=new ArrayList<String>();
				int count=0;
				for(int j=start;j<=end;j++){
					String b1=addZero(data[1].length()-(j+"").length())+""+j;
					
					ArrayList<String> sam=new ArrayList<String>();
					addSample(b1, sam);
					for(int k=0;k<sam.size();k++){
						int key=Integer.parseInt(sam.get(k));						
						if(key>=start&&key<=end&&inBlackL(b1+" "+sam.get(k), blackList)==false&&Integer.parseInt(b1)!=Integer.parseInt(sam.get(k))){
						//System.out.println(b1+" "+sam.get(k));
						count++;
						//System.out.println("Count= "+count);
						blackList.add(sam.get(k)+" "+b1);

							
						}
						
					}
					
					
				}
				answer[numberOutput]=answer[numberOutput]+" "+count;
				numberOutput++;
				
				
			}
			for(int i=0;i<answer.length;i++){
				System.out.println(answer[i]);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

	}public static String addZero(int n){
		String box="";
		for(int i=0;i<n;i++){
			box+="0";
		}
		return box;
	}
	public static Boolean match(String a,String b){
		String [] key1slot=a.split(" ");
		String [] key2slot=b.split(" ");
		boolean check1=false,check2=false;
		if(key1slot[0].equals(key2slot[1])){
			check1=true;
		}
		if(key1slot[1].equals(key2slot[0])){
			check2=true;
		}
		if(check1==true&&check2==true){
			return true;
		}else{
			return false;
		}		
	}public static Boolean inBlacnList(String key,ArrayList<String> b){
		boolean check=false;
		for(int i=0;i<b.size();i++){
			if(key.equals(b.get(i))){
				check=true;
			}
		}
		return check;
	}
	public static Boolean inBlackL(String key,ArrayList<String> b){
		boolean check=false;
		String []keySlot=key.split(" ");
		boolean check2=false,check3=false,check4=false;
		for(int i=0;i<b.size();i++){
			String []slot=b.get(i).split(" ");
			if(keySlot[0].equals(slot[0])&&keySlot[1].equals(slot[1])){
				check2=true;
			}else if(keySlot[0].equals(slot[1])&&keySlot[1].equals(slot[0])){
				check3=true;
			}else if(keySlot[1].equals(slot[0])&&keySlot[0].equals(slot[1])){
				check4=true;
			}
			
		}
		if(check2==false&&check3==false&&check4==false){
			check=false;
		}else{
			check=true;
		}
		return check;
	}
	public static void addSample(String a,ArrayList<String> sample){
		for(int j=0;j<a.length()-1;j++){
			String aNew="";
			aNew=a.substring(a.length()-1);
			for(int i=0;i<a.length()-1;i++){			
				aNew=aNew+""+a.charAt(i);
			}
			sample.add(aNew);
			a=aNew;
			}
	}

}
