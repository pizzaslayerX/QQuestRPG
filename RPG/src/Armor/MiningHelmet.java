package Armor;
import Run.*;
public class MiningHelmet
{
	public static int fireR;
	public static int iceR;
	public static int shockR;
    public static int def = 35;
    public static int price = 1050;
    public static String name = "Trusty Mining Helmet";
    public static String desc = "91 days without incident!";
    public static void setArmor() throws InterruptedException
    {
        RPGRunner.append("You've equipped " + name + ".");
        ArmorManager.setArmor(def,name,desc,price,fireR,iceR,shockR);
    }
    public static void lootArmor() throws InterruptedException
    {
    	Main.LootScreen.setLootArmor(new ArmorManager(def,name,desc,price,fireR,iceR,shockR));
    }
    
    public static ArmorManager newArmor() {
    	return new ArmorManager(def,name,desc,price,fireR,iceR,shockR);
    }
}


