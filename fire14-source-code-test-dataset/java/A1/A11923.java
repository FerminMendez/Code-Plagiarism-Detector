import java.io.*;
import java.util.*;

public class Main {

	public static Map<Integer, Integer> mapMax=Collections.synchronizedMap( new HashMap<Integer, Integer>());
	public static Map<Integer, Integer> mapSurprisingMax=Collections.synchronizedMap( new HashMap<Integer, Integer>());
	
	/**
	 * */
	public static double getFactor( int n){
		double nFactor=( double) 1;
		for( int i=1; i<=n; i++)
			nFactor*=i; 
		return nFactor; }
	
	/**
	 * */
	public static double getCombinations( int nData, int nItems){
		return getFactor( nData)/ ( getFactor( nData- nItems)* getFactor( nItems)); }
	
	/**
	 * */
	/**@class Combination
	 * */
	public class Combination{
		public Integer lastElement=0;
		public Set<Integer> setItems=Collections.synchronizedSet( new HashSet<Integer>());
		/***/
		public Combination(){}
		public Combination( Combination src){
			this.lastElement=src.lastElement;
			this.setItems.addAll( src.setItems); }
		public void addItem( Integer item){
			this.lastElement=item;  
			this.setItems.add( this.lastElement); }}
	
	/**@class Combinator
	 * */
	public class Combinator{
		
		public Integer[] rItems;
		
		/**@param nItems
		 * */
		public Combinator( int nItems){
			this.rItems=new Integer[ nItems];
			for( int i=0; i!=this.rItems.length; i++) 
				this.rItems[ i]=i; }
		
		/**@param nSubitems
		 * */
		public double countCombinations( int nSubitems){
			return Main.getCombinations( this.rItems.length, nSubitems);  }

		/**@
		 * */
		private Set<Combination> _getCombinations( Set<Combination> srcCombinations, int nSubitems){
			Set<Combination> setCombinations=Collections.synchronizedSet( new HashSet<Combination>());
			Iterator<Combination> iter=srcCombinations.iterator();
			while( iter.hasNext()){
				Combination srcCombination=iter.next(); 
				if( srcCombination.setItems.size()==nSubitems){
					setCombinations.add( srcCombination); 
				}else{					
					Set<Combination> setSubitems=Collections.synchronizedSet( new HashSet<Combination>());
					for( int i=0; i!=this.rItems.length; i++){
						Combination combination=new Combination( srcCombination);
						if( this.rItems[ i]> combination.lastElement){
							combination.addItem( this.rItems[ i]);
							setSubitems.add( combination); }}					
					setCombinations.addAll( this._getCombinations( setSubitems, nSubitems)); 	}}
			return setCombinations; }
				
		/**@param nSubitems
		 * */
		public Set<Combination> getCombinations( int nSubitems){
			Set<Combination> setCombinations=Collections.synchronizedSet( new HashSet<Combination>());
			double nCombinations=this.countCombinations( nSubitems); 
			if( nCombinations>0){				
				for( int i=0; i!=this.rItems.length; i++){
					Combination combination=new Combination();
					combination.addItem( this.rItems[ i]); 
					setCombinations.add( combination); }
				return this._getCombinations( setCombinations, nSubitems); }
			return setCombinations; }}
	
	/**
	 * */
	public class TestCase{
		
		public Integer id, n, s, p; 
		public Integer iResult=0;
		public Integer[] rPoints; 
		/***/
		public TestCase( Integer id, Integer n, Integer s, Integer p, Integer[] rPoints){
			this.id=id; 
			this.n=n; 
			this.s=s; 
			this.p=p; 
			this.rPoints=Arrays.copyOf( rPoints, rPoints.length); }
		
		/***/
		public void doSolution(){
			this.iResult=0;
			if( this.s==0){
				for( int i=0; i!=this.rPoints.length; i++){
					if( Main.mapMax.get( this.rPoints[ i])>=this.p)
						this.iResult++; }				
			}else{
				/***/
				Combinator combinator=new Combinator( this.n); 
				Set<Combination> setCombinations=combinator.getCombinations( this.s);
				Iterator<Combination> iterCombination=setCombinations.iterator();
				while( iterCombination.hasNext()){
					Combination combination=iterCombination.next();
					this.iResult=Math.max( this.iResult, 
							this.doCombination( combination)); }}}
		
		public Integer doCombination( Combination combination){
			Integer iResult=0;
			for( int i=0; i!=this.rPoints.length; i++){
				Integer max=( combination.setItems.contains( i))? Main.mapSurprisingMax.get( this.rPoints[ i]): 
					Main.mapMax.get( this.rPoints[ i]);
				if( max>=this.p)
					iResult++; }
			return iResult; }
	}	
	public TestCase createTestCase( Integer id, Integer n, Integer s, Integer p, Integer[] rPoints){
		return new TestCase( id, n, s, p, rPoints); } 
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			Main m=new Main();
			LineNumberReader reader=new LineNumberReader( new FileReader( new File( args[ 0].trim())));
			PrintWriter printer=new PrintWriter( new FileWriter( args[ 1].trim()));
			
				
			/** ScoreMaps */
			for( int i0=0; i0<=10; i0++){
				for( int i1=0; i1<=10; i1++){
					for( int i2=0; i2<=10; i2++){
						Integer maxScore=Math.max( i0, Math.max( i1, i2)); 
						if( ( Math.abs( i0- i1)<= 2) && ( Math.abs( i0- i2)<= 2) && ( Math.abs( i1- i2)<= 2)){
							Integer nSum=i0+ i1+ i2;
							// Not surprising score. 
							if( !(( Math.abs( i0- i1)==2) ||  ( Math.abs( i0- i2)==2) || ( Math.abs( i1- i2)==2))){
								if( !Main.mapMax.containsKey( nSum)){
									Main.mapMax.put( nSum, maxScore); }					
								Main.mapMax.put( nSum, Math.max( Main.mapMax.get( nSum), maxScore)); }
							// Surprising Score. 
							if( !Main.mapSurprisingMax.containsKey( nSum)){
								Main.mapSurprisingMax.put( nSum, maxScore); }					
							Main.mapSurprisingMax.put( nSum, Math.max( Main.mapSurprisingMax.get( nSum), maxScore)); }}}}

			/***/
			int nTestCases=Integer.valueOf( reader.readLine().trim());
			for( int n=0; n!=nTestCases; n++){
				String str[]=reader.readLine().split( " ");
				Integer[] rPoints=new Integer[ str.length- 3];
				for( int i=3; i!=str.length; i++)
					rPoints[ i- 3]=Integer.valueOf( str[ i].trim()); 
				TestCase testCase=m.createTestCase( n+ 1, 
						Integer.valueOf( str[ 0].trim()), 
						Integer.valueOf( str[ 1].trim()), Integer.valueOf( str[ 2].trim()), rPoints);				
				testCase.doSolution();				
				printer.println( "Case #"+ testCase.id+": "+ testCase.iResult);
				System.out.println( "Case #"+ testCase.id+": "+ testCase.iResult); }
			
			printer.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace(); } 
		catch (IOException e) {
			e.printStackTrace(); }}}
