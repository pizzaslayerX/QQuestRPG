package armor;
import backend.*;
import gameplay.Shoppable;
public class LizardHide
{
	public static int fireR = 10;
	public static int iceR = -25;
	public static int shockR;
    public static int def = 20;
    public static int price = 400;
    public static String name = "Lizard Hide";
    public static String desc = "Reptile scales are better than human skin...";
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


