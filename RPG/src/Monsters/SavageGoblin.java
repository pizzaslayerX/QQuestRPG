package Monsters;
public class SavageGoblin extends MonsterManager
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
    private String names = "Savage Goblin";
    private boolean smarts = false;
    private String songs = "RowdyRumble.wav";
    private int totals = 2;
    private int[] triggerRates = {0,20,21,35,36,100};
    private String[] atkMsgs = {"The Savage Goblin goes beserk!","The Savage Goblin launches a flaming arrow at you","The Savage Goblin landed a critical strike with its bow"};
    private int[] dmgs = {0,10,21};
    private boolean[] useTurns = {false,true,true};
    private int[] useCounters = {1,0,2,0,2,0};
    private String[] sounds = {"Attack2.wav","SmallFire.wav","Arrow.wav"};
   // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    private int[] statusEffects = {100,1,60,5,3,101,1,64,5,2,102,1,0,0,0};
	private int fireRs = 10;
	private int iceRs = 10;
	private int shockRs = 10;
	private String pics = "SavageGoblin.png";
	private String[] movess = {"Specializes in physical attacks.","Employs specialized ranged attacks."};
	private String descs = "A goblin who has known great pain and suffering. It's experiences have allowed it to become an even deadlier opponent.";
	public SavageGoblin() {
		super();
		setStats();
		summon();
		maxHealth = health;
		id=29;
		moves = movess;
		desc = descs;
	}
	
	
    private void setStats()
    {
        if(easy == true)
        {
            evades = 25;
            crits = 25;
            defs = 15;
            healths = 140;
            attacks = 12;
        }
        else if(med == true)
        {
            evades = 25;
            crits = 25;
            defs = 15;
            healths = 140;
            attacks = 12;
        }
        
        else if(hard == true)
        {
            evades = 25;
            crits = 35;
            defs = 15;
            healths = 147;
            attacks = 13;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Chucks rocks at", "Stabs","Tackles",crits,evades,fireRs,iceRs,shockRs,pics);
        moveSet(totals,triggerRates,atkMsgs,dmgs,useTurns,sounds,statusEffects,useCounters,songs);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 50 + (int)(Math.random() * 15);
        Main.LootScreen.setGold(gold);
        int exp = 30 + (int)(Math.random() * 10);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Main.LootScreen.setLootMisc("Eww Matter",1);
        int amt = (int)(Math.random() * 2) + 1;
        threshold = (int)(Math.random() * 101);
        if(threshold < 33)
             Main.LootScreen.setLootMisc("Iron Bar",amt);
        threshold = (int)(Math.random() * 101);
        if(threshold < 20)
            Weapon.IronDagger.lootWeapon();
        threshold = (int)(Math.random() * 101);
        if(threshold < 20)
            Weapon.LongBow.lootWeapon();
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


