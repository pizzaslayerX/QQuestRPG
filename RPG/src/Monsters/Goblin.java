package Monsters;
public class Goblin extends MonsterManager
{

	   public static boolean easy = false;
	    public static boolean med = false;
	    public static boolean hard = false;
    private int evades;
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Goblin";
    private boolean smarts = false;
    private String songs = "RowdyRumble.wav";
    private int totals = 1;
    private int[] triggerRates = {0,33};
    private String[] atkMsgs = {"The Goblin shanks you ferociously"};
    private int[] dmgs = {0,0};
    private boolean[] useTurns = {true,true};
    private int[] useCounters = {2,0};
    private String[] sounds = {"Attack2.wav"};
   // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    private int[] statusEffects = {100,1,66,7,3};
	private int fireRs;
	private int iceRs;
	private int shockRs;
	private String[] movess = {"Specializes in physical attacks.","Attacks in groups."};
	private String descs = "A common inhabitant of the Grand Mines. Very unintillegent and would much rather fight than compromise with words.";
    private String pics = "Goblin.png";
	public Goblin() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=14;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 25;
            crits = 25;
            defs = 5;
            healths = 60;
            attacks = 7;
        }
        else if(med == true)
        {
            evades = 25;
            crits = 25;
            defs = 5;
            healths = 60;
            attacks = 8;
        }
        
        else if(hard == true)
        {
            evades = 25;
            crits= 35;
            defs =5;
            healths = 67;
            attacks = 8;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Bites", "Stabs","Spits on",crits,evades,fireRs,iceRs,shockRs,pics);
        moveSet(totals,triggerRates,atkMsgs,dmgs,useTurns,sounds,statusEffects,useCounters,songs);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 30 + (int)(Math.random() * 10);
        Main.LootScreen.setGold(gold);
        int exp = 20 + (int)(Math.random() * 5);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Main.LootScreen.setLootMisc("Eww Matter",1);
        threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Item.Potion.lootItem();
        threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Weapon.SteelDagger.lootWeapon();
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


