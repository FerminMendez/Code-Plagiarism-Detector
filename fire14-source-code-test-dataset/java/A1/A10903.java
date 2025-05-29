import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class qb {

	public static void main(String [] args)
	{
		String fileName = "B-small-attempt4.in";
		
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("output.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line="";
			int count = 0;
			while((line=br.readLine())!=null)
			{
				if(count == 0)
				{
					count++;					
					continue;
				}
				String [] sp = line.split(" ");
				
				int [] rule = new int[3];	//rule 3개를 집어넣음. 1.사람수, 2.서프라이징 갯수. 3.맥스점수				
				for(int i=0; i<3; i++)
					rule[i] = Integer.parseInt(sp[i]);

				
				int [] player = new int[sp.length-3];	//나머지 뒤에 값들이 플레이어 점수이므로 늠.
				int [] playerScore = new int[player.length*3];	//한사람당 세명의 심사위원 평가 점수
				for(int i=0; i<player.length; i++)
					player[i] = Integer.parseInt(sp[i+3]);					
				
				for(int i=0; i<player.length; i++)		//스코어 분배
				{
					if(player[i] % 3 == 0)
					{
						for(int j=0; j<3; j++)
						{
							playerScore[i*3] = player[i]/3;
							playerScore[i*3+1] = player[i]/3;
							playerScore[i*3+2] = player[i]/3;
						}
					}
					else if(player[i] % 3 == 1)
					{
						for(int j=0; j<3; j++)
						{
							playerScore[i*3] = player[i]/3+1;
							playerScore[i*3+1] = player[i]/3;
							playerScore[i*3+2] = player[i]/3;
						}						
						
					}
					else if(player[i] % 3 == 2)
					{
						for(int j=0; j<3; j++)
						{
							playerScore[i*3] = player[i]/3+1;
							playerScore[i*3+1] = player[i]/3+1;
							playerScore[i*3+2] = player[i]/3;
						}						
					}					
				}
				
				int nPlayerOverMax = 0;	
				int nPlayerCanSup = 0;
				int solution = 0;
				for(int i=0; i<player.length; i++) //검출식
				{
					if(rule[2]*3-3 < player[i])
						nPlayerOverMax++;
					else 
					{
						if(rule[2] < player[i] )
						{
							if(player[i] % 3 == 0 || player[i] %3 == 2)
							{
								
								if((playerScore[i*3]) +1 >= rule[2])
								{
									nPlayerCanSup++;
								}
							}
							else
							{
								if((playerScore[i*3]) >= rule[2])
									nPlayerCanSup++;
							}
								
						}
					}
				}
				if(nPlayerCanSup >= rule[1])
					solution = nPlayerOverMax + rule[1];
				else
					solution = nPlayerOverMax + nPlayerCanSup;
				
				if(solution > rule[0])
					solution = rule[0];
				
				bw.write("Case #"+count+": "+solution);
				bw.write("\n");
				count++;
			}
			
			bw.close();
			fw.close();
			br.close();
			fr.close();
			
				
		}catch(Exception EE)
		{
			EE.printStackTrace();
		}
		
		
	}
	
}
