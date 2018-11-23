package Armor;
import Run.*;
public class ChainMail
{
	public static int fireR;
	public static int iceR;
	public static int shockR;
    public static int def = 28;
    public static int price = 650;
    public static String name = "Chain Mail";
    public static String desc = "Tightly woven chain links. Choking Hazard.";
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


