package Monsters;
import Run.*;
public class TinyTim extends MonsterManager
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
    private String names = "Tiny Tim";
    private boolean smarts = true;
	private int fireRs;
	private int iceRs;
	private int shockRs;
    private String pics = "SmallTim.jpg";
    private String[] movess = {"Capable of exploding at low health."};
	private String descs = "A small clown with an attitude. Appears to be the dominant one its relationship with the Big Clown.";
    public TinyTim() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=34;
    	moves = moves;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 33;
            crits = 20;
            defs = 5;
            healths = 65;
            attacks = 6;
        }
        else if(med == true)
        {
            evades = 33;
            crits = 21;
            defs = 5;
            healths = 75;
            attacks = 7;
        }
        
        else if(hard == true)
        {
            evades = 33;
            crits = 21;
            defs = 5;
            healths = 81;
            attacks = 7;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Runs circles around", "Kicks","Head Butts",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 50 + (int)(Math.random() * 11);
        Main.LootScreen.setGold(gold);
        int exp = 35 + (int)(Math.random() * 6);
        int threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 4) + 2;
        if(threshold < 85)
            Main.LootScreen.setLootMisc("Red Ball",amt);
        threshold = (int)(Math.random() * 101);
        amt = (int)(Math.random() * 2) + 1;
        if(threshold < 50)
            Main.LootScreen.setLootMisc("Purple Ball",amt);
        threshold = (int)(Math.random() * 101);
         if(threshold < 30)
            Item.MegaPotion.lootItem();
            
        if(threshold < 85)
            Main.LootScreen.setLootMisc("Green Ball",1);
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


