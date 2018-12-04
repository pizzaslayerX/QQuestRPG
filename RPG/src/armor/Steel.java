package armor;
import backend.*;
public class Steel
{
	public static int fireR;
	public static int iceR;
	public static int shockR;
    public static int def = 38;
    public static int price = 1500;
    public static String name = "Steel Coat";
    public static String desc = "Stronger and lighter than iron.";
    public static void setArmor() throws InterruptedException
    {
        RPGRunner.append("You've equipped " + name + ".");
        ArmorManager.setArmor(def,name,desc,price,fireR,iceR,shockR);
    }
    public static void lootArmor() throws InterruptedException
    {
    	gameplay.LootScreen.setLootArmor(new ArmorManager(def,name,desc,price,fireR,iceR,shockR));
    }
    public static ArmorManager newArmor() {
    	return new ArmorManager(def,name,desc,price,fireR,iceR,shockR);
    }
}


