package Monsters;
import Run.*;
public class BeabzleHard
{
    public static int evade;
    // instance variables - replace the example below with your own
    public static int def;
    public static int health;
    public static int attack;
    public static int crit;
    public static String name = "Beabzle: The Last Human";
    public static boolean smart = true;
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
	public static int fireR = 33;
	public static int iceR =33;
	public static int shockR = 33;
    public static String pic = "";
	
    public static void setStats()
    {
        if(easy == true)
        {
            evade = 20;
            crit = 60;
            def = 10;
            health = 3400;
            attack = 16;
        }
        else if(med == true)
        {
            evade = 20;
            crit = 70;
            def = 25;
            health = 3750;
            attack = 16;
        }
        
        else if(hard == true)
        {
            evade = 25;
            crit = 70;
            def = 33;
            health = 4120;
            attack = 18;
        }    
        }
    
    
    
    public static void getDrops() throws InterruptedException
    {
        int gold = 0 + (int)(Math.random() * 6);
        Main.LootScreen.setGold(gold);
        int exp = 35 + (int)(Math.random() * 41);
        int threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 50)
        {
            Weapon.RuneTrident.lootWeapon();
        }
        
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
        
    }
   }


