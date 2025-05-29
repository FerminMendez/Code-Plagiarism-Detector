import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;



public class Executer {

	protected static final String FICHERO_ENTRADA_SHORT = "C-small-attempt0.in";
	protected static final String FICHERO_SALIDA_SHORT = "C-small-attempt0.out";
	protected static final String FICHERO_ENTRADA_LARGE = "C-large-attempt0.in";
	protected static final String FICHERO_SALIDA_LARGE = "C-large-attempt0.out";

	
	/**
	 * @param args
	 */
	public static void main(String[] args){

		TemplateClass test;
		try{
			
			//SHORT VERSION
			test = new Recycled(FICHERO_ENTRADA_SHORT, FICHERO_SALIDA_SHORT);
			//LARGE VERSION
			//test = new Store(FICHERO_ENTRADA_LARGE, FICHERO_SALIDA_LARGE);
			
			test.procesaTestCase();
		}catch (Exception e){
			System.out.println("ERROR");
		}
	
	}
	
}
