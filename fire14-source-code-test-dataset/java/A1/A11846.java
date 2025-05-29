
import java.io.FileNotFoundException;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amya
 */
public class Dancing {
      public static void main(String args[]) throws FileNotFoundException{    
        List<String> lines = FileUtil.readFileByLine("input1");
        int records = Integer.parseInt(lines.get(0));
        int numOfGooglers = 0;
        int numOfSurprises = 0;
        int bestScore = 0;
        String[] nums = null;
        int eligiblesWithSurprise = 0;
        int eligiblesWithoutSurprise = 0;
        int onBorder = 0;
        int finalEligibles = 0;
        for(int i = 1; i<=records; i++){
            nums = lines.get(i).split(" ");
            numOfGooglers = Integer.parseInt(nums[0]);
            numOfSurprises = Integer.parseInt(nums[1]);
            bestScore = Integer.parseInt(nums[2]);
            for(int j=3 ; j<nums.length; j++){
                if(Integer.parseInt(nums[j])>=bestScore){
                    if(Integer.parseInt(nums[j])>=(bestScore*3 - 4)){
                        eligiblesWithSurprise ++;
                    }
                    if(Integer.parseInt(nums[j])>=(bestScore*3 - 2)){
                        eligiblesWithoutSurprise ++;
                    }
                }
            }
            
            finalEligibles = eligiblesWithoutSurprise;
            
            onBorder = eligiblesWithSurprise - eligiblesWithoutSurprise;
            if(onBorder > numOfSurprises){
                finalEligibles += numOfSurprises;
            }else{
                finalEligibles += onBorder;
            }
            
            if(i == records)
                FileUtil.writeOutput("Case #"+i+": "+finalEligibles, true);
            else
                FileUtil.writeOutput("Case #"+i+": "+finalEligibles, false);
            
            eligiblesWithSurprise = 0;
            eligiblesWithoutSurprise = 0;
        }
      }
}
