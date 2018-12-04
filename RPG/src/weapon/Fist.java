package weapon;

public class Fist
{
   public static String weaponName = "Fists";
    public static int dmg = 1000;
   public static int[] ability = {0,0,0,0};
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static int crit = 0;
   public static int price = 0;
   public static String Desc = "Just your hands man.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
}
