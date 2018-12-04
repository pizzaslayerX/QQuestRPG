package monsters;
public class ToxicSludge extends MonsterManager
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
    private String names = "Toxic Sludge";
    private boolean smarts = false;
    private String songs = "RowdyRumble.wav";
    private int totals = 2;
    private int[] triggerRates = {0,25,26,40};
    private String[] atkMsgs = {"The Toxic Sludge sprays a dark liquid on you","A part of the Sludge's body regenerated!"};
    private int[] dmgs = {0,0};
    private boolean[] useTurns = {false,true};
    private int[] useCounters = {1,0,3,0};
    private String[] sounds = {"AcidSpray.wav","Heal.wav"};
   // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    private int[] statusEffects = {100,1,63,9,33,101,1,67,25,1};
	private int fireRs = -50;
	private int iceRs;
	private int shockRs = 100;
    private String pics = "ToxicSludge.jpg";
    private String[] movess = {"Capable of inflicting Poision.","Capable of regeneration."};
	private String descs = "A mindless mass of corrosive goo that consumes anything in its path. Those unable to escape the Toxic Sludge will suffer a terrible demise.";
    public ToxicSludge() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=35;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 50;
            defs = 100;
            healths = 60;
            attacks = 3;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 60;
            defs = 100;
            healths = 65;
            attacks = 4;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 65;
            defs = 100;
            healths = 70;
            attacks = 4;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Engulfs", "Plops on","Slams into",crits,evades,fireRs,iceRs,shockRs,pics);
        moveSet(totals,triggerRates,atkMsgs,dmgs,useTurns,sounds,statusEffects,useCounters,songs);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 1 + (int)(Math.random() * 11);
        gameplay.LootScreen.setGold(gold);
        int exp = 30 + (int)(Math.random() * 10);
        int threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 2) + 1;
        if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Dark Goo",amt);
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


