package Armor;
import Run.*;
public class Studded
{
	public static int fireR;
	public static int iceR = 5;
	public static int shockR = 5;
    public static int def = 25;
    public static int price = 500;
    public static String name = "Studded Leather";
    public static String desc = "Light leather armor with a couple of steel plates.";
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


