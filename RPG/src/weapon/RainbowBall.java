package weapon;
import backend.*;
public class RainbowBall
{
   public static String weaponName = "Rainbow Particle Launcher";
    public static int dmg = 45;
   public static int crit = 18;
   public static int price = 2001;
   public static String aName = "Stun Impact+ [Stuns for 2 turn]";
   public static String triggerMsg = "Color Overload!";
      //id,dmg,duration,trigger percent
   public static int[] ability = {3,0,2,30};
   public static String Desc = "A bunch of rainbows packed into tiny balls.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
