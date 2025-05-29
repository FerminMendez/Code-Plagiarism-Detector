import java.io.*;
import java.util.*;

/**
 * */
public class Main {
	
	/**
	 * */
	public class TestCase{
		
		public Integer a, b;
		public Integer[] rNumbers; 
		public Integer iResult=0; 
		public Set<String> setPairs=Collections.synchronizedSet( new HashSet<String>());
		
		/**
		 * @param a
		 * @param b
		 * */
		public TestCase( int a, int b){
			this.a=a;
			this.b=b; 
			this.rNumbers=new Integer[ ( this.b- this.a)+ 1];
			for( int i=this.a; i<=this.b; i++)
				this.rNumbers[ i- this.a]=i; }
		
		/**
		 * */
		public void doSolution(){
			this.iResult=0;
			for( int i=0; i!=this.rNumbers.length; i++){
				Integer number=this.rNumbers[ i];
				String strNumber=String.valueOf( number); 
				if( strNumber.length()>=2){
					for( int s=1; s!=strNumber.length(); s++){
							String strPrefix=strNumber.substring( 0, s); 
							String strSuffix=strNumber.substring( s); 
							String strNewNumber=strSuffix+ strPrefix; 
							Integer newNumber=Integer.valueOf( strNewNumber);
							if(( newNumber>=this.a) && ( newNumber<=this.b) && ( number.compareTo( newNumber)!=0))
								this.addPair( number, newNumber); }}}
			this.iResult=this.setPairs.size(); }
		
		public void addPair( Integer n, Integer m){
			String nm=n+"+"+m; 
			String mn=m+"+"+n; 
			if( !this.setPairs.contains( nm) && !this.setPairs.contains( mn)){
				this.setPairs.add( nm); }}

	}
	public TestCase createTestCase( int a, int b){ return new TestCase( a, b); }	
	
	/**
	 * */
	public static void main( String[] args){

		try {
		
			Main m=new Main();
			LineNumberReader reader=new LineNumberReader( new FileReader( new File( args[ 0].trim())));
			PrintWriter printer=new PrintWriter( new FileWriter( args[ 1].trim()));
			
			int nTestCases=Integer.valueOf( reader.readLine());
			for( int i=0; i!=nTestCases; i++){
				String str[]=reader.readLine().split( " ", 2);
				TestCase testCase=m.createTestCase( Integer.valueOf( str[ 0].trim()), Integer.valueOf( str[ 1].trim())); 
				testCase.doSolution(); 				
				printer.println( "Case #"+( i+ 1)+": "+ testCase.iResult);
				System.out.println( "Case #"+( i+ 1)+": "+ testCase.iResult); }
						
			printer.close();
		
		} catch (FileNotFoundException e) {
		
		e.printStackTrace(); } catch (IOException e) {
		e.printStackTrace(); }}}
