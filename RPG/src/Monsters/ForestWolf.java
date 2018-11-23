package Monsters;

public class ForestWolf extends MonsterManager
{

    // instance variables - replace the example below with your own
    private int evades;
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Forest Wolf";
    private boolean smarts = false;
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
	private int fireRs;
	private int iceRs = 20;
	private int shockRs;
	private String pics = "ForestWolf.jpg";
	private String[] movess = {"Specializes in physical attacks.","Attacks in groups."};
	private String descs = "One of the many predators of the wilderness. Once it senses prey, it will pursue it to the ends of the earth.";
	public ForestWolf() {
		super();
		setStats();
		summon();
		maxHealth = health;
		id=12;
		moves = movess;
		desc = descs;
	}
	
    private void setStats()
    {
        if(easy == true)
        {
            evades = 25;
            crits = 10;
            defs = 5;
            healths = 37;
            attacks = 7;
        }
        else if(med == true)
        {
            evades = 25;
            crits = 15;
            defs = 10;
            healths = 43;
            attacks = 7;
        }
        
        else if(hard == true)
        {
            evades = 33;
            crits = 15;
            defs = 10;
            healths = 50;
            attacks = 9;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Slams into", "Slobbers on","Bites",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 5 + (int)(Math.random() * 15);
        Main.LootScreen.setGold(gold);
        int exp = 15 + (int)(Math.random() * 6);
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
    }
   }


