package Armor;
import Run.*;
public class Master
{
	public static int fireR = 20;
	public static int iceR = 20;
	public static int shockR = 20;
    public static int def = 40;
    public static int price = 1750;
    public static String name = "Armor of the Master";
    public static String desc = "Harbors the soul of the legendary warrior Xu Chiping";
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


