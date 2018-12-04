package weapon;
import backend.*;
public class AngryBeak
{
    public static String weaponName = "The Angry Beaker";
    public static int dmg = 89;
    public static int crit = 0;
    //id,dmg,duration,trigger percent
    public static int[] ability = {12,20,1,5};
    public static String triggerMsg = "A shard of ice spits out the end of the staff!";
    public static String aName = "Icy Pelt [Deals 20 Frost Dmg]";
    public static int price = 3000;
    public static String Desc = "A long staff with a powerful penguin beak at the tip";
    public static void setWeapon() throws InterruptedException
    {
        WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
