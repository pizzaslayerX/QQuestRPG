package Armor;
import Run.*;
public class Iron
{
	public static int fireR = -5;
	public static int iceR;
	public static int shockR;
    public static int def = 33;
    public static int price = 1110;
    public static String name = "Iron Plated";
    public static String desc = "Solid plates of iron prevent serious injury";
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


