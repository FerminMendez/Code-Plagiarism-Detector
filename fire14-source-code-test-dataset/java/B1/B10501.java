import java.io.*;
public class ProblemC {
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("E:\\test.txt"));
            int no;
            no= Integer.parseInt(br.readLine());
            int casen=0,i,j;
            int a,b,count;
            String temp,t,u;
            String output;
            output="";
            String spl[];
            String memory,fp,lp;
            while( casen < no ) {
                temp = br.readLine();
                output += "Case #"+(casen+1)+": ";
                spl = temp.split(" ");
                a = Integer.parseInt(spl[0]);
                b = Integer.parseInt(spl[1]);
                count = 0;
                memory = "";
                for(i=a;i<=b; i++) {
                	t = i+"";
                	for(j=1;j<t.length();j++) {
                		u= t.substring(j);
                		u+= t.substring(0,j);
                		//System.out.println(u);
                		if( !u.startsWith("0") && Integer.parseInt(u) < i && Integer.parseInt(u)<= b && Integer.parseInt(u) >= a)
                		{
                			if( t.length() % 2 == 0 ) {
                				fp= t.substring(0,t.length()/2);
                				lp = t.substring(t.length()/2);
                				if( fp.equals(lp) ) {
                					if(!memory.contains(Integer.parseInt(u)+" "+i)) {
                						count++;
                						memory += Integer.parseInt(u) + " " + i+"\n";
                					}
                				}
                				else {
                					count++;
                				}
                			}
                			else {
                				count++;
                			}
                			/*if( memory.contains(Integer.parseInt(u)+" "+i) )
                				System.out.println(Integer.parseInt(u)+"  "+i);
                			else
                			{
                				count++;
                				memory += Integer.parseInt(u) + " " + i+"\n";
                			}*/
                		}
                	}
                }
                output += count;
                if( casen != no-1 )
                    output += "\n";
                casen++;
            }
            BufferedWriter bw = new BufferedWriter( new FileWriter("E:\\result.txt"));
            bw.write(output);
            bw.close();
            br.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}