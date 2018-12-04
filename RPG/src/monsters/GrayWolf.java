package monsters;

public class GrayWolf extends MonsterManager
{

    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private int evades;
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Gray Wolf";
    private boolean smarts = false;
	private int fireRs;
	private int iceRs = 20;
	private int shockRs;
    private String pics = "GrayWolf.jpg";
    private String[] movess = {"Specializes in physical attacks."};
	private String descs = "The feared Gray Wolf is one of the biggest species of wolf. It's massive size allows for it to easily overpower most forest creatures.";
    public GrayWolf() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=15;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 10;
            crits = 10;
            defs = 10;
            healths = 135;
            attacks = 8;
        }
        else if(med == true)
        {
            evades = 12;
            crits = 15;
            defs = 10;
            healths = 135;
            attacks = 9;
        }
        
        else if(hard == true)
        {
            evades = 15;
            crits = 22;
            defs = 10;
            healths = 158;
            attacks = 10;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Rakes it's claws through", "chomps down on","Slams into",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 20 + (int)(Math.random() * 11);
        gameplay.LootScreen.setGold(gold);
        int exp = 30 + (int)(Math.random() * 15);
        gameplay.LootScreen.setExp(exp);
        gameplay.LootScreen.open();
    }
   }


