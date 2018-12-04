package monsters;
import backend.*;
import gameplay.*;
public class WellSpider extends MonsterManager
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
    private String names = "Hairy Spider";
    private boolean smarts = false;
	private int fireRs;
	private int iceRs;
	private int shockRs;
    private String pics = "WellSpider.png";
    private String[] movess = {"Specializes in physical attacks.","Attacks in groups."};
	private String descs = "A rare species that can only be found deep underground.";
    public WellSpider() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=36;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 10;
            crits = 10;
            defs = 10;
            healths = 38;
            attacks = 5;
        }
        else if(med == true)
        {
            evades = 10;
            crits = 13;
            defs = 10;
            healths = 45;
            attacks = 6;
        }
        
        else if(hard == true)
        {
            evades = 10;
            crits = 13;
            defs = 15;
            healths = 51;
            attacks = 7;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Bites", "Stabs","Sprays",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 15 + (int)(Math.random() * 19);
        gameplay.LootScreen.setGold(gold);
        int exp = 10 + (int)(Math.random() * 21);
        int threshold = 1 + (int)(Math.random() * 100);
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 60)
        {
           consumables.Potion.lootItem();
        }
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 50)
            gameplay.LootScreen.setLootMisc("String",1);
        gameplay.LootScreen.setExp(exp);
        gameplay.LootScreen.open();
        
    }
    
        
    
        public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
   }


