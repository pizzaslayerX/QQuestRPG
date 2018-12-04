package monsters;
import backend.*;
public class Ogre extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    // instance variables - replace the example below with your own
    private int evades;
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Ogre";
    private boolean smarts = false;
	private int fireRs;
	private int iceRs;
	private int shockRs;
	private String pics = "Ogre.png";
	
	private String[] movess = {"Employs devastating physical attacks."};
	private String descs = "A fat, stinky, ugly behemoth. This creature is very territorial, prefering to live in wet and desolate regions such as swamps. Anyone daring enough to enter an Ogre's domain is asking to be turned into stew.";
	
	public Ogre() {
		super();
		setStats();
		summon();
		maxHealth = health;
		id=20;
		moves = movess;
		desc = descs;
	}
	
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 15;
            defs = 20;
            healths = 360;
            attacks = 22;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 15;
            defs = 20;
            healths = 360;
            attacks = 23;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 16;
            defs = 20;
            healths = 400;
            attacks = 25;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Farts on", "Grabs and throws","Belly flops on",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 70 + (int)(Math.random() * 36);
        gameplay.LootScreen.setGold(gold);
        int exp = 50 + (int)(Math.random() * 16);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Greater Soul",1);
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


