package Monsters;
import Run.*;
public class Werewolf extends MonsterManager
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
    private String names = "Werewolf";
    private boolean smarts = false;
	private int fireRs;
	private int iceRs = 25;
	private int shockRs = -10;
    private String pics = "Werewolf.png";
    private String[] movess = {"Employs powerful physical attacks."};
	private String descs = "Once human, now a savage beast that has lost its humanity.";
    public Werewolf() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=37;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 10;
            crits = 15;
            defs = 30;
            healths = 100;
            attacks = 9;
        }
        else if(med == true)
        {
            evades = 10;
            crits = 18;
            defs = 33;
            healths = 110;
            attacks = 10;
        }
        
        else if(hard == true)
        {
            evades = 10;
            crits = 20;
            defs = 33;
            healths = 125;
            attacks = 10;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Pounces on", "Slashes","Rams into",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 100 + (int)(Math.random() * 21);
        Main.LootScreen.setGold(gold);
        int exp = 20 + (int)(Math.random() * 11);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 34)
            Item.MegaPotion.lootItem();
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


