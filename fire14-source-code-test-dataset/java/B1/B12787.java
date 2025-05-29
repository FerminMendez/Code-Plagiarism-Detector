import java.io.FileNotFoundException;


public class main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Parser parser = new Parser(args[0]);
		Recycled recycled = new Recycled(parser.parse(1));
		recycled.solve();
	}

}
