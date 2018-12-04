package armor;
public class None
{
	public static int fireR;
	public static int iceR;
	public static int shockR;
    public static int def = 0;
    public static int price = 0;
    public static String name = "Shirt";
    public static String desc = "none";
    public static void setArmor() throws InterruptedException
    {
        ArmorManager.setArmor(def,name,desc,price,fireR,iceR,shockR);
    }
    public static ArmorManager newArmor() {
    	return new ArmorManager(def,name,desc,price,fireR,iceR,shockR);
    }
}
