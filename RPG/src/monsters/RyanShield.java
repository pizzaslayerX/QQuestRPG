package monsters;
import backend.*;
public class RyanShield extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private int evades;
    // instance variables - replace the example below with your own
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Sacred Shield";
    private boolean smarts = true;
	private int fireRs = 100;
	private int iceRs = 100;
	private int shockRs = 100;
    private String pics ="RyanShield.png";
    private String[] movess = {"Grants immunity to owner."};
	private String descs = "???";
    public RyanShield() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=28;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 0;
            defs = 50;
            healths = 55;
            attacks = 0;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 0;
            defs = 50;
            healths = 60;
            attacks = 0;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 0;
            defs = 50;
            healths = 75;
            attacks = 0;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"screechs at", "slams into","spits fire at",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        gameplay.Story.textEffect("Archangel Ryan: What! That shield cost me a fortune!\n\n");
        gameplay.Story.pause(3000);
        int exp = 0;
        int gold = 0;
        gameplay.LootScreen.setGold(gold);
        int threshold = 1 + (int)(Math.random() * 100);
        if(threshold < 50)
           consumables.Ultramarine.lootItem();
        gameplay.LootScreen.setExp(exp);
        gameplay.LootScreen.open();
        
    }
   }


