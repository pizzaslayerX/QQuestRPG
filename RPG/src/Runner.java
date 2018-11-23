import Run.*;
public class Runner
{

    public static void main(String[]args) throws Exception {
    	String hi = System.getenv("APPDATA");
    	System.out.println(hi);
    	//String hii = System.getProperty("user.home");
    	//System.out.println(hii);
            new RPGRunner();
    }

}