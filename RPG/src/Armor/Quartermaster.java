package Armor;
import Run.*;
public class Quartermaster
{
	public static int fireR = 10;
	public static int iceR = 10;
	public static int shockR;
    public static int def = 32;
    public static int price = 1466;
    public static String name = "Quartermaster's Attire";
    public static String desc = "The color scheme radiates uneasiness...";
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


