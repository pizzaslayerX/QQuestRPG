package armor;
import backend.*;
public class Wood
{
	public static int fireR = -25;
	public static int iceR;
	public static int shockR;
    public static int def = 22;
    public static int price = 380;
    public static String name = "Wooden Armor";
    public static String desc = "The unrefined version of paper armor";
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


