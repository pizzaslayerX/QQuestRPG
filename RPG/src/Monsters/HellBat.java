package Monsters;
import Run.*;
public class HellBat extends MonsterManager
{
	   public static boolean easy = false;
	    public static boolean med = false;
	    public static boolean hard = false;
    private int evades;
   
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Hell Bat";
    private boolean smarts = true;
	private int fireRs = 120;
	private int iceRs = -33;
	private int shockRs;
    private String pics = "Bat.jpg";
    private String[] movess = {"Can drop healing items."};
	private String descs = "A small creature that is easily controlled by powerful fire users. It thives in conditions of extreme heat that other creatures may find to be unbearable. ";
    public HellBat() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=16;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 15;
            crits = 0;
            defs = 0;
            healths = 21;
            attacks = 3;
        }
        else if(med == true)
        {
            evades = 15;
            crits = 5;
            defs = 0;
            healths = 26;
            attacks = 3;
        }
        
        else if(hard == true)
        {
            evades = 15;
            crits = 5;
            defs = 0;
            healths = 30;
            attacks = 4;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"screechs at", "slams into","spits fire at",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 10 + (int)(Math.random() * 15);
        Main.LootScreen.setGold(gold);
        int exp = 5 + (int)(Math.random() * 15);
        int threshold = 1 + (int)(Math.random() * 100);
        if(threshold < 65)
        Item.HighPotion.lootItem();
        threshold = (int)(Math.random() * 101);
         int amt = (int)(Math.random() * 3) + 1;
        if(threshold < 30)
            Main.LootScreen.setLootMisc("Dark Dust",amt);
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
        
    }
   }


