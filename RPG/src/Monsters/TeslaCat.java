package Monsters;
import Run.*;
public class TeslaCat extends MonsterManager
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
    private String names = "Tesla Cat";
    private boolean smarts = false;
	private int fireRs = 50;
	private int iceRs = -0;
	private int shockRs = 120;
    private String pics = "TeslaCat.png";
    private String[] movess = {"Employs devastating physical attacks.","Capable of inflicting Stun."};
	private String descs = "A technological terror that considers all life to be prey. The knowledge used to create such a machine was lost long ago.";
    public TeslaCat() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=33;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 15;
            crits = 15;
            defs = 20;
            healths = 165;
            attacks = 15;
        }
        else if(med == true)
        {
            evades = 18;
            crits = 15;
            defs = 30;
            healths = 165;
            attacks = 15;
        }
        
        else if(hard == true)
        {
            evades = 18;
            crits = 15;
            defs = 33;
            healths = 185;
            attacks = 18;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Shocks", "Spins and zaps","Claws",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 45 + (int)(Math.random() * 21);
        Main.LootScreen.setGold(gold);
        int exp = 40 + (int)(Math.random() * 26);
        int threshold = 1 + (int)(Math.random() * 100);
        int amt = 1 + (int)(Math.random() * 3);
        if(threshold <= 50)
            Main.LootScreen.setLootMisc("Reflux Coil",amt);
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 20)
            Main.LootScreen.setLootMisc("Photon Battery",1);
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
    }
   }


