package Monsters;
import Run.*;
public class PlasmaDog extends MonsterManager
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
    private String names = "Plasma Dog";
    private boolean smarts = false;
	private int fireRs = 10;
	private int iceRs = -20;
	private int shockRs = 50;
    private String pics = "PlasmaDog.jpg";
    private String[] movess = {"Specializes in physical attacks."};
	private String descs = "Woof.";
    public PlasmaDog() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=22;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 10;
            crits = 30;
            defs = 0;
            healths = 47;
            attacks = 7;
        }
        else if(med == true)
        {
            evades = 10;
            crits = 30;
            defs = 0;
            healths = 55;
            attacks = 8;
        }
        
        else if(hard == true)
        {
        	shockRs = 100;
            evades = 10;
            crits = 35;
            defs = 5;
            healths = 65;
            attacks = 8;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Barks at", "Shoots sparks at","Breaths hot air on",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 30 + (int)(Math.random() * 16);
        Main.LootScreen.setGold(gold);
        int exp = 20 + (int)(Math.random() * 6);
        int threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 20)
            Item.PowerPotion.lootItem();
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 34)
            Main.LootScreen.setLootMisc("Reflux Coil",1);
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
    }
   }


