package Monsters;
import Run.*;
public class SkeletonWarrior extends MonsterManager
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
    private String names = "Skeleton Warrior";
    private boolean smarts = true;
	private int fireRs = -40;
	private int iceRs = -40;
	private int shockRs = 100;
    private String pics = "SkeletonWarrior.png";
    private String[] movess = {"Employs powerful physical attacks."};
	private String descs = "Although dead, these warriors still retain the might and prowess that they possessed in life.";
    public SkeletonWarrior() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=30;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 5;
            defs = 10;
            healths = 40;
            attacks = 4;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 10;
            defs = 10;
            healths = 42;
            attacks = 5;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 10;
            defs = 10;
            healths = 46;
            attacks = 6;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Strikes", "Bashes","Cleaves",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 20 + (int)(Math.random() * 25);
        Main.LootScreen.setGold(gold);
        int exp = 15 + (int)(Math.random() * 20);
        int threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 34)
        {
            Weapon.AncientGreatSword.lootWeapon();
        }
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 50)
        {
            Item.HighPotion.lootItem();
        }
        threshold = (int)(Math.random() * 101);
         int amt = (int)(Math.random() * 3) + 1;
        if(threshold < 30)
            Main.LootScreen.setLootMisc("Dark Dust",amt);
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
        
    }
   }


