import java.util.HashSet;


public class Recycler implements Runnable{
	
	private int start,end;
	private HashSet<String> set;
	
	public Recycler(int first,int second){
		start=first;
		end=second;
		set=new HashSet<String>();
	}
	
	public void run(){
		for(int i=start;i<=end;i++){
			recycle(i);
		}
	}
	
	private void recycle(int num){
		String temp=String.valueOf(num);
		int length=temp.length();
		for(int i=length-1;i>0;i--){
			String temp2=temp.substring(i)+temp.substring(0,i);
			int num2=Integer.parseInt(temp2);
			if(num<num2 && num2<=end){
				set.add(num+""+num2);
				//System.out.println(temp+" "+temp2+" "+set.size());
			}
			//System.out.println(temp+" "+temp2+" "+set.size());
			
		}
	}
	public int getCount() {
		return set.size();
	}
}
