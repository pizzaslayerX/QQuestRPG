package Monsters;
public class Minotaur extends MonsterManager
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
    private String names = "Minotaur";
    private boolean smarts = false;
    private String songs = "CarnivalFight.wav";
    private int totals = 2;
    private int[] triggerRates = {0,20,21,50};
    private String[] atkMsgs = {"The Minotaur creates a shockwave on the ground","The Minotaur rages!"};
    private int[] dmgs = {26,0};
    private boolean[] useTurns = {true,true};
    private int[] useCounters = {2,0,1,0};
    private String[] sounds = {"GroundShake.wav","RageGrowl.wav"};
   // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    private int[] statusEffects = {100,1,0,0,0,101,2,40,10,2,60,2,2};
	private int fireRs;
	private int iceRs;
	private int shockRs;
	private String[] movess = {"Employs devastating physical attacks.","Prone to intense fits of rage."};
	private String descs = "A hungry solitary beast that spends its time roaming corridors searching for victims. Anyone unfortunate enough to cross paths with this beast will be ripped apart.";
	
    private String pics = "Minotaur.png";
	
    public Minotaur() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=18;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 5;
            crits = 15;
            defs = 15;
            healths = 305;
            attacks = 15;
        }
        else if(med == true)
        {
        	dmgs[0] = 30;
            evades = 5;
            crits = 15;
            defs = 20;
            healths = 310;
            attacks = 16;
            iceRs = 10;
        }
        
        else if(hard == true)
        {
        	totals = 3;
        	dmgs[0] = 37;
            evades = 5;
            crits = 15;
            defs = 20;
            healths = 330;
            attacks = 17;
            iceRs = 20;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Throws its axe at", "Punches","Rams its horns into",crits,evades,fireRs,iceRs,shockRs,pics);
        moveSet(totals,triggerRates,atkMsgs,dmgs,useTurns,sounds,statusEffects,useCounters,songs);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 100 + (int)(Math.random() * 35);
        Main.LootScreen.setGold(gold);
        int exp = 80 + (int)(Math.random() * 10);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Main.LootScreen.setLootMisc("Greater Soul",1);
        threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Item.PowerPotion.lootItem();
        threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 3) + 1;
        if(threshold < 25)
            Main.LootScreen.setLootMisc("Iron Bar",amt);
        threshold = (int)(Math.random() * 101);
        amt = (int)(Math.random() * 2) + 1;
        if(threshold < 50)
            Main.LootScreen.setLootMisc("Minotaur Horn",amt);
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


