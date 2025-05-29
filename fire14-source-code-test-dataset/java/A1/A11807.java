
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Qualification B
 * @author Cristian Piacente
 */
public class QualificationB {

    public static void main(String args[]) {


        /*for (int i = 20; i < 24; i++) {
            System.out.println("Value:" + i);
            Case c = new Case(i);
            System.out.println(c.isDot0());
            System.out.println(c.isDot33());
            System.out.println(c.isDot66());
            System.out.println("Medium value:" + c.getMediumValue());
            System.out.println("Normal value:" + c.getNormalValue());
            System.out.println("Special value:" + c.getSpecialCaseValue());
        }*/
        try {

            //Read input file and translate

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("c:\\B-small-attempt0.in")));
            BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\output.txt")));
            int ncases = Integer.parseInt(br.readLine());
            for (int ccase = 0; ccase < ncases; ccase++) {
                ArrayList<Case> cases=new ArrayList<Case>();
                String line = br.readLine();
                StringTokenizer st=new StringTokenizer(line," ");
                int googlers=Integer.parseInt(st.nextToken());
                int specialCases=Integer.parseInt(st.nextToken());
                int minVal=Integer.parseInt(st.nextToken());
                int result=0;
                for(int k=0;k<googlers;k++){
                    cases.add(new Case(Integer.parseInt(st.nextToken())));
                }
                Collections.sort(cases, new NormalCaseComparator());
                /*
                 * First find out how many are already ok, and remove them
                 */
                for(int i=0;i<cases.size();i++){
                    Case c = cases.get(i);
                    if(c.getNormalValue()>=minVal){
                        cases.remove(i);
                        result++;
                        i--;
                        continue;
                    }
                }
                /*
                 * Then based on the max num of specialCase explore their special value
                 */
                for(int i=0;i<cases.size() && result<=googlers && specialCases>0;i++){
                    Case c = cases.get(i);
                    if(c.getSpecialCaseValue()>=minVal){
                        cases.remove(i);
                        result++;
                        specialCases--;
                        i--;
                    }
                }
                pw.write("Case #"+(ccase+1)+": "+result+"\r\n");
            }
            br.close();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Qualification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Case {

    boolean dot66 = false;
    boolean dot33 = false;
    boolean dot0 = false;
    private int value = -1;
    private int mediumValue;
    private float mediumFloatValue;

    public Case(int value) {
        this.value = value;
        this.mediumFloatValue=this.value/3f;
        this.mediumValue = (int) Math.floor(this.value / 3f);
        if (this.value / 3f - (int) Math.floor(this.value / 3f) == 0) {
            dot0 = true;
        } else {
            if (this.value / 3f - (int) Math.floor(this.value / 3f) > 0.4f) {
                dot66 = true;
            } else {
                dot33 = true;
            }
        }
    }

    public boolean isDot0() {
        return dot0;
    }

    public boolean isDot33() {
        return dot33;
    }

    public boolean isDot66() {
        return dot66;
    }

    public int getMediumValue() {
        return mediumValue;
    }

    public void setMediumValue(int mediumValue) {
        this.mediumValue = mediumValue;
    }

    public int getNormalValue() {
        if(this.value==0){
            return 0;
        }
        if (isDot0()) {
            return mediumValue;
        } else {
            if (isDot66()) {
                return mediumValue + 1;
            } else {
                return mediumValue + 1;
            }
        }
    }

    public int getSpecialCaseValue() {
        if(this.value==0){
            return 0;
        }
        if (isDot0()) {
            return mediumValue + 1;
        } else {
            if (isDot66()) {
                return mediumValue + 2;
            } else {
                return mediumValue + 1;
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float getMediumFloatValue() {
        return mediumFloatValue;
    }
}
class NormalCaseComparator implements Comparator<Case>{

    @Override
    public int compare(Case o1, Case o2) {
        if(o1.getNormalValue()==o2.getNormalValue()){
            return 0;
        }
        else{
            if(o1.getNormalValue()>o2.getNormalValue()){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
}
class SpecialCaseComparator implements Comparator<Case>{

    @Override
    public int compare(Case o1, Case o2) {
        if(o1.getSpecialCaseValue()==o2.getSpecialCaseValue()){
            return 0;
        }
        else{
            if(o1.getSpecialCaseValue()>o2.getSpecialCaseValue()){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
}