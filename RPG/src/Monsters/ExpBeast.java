package Monsters;
import java.util.Scanner;
public class ExpBeast
{
    // instance variables - replace the example below with your own
    public static int def;
    public static int health;
    public static int evade;
    public static int attack;
    public static int crit;
    public static String name = "Exp Beast";
    public static boolean smart = false;
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
	public static int fireR;
	public static int iceR;
	public static int shockR;
	public static String pic = "trapdoor.png";
	
    public static void setStats()
    {
        if(easy == true)
        {
            evade = 0;
            crit = 0;
            def = 0;
            health = 0;
            attack = 0;
        }
        else if(med == true)
        {
            evade = 0;
            crit = 0;
            def = 0;
            health = 0;
            attack = 0;
        }
        
        else if(hard == true)
        {
            evade = 0;
            crit = 0;
            def = 0;
            health = 0;
            attack = 0;
        }    
        }
    
    public static void summon() throws InterruptedException
    {
        System.out.println("Dead Entity");
    }
    
    public static void getDrops() throws InterruptedException
    {
        Scanner choice = new Scanner(System.in);
        System.out.println("How much xp do you wish to recieve?");
        int exp = choice.nextInt();
        System.out.println("How much gold do you wish to recieve?");
        int gold = choice.nextInt();
        Main.LootScreen.setGold(gold);
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
    }
   }
