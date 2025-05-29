import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class dancing {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="";
		StringTokenizer strtok;
		
		int googlers, surprises, p, count=0;
		
		int line = 0;
		int totalscore, base, residual;
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader("input"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			
			line = Integer.parseInt(inputStream.readLine());
			for(int i=0; i< line; i++){
				input = inputStream.readLine(); 
				strtok = new StringTokenizer(input," ");
				
				googlers = Integer.parseInt(strtok.nextToken());
				surprises = Integer.parseInt(strtok.nextToken());
				p = Integer.parseInt(strtok.nextToken());
				for(int j=0 ; j< googlers; j++){
					totalscore = Integer.parseInt(strtok.nextToken());
					base = totalscore/3;
					residual = totalscore % 3;
					
					triplet normal,surprise;
					
					if(residual==0){
						//normal
						normal = new triplet(base,base,base);
						//surprising
						surprise = new triplet(base-1,base,base+1);
						
						if(normal.score()>=p)
							count++;
						else if(surprise.status!="invalid" && surprise.score()>=p && surprises > 0){
							count++;
							surprises--;
						}
					}
					else if(residual==1){
						//normal
						normal = new triplet(base,base,base+1);
						//surprising but not helpful
						//new triplet(base-1,base+1,base+1);
						if(normal.score()>=p)
							count++;
					}
					else if(residual==2){
						//normal
						normal = new triplet(base,base+1,base+1);
						//surprising
						surprise = new triplet(base,base,base+2);
						if(normal.score()>=p)
							count++;
						else if(surprise.status!="invalid" && surprise.score()>=p && surprises > 0){
							count++;
							surprises--;
						}
					}
				}//for each googler
				
				//System.out.println("Case #"+(i+1)+": "+count);
				
				if(i!=line-1)
					writer.write("Case #"+(i+1)+": "+count+"\r\n");
				else
					writer.write("Case #"+(i+1)+": "+count);
				count = 0;
				
				
				
			}//read new line
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//main
}












