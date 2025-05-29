public class Googler {
	int total;
	boolean prizeSurprise = false;
	boolean prizeNoSurprise = false;
	boolean failSurprise = false;
	boolean failNoSurprise = false;
	boolean used = false;
	int trueCounter = 0;

	public Googler poss(int total, int prize){
		this.used = false;
		this.total = total;
		for (int i=10; i>-1; i--){
			if (total>=i){
				int twoA = total - (2*i);
				if (twoA >=0 && twoA<= i){
					if (twoA == i || twoA == i-1){
						if (i>=prize){
							if (prizeNoSurprise == false){trueCounter++;}
							prizeNoSurprise = true;
						} else {
							if (failNoSurprise == false){trueCounter++;}
							failNoSurprise = true;
						}
					}
					if (twoA == i-2){
						if (i>=prize){
							if (prizeSurprise == false){trueCounter++;}
							prizeSurprise = true;
						} else {
							if (failSurprise == false){trueCounter++;}
							failSurprise = true;
						}
					}
				}
				int oneA = total - i - (i-1);
				if (oneA >=0 && oneA<= i){
					if (oneA == i ||oneA == i-1){
						if (i>=prize){
							if (prizeNoSurprise == false){trueCounter++;}
							prizeNoSurprise = true;
						} else {
							if (failNoSurprise == false){trueCounter++;}
							failNoSurprise = true;
						}
					}
					if (oneA == i-2){
						if (i>=prize){
							if (prizeSurprise == false){trueCounter++;}
							prizeSurprise = true;
						} else {
							if (failSurprise == false){trueCounter++;}
							failSurprise = true;
						}
					}
				}
				int splitA = total - i - (i-2);
				if (splitA >=0 && oneA<= i){
					if (splitA == i ||oneA == i-1 || splitA== i-2){
						if (i>=prize){
							if (prizeSurprise == false){trueCounter++;}
							prizeSurprise = true;
						} else {
							if (failSurprise == false){trueCounter++;}
							failSurprise = true;
						}
					}
				}
			}
		}
		return this;
	}
	
}
