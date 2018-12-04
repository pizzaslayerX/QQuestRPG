package monsters;
import backend.*;
public class KillerClown extends MonsterManager
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
    private String names = "Killer Clown";
    private boolean smarts = true;
	private int fireRs;
	private int iceRs;
	private int shockRs = -20;
    private String pics = "KillerClown.jpg";
    private String[] movess = {"Employs powerful physical attacks.","Can inflict Silence and Stun.","Occasionally experiences fits of rage.","Drops rare balls."};
	private String descs = "The baddest, meanest, and scariest denizen of the horror fair. This Killer Clown is the product of the most notorious experiments conducted at El Carnival.";
    public KillerClown() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=17;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 10;
            defs = 20;
            healths = 170;
            attacks = 10;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 10;
            defs = 20;
            healths = 180;
            attacks = 11;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 15;
            defs = 22;
            healths = 200;
            attacks = 12;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Stabs", "Laughs Maniacally at","Throws rings of fire at",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 26 + (int)(Math.random() * 15);
        gameplay.LootScreen.setGold(gold);
        int exp = 40 + (int)(Math.random() * 16);
        int threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 4) + 1;
        if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Blue Ball",amt);
            threshold = (int)(Math.random() * 101);
            if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Red Ball",2);
        threshold = (int)(Math.random() * 101);
        if(threshold < 33)
            gameplay.LootScreen.setLootMisc("Green Ball",1);
            
        threshold = (int)(Math.random() * 101);
        if(threshold < 45)
            consumables.HighPotion.lootItem();
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


