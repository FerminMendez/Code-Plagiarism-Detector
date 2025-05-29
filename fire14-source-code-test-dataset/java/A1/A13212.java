import java.util.ArrayList;
import java.util.Arrays;
public class Problem2
{
    public int countResults(String[] nums){
        int googlers = Integer.parseInt(nums[0]);
        int surprising = Integer.parseInt(nums[1]);
        int min = Integer.parseInt(nums[2]);
        int count = 0;
        int[] possible = new int[googlers];
        System.out.println("Min: "+min+", Surprising: "+surprising);
        for(int i = 3; i<nums.length;i++){
            int curr = Integer.parseInt(nums[i]);
            System.out.println("Curr: "+curr);
            if(curr<=1){
                if(min==0){
                    count+=1;
                }
                else if(curr==1&&min==1){
                    count+=1;
                }
                continue;
            }
            switch(curr%3){
                case 0:
                    if(curr/3+1==min){
                        possible[i-3]=1;
                    }
                    else if(curr/3>=min){
                        count+=1;
                    }
                    break;
                case 1:
                    if(curr/3+1>=min){
                        count+=1;
                    }
                    break;
                case 2:
                    if(curr/3+1>=min){
                        count+=1;
                    }
                    else if(curr/3+2>=min){
                        possible[i-3]=1;
                    }
            }
            System.out.println("Count: "+count+", possible: "+possible[i-3]);
        }
        Arrays.sort(possible);
        for(int j=0;j<surprising;j++){
            System.out.println("Switching "+possible[possible.length-1-j]);
            count+=possible[possible.length-1-j];
        }
        System.out.println("Final Count "+count);
        return count;
    }
    public void solve(){
        ReadWriter rw = new ReadWriter();
        ArrayList<String> input = rw.readFile("B-small-attempt0.in");
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
        rw.writeFile(ans, "output2.txt");
    }
}
