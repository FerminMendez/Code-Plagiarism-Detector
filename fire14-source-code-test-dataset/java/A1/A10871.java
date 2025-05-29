/**
 * Created by IntelliJ IDEA.
 * User: Manish
 * Date: 4/14/12
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class CodeJamProblemB {
    public static void main(String args[]) throws Exception {
        String inputPath ="C:\\\\Users\\\\Manish\\\\IdeaProjects\\\\Codejam\\\\src\\\\B-small-attempt0.in";
        String outputPath ="C:\\\\Users\\\\Manish\\\\IdeaProjects\\\\Codejam\\\\src\\\\B-small.out";
        CodeJamProblemB problemB = new CodeJamProblemB();
        String[] str = problemB.readFromFile(inputPath);
        str = problemB.solution(str);
        problemB.writeToFile(outputPath, str);
    }

    private String[] solution(String[] str){
        String[] strNew = new String[str.length-1];
        for(int i=0; i<strNew.length; i++){
            strNew[i] = "Case #" +(i+1)+ ": " + find(str[i + 1]);
        }
        return strNew;
    }

    public int find(String str){
        String s1[] = str.split(" ");
        int n = Integer.parseInt(s1[0]);
        int s = Integer.parseInt(s1[1]);
        int p = Integer.parseInt(s1[2]);
        int y=0;
        int[] t = new int[n];
        for(int i=0; i<n; i++){
            t[i] = Integer.parseInt(s1[i+3]);
        }
        Arrays.sort(t);
        for(int x : t){
            int max1=0;
            int max2=0;
            if(x < 2){
                max1=max2=x;
            }
            else if(x==2){
                max1=1;
                if(s > 0){
                    max2=2;
                }
                if(max2 >= p){
                    s--;
                }
            }
            else if(x%3 == 0){
                max1 = x/3;
                if(s > 0 && max1<p){
                    max2 = x/3 + 1;
                    if(max2 >= p){
                        s--;
                    }

                }
            }
            else if(x%3 == 1){
                max1 = x/3 + 1;
            }
            else{
                max1 = x/3 + 1;
                if(s > 0 && (x/3 + 2) <= 10 && max1<p){
                    max2 = x/3 + 2;
                    if(max2 >= p){
                        s--;
                    }
                }
            }
            if(max1>=p || max2>=p){
                y++;
            }
        }

        return y;
    }



    public String[] readFromFile(String inputPath) throws FileNotFoundException,IOException {
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        ArrayList<String> strArrList = new ArrayList<String>();
        try{
            fis = new FileInputStream(inputPath);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                strArrList.add(strLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if (br != null) {
                    br.close();
                }
                if (dis != null) {
                    dis.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return strArrList.toArray(new String[strArrList.size()]);
    }

    public void writeToFile(String outputPath, String[] strArr) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(outputPath));

            for(int i=0; i<strArr.length; i++){
                bw.write(strArr[i]);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
