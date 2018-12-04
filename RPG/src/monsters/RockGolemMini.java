package monsters;

import gameplay.LootScreen;

public class RockGolemMini extends MonsterManager
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
    private String names = "Rock Golem Mini";
    private boolean smarts = false;
    private String songs = "RowdyRumble.wav";
    private int totals = 0;
    private int[] triggerRates = {0};
    private String[] atkMsgs = {""};
    private int[] dmgs = {0};
    private boolean[] useTurns = {true};
    private int[] useCounters = {0};
    private String[] sounds = {""};
   // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    private int[] statusEffects = {0};
	private int fireRs = 33;
	private int iceRs = 33;
	private int shockRs = 100;
	private String pics = "RockGolemMini.jpg";
	 private String[] movess = {"Employs moderate physical attacks."};
		private String descs = "A mindless sentinel that is tasked with destroying intruders that would dare enter the Grand Mines. The powerful magic used to create Rock Golems is unknown to all but few.";  
	public RockGolemMini() {
		super();
		setStats();
		summon();
		maxHealth = health; 
		id=26;
		moves = movess;
		desc = descs;
	}
	
    private void setStats()
    {
        if(easy == true)
        {
            evades = 10;
            crits = 10;
            defs = 40;
            healths = 125;
            attacks = 8;
        }
        else if(med == true)
        {
            evades = 10;
            crits = 10;
            defs = 50;
            healths = 133;
            attacks = 8;
        }
        
        else if(hard == true)
        {
            evades = 10;
            crits = 8;
            defs = 75;
            healths =  144;
            attacks = 8;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Sprays dirt at", "Rolls into","Chucks a pebble at",crits,evades,fireRs,iceRs,shockRs,pics);
        moveSet(totals,triggerRates,atkMsgs,dmgs,useTurns,sounds,statusEffects,useCounters,songs);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 26 + (int)(Math.random() * 5);
        gameplay.LootScreen.setGold(gold);
        int exp = 10 + (int)(Math.random() * 11);
        int threshold = (int)(Math.random() * 101);
        threshold = (int)(Math.random() * 101);
    	if(threshold < 50)
    		LootScreen.setLootMisc("Iron Bar", 1);
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


