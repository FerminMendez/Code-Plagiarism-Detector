public class Runner {
    public static void main(String args[]) throws Exception {
         BaseSolution bs  = (BaseSolution) Class.forName(args[0]).newInstance();
         bs.start(args[1]);
    }
}