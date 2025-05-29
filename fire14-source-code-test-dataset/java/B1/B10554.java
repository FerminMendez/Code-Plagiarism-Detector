import java.io.*;
import java.util.HashMap;
class probC{
	public static void main(String[] args){
		Code b=new Code();
	}
}
class Code{
	public Code(){
		try {
			FileWriter fstream = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			File fin = new File("C-small-attempt0.in");
			FileReader fr = new FileReader(fin);
			BufferedReader reader = new BufferedReader(fr);

			int t = Integer.parseInt(reader.readLine());

			for (int qq=0;qq<t;qq++){
				String soal=reader.readLine();
				int jwb=0;

				String[] agg=soal.split(" ");
				int awal=Integer.parseInt(agg[0]);
				int akhir=Integer.parseInt(agg[1]);

				for (int i=awal;i<=akhir;i++){
					for (int j=i+1;j<=akhir;j++){
						if (isRecycled(i,j)){
							jwb++;
						}
					}
				}

				out.write("Case #"+(qq+1)+": "+jwb+"\n");
			}

			reader.close();
			out.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
        }
	}
	public boolean isRecycled(int q,int w){
		boolean hsl=false;
		String a=q+"";
		String b=w+"";
		int pjg=a.length();

		for (int i=0;i<pjg;i++){
			if (a.equals(b)){
				return true;
			} else {
				b=b.substring(1)+b.charAt(0);
			}
		}

		return hsl;
	}
}