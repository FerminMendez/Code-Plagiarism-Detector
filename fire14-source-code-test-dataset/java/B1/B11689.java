
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String args[]) {
        {
            FileWriter fostream = null;
            FileInputStream fis = null;
            DataInputStream in = null;
            BufferedReader br = null;
            BufferedWriter bw = null;
            int count = 0;

            int testCase;

           
            ArrayList<Integer> a;
            try {

                fis = new FileInputStream("src\\io\\C-small-attempt1.in");
                //fis = new FileInputStream("src\\io\\C-large-attempt0.in");
                //fis = new FileInputStream("src\\io\\C-small-practice.txt");
                in = new DataInputStream(fis);
                br = new BufferedReader(new InputStreamReader(in));

                fostream = new FileWriter("src\\io\\C-out-small2.txt", false);
               // fostream = new FileWriter("src\\io\\C-out-large.txt", false);
                bw = new BufferedWriter(fostream);
                StringBuffer str, res = new StringBuffer();
                String temp,n ;
                boolean flag;
                char c[],check;
                testCase = Integer.parseInt(br.readLine());
                for (int i = 1; i <= testCase; i++) {
                    
                    a = new ArrayList<Integer>();
                    String input[] = br.readLine().split(" ");
                    str = new StringBuffer();
                    int A = Integer.parseInt(input[0]);
                    int B = Integer.parseInt(input[1]);
                    int total = 0;
                    for (int j = A; j <= B; j++) {
                        //  System.out.println("number " + j);

                        n= String.valueOf(j);
                        flag = true;
                        c = n.toCharArray();
                        check = c[0];
                        for (int p = 1; p < c.length; p++) {
                            if (c[p] == check) {
                                continue;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) {
                            for (int l = 1; l < c.length; l++) {
                                str = new StringBuffer();
                                for (int k = 0, m = (l % c.length); k < c.length; k++) {
                                    //System.out.print(m);
                                    str.append(c[m]);
                                    m = ((m + 1) % c.length);

                                }

                                temp = str.toString();

                                temp = temp.replaceFirst("^0*", "");

                                //System.out.println(temp);
                                if (Integer.parseInt(temp) >= A && Integer.parseInt(temp) <= B) {
                                    //   System.out.println(j + " "+temp);
                                        a.add(j);
                                        a.add(Integer.parseInt(temp));
                                        
/*                                        if(s.contains(j)){
                                                System.out.print(true + " "+ count+" ");
                                                count++;
                                            }else{
                                                s.add(j); 
                                            }
                                            if(s.contains(Integer.parseInt(temp))){
                                               // System.out.print(true);
                                                //count++;
                                            }
                                            else{
                                            s.add(Integer.parseInt(temp));
                                            }
                  */                  
                                }
                                
                                str = new StringBuffer();
                            }


                        }
                        str = null;



                    }


                    //System.out.println(s.size() / 2);
                        Collections.sort(a);
                        count= 0;
                        for(int q=0;q<a.size();q++){
                            int diff = a.lastIndexOf(a.get(q))-a.indexOf(a.get(q));
                            //System.out.println(diff);
                            count += (diff+1)/2;
                            q = a.lastIndexOf(a.get(q));
                            //q += diff;
                            
                        }
                      //  System.out.println(count/2);
                       
                    if (i == testCase) {
                        bw.write("Case #" + i + ": " + count / 2);
                        bw.flush();
                    } else {
                        bw.write("Case #" + i + ": " + count / 2 + "\n");
                        bw.flush();
                    }
                count =0;
                }
              //  System.out.println();
            //    System.out.println(a.size());
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            } finally {
                try {
                    fostream.close();
                    fis.close();
                    br.close();

                } catch (IOException ex) {
                }
            }
        }
    }
}
