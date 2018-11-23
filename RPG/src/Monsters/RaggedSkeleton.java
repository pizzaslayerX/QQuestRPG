package Monsters;
import Run.*;
public class RaggedSkeleton extends MonsterManager
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
    private String names = "Ragged Skeleton";
    private boolean smarts = false;
	private int fireRs = -40;
	private int iceRs = -40;
	private int shockRs = 100;
    private String pics = "Skeleton.png";
    private String[] movess = {"Employs weak physical attacks."};
	private String descs = "An animated pile of bones. Most of it's bones are cracked and ready to fall apart.";
    public RaggedSkeleton() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=23;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 0;
            defs = 0;
            healths = 20;
            attacks = 3;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 5;
            defs = 5;
            healths = 24;
            attacks = 4;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 5;
            defs = 8;
            healths = 29;
            attacks = 4;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"bashes", "slashes","punches",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 10 + (int)(Math.random() * 15);
        Main.LootScreen.setGold(gold);
        int exp = 9 + (int)(Math.random() * 7);
        int threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 35)
        {
            Weapon.AncientSword.lootWeapon();
        }
        threshold = (int)(Math.random() * 101);
         int amt = (int)(Math.random() * 2) + 1;
        if(threshold < 30)
            Main.LootScreen.setLootMisc("Dark Dust",amt);
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
        
    }
   }


