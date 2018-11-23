package Armor;
import Run.*;
public class Paper
{
	public static int fireR = -50;
	public static int iceR;
	public static int shockR = 5;
    public static int def = 5;
    public static int price = 80;
    public static String name = "Paper Armor";
    public static String desc = "What?";
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


