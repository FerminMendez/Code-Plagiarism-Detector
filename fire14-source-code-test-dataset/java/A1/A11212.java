import java.util.ArrayList;

public class DancingWG{
	public static void main(String[] args){
		ArrayList<String> inputs = IOGoogleCodeJam.fileInput(args[0]);
		ArrayList<String> outputs= new ArrayList<String>();
		int lines=Integer.parseInt(inputs.get(0));
		for(int i=1;i<=lines;i++){
			outputs.add(processData(inputs.get(i)));
		}
		IOGoogleCodeJam.resultsOutput(outputs,1);
	}

	public static String processData(String s){
		String aux[] = s.split(" ");
		int N = Integer.parseInt(aux[0]);
		int S = Integer.parseInt(aux[1]);
		int p = Integer.parseInt(aux[2]);
		int c = 0; //count googlers
		for(int i=3;i<aux.length;i++){
			int x = Integer.parseInt(aux[i]);
			int y = 0;
			switch(x%3){
				case 0: y=x/3;
					if(y>=p){
						c++;
					}else if(y>0){//if 0 reach here, it doesn't count
						y=(x+3)/3;
						if(y<=10 && y>=p && S>0){
							c++;
							S--;
						}
					}
					break;
				case 1: y=(x+2)/3;
					if(y>=p){
						c++;//I dont care if there's a surprise here
					}
					break;
				case 2: y=(x+1)/3;
					if(y>=p){
                                        	c++;
                                        }else{
                                                y=(x+4)/3;
                                                if(y<=10 && y>=p && S>0){
                                                	c++;
                                                        S--;
                                                }
                                        }
					break;
			}
		}
		return String.valueOf(c);
	}
}
