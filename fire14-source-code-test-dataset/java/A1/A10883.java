import java.util.ArrayList;
import java.util.List;


public class Dancers implements Solver {
	int N;
	int S;
	int p;
	List<Integer> dan = new ArrayList<Integer>();
	

	public Dancers(List<String> lineas) {
		String[] cosa = lineas.get(0).split(" ");
		N=Integer.parseInt(cosa[0]);
		S=Integer.parseInt(cosa[1]);
		p=Integer.parseInt(cosa[2]);
		for (int i=0; i<N; i++){
			dan.add(Integer.parseInt(cosa[i+3]));
		}
		// TODO Auto-generated constructor stub
	}


	@Override
	public String solve() {
		int conta=0;
		for (int i=0; i<N; i++){
			if (dan.get(i)>=p+p-1+p-1 && dan.get(i)>=p){
				conta++;
			}
			else if(dan.get(i)>=p+p-2+p-2 && dan.get(i)>=p && S>0){
				conta++;
				S--;
			}
		}
		// TODO Auto-generated method stub
		return conta+"";
	}

}
