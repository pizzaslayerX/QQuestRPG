package Monsters;

public class Gargoyle extends MonsterManager
{

    // instance variables - replace the example below with your own
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private int evades;
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Gargoyle";
    private boolean smarts = true;
	private int fireRs = 50;
	private int iceRs = 50;
	private int shockRs = 100;
    private String pics = "Gargoyle.jpg";
    private String[] movess = {"Employs devastating physical attacks"};
	private String descs = "A hostile demon made of solid stone. Truly terrifying.";
    public Gargoyle() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=13;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 20;
            crits =11;
            defs = 33;
            healths = 210;
            attacks = 20;
        }
        else if(med == true)
        {
            evades = 20;
            crits = 11;
            defs= 33;
            healths = 215;
            attacks = 20;
        }
        
        else if(hard == true)
        {
            evades = 20;
            crits = 11;
            defs = 35;
            healths = 226;
            attacks = 22;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Shoots spikes at", "Throws stones at","Crushes",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 60 + (int)(Math.random() * 21);
        Main.LootScreen.setGold(gold);
        int exp = 50 + (int)(Math.random() * 11);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Main.LootScreen.setLootMisc("Greater Soul",1);
        threshold = (int)(Math.random() * 101);
        if(threshold < 30)
            Item.HighPotion.lootItem();
        threshold = (int)(Math.random() * 101);
         int amt = (int)(Math.random() * 3) + 1;
        if(threshold < 30)
            Main.LootScreen.setLootMisc("Dark Dust",amt);
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
    }
   }


