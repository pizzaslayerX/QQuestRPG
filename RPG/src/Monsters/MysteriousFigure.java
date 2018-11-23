package Monsters;
public class MysteriousFigure extends MonsterManager
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
    private String names = "Mysterious Figure";
    private boolean smarts = false;
    private String songs = "MiniBoss1.wav";
    private int totals = 2;
    private int[] triggerRates = {0,25,26,50};
    private String[] atkMsgs = {"Penguin Storm!","The Mysterious Figure grew a beak!"};
    private int[] dmgs = {0,0};
    private boolean[] useTurns = {true,true};
    private int[] useCounters = {1,0,2,0};
    private String[] sounds = {"Noot.wav","ComedyGrow.wav"};
    // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    private int[] statusEffects = {100,2,66,13,3,61,12,1,101,1,60,10,5};
    private int fireRs = -25;
    private int iceRs = 75;
    private int shockRs;
    private String pics = "MF.jpg";
    private String[] movess = {"Employs devastating physical attacks.","Employs powerful magic attacks.","Can cast powerful buffs."};
	private String descs = "Nothing is known about this entity besides its mysterious affiliation with penguins...";
    public MysteriousFigure() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=19;
    	moves = movess;
    	desc =descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 35;
            crits = 36;
            defs = 20;
            healths = 240;
            attacks = 8;
        }
        else if(med == true)
        {
            evades = 35;
            crits = 36;
            defs = 20;
            healths = 240;
            attacks = 8;
        }

        else if(hard == true)
        {
            evades= 40;
            crits = 36;
            defs = 20;
            healths = 240;
            attacks = 8;
            totals = 3;
        }
    }

    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Jabs", "Back kicks","Throws a block of ice at",crits,evades,fireRs,iceRs,shockRs,pics);
        moveSet(totals,triggerRates,atkMsgs,dmgs,useTurns,sounds,statusEffects,useCounters,songs);
    }


    public void getDrops() throws InterruptedException
    {
        int gold = 0;
        Main.LootScreen.setGold(gold);
        int exp = 40 + (int)(Math.random() * 10);
        Item.Elixer.lootItem();
        int threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Item.PowerPotion.lootItem();
         threshold = (int)(Math.random() * 101);
        if(threshold < 15)
            Weapon.AngryBeak.lootWeapon();
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
    }
}


