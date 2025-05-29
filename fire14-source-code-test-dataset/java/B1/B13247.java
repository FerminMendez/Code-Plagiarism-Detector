import java.util.ArrayList;
import java.util.Arrays;
public class Problem3
{
    public void solve(){
        ReadWriter rw = new ReadWriter();
        ArrayList<String> input = rw.readFile("C-small-attempt0.in");
        ArrayList<String> ans = new ArrayList<String>();
        int num;
        boolean first = true;
        int count=0;
        for(String s : input){
            if(first){
                num=Integer.parseInt(s);
                first=false;
            }
            else{
                String[] nums = s.split(" ");
                ans.add("Case #"+count+": "+countResults(nums));
            }
            count++;
        }
        rw.writeFile(ans, "output3.txt");
    }
    public int countResults(String[] nums){
        ArrayList<String> checked = new ArrayList<String>();
        int min = Integer.parseInt(nums[0]);
        int max = Integer.parseInt(nums[1]);
        int temp = min;
        int count=0;
        while(temp<max){
            String s = ""+temp;
            for(int i = 0;i<s.length();i++){
                if(s.substring(i,i+1).equals("0")){
                    continue;
                }
                String x = s.substring(i,s.length())+s.substring(0,i);
                
                int comp = Integer.parseInt(x);
                if(comp>temp&&comp<=max&&checked.indexOf(""+temp+" "+x)==-1){
                    count++;
                    System.out.println(""+temp+" "+comp);
                    checked.add(""+temp+" "+x);
                }
            }
            temp++;
        }
        return count;
    }
}
