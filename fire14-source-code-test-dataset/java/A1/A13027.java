package javaapplication1;
import java.io.*;
public class DancingWithTheGooglers2 {
    public static int numberOfGooglers(int scores[],int s,int minScore){
        int count=0;
        int score=0;
        for(int i=0;i<scores.length;i++){
            score=scores[i];
            int base=(int)score/3;
            switch(score%3){
                case 0: //System.out.println("0score = "+score);
                        if(base>=minScore){
                            count++;
                        }
                        else{
                            if(s>0&&base>0&&(base+1)>=minScore){
                                count++;
                                s--;
                            }
                        }
                    break;
                    
                case 1://System.out.println("1score = "+score);
                    if(base>=minScore||(base+1)>=minScore){
                            count++;
                        }
                        else{
                            if(s>0&&(base+1)>=minScore){
                                count++;
                                s--;
                            }
                    }
                    break;
                case 2://System.out.println("2score = "+score);
                    if((base+1)>=minScore||base>=minScore){
                            count++;
                        }
                        else{
                            if(s>0&&(base+2)>=minScore){
                                count++;
                                s--;
                            }
                        }
                    break;
            }
        }
        return count;
    }
    public static void main(String args[])throws IOException{
        BufferedWriter bw= new BufferedWriter(new FileWriter("c:/codejam/testo.txt"));
        BufferedReader br=new BufferedReader(new FileReader("c:/codejam/B-small-attempt0.in"));
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            String[] str=(br.readLine()).split(" ");
            int n=Integer.parseInt(str[0]);
            int s=Integer.parseInt(str[1]);
            int p=Integer.parseInt(str[2]);
            int arr[]=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=Integer.parseInt(str[j+3]);
                //System.out.println(arr[j]);
            }
            bw.write("Case #"+i+": "+numberOfGooglers(arr,s,p));
            bw.newLine();
        }
        bw.close();
    }
}
