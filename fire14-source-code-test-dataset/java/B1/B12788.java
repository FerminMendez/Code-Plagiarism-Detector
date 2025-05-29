import java.util.List;
import java.util.Map;


public class Recycled {
	List<List<List<String>>> input;
	
	public Recycled(List<List<List<String>>> input){
		this.input = input;
	}
	
	public boolean recycled(int n, int m){
		boolean r = false;
		String stringN = Integer.toString(n);
		for(int i = 1; i < stringN.length(); i++){
			String tmp = new String();
			tmp += stringN.substring(i, stringN.length());
			tmp += stringN.substring(0, i);
			if(Integer.parseInt(tmp) == m){
				r = true;
				break;
			}
		}
		return r;
	}
	
	public void solve(){
		for(int i = 0; i < input.size(); i++){
			int cpt = 0;
			int a = Integer.parseInt(input.get(i).get(0).get(0));
			int b = Integer.parseInt(input.get(i).get(0).get(1));
			for(int x = a; x < b; x++){
				for(int y = x + 1; y <= b; y++){
					if(recycled(x, y)) cpt++;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + cpt);
		}
	}
}
