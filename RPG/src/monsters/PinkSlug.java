package monsters;

public class PinkSlug extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private int evades;
    // instance variables - replace the example below with your own
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "~Pink Slug~";
    private boolean smarts = false;
	private int fireRs = 100;
	private int iceRs = 100;
	private int shockRs = 100;
    private String pics = "PinkSlug.jpg";
    private String[] movess = {"Drops very rare loot."};
	private String descs = "The fabled ~Pink Slug~ is a rare sight to behold. It is a generally docile creature, however it is always forced into confrontation by people like you.";
    public PinkSlug() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=21;
    	if(backend.SetUp.censor == false)
    		descs = "The fabled ~Pink Slug~ is a rare sight to behold. It is a generally docile creature, however it is always forced into confrontation by dicks like you.";
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 0;
            defs = 65;
            healths = 110;
            attacks = 0;
        }
        else if(med == true)
        {
            evades = 5;
            crits = 0;
            defs = 65;
            healths = 110;
            attacks = 1;
        }
        
        else if(hard == true)
        {
            evades = 5;
            crits = 0;
            defs = 65;
            healths = 120;
            attacks = 1;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"squishes", "farts on","rubs",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 100 + (int)(Math.random() * 50);
        gameplay.LootScreen.setGold(gold);
        int exp = 20 + (int)(Math.random() * 19);
        int threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 4) + 1;
        if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Q-Cube",amt);
             threshold = (int)(Math.random() * 101);
             amt = (int)(Math.random() * 4) + 1;
        if(threshold < 25)
            gameplay.LootScreen.setLootMisc("U-Cube",amt);
            threshold = (int)(Math.random() * 101);
             amt = (int)(Math.random() * 10) + 5;
        if(threshold < 13)
            gameplay.LootScreen.setLootMisc("I-Cube",amt);
            threshold = (int)(Math.random() * 101);
             amt = (int)(Math.random() * 10) + 5;
        if(threshold < 6)
            gameplay.LootScreen.setLootMisc("N-Cube",amt);
            threshold = (int)(Math.random() * 101);
             amt = (int)(Math.random() * 10) + 10;
        if(threshold < 3)
            gameplay.LootScreen.setLootMisc("C-Cube",amt);
            threshold = (int)(Math.random() * 101);
        if(threshold < 2)
            gameplay.LootScreen.setLootMisc("Y-Cube",20);
            threshold = (int)(Math.random() * 101);
        if(threshold < 33)
           weapon.PinkHammer.lootWeapon();
        gameplay.LootScreen.setExp(exp);
        gameplay.LootScreen.open();
        
    }
   }


