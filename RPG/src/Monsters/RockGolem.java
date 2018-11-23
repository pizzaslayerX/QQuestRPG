package Monsters;

import Main.LootScreen;

public class RockGolem extends MonsterManager
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
    private String names= "Rock Golem";
    private boolean smarts = false;
    private String songs = "RowdyRumble.wav";
    private int totals = 3;
    private int[] triggerRates = {0,15,21,35,36,50};
    private String[] atkMsgs = {"The Rock Golem vomits molten fire","The Rock Golem hardens","You recieved a Concusion!!!"};
    private int[] dmgs = {0,0,10};
    private boolean[] useTurns = {true,true,true};
    private int[] useCounters = {2,0,3,0,1,0};
    private String[] sounds = {"LiquidRush.wav","RockCrumble.wav","Punch.wav"};
   // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    private int[] statusEffects = {100,1,64,10,3,101,1,40,20,2,102,1,68,0,2};
	private int fireRs = 33;
	private int iceRs = 33;
	private int shockRs = 100;
    private String pics = "RockGolem.jpg";
    private String[] movess = {"Employs powerful physical attacks.","Inflicts status ailments.","Can casts buffs.","Splits into two weaker versions upon death."};
	private String descs = "A mindless sentinel that is tasked with destroying intruders that would dare enter the Grand Mines. The powerful magic used to create Rock Golems is unknown to all but few.";  
    public RockGolem() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=25;
    	moves = movess;
    	desc = descs;
    }
	
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 10;
            defs = 40;
            healths = 250;
            attacks = 13;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 10;
            defs = 50;
            healths = 266;
            attacks = 15;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 8;
            defs = 75;
            healths =  312;
            attacks = 16;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Rolls into", "Smashes","Chucks a bolder at",crits,evades,fireRs,iceRs,shockRs,pics);
        moveSet(totals,triggerRates,atkMsgs,dmgs,useTurns,sounds,statusEffects,useCounters,songs);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 36 + (int)(Math.random() * 15);
        Main.LootScreen.setGold(gold);
        int exp = 30 + (int)(Math.random() * 21);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 26)
        	LootScreen.setLootMisc("Rock Golem Heart",1);
        threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 3) + 1;
    	if(threshold < 50)
    		LootScreen.setLootMisc("Iron Bar", amt);
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


