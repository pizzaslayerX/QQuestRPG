package weapon;
import backend.*;
public class VirusKnife
{
   public static String weaponName=  "Viral Dagger";
    public static int dmg = 21;
   public static int crit = 66;
   public static int price = 3666;
   public static String aName = "Liquify [16 Poison dmg per turn until 50% of max health is dealt]";
   public static String triggerMsg = "The enemy has been infected";
      //id,dmg,duration,trigger percent
   public static int[] ability = {14,16,50,66};
   public static String Desc = "The blade is crawling with a deadly pathogen";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
